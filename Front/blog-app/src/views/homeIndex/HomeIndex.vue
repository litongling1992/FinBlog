<template>
  <div>
    <nav-bar></nav-bar>
    <router-view></router-view>
    <my-footer></my-footer>
  </div>
  
</template>

<script>
import { Component, Prop, Provide, Vue } from 'vue-property-decorator';
import Common from "@/utils/Common"
import Base64 from "@/utils/Base64"
import Card from "@/components/card/Card.vue"
import NavBar from '../../components/nav/Nav.vue'
import MyFooter from '../../components/footer/Footer.vue'
@Component({
  components:{
    NavBar,
    MyFooter
  }
})
export default class HomeIndex extends Vue {

}
</script>

<style>

</style>