package com.baizhi.service;

import com.baizhi.entity.Essay;
import com.baizhi.vo.PageRequest;
import com.baizhi.vo.PageResult;

import java.util.List;

public interface EssayService {
    List<Essay> findAll();

    void save(Essay emp);

    void delete(String id);

    Essay findOne(String id);

    void updateOne(Essay emp);

    List<Essay> findByTags(String tag);

    List<String> findTags();

    PageResult findPage(PageRequest pageRequest);
}
