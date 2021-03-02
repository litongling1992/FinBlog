/*
 * @Author: your name
 * @Date: 2021-02-24 17:17:44
 * @LastEditTime: 2021-03-02 12:38:28
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \blog-app\src\main.ts
 */
import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import less from 'less'
import Highlight from './utils/highlight'
import VueLazyload from 'vue-lazyload'

Vue.prototype.$axios = axios  
Vue.config.productionTip = false
Vue.use(Highlight)
//Vue.use(less)
Vue.use(ElementUI)
/* eslint-disable no-new */
Vue.use(VueLazyload, {
  loading: require('./assets/img/loading.gif'),//加载中图片，一定要有，不然会一直重复加载占位图
  error: require('./assets/img//error_img.jpg')  //加载失败图片
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
