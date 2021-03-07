<!--
 * @Author: your name
 * @Date: 2021-03-06 12:31:01
 * @LastEditTime: 2021-03-07 16:43:48
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Admin\src\views\Essay\AddEssay.vue
-->
<template>
    <div>
       <el-form class="form-box" :rules="rules" ref="formData" :model="formData" label-width="100px">
            <el-form-item label="标题" prop="name">
                <el-input v-model="formData.essayTitle" placeholder="请输入文章标题" class="input-satnder"></el-input>
            </el-form-item>
            <el-form-item label="文章类型" prop="level">
                <el-select v-model="formData.labelId" placeholder="类型">
                        <el-option label="Code" value="Code"></el-option>
                        <el-option label="Life" value="Life"></el-option>
                        <el-option label="Author" value="Author"></el-option>
                        <el-option label="Other" value="Other"></el-option>       
                </el-select>
            </el-form-item>
            <el-form-item label="分类标签" prop="labelName">
                <el-input v-model="formData.labelName" placeholder="分类标签" class="input-satnder"></el-input>
            </el-form-item>
             <!-- <el-form-item label="标题图" prop="essayImg">
               <input id="pho" type="file" ref="myPhoto" name="photo" />
            </el-form-item> -->
            <el-form-item label="标题图" prop="essayImg">
                <!-- <el-upload
                          class="avatar-uploader"
                          action="string"
                          :on-change="handleChange"
                          :show-file-list="false"
                          :http-request="uploadImg"
                          :before-upload="beforeAvatarUpload">
                            <img v-if="formData.titleImg" :src="formData.titleImg" class="avatar">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload> -->
                        <el-upload
                          class="avatar-uploader"
                          action="lei"
                          :on-change="handleChange"
                          :show-file-list="false"
                           :before-upload="beforeAvatarUpload"
                          :http-request="uploadImg"><!--覆盖默认上传-->
                          <img v-if="imageUrl" :src="imageUrl" class="avatar">
                          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>

            </el-form-item>
             <el-form-item label="摘要" prop="computer">
                <el-input type="textarea" v-model="formData.essayAbout" width="400px"></el-input>
            </el-form-item>
            <el-form-item label="正文" prop="computer">
                  <mavon-editor
                    v-model="formData.essayContent"
                    ref="md"
                    @imgAdd="$imgAdd" 
                    @change="change"
                    :toolbars="toolbars"
                    :toolbarsBackground="'#f9f9f9'"
                    :hljs = "true"                     
                    style="min-height: 600px"
                  >			   
                  </mavon-editor>
            </el-form-item>
             <el-form-item>
                <el-button @click="submitForm" type="primary"   :loading="isLoding" >保存</el-button>
                <el-button @click="resetForm">重置</el-button>
           </el-form-item>
       </el-form>
      </div>
