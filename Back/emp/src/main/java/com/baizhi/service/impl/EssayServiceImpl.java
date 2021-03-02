/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: EssayServiceImpl
 * Author:   Administrator
 * Date:     2021/3/2 18:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.service.impl;

import com.baizhi.dao.EmpDao;
import com.baizhi.dao.EssayDao;
import com.baizhi.entity.Emp;
import com.baizhi.entity.Essay;
import com.baizhi.service.EssayService;
import com.baizhi.vo.PageRequest;
import com.baizhi.vo.PageResult;
import com.baizhi.vo.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2021/3/2
 * @since 1.0.0
 */
@Service
@Transactional //事务的注解
public class EssayServiceImpl implements EssayService {

    @Autowired
    EssayDao empDao;

    @Override
    public List<Essay> findAll() {
        return empDao.findAll();
    }

    @Override
    public void save(Essay emp) {
        empDao.save(emp);
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }

    @Override
    public Essay findOne(String id) {
        return empDao.findOne(id);
    }

    @Override
    public void updateOne(Essay emp) {
        empDao.updateOne(emp);
    }

    @Override
    public List<Essay> findByTags(String tag) {
        return empDao.findByTags(tag);
    }

    @Override
    public List<String> findTags() {
        return empDao.findTags();
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
    private PageInfo<Essay> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();

        PageHelper.startPage(pageNum, pageSize);

        List<Essay> sysMenus = empDao.findPage();

        switch (pageRequest.getLabelType()){
            case 1:
                sysMenus = empDao.findByTags("Code");
                break;
            case 2:
                sysMenus = empDao.findByTags("Life");
                break;
            case 3:
                sysMenus = empDao.findByTags("Author");
                break;
            default:
                break;
        }
        if (pageRequest.getLabelName() != null){
            sysMenus = empDao.findByTags(pageRequest.getLabelName());
        }

        return new PageInfo<Essay>(sysMenus);
    }
}
