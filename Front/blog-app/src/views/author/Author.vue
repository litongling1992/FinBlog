<template>
     <div>
      <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title bigger">Author</h1>
          <p class="m-heading__description">
            Sun was shining over me
          </p>
        </div>
        <div class="l-image">
        <img 
          v-lazy='"https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/d078ff000f9e4cbfcd4b3be8b0a10bf74d2f3948a85d427ba9506f8040bcdbc98bb2ccdd2fc1fa81557dfd08bb17e012?pictype=scale&from=30013&version=3.3.3.3&uin=2248410897&fname=pexels-sam-lion-5731804.jpg&size=750"' 
          :key='"https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/d078ff000f9e4cbfcd4b3be8b0a10bf74d2f3948a85d427ba9506f8040bcdbc98bb2ccdd2fc1fa81557dfd08bb17e012?pictype=scale&from=30013&version=3.3.3.3&uin=2248410897&fname=pexels-sam-lion-5731804.jpg&size=750"'
         class="image" style="height:500px;">
        </div>
      </div>
      <div class="l-content" data-aos="fade-up">
           <card :essayList="essayList"/>
      </div>
      <div class="l-content-foot"> 
        <el-pagination  v-show="isPage" 
          small
          layout="prev, pager, next"
          @current-change="current_change"
          :page-sizes="[5,10,20]" 
          :page-size="size"
          :total='essayCount'>
        </el-pagination>
      </div>
    </div>
</template>
<script lang="ts">
import { Component, Prop, Provide, Vue } from 'vue-property-decorator';
import Common from "@/utils/Common"
import Base64 from "@/utils/Base64"
import Card from "@/components/card/Card.vue"
@Component({
  components:{
    Card
  }
})
export default class Author extends Vue{

  isPage:boolean = false;


  essayList:any = []; //文章数据
   @Provide() page:number =1;
   @Provide() size:number = 9;
   @Provide() essayCount:number =0;

  mounted() {
       // 开启滚动监听
	  window.addEventListener('scroll', this.handleScroll);
    }

       // 滚动监听  滚动触发的效果写在这里
      handleScroll () {
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;

        if (scrollTop >= 30) { 
          this.loadData(); 
          this.isPage=true
          window.removeEventListener('scroll', this.handleScroll); // 关闭监听  
        } 
      }

      getEssayDetail(id:string){
        this.$router.push(`/essaydetail/${id}`)
      }

      current_change(currentPage:number){  //改变当前页
             this.page = currentPage;
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