</template>
<script>
////import 'highlight.js/styles/googlecode.css';
//import hljs from 'highlight.js'; //导入代码高亮文件
import marked from 'marked'
  export default {
        name: "VueEditor",
        data(){
            return{
                    //路由传参过来的id
                    essayId: '',
                    imageUrl: '',
                    tempUrl: '',
                    markContent :'',
                    isLoding:false,
               			formData:{
                      id:'',
                      essayTitle:"",
                      essayAbout: "",
                      essayContent: "",
                      essayImg: "",
                      labelId: "",
                      labelName: ""
                      },
                      rules: {
                          essayTitle: [{required: true, message: '请输入标题', trigger: 'blur'}],
                          essayAbout: [{required: true, message: '请输入栏目', trigger: 'blur'}],
                          essayContent: [{required: true, message: '请输入内容', trigger: 'blur'}],              
                          labelName: [{required: true, message: '请输入内容', trigger: 'blur'}],
                       
                          labelId: [
                                  {
                                      required: true,
                                      message: "请选择类型",
                                      trigger: "change"
                                  }
                              ]
                      },
                      toolbars: {
                          bold: true, // 粗体
                          italic: true, // 斜体
                          header: true, // 标题
                          underline: true, // 下划线
                          strikethrough: true, // 中划线
                          mark: true, // 标记
                          superscript: true, // 上角标
                          subscript: true, // 下角标
                          quote: true, // 引用
                          ol: true, // 有序列表
                          ul: true, // 无序列表
                          link: true, // 链接
                          imagelink: true, // 图片链接
                          code: true, // code
                          table: true, // 表格
                          fullscreen: false, // 全屏编辑
                          readmodel: false, // 沉浸式阅读
                          htmlcode: true, // 展示html源码
                          help: true, // 帮助
                          /* 1.3.5 */
                          undo: true, // 上一步
                          redo: true, // 下一步
                          trash: true, // 清空
                          save: false, // 保存（触发events中的save事件）
                          /* 1.4.2 */
                          navigation: true, // 导航目录
                          /* 2.1.8 */
                          alignleft: true, // 左对齐
                          aligncenter: true, // 居中
                          alignright: true, // 右对齐
                          /* 2.2.1 */
                          subfield: true, // 单双栏模式
                          preview: false // 预览
                        }
            }
        },

        created(){
            this.essayId = this.$route.params.id;
            console.log("路由传参的Id为:"+this.essayId);
            if(this.essayId !=''){
                this.loadEssayById();
            }
        },


        watch:{

              $route(to,from){ 
                  this.essayId = this.$route.params.id;
                  },
                },

        methods:{

                  resetForm() {
                    this.$refs['formData'].resetFields();
                    this.formData = {};
                  },

                //提交文章
                submitForm(){            
                  if(this.imageUrl == ''){
                    this.$message.error('请选择一张图片');
                      return;
                  }                                       
                  this.isLoding = false;
                  this.$refs['formData'].validate(valid=>{
                    if (valid) {
                              this.isLoding = true;
                              //文件上传时 请求方式必须是post  enctype必须为multipart/form-data
                                var formData = new FormData();
                                var arcticle = marked(this.formData.essayContent);
                                // formData.append("essayTitle",this.formData.essayTitle);
                                // formData.append("essayAbout",this.formData.essayAbout);
                                // formData.append("essayContent",arcticle);
                                // formData.append("labelId",this.formData.labelId);
                                // formData.append("labelName",this.formData.labelName);
                                // formData.append("essayImg",this.formData.essayImg);
                               // formData.append("photo",this.$refs.myPhoto.files[0]);
                              this.formData.essayContent = arcticle;
                              this.formData.essayImg = this.imageUrl;
                                if(this.essayId !='' && this.essayId > 0){
                                    this.saveById();
                                    this.isLoding = false;
                                }else{
                                  this.$axios.post(`http://localhost:9002/api/blog/saveEssay`, this.formData)
                                        .then((res) => {
                                              console.log(res.data);
                                              this.$message({
                                              message: res.data.msg,
                                              type: "success"
                                              });
                                          this.resetForm();
                                          this.formData = {};
                                        })
                                        .catch((err) => {
                                            console.log("失败"+err.data);
                                            
                                          });
                                          this.isLoding = false;
                                }
                                

                                // this.$axios({
                                //     method:"post",
                                //     url:"http://localhost:9002/api/blog/saveEssay",
                                //     data:formData,
                                //     headers:{
                                //         'content-type':'multipart/form-data'
                                //     }
                                // })
                                // this.$axios.post(`http://localhost:9002/api/blog/saveEssay`,formData)
                                // .then((res) =>{
                                //     if(res.data.state){
                                //       this.isLoding = false;
                                //         this.formData = {};
                                //           this.$message({
                                //             message: res.data.msg,
                                //             type: "success"
                                //             });
                                //            this.imageUrl = ''
                                //     }
                                //  })
                                //   .catch((err) => {
                                //       console.log("失败"+err.data);
                                //       this.isLoding = false;
                                //   });
                          }
                        })
             },
             // 绑定@imgAdd event
            $imgAdd(pos, $file){
                // 第一步.将图片上传到服务器.
                var formdata = new FormData();
                formdata.append('file', $file);
                  this.$axios({
                    url: "http://localhost:9002/api/blog/uploadFile",
                    method: 'post',
                    data: formdata,
                    headers: { 'Content-Type': 'multipart/form-data' },
                    })
                    .then((res) => {
                    // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
                    // $vm指为mavonEditor实例，可以通过如下两种方式获取
                    //通过引入对象获取: import {mavonEditor} from ... 等方式引入后，此时$vm即为mavonEditor
                    //通过$refs获取: html声明ref : <mavon-editor ref=md ></mavon-editor>， 此时$vm为 this.$refs.md`
                    if(res.data.state){
                         this.$refs.md.$img2Url(pos, res.data.url)
                      }
                    
                })
            },
             $imgDel (pos) {
                delete this.img_file[pos]
              },
              change (file, render) {
                this.tempUrl = URL.createObjectURL(file.raw);
                this.formData.essayContent = render
              },

              handleAvatarSuccess(res, file) {
                this.formData.essayImg = URL.createObjectURL(res.data.url);
              },
               beforeAvatarUpload(file) {
                 const isIMAGE = (file.type === 'image/jpeg') ||  (file.type === 'image/jpg') || (file.type ==='image/png')
                 const isLt2M = file.size / 1024 / 1024 < 2
                 if (!isIMAGE) {
                    this.$message.error('上传文件只能是图片格式!')
                }
                if (!isLt2M) {
                    this.$message.error('上传文件大小不能超过 2MB!')
                }
                return isIMAGE && isLt2M
              },

  

               uploadImg(param){
                // 第一步.将图片上传到服务器.
                var formdata = new FormData();
                formdata.append('file', param.file);
                  this.$axios({
                    url: "http://localhost:9002/api/blog/uploadFile",
                    method: 'post',
                    data: formdata,
                    headers: { 'Content-Type': 'multipart/form-data' },
                    })
                    .then((res) => {
                    // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
                    // $vm指为mavonEditor实例，可以通过如下两种方式获取
                    //通过引入对象获取: import {mavonEditor} from ... 等方式引入后，此时$vm即为mavonEditor
                    //通过$refs获取: html声明ref : <mavon-editor ref=md ></mavon-editor>， 此时$vm为 this.$refs.md`
                    if(res.data.state){
                         this.formData.essayImg = res.data.url;
                          this.imageUrl = res.data.url;
                         this.$forceUpdate();
                      }
                    })
                    .catch((err) =>{
                      console.log(err);
                       this.$message.error(error)
                    })
            },


            //将上传图片的原路径赋值给临时路径
            handleChange(file, fileList) {
                 this.tempUrl = URL.createObjectURL(file.raw);
            },


            loadEssayById(){
              if(!this.essayId){
                return;
              }
               this.$axios.get(`http://127.0.0.1:9002/api/blog/findOneById?id=${this.essayId}`)
                .then(res =>{
                       this.formData.id = this.id;
                       this.formData.essayTitle = res.data.result.essayTitle
                       this.formData.essayAbout = res.data.result.essayAbout;                    
                       this.formData.essayContent = res.data.result.essayContent;
                       this.formData.labelId = res.data.result.labelId;
                       this.formData.labelName = res.data.result.labelName;
                       this.formData.essayImg = res.data.result.essayImg;
                       this.imageUrl = res.data.result.essayImg;                 
                      //this.getListEssay(res.data.result.labelId);
                    })
            },
             saveById(){
                if(!this.essayId){
                return;
              }
              this.formData.essayImg = this.imageUrl;
              this.formData.id = this.essayId;
               this.$axios.post(`http://localhost:9002/api/blog/update`, this.formData)
                .then((res) => {
                                   this.$message({
                                              message: res.data.msg,
                                              type: "success"
                                       });
                                    this.imageUrl ='',
                                    this.isLoding =false;
                                    this.resetForm();
                                    this.formData = {};
                                   
                                    })
                .catch((err) => {
                    console.log("失败"+err.data.msg);
                    this.isLoding = false;
                    this.imageUrl ='',
                    this.isLoding =false;
                    this.resetForm();
                    this.formData = {};
                 });
            }
        }
    }
