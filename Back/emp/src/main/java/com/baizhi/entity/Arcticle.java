/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Arcticle
 * Author:   Administrator
 * Date:     2021/2/24 12:05
 * Description: 博客文章实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈博客文章实体〉
 *
 * @author Administrator
 * @create 2021/2/24
 * @since 1.0.0
 */
@Data
@Accessors(chain=true)
public class Arcticle implements Serializable {
    public String id ;
    public String arcticleclass;
    public String tags;
    public String title;
    public String imgpath;
    public String content;
    public Date create_date;
    public Date update_date;
}
