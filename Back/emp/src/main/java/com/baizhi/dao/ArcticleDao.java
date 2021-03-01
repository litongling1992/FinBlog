package com.baizhi.dao;

import com.baizhi.entity.Arcticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArcticleDao {

    List<Arcticle> findAll();

    void save(Arcticle article);

    void delete(String id);

    Arcticle findOne(String id);

    void updateOne(Arcticle article);

    List<Arcticle> findByTags(String tag);

    List<Arcticle> findPage();

    List<String> findTags();

}
