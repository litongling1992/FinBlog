/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: ArcticleController
 * Author:   Administrator
 * Date:     2021/2/24 14:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.controller;

import com.baizhi.entity.Arcticle;
import com.baizhi.entity.Emp;
import com.baizhi.service.ArcticleService;
import com.baizhi.service.EmpService;
import com.baizhi.vo.PageRequest;
import com.baizhi.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2021/2/24
 * @since 1.0.0
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("blog")
public class ArcticleController {

    @Autowired
    private ArcticleService empService;

    @Value("${upload.dir}")
    private String realPath;



    //修改文章信息
    @PostMapping("update")
    public Map<String, Object> update(Arcticle emp, MultipartFile photo) throws IOException {
        log.info("博客文章信息: [{}]", emp.toString());

        Map<String, Object> map = new HashMap<>();
        try {
            if(photo!=null&&photo.getSize()!=0){
                log.info("头像信息: [{}]", photo.getOriginalFilename());
                //图片保存
                String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath, newFileName));
                //设置头像地址
                emp.setImgpath(newFileName);
            }
            //更新文章信息
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

            empService.updateOne(emp);
            map.put("state", true);
            map.put("msg", "博客文章保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "博客保存失败!");
        }
        return map;
    }

    //根据id查询文章信息实现
    @GetMapping("findOne")
    public Arcticle findOne(String id){
        log.info("博客文章信息的id: [{}]",id);
        return empService.findOne(id);
    }

    //删除文章信息实现
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        log.info("删除博客文章的id:[{}]",id);
        Map<String, Object> map = new HashMap<>();
        try {
            //删除员工头像
            Arcticle emp = empService.findOne(id);
            File file = new File(realPath, emp.getImgpath());
            if(file.exists())file.delete();//删除头像
            //删除员工信息
            empService.delete(id);
            map.put("state",true);
            map.put("msg","删除员工信息成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","删除员工信息失败!");
        }
        return map;
    }


    //保存文章信息
    @PostMapping("save")
    public Map<String, Object> save(Arcticle emp, MultipartFile photo) throws IOException {
        log.info("博客文章信息: [{}]", emp.toString());
        log.info("头像信息: [{}]", photo.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        try {
            //头像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath, newFileName));
            //设置头像地址
            emp.setImgpath(newFileName);
            //保存员工信息
            empService.save(emp);
            map.put("state", true);
            map.put("msg", "博客文章保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "博客文章保存失败!");
        }
        return map;
    }

    //获取所有文章列表的方法
    @GetMapping("findAll")
    public List<Arcticle> findAll() {
        return empService.findAll();
    }


    @CrossOrigin
    @PostMapping("findPage")
    public Map<String,Object> findPage(@RequestBody PageRequest pageQuery) {
        Map<String,Object> map = new HashMap<>();
        try {
            PageRequest p = new PageRequest();
            p.setPageSize(pageQuery.getPageSize());
            p.setPageNum(pageQuery.getPageNum());
            PageResult result =empService.findPage(p);

            map.put("state",true);
            map.put("msg","分页查询成功");
            map.put("result",result.getContent());
            map.put("pageSize",result.getPageSize());
            map.put("totalSize",result.getTotalSize());
            map.put("totalPages",result.getTotalPages());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","查询失败");
        }
        return map;
    }
}
