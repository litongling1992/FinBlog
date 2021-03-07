/*
Navicat MySQL Data Transfer

Source Server         : WJ
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : finemp

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-03-07 18:23:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_arcticle`
-- ----------------------------
DROP TABLE IF EXISTS `t_arcticle`;
CREATE TABLE `t_arcticle` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `arcticleclass` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tags` varchar(40) DEFAULT NULL,
  `title` varchar(60) DEFAULT NULL,
  `about` varchar(100) DEFAULT NULL,
  `imgpath` varchar(100) DEFAULT NULL,
  `content` mediumtext,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_arcticle
-- ----------------------------
INSERT INTO `t_arcticle` VALUES ('1', 'Life', 'Life', '生活', '1', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-02-24', '2021-02-24');
INSERT INTO `t_arcticle` VALUES ('2', 'Code', 'Java', '标题Java', '2', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-03-01', '2021-03-01');
INSERT INTO `t_arcticle` VALUES ('3', 'Code', 'Linux', 'Linux入门', '3', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-03-01', '2021-03-01');
INSERT INTO `t_arcticle` VALUES ('4', 'Code', 'Linux', '精通', '4', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-03-01', '2021-03-01');
INSERT INTO `t_arcticle` VALUES ('5', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_emp`
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `type` varchar(20) NOT NULL,
  `computer` varchar(40) NOT NULL,
  `mouse` varchar(40) NOT NULL,
  `other` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES ('1', '李同灵', '笔记本', '惠普', '小米无线鼠标', '显卡');
INSERT INTO `t_emp` VALUES ('2', '张发舜', '台式', '戴尔', '小米无线鼠标', '内存条:8G+显卡2G');
INSERT INTO `t_emp` VALUES ('5', '陈智力', '笔记本', '惠普', '有线鼠标', '风扇');
INSERT INTO `t_emp` VALUES ('6', '严世强', '笔记本', '惠普', '戴尔', '无');
INSERT INTO `t_emp` VALUES ('8', '钱育叶', '笔记本', '惠普', '无线', '有线');
INSERT INTO `t_emp` VALUES ('9', '梁燕', '笔记本', '惠普', '无线鼠标', '有线电视');
INSERT INTO `t_emp` VALUES ('10', '吕学学', '笔记本', '戴尔', '小米无线鼠标', '宏碁电脑');
INSERT INTO `t_emp` VALUES ('11', '周锋', '笔记本', '惠普', '鼠标', '无');
INSERT INTO `t_emp` VALUES ('12', '吴宇宁', '台式', '戴尔', '有线鼠标', '都放到');

-- ----------------------------
-- Table structure for `t_essay`
-- ----------------------------
DROP TABLE IF EXISTS `t_essay`;
CREATE TABLE `t_essay` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `essayTitle` varchar(100) DEFAULT NULL,
  `essayAbout` text,
  `essayContent` mediumtext,
  `essayImg` varchar(100) DEFAULT NULL,
  `labelId` varchar(10) DEFAULT NULL,
  `labelName` varchar(60) DEFAULT NULL,
  `createTime` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_essay
-- ----------------------------
INSERT INTO `t_essay` VALUES ('32', '关于这个博客的开发', '整体风格上，我对设计没有太多的见解，做的时候参考了好多网上,以及在别人现有的基础上改装而来，总体喜欢简约。', '<h1 id=\"自我介绍\">自我介绍</h1>\n<p>毕业于桂林电子科技大学，在一个公司从事了几年的桌面应用开发，从业几年一直在为了生活忙忙碌碌。最近几年Vue开始火起来，为了一探究竟最近也学了起来。希望保持着孜孜不倦的学习心态。在平时的工件或者学习中，遇到问题也经常是看大佬们的博客，从中有所收获。</p>\n<h1 id=\"开发个人博客的原因\">开发个人博客的原因</h1>\n<p>能学习前端知识和实践，对自己开发过程中遇到的问题做纪录，或许还能给别人提供帮助。也佩服能坚持写博客的人，同时希望自己也能更快成长（做为开发，选择了这个行业就必须去主动成长。要不带给你的就是淘汰），所以动手做了这个网站。</p>\n<h1 id=\"用到的技术\">用到的技术</h1>\n<h2 id=\"前端\">前端</h2>\n<p>正好在学Vue \nvue + vue-router + axios + element ui框架的样式 + mavon-editor</p>\n<h2 id=\"包含技术点：\">包含技术点：</h2>\n<pre><code>axios请求封装\n基本组件封装\n父子组件传值\n兄弟组件间传值\n路由传参\n传参加密\n</code></pre>\n<p> 同时博客的后端管理功能使用了vue + TypeScript</p>\n<h1 id=\"后端\">后端</h1>\n<h2 id=\"1、java\">1、Java</h2>\n<p>springboot + mysql + mybatis + redis</p>\n<p>包含技术点：（这对后端开发其实没啥技术点）</p>\n<h1 id=\"基本实现了一个简单的个人网页\">&quot; 基本实现了一个简单的个人网页 &quot;</h1>\n', 'http://localhost:9002/api/75831276-0e35-4564-b043-c6e2475166ff.jpg', 'Author', 'Author', '2021-03-07 08:41:10');
INSERT INTO `t_essay` VALUES ('33', 'Java', '测试篇', '<pre><code class=\"language-java\"> //保存文章信息\n    @PostMapping(&quot;saveEssay&quot;)\n    @CrossOrigin\n    public Map&lt;String, Object&gt; saveEssay(@RequestBody Essay emp) throws IOException {\n        log.info(&quot;博客文章信息: [{}]&quot;, emp.toString());\n        Map&lt;String, Object&gt; map = new HashMap&lt;&gt;();\n        try {\n            Date date = new Date( );\n            SimpleDateFormat ft = new SimpleDateFormat (&quot;yyyy-MM-dd hh:mm:ss&quot;);\n            Timestamp ts = new Timestamp(date.getTime());\n            emp.setCreateTime(ts);\n            //保存信息\n            empService.save(emp);\n            map.put(&quot;state&quot;, true);\n            map.put(&quot;msg&quot;, &quot;博客文章保存成功!&quot;);\n        } catch (Exception e) {\n            e.printStackTrace();\n            map.put(&quot;state&quot;, false);\n            map.put(&quot;msg&quot;, &quot;博客文章保存失败!&quot;);\n        }\n        return map;\n    }\n</code></pre>\n', 'http://localhost:9002/api/bd960711-14a9-4cb3-9eb2-73778a5a1430.jpg', 'Code', 'Java', '2021-03-07 09:48:59');
INSERT INTO `t_essay` VALUES ('34', 'Python', 'Pyhon代码以缩进式为一行', '<pre><code class=\"language-java\">\n//保存文章信息\n    @PostMapping(&quot;saveEssay&quot;)\n    @CrossOrigin\n    public Map&lt;String, Object&gt; saveEssay(@RequestBody Essay emp) throws IOException {\n        log.info(&quot;博客文章信息: [{}]&quot;, emp.toString());\n        Map&lt;String, Object&gt; map = new HashMap&lt;&gt;();\n        try {\n            Date date = new Date( );\n            SimpleDateFormat ft = new SimpleDateFormat (&quot;yyyy-MM-dd hh:mm:ss&quot;);\n            Timestamp ts = new Timestamp(date.getTime());\n            emp.setCreateTime(ts);\n            //保存信息\n            empService.save(emp);\n            map.put(&quot;state&quot;, true);\n            map.put(&quot;msg&quot;, &quot;博客文章保存成功!&quot;);\n        } catch (Exception e) {\n            e.printStackTrace();\n            map.put(&quot;state&quot;, false);\n            map.put(&quot;msg&quot;, &quot;博客文章保存失败!&quot;);\n        }\n        return map;\n    }\n</code></pre>\n', 'http://localhost:9002/api/8c6f4335-ff67-45ee-9147-75f5c6a73644.jpg', 'Code', 'Code', '2021-03-07 10:04:02');
INSERT INTO `t_essay` VALUES ('35', '终于完成', '暂时无摘要', '<pre><code class=\"language-ts\">{\n    path: &#39;/essayTable&#39;,\n    hidden: true,\n    name: &#39;essayManeger&#39;,\n    component: Layout,\n    redirect: &#39;/essayData&#39;,\n    children: [\n      {\n        path: &#39;/essayData&#39;,\n        name: &#39;essayData&#39;,\n        meta: { title: &#39;文章管理&#39;, icon: &#39;el-icon-coordinate&#39; , roles: [&#39;admin&#39;] },\n        component: () =&gt; import(&#39;@/views/Essay/EssayData.vue&#39;)\n      }\n    ]\n\n  },\n  {\n    path: &#39;/userManage&#39;,\n    hidden: true,\n    name: &#39;userManage&#39;,\n    component: Layout,\n    redirect: &#39;/accountData&#39;,\n    children: [\n      {\n        path: &#39;/accountData&#39;,\n        name: &#39;accountData&#39;,\n        meta: { title: &#39;账户管理&#39;, icon: &#39;el-icon-coordinate&#39; , roles: [&#39;admin&#39;] },\n        component: () =&gt; import(&#39;@/views/UserManager/AccountData.vue&#39;)\n      }\n    ]\n  },\n</code></pre>\n', 'http://localhost:9002/api/424f8f77-b22a-4547-8d43-c16075fd2097.jpg', 'Life', '代码', '2021-03-07 18:18:51.308');
INSERT INTO `t_essay` VALUES ('36', 'TypeScript', '暂时无摘要', '<pre><code class=\"language-ts\">{\n    path: &#39;/essayTable&#39;,\n    hidden: true,\n    name: &#39;essayManeger&#39;,\n    component: Layout,\n    redirect: &#39;/essayData&#39;,\n    children: [\n      {\n        path: &#39;/essayData&#39;,\n        name: &#39;essayData&#39;,\n        meta: { title: &#39;文章管理&#39;, icon: &#39;el-icon-coordinate&#39; , roles: [&#39;admin&#39;] },\n        component: () =&gt; import(&#39;@/views/Essay/EssayData.vue&#39;)\n      }\n    ]\n\n  },\n  {\n    path: &#39;/userManage&#39;,\n    hidden: true,\n    name: &#39;userManage&#39;,\n    component: Layout,\n    redirect: &#39;/accountData&#39;,\n    children: [\n      {\n        path: &#39;/accountData&#39;,\n        name: &#39;accountData&#39;,\n        meta: { title: &#39;账户管理&#39;, icon: &#39;el-icon-coordinate&#39; , roles: [&#39;admin&#39;] },\n        component: () =&gt; import(&#39;@/views/UserManager/AccountData.vue&#39;)\n      }\n    ]\n  },\n</code></pre>\n', 'http://localhost:9002/api/793e1b68-8f06-4410-a59a-f8e051a08fb2.jpg', 'Code', '代码', '2021-03-07 18:09:51.072');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `roles` varchar(50) NOT NULL,
  `regstertime` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `realname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123', 'admin', '2020-08-30 12:22:59', 'admin');
INSERT INTO `t_user` VALUES ('2', 'li', '123', 'visitor', '2020-08-30 12:24:46', 'Lee');
INSERT INTO `t_user` VALUES ('3', 'tt', '1234', 'visitor', '2020-08-30 06:50:26', '李同灵');
