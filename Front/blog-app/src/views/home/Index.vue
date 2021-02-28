<template>
    <div>
      <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title">DaHuangzi</h1>
          <p class="m-heading__description">
            Better late than never
          </p>
        </div>
         <div class="l-image">
        <img 
        v-lazy='"https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/0386296a30942b399e2916816a520c8d54ccb107a9a6f9452049c44cd0aa4a2cc1210a9aa000402e7ba3b210a858b13e?pictype=scale&from=30013&version=3.3.3.3&uin=2248410897&fname=pexels-simon-migaj-747964.jpg&size=750"' 
        :key='"https://picabstract-preview-ftn.weiyun.com/ftn_pic_abs_v3/0386296a30942b399e2916816a520c8d54ccb107a9a6f9452049c44cd0aa4a2cc1210a9aa000402e7ba3b210a858b13e?pictype=scale&from=30013&version=3.3.3.3&uin=2248410897&fname=pexels-simon-migaj-747964.jpg&size=750"'
       class="image">
         </div>
      </div>
      <div class="l-content" data-aos="fade-up">
           <card :essayList="essayList"/>
      </div>
      <div class="l-content-foot" > 
        <el-pagination v-show="isPage" 
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
import { Component, Prop, Provide, Vue } from 'vue-property-decorator';
import Common from "@/utils/Common"
import Base64 from "@/utils/Base64"
import Card from "@/components/card/Card.vue"
@Component({
  components:{
    Card
  }
})
export default class Index extends Vue{
    isPage:boolean =  false;
   essayList:any = []; //文章数据
   @Provide() page:number =1;
   @Provide() size:number = 9;
   @Provide() essayCount:number =0;

   url:string ='';
   mounted() {
    // 开启滚动监听
	  window.addEventListener('scroll', this.handleScroll);
    }

    // 滚动监听  滚动触发的效果写在这里
      handleScroll () {
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;

        if (scrollTop >= 20) { 
          this.loadData(); 
          this.isPage=true
          window.removeEventListener('scroll', this.handleScroll); // 关闭监听  
        } 
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

 
   @media screen and (max-width: 2000px) and (min-width: 767px) {
       .m-hero-title{
    text-shadow:
    -1px 1px 0 #ddd,
    -2px 2px 0 #c8c8c8,
    -3px 3px 0 #ccc,
    -4px 4px 0 #b8b8b8,
    -4px 4px 0 #bbb,
    0px 1px 1px rgba(0,0,0,.4),
    0px 2px 2px rgba(0,0,0,.3),
    -1px 3px 3px rgba(0,0,0,.2),
    -1px 5px 5px rgba(0,0,0,.1),
    -2px 8px 8px rgba(0,0,0,.1),
    -2px 13px 13px rgba(0,0,0,.1)
    ;
}
          .img-content{
        position: absolute;
        left:45%;
        top:38%;
        transform: translate(-45%, -38%);
        color:  #faf9f9;
      }
   }
    @media screen and (max-width:768px) and (min-width: 100px){ 
      
        .img-content{
            position: absolute;
            left:30%;
            top:30%;
            transform: translate(-45%, -45%);
            color:  #faf9f9;
        }
    }
</style>