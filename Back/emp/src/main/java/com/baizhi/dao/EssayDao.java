package com.baizhi.dao;

import com.baizhi.entity.Arcticle;
import com.baizhi.entity.Essay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EssayDao {

    List<Essay> findAll();

    void save(Essay article);

    void delete(String id);

    Essay findOne(String id);

    void updateOne(Essay article);

    List<Essay> findByTags(String tag);

    List<Essay> findPage();

    List<String> findTags();
}
