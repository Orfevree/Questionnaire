package com.example.demo.service;

import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.dao.ProjectEntityMapper;
import com.example.demo.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectEntityMapper projectEntityMapper;

    /**
     * 项目查询
     */
    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity){

        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }

    /**
     * 根据项目名查询
     */
    public List<ProjectEntity> selectProjectByName(ProjectEntity projectEntity){
        List<ProjectEntity> result = projectEntityMapper.selectProjectByName(projectEntity);
        return result;
    }

    /**
     * 根据项目id查询
     */
    public List<ProjectEntity> selectProjectById(ProjectEntity projectEntity){
        List<ProjectEntity> result = projectEntityMapper.selectProjectById(projectEntity);
        return result;
    }

    /**
     * 项目新增
     */
    public int addProjectInfo(ProjectEntity projectEntity){
        projectEntity.setId(UUIDUtil.getOneUUID());
        int projectResult = projectEntityMapper.insert(projectEntity);
        if(projectResult!=0){
            return 3;//3表示用户存在
        }else {
            return projectResult;
        }
    }

    /**
     * 项目修改
     */
    public int modifyProjectInfo(ProjectEntity projectEntity){
        int projectResult = projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        return projectResult;
    }

    /**
     * 项目删除
     */
    public int deleteProjectById(ProjectEntity projectEntity){
        int projectResult = projectEntityMapper.deleteProjectById(projectEntity);
        return projectResult;
    }
}