</script>

<style lang="scss" scoped>

.markdown-container {
  .editor-btn {
    margin-top: 20px;
  }
  .title {
    padding-bottom: 30px;
    text-align: center;
    font-size: 20px;
    letter-spacing: 1px;
    color: #333;
    font-weight: 600;
  }
  }

.form-box {
  .el-select {
    width: 200px !important;
  }
  .input-satnder{
        width: 200px !important;
  }
  .input-About{
       width: 1200px !important;
       height: 200px !important;
  }
}
.table-data {
  height: 100%;
  .table-box {
    font-size: 14px;
  }
  .pages {
    background: #fff;
    margin-top: 10px;
    padding: 10px 10px;
    text-align: right;
    height: 55px;
    box-sizing: border-box;
  }
  .search-box {
    background: #fff;
    margin-bottom: 10px;
    padding: 10px 10px;
    border-radius: 4px;
    height: 55px;
    box-sizing: border-box;
    .el-input {
      width: 200px;
      margin-right: 10px;
    }
  }
 .avatar-uploader {
        margin-top: 20px;
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
        width: 100px;
        height: 100px;
    }

    .avatar-uploader:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 100px;
        height: 100px;
        line-height: 100px;
        text-align: center;
    }

    .avatar {
        width: 100px;
        height: 100px;
        display: flex;
    }
}
</style>
