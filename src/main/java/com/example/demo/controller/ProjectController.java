package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.ProjectEntity;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8085", maxAge = 3600)
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     *项目查询
     */
    @RequestMapping(value = "/queryProjectList", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody ProjectEntity projectEntity){

        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        if(projectEntity.getProjectName()!=null&&projectEntity.getId()==null&&!projectEntity.getProjectName().isEmpty()) {
            try {
                List<ProjectEntity> hasProject = projectService.selectProjectByName(projectEntity);
                if (CollectionUtils.isEmpty(hasProject)) {
                    httpResponseEntity.setCode("0");
                    httpResponseEntity.setData("null");
                    httpResponseEntity.setMessage("按名称查询所有失败");
                } else {
                    httpResponseEntity.setCode("666");
                    httpResponseEntity.setData(hasProject);
                    httpResponseEntity.setMessage("查询成功");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }else if(projectEntity.getId()!= null &&projectEntity.getProjectName()==null){
            try {
                List<ProjectEntity> hasProject = projectService.selectProjectById(projectEntity);
                if (CollectionUtils.isEmpty(hasProject)) {
                    httpResponseEntity.setCode("0");
                    httpResponseEntity.setData("null");
                    httpResponseEntity.setMessage("返回信息失败");
                } else {
                    httpResponseEntity.setCode("666");
                    httpResponseEntity.setData(hasProject);
                    httpResponseEntity.setMessage("查询成功");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }else{
            try {
                List<ProjectEntity> hasProject = projectService.queryProjectList(projectEntity);
                if (CollectionUtils.isEmpty(hasProject)) {
                    httpResponseEntity.setCode("0");
                    httpResponseEntity.setData("");
                    httpResponseEntity.setMessage("无项目信息");
                } else {
                    httpResponseEntity.setCode("666");
                    httpResponseEntity.setData(hasProject);
                    httpResponseEntity.setMessage("查询成功");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }



        return httpResponseEntity;
    }

    /**
     * 项目新增
     */
    @RequestMapping(value = "/addProjectInfo", method = RequestMethod .POST, headers = "Accept=application/json")
    public HttpResponseEntity addProjectInfo(@RequestBody ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.addProjectInfo(projectEntity);
            if (result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            } else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 项目修改
     */
    @RequestMapping(value = "/modifyProjectInfo", method = RequestMethod .POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyProjectInfo(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.modifyProjectInfo(projectEntity);
            if (result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            } else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    /**
     * 项目删除
     */
    @RequestMapping(value = "/deleteProjectById", method = RequestMethod .POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteProjectById(@RequestBody ProjectEntity projectEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result = projectService.deleteProjectById(projectEntity);
            if (result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            } else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

}
