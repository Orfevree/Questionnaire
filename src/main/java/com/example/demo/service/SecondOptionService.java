package com.example.demo.service;

import com.example.demo.dao.SecondOptionEntityMapper;
import com.example.demo.dao.entity.SecondOptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondOptionService {

    @Autowired
    private SecondOptionEntityMapper secondOptionEntityMapper;

    //创建关联问题
    public int creatSecondOption (SecondOptionEntity secondOptionEntity){
        int result = secondOptionEntityMapper.creatSecondOption(secondOptionEntity);
        return result;
    }

    //删除关联问题

    public List<SecondOptionEntity> querySecondOption (SecondOptionEntity secondOptionEntity){
        List<SecondOptionEntity> result = secondOptionEntityMapper.querySecondOption(secondOptionEntity);
        return result;
    }

}
