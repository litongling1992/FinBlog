/*
 * @Author: your name
 * @Date: 2021-01-25 16:17:16
 * @LastEditTime: 2021-03-04 12:20:42
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \vue_blog\src\router\index.js
 */
import Vue from 'vue'
import Router from 'vue-router'
import HomeIndex from '@/views/homeIndex'

Vue.use(Router)

export default new Router({
  routes: [
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
          component:(resolve) =>require(['@/views/home'],resolve)
        },
        {
          path: '/essaydetail/:id',
          name: 'essaydetail',
          component:(resolve) =>require(['@/views/essaydetail'],resolve)
        },  {
          path: '/code',
          name: 'code',
          component:(resolve) =>require(['@/views/code'],resolve)
        }, 
        {
          path: '/life',
          name: 'life',
          component:(resolve) =>require(['@/views/life'],resolve)
        },
        {
          path: '/tag/:labelName',
          name: 'tag',
          component:(resolve) =>require(['@/views/tags'],resolve)
        },  
        {
          path: '/author',
          name: 'author',
          component:(resolve) =>require(['@/views/author'],resolve)
        },{
          path: '/labels/:labelName',
          name: 'labels',
          component:(resolve) =>require(['@/views/labels'],resolve)
        }, {
          path: '/message',
          name: 'message',
          component:(resolve) =>require(['@/views/message'],resolve)
        }
      ]
    }
  ]
})
const originalPush = Router.prototype.push
   Router.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}