/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: EssayController
 * Author:   Administrator
 * Date:     2021/3/2 18:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.controller;

import com.baizhi.entity.Essay;
import com.baizhi.service.EssayService;
import com.baizhi.vo.PageRequest;
import com.baizhi.vo.PageResult;
import com.baizhi.vo.TagsVo;
import lombok.extern.slf4j.Slf4j;
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
 * @create 2021/3/2
 * @since 1.0.0
 */
@RestController
@CrossOrigin
@RequestMapping("blog")
@Slf4j
public class EssayController {

    @Autowired
    private EssayService empService;

    @Value("${upload.dir}")
    private String realPath;



    //修改文章信息
    @PostMapping("update")
    public Map<String, Object> update(Essay emp, MultipartFile photo) throws IOException {
        log.info("博客文章信息: [{}]", emp.toString());

        Map<String, Object> map = new HashMap<>();
        try {
            if(photo!=null&&photo.getSize()!=0){
                log.info("头像信息: [{}]", photo.getOriginalFilename());
                //图片保存
                String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath, newFileName));
                //设置头像地址
                emp.setEssayImg(newFileName);
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
    public Essay findOne(String id){
        log.info("博客文章信息的id: [{}]",id);
        return empService.findOne(id);
    }

    //根据id查询文章信息实现
    @GetMapping("findOneById")
    public Map<String, Object> findOneById(String id){
        log.info("博客文章信息的id: [{}]",id);
        Map<String, Object> map = new HashMap<>();
        try{
            Essay arcticle = empService.findOne(id);
            if(arcticle != null){
                map.put("state",true);
                map.put("msg","查询文章信息成功!");
                map.put("result",arcticle);

            }else {
                map.put("state",false);
                map.put("msg","查询失败!");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","查询失败!");
        }
        return map;
    }

    //删除文章信息实现
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        log.info("删除博客文章的id:[{}]",id);
        Map<String, Object> map = new HashMap<>();
        try {
            //删除员工头像
            Essay emp = empService.findOne(id);
            File file = new File(realPath, emp.getEssayImg());
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
    public Map<String, Object> save(Essay emp, MultipartFile photo) throws IOException {
        log.info("博客文章信息: [{}]", emp.toString());
        log.info("头像信息: [{}]", photo.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        try {
            //头像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath, newFileName));
            //设置头像地址
            emp.setEssayImg(newFileName);
            //保存信息
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
    public Map<String,Object> findAll() {
        Map<String,Object> map = new HashMap<>();
        try {
            map.put("state",true);
            map.put("msg","获取所有标签成功");
            map.put("result",empService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","查询失败");
        }
        return map;
    }

    //获取所有文章列表的方法
    @GetMapping("findByTags")
    public Map<String,Object> findByTags(String tag) {
        Map<String,Object> map = new HashMap<>();
        try {
            map.put("state",true);
            map.put("msg","获取所有标签成功");
            map.put("result",empService.findByTags(tag));
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","查询失败");
        }
        return map;
    }

    //获取所有文章标签的方法
    @GetMapping("findTags")
    public Map<String,Object> findTags() {
        Map<String,Object> map = new HashMap<>();
        try {
            List<TagsVo> tagsVos = new ArrayList<TagsVo>();
          List<String> tags = empService.findTags();
            for(int i=0;i<tags.size();i++){
                TagsVo tag = new TagsVo();
                tag.setIndex(i+1);
                tag.setLabelName(tags.get(i));
                tagsVos.add(tag);
            }
            map.put("state",true);
            map.put("msg","获取所有标签成功");
            map.put("result",tagsVos);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","查询失败");
        }
        return map;
    }

    @CrossOrigin
    @PostMapping("findEssay")
    public Map<String,Object> findEssay(@RequestBody PageRequest pageQuery) {
        Map<String,Object> map = new HashMap<>();
        try {
            PageRequest p = new PageRequest();
            p.setPageSize(pageQuery.getPageSize());
            p.setPageNum(pageQuery.getPageNum());
            p.setLabelType(pageQuery.getLabelType());
            p.setLabelName(pageQuery.getLabelName());
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
