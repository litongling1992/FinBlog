/*
 * @Author: your name
 * @Date: 2020-07-25 13:03:14
 * @LastEditTime: 2021-03-06 12:25:57
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \blog-front\vue.config.js
 */
module.exports = {
    // 反向代理
  devServer: {
    open: true,
    host: 'localhost',
    port: 8080,
    https: false,
    hotOnly: false,
    proxy: {
      // 配置跨域
      '/api': {
        target: 'http://127.0.0.1:9002/api',
        ws: true,
        changOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    },
    before: app => {}
  }
};