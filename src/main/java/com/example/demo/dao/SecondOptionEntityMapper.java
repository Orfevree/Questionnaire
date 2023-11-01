package com.example.demo.dao;

import com.example.demo.dao.entity.SecondOptionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SecondOptionEntityMapper {

    //创建关联选项
    int creatSecondOption(SecondOptionEntity secondOptionEntity);


    List<SecondOptionEntity> querySecondOption(SecondOptionEntity secondOptionEntity);

}
