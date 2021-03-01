<!--
 * @Author: your name
 * @Date: 2021-03-01 12:11:55
 * @LastEditTime: 2021-03-01 16:13:30
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \blog-app\src\components\footer\Footer.vue
-->
<template>
    <div>
      <div class="m-footer">
        <div class="m-footer-p">
          <span class="m-footer-i">LiTonglingBlog © 2021</span>
          <span class="m-footer-i">&nbsp; • &nbsp;</span>
          <span> <a href="http://beian.miit.gov.cn/" class="m-footer-a" target="_blank" rel="noopener">京ICP备</a></span>
        </div>
      </div>
  </div>
</template>
<script lang="ts">
import { Component, Prop, Provide, Vue } from 'vue-property-decorator';
import Common from "@/utils/Common"
import Base64 from "@/utils/Base64"
@Component
export default class Footer extends Vue{

}
</script>
<style lang="less" scoped>

.m-footer{
    width: 100%;
    height: 200px;
    background: #3c6d9e;
    .m-footer-p{
      float: left;
      width:100%;
      margin-top: 80px;
      color: rgb(250, 250, 250); 
      .m-footer-a{
        text-decoration: none;
        color: rgb(250, 250, 250); 
      }
    }
}


</style>