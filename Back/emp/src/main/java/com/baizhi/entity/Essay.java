/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: Essay
 * Author:   Administrator
 * Date:     2021/3/2 18:03
 * Description: 文章博客实体类
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
 * 〈文章博客实体类〉
 *
 * @author Administrator
 * @create 2021/3/2
 * @since 1.0.0
 */
@Data
@Accessors(chain=true)
public class Essay implements Serializable {

    public String id ;
    public String essayTitle;
    public String essayAbout;
    public String essayImg;
    public String essayContent;
    public String labelId;
    public String labelName;
    public Date createTime;
}
