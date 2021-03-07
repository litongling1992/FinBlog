<!--
 * @Author: your name
 * @Date: 2021-03-06 12:31:01
 * @LastEditTime: 2021-03-06 17:08:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Admin\src\views\Essay\AddEssay.vue
-->
<template>
    <div>
       <el-form class="form-box" :rules="rules" ref="ruleForm" :model="form" label-width="100px">
            <el-form-item label="标题" prop="name">
                <el-input v-model="form.essayTitle" placeholder="请输入文章标题" class="input-satnder"></el-input>
            </el-form-item>
            <el-form-item label="文章类型" prop="level">
                <el-select v-model="form.labelId" placeholder="类型">
                        <el-option label="Code" value="Code"></el-option>
                        <el-option label="Life" value="Life"></el-option>
                        <el-option label="Author" value="Author"></el-option>
                        <el-option label="Other" value="Other"></el-option>       
                </el-select>
            </el-form-item>
            <el-form-item label="分类标签" prop="labelName">
                <el-input v-model="form.labelName" placeholder="分类标签" class="input-satnder"></el-input>
            </el-form-item>
             <el-form-item label="标题图" prop="essayImg">
               <input type="file" ref="myPhoto" name="photo" />
            </el-form-item>
             <el-form-item label="摘要" prop="computer">
                <el-input type="textarea" v-model="form.essayAbout" width="400px"></el-input>
            </el-form-item>
            <el-form-item label="正文" prop="computer">
			   <mavon-editor
			     v-model="form.essayContent"
			     ref="md"
			     style="min-height: 600px"
			   >			   
			   </mavon-editor>
            </el-form-item>
             <el-form-item>
                <el-button @click="submitForm('ruleForm')" type="primary">保存</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
           </el-form-item>
       </el-form>
      </div>
</template>

<script lang="ts">
import { Component, Vue , Provide} from 'vue-property-decorator';
import { Getter, Action , State , Mutation } from 'vuex-class';

@Component
export default class AddEssay extends Vue{

  @Provide() form:Object ={
        essayTitle: "",
        essayAbout: "",
        essayContent: "",
        essayImg: "",
        labelId: "",
        labelName: ""
        
    };

    @Provide() rules: any = {
    essayTitle: [{ required: true, message: "请输入标题", trigger: "blur" }],
    essayAbout: [{ required: true, message: "请输入文章摘要", trigger: "change" }],
    essayContent: [{ required: true, message: "请输入文章内容", trigger: "blur" }],
	  labelName: [{ required: true, message: "请输入标签内容", trigger: "blur" }],
    labelId: [
      {
        required: true,
        message: "请选择类型",
        trigger: "change"
      }
    ]
  };

     //  // 将图片上传到服务器，返回地址替换到md中
     // $imgAdd(pos, $file){
     //        var formdata = new FormData();
     //         formdata.append("file", $file);
     //          //将下面上传接口替换为你自己的服务器接口
			  //  (this as any).$axios.post(`http`)
     //           axios({
     //               url: "`/api/blog/uploadFile`",
     //               method: "post",
     //               data: formdata,
     //               headers: { "Content-Type": "multipart/form-data" }
     //             }).then(url => {
     //               this.$refs.md.$img2Url(pos, url);
     //             });
     //  }

  submitForm(formName: string) {

      console.log(this.$refs.myPhoto);//获取文件信息

    (this as any).$refs[formName].validate((valid: boolean) => {
      if (valid) {

          console.log("photo",(this.$refs.myPhoto as Element))

        // (this as any).$axios
        //   .post(`api/blog/save`, this.form)
        //   .then((res: any) => {
        //     this.$message({
        //       message: res.data.msg,
        //       type: "success"
        //     });
        //     this.resetForm(formName);
        //   });
			//文件上传时 请求方式必须是post  enctype必须为multipart/form-data
						// var formData = new FormData();
						// formData.append("essayTitle",this.form.e);
						// formData.append("essayAbout",this.emp.salary);
						// formData.append("essay",this.emp.age);
						// formData.append("photo",this.$refs.myPhoto.files[0]);
						// 	var _this = this;
						//   let formData:any ={
						//       "essayTitle": _this.form.essayTitle,
						//       "essayAbout": _this.form.essayTitle,
						//       "essayContent": _this.form.essayTitle,
						//       "essayImg": _this.form.essayTitle,
						//       "labelId": _this.form.essayTitle,
						//       "labelName": _this.form.essayTitle,
						// 	    "photo": _this.$refs[myPhoto].f
						//   };
						
					
						// axios({
						// 	method:"post",
						// 	url:"http://localhost:9002/api/blog/save",
						// 	data:formData,
						// 	headers:{
						// 		'content-type':'multipart/form-data'
						// 	}
						// }).then(res=>{
						// 	console.log(res.data);
						// 	if(res.data.state){
						// 		if(window.confirm(res.data.msg+",点击确定跳转到列表页面!")){
						// 			location.href="/ems_vue/emplist.html";
						// 		}else{
						// 			_this.emp = {};
						// 		}
						// 	}else{
						// 		alert(res.data.msg);
						// 	}
						// });
      }
    });
  }

  resetForm(formName: string) {
    (this as any).$refs[formName].resetFields();
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
}
</style>
