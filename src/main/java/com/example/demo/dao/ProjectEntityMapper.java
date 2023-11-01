package com.example.demo.dao;

import com.example.demo.dao.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectEntityMapper {

    /**
     *项目查询
     */
    List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);

    /**
     * 根据项目名查询
     */
    List<ProjectEntity> selectProjectByName(ProjectEntity projectEntity);

    /**
     * 根据项目名查询
     */
    List<ProjectEntity> selectProjectById(ProjectEntity projectEntity);

    /**
     *项目新增
     */
    int insert(ProjectEntity projectEntity);

    /**
     * 项目修改
     */
    int updateByPrimaryKeySelective(ProjectEntity projectEntity);

    /**
     * 项目删除
     */
    int deleteProjectById(ProjectEntity projectEntity);

}
