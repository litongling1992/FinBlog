<template>
    <div>
      <div class="l-banan">
        <img 
        :src="imgpath" class="image"> 
      </div>
      <div class="e-content"  data-aos="fade-up" v-highlight>
        <div>
          <h1 align='center'  style="font-size:200%;">{{essayDetail.essayTitle}}</h1>
          <br>
        </div>
          <article v-html="essayContent"></article>
      </div>
      <div class="e-banan"> 
      
         <el-tooltip class="item" effect="light" :content='contente' placement="right-start"> 
          <img src="../../assets/img/boycontent.png" class="boy-content" @mouseover='mouseover'>
         </el-tooltip> 

        <img src="../../assets/img/message.png" @click="drawer = true"  class="mage">
        <el-drawer
           direction='btt'
           size="80%"
          :visible.sync="drawer"
          :with-header="false">
          <div class="el-drawer-d"> 
            <el-card class="el-card-d" shadow="always">
             <div class="infinite-list-wrapper" style="overflow:auto;">
                <el-timeline
                  infinite-scroll-disabled="disabled"> 
                <div v-if="allmessages.length>0"> 
                  <el-timeline-item v-for="(item,index) in allmessages"  :key="index" :timestamp='item.createTime' placement="top">
                    <el-card class="el-card-m" style="height:120px">
                      <h4>{{item.memberName}}：</h4>
                      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.content}}</p>
                    </el-card>
                  </el-timeline-item>
                </div>
                <div v-else>
                   <el-timeline-item placement="top">
                    <el-card class="el-card-m" style="height:120px">
                      <h4>Coder：</h4>
                      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说点什么吧😁</p>
                    </el-card>
                  </el-timeline-item>
                </div>
              </el-timeline> 
              </div>
              <div class="el-card-messages">
                 <el-input type="textarea" :rows="5" placeholder="输入留言" maxlength="200" v-model="message"></el-input>
                 <el-button type="info" round class="submit-message" @click="submitMessage">留言</el-button>
              </div>
            </el-card> 
          </div>
        </el-drawer>
      </div>
      <h2 style="margin-top:50px">Recommended for you</h2>
      <div v-if="essayList.length>0" class="essay-card">
        <card :essayList="essayList"/>
      </div>
      <div v-else class="essay-card">
        <h3>No posts found</h3>
        <p>
        Apparently there are no posts at the moment, check again later.
      </p>
      </div>
       
      <!-- <circle class="progress-ring__circle js-progress" fill="transparent" r="23" stroke-width="3" cx="25" cy="25" style="stroke-dasharray: 157.08, 157.08; stroke-dashoffset: 141.372;"></circle> -->
     
  </div>
</template>
<script lang="ts">
import { Component, Vue, Provide, Prop, Watch} from 'vue-property-decorator';
import Common from "@/utils/Common"
import Base64 from "@/utils/Base64"
import Card from "@/components/card/Card.vue"
@Component({
  components:{
    Card
  }
})
export default class EssayDetail extends Vue{

        essayDetail:Object = {}
        essayContent:string = '';
        essayImg:string ='';
        essayList:any =[]
        id:string = Base64.decode(this.$route.params.id);
        contente:string = '';
        drawer:boolean =  false;
        count:number =  10;
        loading:boolean = false;
        message:string =''
        allmessages:any = [];

     @Watch("id", { deep: true })
    watchSpaceValues(newValue: string,oldVal:string) {
                 if (!newValue) return;
                this.id=Base64.decode(newValue),
                this.getEssay()
        }

    getEssay(){
          (this as any).$axios.get("http://localhost:9002/api/blog/findOne",)
                .then((res:any) => {
                        this.$message({
                            message: res.data.msg,
                            type: "success"
        });
            this.essayContent = res.data.content
            this.essayDetail = res.data
            this.essayImg = res.data.imgpath
            this.getListEssay(res.data.labelId,res.data.id);
     })
     .catch((err:any) => {

     })
    }

     /**
       * 加载essayList
       */
      getListEssay(labelId:string,id:string){
           (this as any).$post('/api/blog/findEssayByRe',{
              labelId:labelId,
              id:id
            })
            .then((response:any) =>{
              this.essayList=response.data.rows;
            })
      }

}
</script>


<style scope>

</style>