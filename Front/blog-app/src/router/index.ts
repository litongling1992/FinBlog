/*
 * @Author: your name
 * @Date: 2021-02-24 17:17:45
 * @LastEditTime: 2021-03-02 13:51:28
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \blog-app\src\router\index.ts
 */
import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import Home from '../views/home/Index.vue'
import HomeIndex from '../views/homeIndex/HomeIndex.vue'
import essaydetail from '../views/essaydetail/EssayDetail.vue'
import code from '../views/code/Code.vue'
import life from '../views/life/Life.vue'
import author from '../views/author/Author.vue'
import label from '../views/label/Label.vue'
import message from '../views/message/Message.vue'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: '/',
    redirect: '/home',
  },
  {
    path: '/home',
    component: HomeIndex,
    children: [
      {
        path: '/home',
        name: 'home',
        component:Home
      },
      // {
      //   path: '/essaydetail/:id',
      //   name: 'essaydetail',
      //   component: essaydetail
      // }, 
      // {
      //   path: '/essaydetail/:id',
      //   name: 'essaydetail',
      //   component:(resolve) =>require(['@/views/essaydetail'],resolve)
      // },
     
      {
        path: '/code',
        name: 'code',
        component:code
      },  
      {
        path: '/life',
        name: 'life',
        component:life
      },  
      {
        path: '/author',
        name: 'author',
        component:author
      },
      {
        path: '/labels/:labelId/:labelName',
        name: 'labels',
        component:label
      }, 
      {
        path: '/message',
        name: 'message',
        component:message
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
//解决重复点击左侧菜单栏，控制台会输出报错问题
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location:any) {
  return (originalPush.call(this, location) as any).catch((err:any) => err)
}
export default router
