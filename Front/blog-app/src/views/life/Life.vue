<!--
 * @Author: your name
 * @Date: 2021-03-02 12:51:34
 * @LastEditTime: 2021-03-02 12:53:51
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \blog-app\src\views\life\Life.vue
-->
<template>
  <div>
      <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title bigger">Life</h1>
          <p class="m-heading__description">
            Love life , stay safe
          </p>
        </div>
        <div class="l-image">
        <img src="../../assets/img/life.jpg" class="image" style="height:500px;">
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
import { Component, Vue, Provide, Prop, Watch} from 'vue-property-decorator';
import Common from "@/utils/Common"
import Base64 from "@/utils/Base64"
import Card from "@/components/card/Card.vue"
@Component({
  components:{
    Card
  }
})
export default class Life extends Vue{

    essayList:any = []; //文章数据
   @Provide() page:number =1;
   @Provide() size:number = 9;
   @Provide() essayCount:number =0;

   url:string ='';
    created () {
     this.loadData();
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
         this.essayList = res.data.result;
         this.essayCount = res.data.totalSize;
      })
     .catch((err:string)=>{
      console.log("查询错误" + err);
     });
   }

   current_change(currentPage:number){  //改变当前页
      this.page = currentPage;
      this.loadData();
    }

}
</script>


<style lang="less" scoped>  
@import '../../assets/css/common.less';
</style>