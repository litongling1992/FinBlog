<template>
  <div>
    <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title bigger">{{labelName}}</h1>
          <p class="m-heading__description">
            {{essayCount}} articles with this tag
          </p>
        </div>
        <div class="image" style="height:500px;">
        </div>
      </div>
        <div class="l-content" data-aos="fade-up">
           <card :essayList="essayList"/>
      </div>
      <div class="l-content-foot"> 
        <el-pagination 
          small
          layout="prev, pager, next"
           @current-change="current_change"
            :page-size="9"
          :total='essayCount'>
        </el-pagination>
      </div>
  </div>
</template>
<script lang="ts">
import { Component, Prop, Provide, Vue, Watch } from 'vue-property-decorator';
import Common from "@/utils/Common"
import Base64 from "@/utils/Base64"
import Card from "@/components/card/Card.vue"
@Component({
  components:{
    Card
  }
})
export default class Label extends Vue{

  isPage:boolean = false;

    labelId:string = Base64.decode(this.$route.params.labelId);

    labelName:string = this.$route.params.labelName;

  essayList:any = []; //文章数据
   @Provide() page:number =1;
   @Provide() size:number = 9;
   @Provide() essayCount:number =0;

  

      getEssayDetail(id:string){
        this.$router.push(`/essaydetail/${id}`)
      }

      current_change(currentPage:number){  //改变当前页
             this.page = currentPage;
             this.loadData();
        }

  
   created() {
        this.loadData();
        this.$router.afterEach((to,from,next)=>{
　　　　 window,scrollTo(0,0)
　　})
  }
    
     loadData() {
     const pageQuery:object ={
        pageNum:this.page,
        pageSize: this.size,
     };
    //  (this as any).$axios.post("http://127.0.0.1:8989/api/emp/findPage", pageQuery).then((res:any)=>{
    //     console.log("输出res:"+ res.pageNum);
    //     // this.tableData = res.data.data.list;
    //     // this.total = res.data.data.total;
    //      this.tableData = res.content;
    //      this.total = res.totalSize;
    //  })
      (this as any).$axios.post(`/api/blog/findPage`,pageQuery)
      .then((res: any) => {
         console.log("输出res:"+ res.data.pageSize);
         this.essayCount = res.data.totalSize;
         this.essayList = res.data.result;
      })
     .catch((err:string)=>{
      console.log("查询错误" + err);
     });
   }


}
</script>


<style lang="less" scope>
@import '../../assets/css/common.less';
</style>