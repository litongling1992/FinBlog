<template>
  <div>
    <!-- <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title bigger">{{labelName}}</h1>
          <p class="m-heading__description">
            {{essayCount}} articles with this tag
          </p>
        </div>
        <div class="image" style="height:500px;">
        </div>
      </div> -->
        <!-- <div class="l-content" data-aos="fade-up">
           <card :essayList="essayList"/>
      </div>
      <div class="l-content-foot"> 
        <el-pagination 
          small
          layout="prev, pager, next"
           @current-change="current_change"
          :total='essayCount'>
        </el-pagination>
      </div> -->
       <!-- <div class="l-content" data-aos="fade-up">
           <card :essayList="essayList"/>
      </div>
      <div class="l-content-foot" > 
        <el-pagination
          small
          layout="prev, pager, next"
           @current-change="current_change"
          :page-size="9"
          :total='essayCount'> 
        </el-pagination>
      </div> -->
     <div class="l-banan">
        <div class="img-content " data-aos="fade-down">
          <h1 class="m-hero-title bigger" :key="key">{{labelName}}</h1>
          <p class="m-heading__description" :key="key">
            {{essayCount}} articles with this tag
          </p>
        </div>
          <div class="image" style="height:500px;">
        </div>
      </div>
     <div class="l-content" data-aos="fade-up"> 
           <!-- <card :essayList="essayList" /> -->
            <!-- <custom-card  v-for="item in essayList" :essay="item" :key="item.id" :parentData="item.id"></custom-card> -->
            <!-- <li v-for="item in essayList" :key="item.id">
                {{ item.essayTitle }}
           </li> -->
             <custom-card   :essay="singleEssay"  :parentData="singleEssay.id"></custom-card>
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
import CardView from '@/components/card'
import CustomCard from '@/components/Custom'
import Vue from 'vue'
  export default {
    components: {
      CardView,
      CustomCard
    },
  data(){
    return{
      labelId : this.$Base64.decode(this.$route.params.labelId), 
        labelName: this.$route.params.labelName,
       	currentPage:1,
        essayList:[],
        essayCount:0,
        singleEssay:{}
    }
  },
        
 

 async created() {
      this.labelName=this.$route.params.labelName;
      console.log("第1次获取标签: "+this.labelName);

    await   this.getListEssay();
       this.key();

      this.$router.afterEach((to,from,next)=>{
 　　　　window,scrollTo(0,0)
 　　  });

      console.log("第1次获取标签结果: " + this.essayCount);
  },
   mounted() {
    
  // 开启滚动监听
	  window.addEventListener('scroll', this.handleScroll);
   //  console.log("第二次获取标签: "+this.labelName+";"+ this.essayCount)
    //  this.loadListEssay(this.labelName);
    //   console.log("第二次获取标签结果: "+this.labelName+";"+ this.essayCount)
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
    //$route:{

        // handler(newVal,oldVal){
        //    // this.labelId=this.$Base64.decode(newVal.params.labelId);
        //     this.labelName = this.$route.newVal.params.labelName;
        //     console.log("第3次获取标签"+this.labelName);
        //     this.getListEssay();
        //     console.log("监听标签："+this.labelName+";"+ this.essayCount);
        // }


    //}
  },



  methods: {
     // 滚动监听  滚动触发的效果写在这里
      handleScroll () {
        var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;

        if (scrollTop >= 20) { 
          this.getListEssay(); 
          window.removeEventListener('scroll', this.handleScroll); // 关闭监听  
        } 
      },
	    key(){
        var _this = this;
	      _this.key = _this.$route.params.labelName + Math.random();
	    },
     getEssayDetail(id){
        this.$router.push(`/essaydetail/${id}`)
      },

    async  current_change(currentPage){  //改变当前页
             this.currentPage = currentPage;
           await  this.getListEssay();
      },

       /**
       * 加载essayList
       */
     async getListEssay(){
          var _this = this;
          const pageQuery = {
				       pageNum:_this.currentPage,
				       pageSize: 9,
					     labelName: _this.labelName
				  };
     
          _this.$axios.post(`http://127.0.0.1:9002/api/blog/findEssay`,pageQuery)
            .then((response) =>{
              _this.essayList = [];
              _this.labelName = this.$route.params.labelName;
              let result = response.data.result;
                _this.singleEssay = result[0];
              // result.forEach(user=>{
              //           essayList.push(user);
              //           console.log("循环输出网络请求对象: "+user.labelName+";"+ user.essayTitle);
              //         })
              this.essayList = response.data.result;
              this.essayCount = response.data.totalSize;
              console.log("网络请求结果: "+this.labelName+";"+ this.essayCount);

              for(var i=0;i<this.essayList.length;i++){
                //_this.singleEssay = this.essayList[i];
                console.log("循环结果: "+this.essayList[i].essayTitle);
              }
              this.$forceUpdate();
              
            })
            .catch((error)=>{
               this.essayList=response.data.result;
             
               console.log("获取标签结果错误: "+error+this.labelName+";"+ this.essayCount)
            })
            await this.$nextTick();
      },

    },
}
</script>

<style lang="less" scoped>
//@import '../../assets/css/common.less';
  .l-banan{
    width: 100%;
    height: 15%;
    position: relative;
  }
   @media screen and (max-width: 3000px) and (min-width: 767px) {
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
 
  .m-hero-content{ 
     color: rgb(218, 216, 216);
  }
.image{
   width: 100%; 
   background: rgb(190, 207, 203);
    object-fit: cover;
}
  .l-content-foot{
    font-size: 40px;
    margin-top: 50px;
    height: 120px;
  }
</style>