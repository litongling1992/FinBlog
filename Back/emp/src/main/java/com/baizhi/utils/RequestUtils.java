/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: RequestUtils
 * Author:   Administrator
 * Date:     2021/3/5 17:10
 * Description: 请求获取服务器地址
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈请求获取服务器地址〉
 *
 * @author Administrator
 * @create 2021/3/5
 * @since 1.0.0
 */
public class RequestUtils {
    public static  String getBasePath(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

        return basePath;
    }
}
