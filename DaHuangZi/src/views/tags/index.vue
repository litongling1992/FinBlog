<!--
 * @Author: your name
 * @Date: 2021-01-25 16:17:16
 * @LastEditTime: 2021-03-04 13:56:08
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue_blog\src\views\life\index.vue
-->
<template>
    <div>
      <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title bigger">{{labelName}}</h1>
          <p class="m-heading__description">
           {{essayCount}} articles with this tag
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

<script>   
import Card from '@/components/card'
  export default {
    components: {
      Card
    },
    data() {
      return {
		currentPage:1,
        essayList:[],
        essayCount:0,
        labelName: '',

      };
    },
     watch:{

    $route(to,from){
     
      this.labelName = this.$route.params.labelName;
       console.log("第3次获取标签"+this.labelName);
       this.getListEssay();
       this.key();
       console.log("第3次获取结果 " + this.essayList);
    
    },

    labelName(newVal,oldVal){
      this.labelName = this.$route.newVal.params.labelName;
      this.getListEssay();
      console.log("监听标签："+this.labelName+";"+ this.essayCount);
    }
  },

    created() {
      this.getListEssay();
    },
    mounted() {
    },
    methods: {
      getEssayDetail(id){
        this.$router.push(`/essaydetail/${id}`)
      },
      current_change(currentPage){  //改变当前页
             this.currentPage = currentPage;
             this.getListEssay();
         },
      /**
       * 加载essayList
       */
      getListEssay(){
    const pageQuery ={
      labelName: this.$route.params.labelName,
			pageNum:this.currentPage,
			pageSize: 9,
		};
     this.$axios.post(`http://127.0.0.1:9002/api/blog/findEssay`,pageQuery)
            .then((response) =>{
              this.essayList=response.data.result;
              this.essayCount=response.data.totalSize;
            })
      },
    },
  }
</script>

 
<style lang="less" scoped>  
@import '../../assets/css/common.less';
</style>