package com.baizhi.service;

import com.baizhi.entity.Arcticle;
import com.baizhi.vo.PageRequest;
import com.baizhi.vo.PageResult;

import java.util.List;

public interface ArcticleService {

    List<Arcticle> findAll();

    void save(Arcticle emp);

    void delete(String id);

    Arcticle findOne(String id);

    void updateOne(Arcticle emp);

    List<Arcticle> findByTags(String tag);

    PageResult findPage(PageRequest pageRequest);
}
