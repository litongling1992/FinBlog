<!--
 * @Author: your name
 * @Date: 2021-01-25 16:17:16
 * @LastEditTime: 2021-03-02 19:52:54
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \vue_blog\src\views\code\index.vue
-->
<template>
    <div>
      <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title bigger">Code</h1>
          <p class="m-heading__description">
            {{essayCount}} articles with this tag
          </p>
        </div>
        <div class="l-image">  
          <img src="../../assets/img/code.jpg" class="image">
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
import Card from '@/components/card'; 
  export default {
    components: {
      Card
    },
    data() {
      return {
		currentPage:1,
        essayList:[],
        essayCount:0, 
        url:''
      };
    },
    created() {
      this.getListEssay();
    },
    mounted() {
    },
    methods: { 
      current_change(currentPage){  //改变当前页
             this.currentPage = currentPage;
             this.getListEssay(currentPage);
         },
      /**
       * 加载essayList
       */
      getListEssay(currentPage){
			const pageQuery ={
				       pageNum:this.currentPage,
				       pageSize: 9,
					   labelType:1
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