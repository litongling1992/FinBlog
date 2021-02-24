<!--
 * @Author: your name
 * @Date: 2021-02-17 13:05:09
 * @LastEditTime: 2021-02-17 19:54:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue-empty-demo\src\components\card\Card.vue
-->
<template>
    <div class="card-t">
        <el-row>

        </el-row>
    </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class Card extends Vue{

}
</script>


<style scope>
.card-t{
  width: 80%; 
  margin: 0 auto;
       
}
.el-row{
   /**
  卡片居中
  */
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
}
 
.el-col{ 
    width: 350px;
    height: 500px; 
    padding: 20px;
    margin-top: 40px;
    border-radius:10px; 
}
  /*
  阴影+鼠标划过浮动
 */ 
  .card-blog{
     border-radius:10px; 
  }
  .card-blog:hover{
    border-radius:10px;  
    transform: translate(0,-7px);
	  transition-delay: 0s !important; 
  }
.card-m{
    width:100%;
    height: 100px;
    overflow: hidden;/* 超出的文本隐藏 */
    text-overflow: ellipsis; /* 溢出用省略号显示 */
}

  .image {
    width: 100%;
    height: 250px;
    display: block;
    object-fit: cover;
    cursor: pointer;
  }
  .card-massges{
    height: 120px;
    text-align: center;
    width: 80%;
    margin:0 auto;
    background: #ffffff;
    
    cursor: pointer;
  }
  .card-label{
    margin-right: 260px; 
  }
  .m-card-tag{
    cursor: pointer;
    margin: 0 auto;
    border-radius: 15px;
    background: #2ec4b6; 
    display: inline-block;
    font-size: 12px;
    font-weight: 700;
    padding: 5px 10px; 
    color: rgb(250, 250, 250);
  }
    .l-time{
   margin-right: 55%; 
   color: rgb(124, 120, 120) ;
  }
  @media screen and (max-width: 3000px) and (min-width: 1000px) {
      
   }

</style>