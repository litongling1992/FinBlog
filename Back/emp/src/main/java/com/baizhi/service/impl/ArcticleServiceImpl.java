/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: ArcticleServiceImpl
 * Author:   Administrator
 * Date:     2021/2/24 14:00
 * Description: 博客文章服务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.service.impl;

import com.baizhi.dao.ArcticleDao;
import com.baizhi.entity.Arcticle;
import com.baizhi.service.ArcticleService;
import com.baizhi.vo.PageRequest;
import com.baizhi.vo.PageResult;
import com.baizhi.vo.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈博客文章服务实现类〉
 *
 * @author Administrator
 * @create 2021/2/24
 * @since 1.0.0
 */
@Service
@Transactional //事务的注解
public class ArcticleServiceImpl implements ArcticleService {

    @Resource
    ArcticleDao arcticleDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Arcticle> findAll() {
        return arcticleDao.findAll();
    }

    @Override
    public List<Arcticle> findByTags(String tag) {
        return arcticleDao.findByTags(tag);
    }

    @Override
    public List<String> findTags() {
        return arcticleDao.findTags();
    }

    @Override
    public void save(Arcticle emp) {
        emp.setCreate_date(new Date());
        emp.setUpdate_date(new Date());
        arcticleDao.save(emp);
    }

    @Override
    public void delete(String id) {
        arcticleDao.delete(id);
    }

    @Override
    public Arcticle findOne(String id) {
        return arcticleDao.findOne(id);
    }

    @Override
    public void updateOne(Arcticle emp) {
        emp.setCreate_date(new Date());
        emp.setUpdate_date(new Date());
        arcticleDao.updateOne(emp);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @return
     */
    private PageInfo<Arcticle> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Arcticle> sysMenus = arcticleDao.findPage();
        return new PageInfo<Arcticle>(sysMenus);
    }
}
