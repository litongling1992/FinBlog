/*
 * @Author: your name
 * @Date: 2020-08-12 17:04:28
 * @LastEditTime: 2021-03-07 10:39:53
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \blog-front\src\main.ts
 */
import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from './utils/http'
//import mavonEditor from "mavon-editor"
//import "mavon-editor/dist/css/index.css";

//  markdown编辑器
 //markdown解析== 全局引入== 在main.ts中 
 import mavonEditor from 'mavon-editor'
 import 'mavon-editor/dist/css/index.css'
//  import { markdownItMermaid } from '@liradb2000/markdown-it-mermaid';
//  mavonEditor.markdownIt.use(markdownItMermaid);
 Vue.use(mavonEditor)
// import mavonEditor from 'mavon-editor'  //引入markdown编辑器
// import 'mavon-editor/dist/css/index.css'
// Vue.use(mavonEditor)
// 富文本编辑器
// import VueQuillEditor from 'vue-quill-editor' //引入富文本编辑器
// import 'quill/dist/quill.core.css' // import styles
// import 'quill/dist/quill.snow.css' // for snow theme
// import 'quill/dist/quill.bubble.css' // for bubble theme
// Vue.use(VueQuillEditor)

//import '@/assets/css/markdown/dark.css' //引入代码高亮的css
import hljs from 'highlight.js'

// //封装成一个指令
// Vue.directive('highlight', (el) => {
//     let blocks = el.querySelectorAll('pre code')
//     blocks.forEach((block) => {
//         hljs.highlightBlock(block)
//     })
// })

Vue.use(ElementUI);
//Vue.component("mavon-editor", mavonEditor);


Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
//axios.defaults.baseURL = '/api'

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
