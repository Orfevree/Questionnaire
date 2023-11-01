package com.example.demo;

import com.example.demo.common.utils.UUIDUtil;
import com.example.demo.controller.*;
import com.example.demo.dao.ProjectEntityMapper;
import com.example.demo.dao.UserEntityMapper;
import com.example.demo.dao.entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

@SpringBootTest
class Demo1ApplicationTests {

    /*  @Test
      void contextLoads() {
      }
  */
    Logger log = Logger.getLogger(Demo1ApplicationTests.class);

    @Resource
    private ProjectController projectController;
    @Resource
    private UserController userController;
    @Resource
    private QuestionController questionController;
    @Resource
    private QuestionnaireController questionnaireController;
    @Resource
    private SecondOptionController secondOptionController;


    //问卷添加测试
    @Test
    public void testAddQuestionnaire() throws Exception{
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        //添加成功测试
        questionnaireEntity.setProjectId("1");
        questionnaireEntity.setQuestionnaireId(90);
        questionnaireEntity.setQuestionnaireName("添加测试成功");

        //添加失败测试
        questionnaireEntity.setQuestionnaireId(60);

        questionnaireController.creatQuestionnaire(questionnaireEntity);
        //异常测试
        questionnaireController.creatQuestionnaire(null);
    }


    //问卷删除测试
    @Test
    public void testDelQuestionnaire() throws Exception{
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        //删除成功测试
        questionnaireEntity.setProjectId("1");
        questionnaireEntity.setQuestionnaireId(66);
        questionnaireEntity.setQuestionnaireName("删除测试成功");

        //删除失败测试
        questionnaireEntity.setQuestionnaireId(100);

        questionnaireController.deleteQuestionnaireById(questionnaireEntity);
        //异常测试
        questionnaireController.deleteQuestionnaireById(null);
    }

    //问卷展示测试
    @Test
    public void testQueryQuestionnaire() throws Exception{
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        //展示成功测试
        /*questionnaireEntity.setProjectId("1");
        questionnaireEntity.setQuestionnaireId(90);
        questionnaireEntity.setQuestionnaireName("添加测试成功");*/

        //展示失败测试
        /*questionnaireEntity.setQuestionnaireId(60);*/

        questionnaireController.queryQuestionnaireList(questionnaireEntity);
        //异常测试
        questionnaireController.queryQuestionnaireList(null);
    }

    //问卷发布测试
    @Test
    public void testPublishQuestionnaire() throws Exception{
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        //发布成功测试
        questionnaireEntity.setQuestionnaireId(88);
        //questionnaireEntity.setPublishTime();


        //发布失败测试
        questionnaireEntity.setQuestionnaireId(101);

        questionnaireController.publishQuestionnaire(questionnaireEntity);
        //发布测试
        questionnaireController.publishQuestionnaire(null);
    }

    //问卷预览测试
    @Test
    public void testPreviewQuestionnaire() throws Exception{
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        //预览成功测试
        questionnaireEntity.setQuestionnaireId(70);
        //questionnaireEntity.setPublishTime();


        //预览失败测试
        questionnaireEntity.setQuestionnaireId(101);

        questionnaireController.previewQuestionnaireById(questionnaireEntity);
        //异常测试
        questionnaireController.previewQuestionnaireById(null);
    }

    //创建问题测试
    @Test
    public void testAddQuestion() throws Exception{
        QuestionEntity questionEntity = new QuestionEntity();
        //创建成功测试
        questionEntity.setQuestionnaireId(80);
        questionEntity.setQuestionId(80);

        //创建失败测试
        questionEntity.setQuestionId(40);

        questionController.creatQuestion(questionEntity);
        //异常测试
        questionController.creatQuestion(null);
    }

    //预览问题测试
    @Test
    public void testPreviewQuestion() throws Exception{
        QuestionEntity questionEntity = new QuestionEntity();
        //预览成功测试
        questionEntity.setQuestionnaireId(56);
        questionEntity.setQuestionId(46);

        //预览失败测试
        questionEntity.setQuestionId(100);

        questionController.previewQuestionById(questionEntity);
        //异常测试
        questionController.previewQuestionById(null);
    }

    //创建关联问题测试
    @Test
    public void testAddSecondOption() throws Exception{
        SecondOptionEntity secondOptionEntity = new SecondOptionEntity();

        //创建成功测试
        secondOptionEntity.setQuestionId(52);
        secondOptionEntity.setSecondOptionId(20);

        //创建失败测试
        secondOptionEntity.setSecondOptionId(10);

        secondOptionController.creatSecondOption(secondOptionEntity);
        //异常测试
        secondOptionController.creatSecondOption(null);
    }


    //用户添加测试
    //@Test
    public void testAdd() throws Exception{


        UserEntity userEntity = new UserEntity();
        //添加成功测试
        /*userEntity.setId("1");
        userEntity.setUsername("admin");
        userEntity.setPassword("123999");*/
        //异常测试
        userController.addUser(null);
    }
    //登录测试
    //@Test
    public void testLogin() throws Exception{


        UserEntity userEntity = new UserEntity();
//        //登录成功测试
        /*userEntity.setUsername("adc");
        userEntity.setPassword("123");*/

//       //登录失败测试
        /*userEntity.setUsername("admin");
        userEntity.setPassword("123999");*/
        //异常测试
        userController.userLogin(null);

    }

    //用户修改测试
    //@Test
    public void testChange() throws Exception{


        UserEntity userEntity = new UserEntity();
//        //修改成功测试
        /*userEntity.setId("c7681539d20c4d429ec2822a4a50ea07");
        userEntity.setUsername("abc");
        userEntity.setPassword("123456");
        userEntity.setStartTime(null);
        userEntity.setStopTime(null);*/
//       //修改失败测试
        /*userEntity.setId("33333");
        userEntity.setUsername("admin");
        userEntity.setPassword("123999");*/
        //异常测试
        userController.modifyUser(userEntity);

    }

    //用户查询测试
    //@Test
    public void testUserQuery() throws Exception{


        UserEntity userEntity = new UserEntity();
//        //用户查询成功测试
        /*userEntity.setId("1");
        userEntity.setUsername("abc");
        userEntity.setPassword("123");*/
//       //用户查询失败测试
        /*userEntity.setId("33333");
        userEntity.setUsername("admin");
        userEntity.setPassword("123999");*/
        //异常测试
        userController.queryUserList(userEntity);

    }

    //用户删除测试
    //@Test
    public void testUserDelete() throws Exception{


        UserEntity userEntity = new UserEntity();
//        //用户删除成功测试
        /*userEntity.setId("78db4c72f7d34c428e3916316f48973b");
        userEntity.setUsername("abc");
        userEntity.setPassword("123");*/
//       //用户删除失败测试
        /*userEntity.setId("33333");
        userEntity.setUsername("admin");
        userEntity.setPassword("123999");*/
        //异常测试
        userController.deleteUserInfo(null);

    }

    //用户状态改变测试
    //@Test
    public void testUserChangeStatus() throws Exception{


        UserEntity userEntity = new UserEntity();
//        //用户状态改变成功测试
        /*userEntity.setId("78db4c72f7d34c428e3916316f48973b");
        userEntity.setUsername("abc");
        userEntity.setPassword("123");*/
//       //用户状态改变失败测试
        userEntity.setId("33333");
        /*userEntity.setUsername("admin");
        userEntity.setPassword("123999");*/
        //异常测试
        //userController.updateUserStatus(userEntity);

    }
    //项目添加测试
    //@Test
    public void testProjectAdd() throws Exception{


        ProjectEntity projectEntity = new ProjectEntity();
//        //项目添加成功测试
       /* projectEntity.setProjectName("餐饮调查问卷");
        projectEntity.setProjectContent("调查餐饮");*/

//       //项目添加失败测试
        //id相同时即创建失败！！！！
        //projectEntity.setId("2");
        /*projectEntity.setProjectName("admin");
        projectEntity.setProjectContent("123999");*/
        //异常测试
        projectController.addProjectInfo(projectEntity);

    }
    //项目删除测试
    //@Test
    public void testProjectDelete() throws Exception{


        ProjectEntity projectEntity = new ProjectEntity();
//        //项目删除成功测试
        //projectEntity.setId("2");


//       //项目删除失败测试
        //projectEntity.setId("222");
        /*projectEntity.setProjectName("admin");
        projectEntity.setProjectContent("123999");*/
        //异常测试
        projectController.deleteProjectById(projectEntity);

    }

    //项目修改测试
    //@Test
    public void testProjectModify() throws Exception{


        ProjectEntity projectEntity = new ProjectEntity();
//        //项目修改成功测试
        /*projectEntity.setId("b66bcaf9e3ea44ad9bc86bfdfa62ed5a");
        projectEntity.setProjectName("属鼠调查问卷");
        projectEntity.setProjectContent("调查属鼠");*/

//       //项目修改失败测试
        /*projectEntity.setId("222");
        projectEntity.setProjectName("admin");
        projectEntity.setProjectContent("123999");*/
        //异常测试
        projectController.modifyProjectInfo(projectEntity);

    }

    //项目列表查询测试
    //@Test
    public void testProjectList() throws Exception{


        ProjectEntity projectEntity = new ProjectEntity();
//        //项目列表查询成功测试
       /* projectEntity.setId("9f0537c923cd497ab1a047449bd42b7b");
        projectEntity.setProjectName("属鼠调查问卷");
        projectEntity.setProjectContent("调查属鼠");*/

//       //项目列表查询失败测试
       /* projectEntity.setId("222");
        projectEntity.setProjectName("admin");
        projectEntity.setProjectContent("123999");*/
        //异常测试
        projectController.queryProjectList(projectEntity);

    }

    //项目查询测试
    //@Test
    public void testProjectByName() throws Exception{


        ProjectEntity projectEntity = new ProjectEntity();
//        //项目查询成功测试
        /*projectEntity.setId(null);
        projectEntity.setProjectName("属鼠调查问卷");
        projectEntity.setProjectContent("调查属鼠");*/

//       //项目查询失败测试
        projectEntity.setId(null);
        projectEntity.setProjectName("admin");
        projectEntity.setProjectContent("123999");
        //异常测试
        projectController.queryProjectList(projectEntity);

    }

    //项目查询测试
    //@Test
    public void testProjectById() throws Exception{


        ProjectEntity projectEntity = new ProjectEntity();
//        //项目查询成功测试
       /* projectEntity.setId("b66bcaf9e3ea44ad9bc86bfdfa62ed5a");
        projectEntity.setProjectName(null);
        projectEntity.setProjectContent("调查属鼠");*/

//       //项目查询失败测试
        /*projectEntity.setId("44444444");
        projectEntity.setProjectName(null);
        projectEntity.setProjectContent("123999");*/
        //异常测试
        projectController.queryProjectList(projectEntity);

    }


    //@Test
    public void queryUserList() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        List<UserEntity> list = userEntityMapper.queryUserList(userEntity);
        if(CollectionUtils.isEmpty(list)){
            // 记录error级别的信息
        }else{
            System.out.println(list);
            // 记录info级别的信息
            log.info(">>queryUserList用户列表查询测试成功");
        }
    }

    //@Test
    public void selectUserInfo() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        userEntity.setPassword("123");
        List<UserEntity> list = userEntityMapper.selectUserInfo(userEntity);
        if(CollectionUtils.isEmpty(list)){
            // 记录error级别的信息
        }else{
            System.out.println(list);
            // 记录info级别的信息
            log.info(">>selectUserInfo用户登录测试成功");
        }
    }

    //@Test
    public void insert() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUIDUtil.getOneUUID());
        userEntity.setStatus("1");
        userEntity.setUsername("B");
        userEntity.setPassword("123");
        int i = userEntityMapper.insert(userEntity);
        if(i==0){
            // 记录error级别的信息
        }else{
            System.out.println(i);
            // 记录info级别的信息
            log.info(">>insert用户插入测试成功");
        }
    }

    //@Test
    public void deleteUserById() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        int i = userEntityMapper.deleteUserById(userEntity);
        if(i==0){
            // 记录error级别的信息
        }else{
            System.out.println(i);
            // 记录info级别的信息
            log.info(">>delete用户删除测试成功");
        }
    }

    //@Test
    public void modifyUserInfo() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
        //调用userMapper的方法
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        userEntity.setUsername("admin");
        userEntity.setPassword("123");
        int i = userEntityMapper.updateByPrimaryKeySelective(userEntity);
        if(i==0){
            // 记录error级别的信息
        }else{
            System.out.println(i);
            // 记录info级别的信息
            log.info(">>modify用户修改测试成功");
        }
    }

    //@Test
    public void queryProjectList() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建ProjectEntityMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用projectEntity的方法
        ProjectEntity projectEntity =new ProjectEntity();
        List<ProjectEntity> list = projectEntityMapper.queryProjectList(projectEntity);
        if(CollectionUtils.isEmpty(list)){
            // 记录error级别的信息
        }else{
            System.out.println(list);
            // 记录info级别的信息
            log.info(">>queryProjectList项目列表测试成功");
        }

    }

    //@Test
    public void queryProject() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建ProjectEntityMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用projectEntity的方法
        ProjectEntity projectEntity =new ProjectEntity();
        projectEntity.setProjectName("心理调查问卷");
        List<ProjectEntity> list = projectEntityMapper.queryProjectList(projectEntity);
        if(CollectionUtils.isEmpty(list)){
            // 记录error级别的信息
        }else{
            System.out.println(list);
            // 记录info级别的信息
            log.info(">>queryProjectList项目查询测试成功");
        }
    }

    //@Test
    public void addProjectInfo() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建ProjectEntityMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用projectEntity的方法
        ProjectEntity projectEntity =new ProjectEntity();
        projectEntity.setId(UUIDUtil.getOneUUID());
        projectEntity.setProjectName("项目调查问卷");
        projectEntity.setProjectContent("关于测试的调查");
        int i = projectEntityMapper.insert(projectEntity);
        if(i==0){
            // 记录error级别的信息
        }else{
            System.out.println(i);
            // 记录info级别的信息
            log.info(">>insert项目添加测试成功");
        }
    }

    //@Test
    public void modifyProjectInfo() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建ProjectEntityMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用projectEntity的方法
        ProjectEntity projectEntity =new ProjectEntity();
        projectEntity.setId("1");
        projectEntity.setProjectName("调查项目修改问卷");
        projectEntity.setProjectContent("修改调查情况");
        int i = projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        if(i==0){
            // 记录error级别的信息
        }else{
            System.out.println(i);
            // 记录info级别的信息
            log.info(">>modify项目修改测试成功");
        }
    }

    //@Test
    public void deleteProjectById() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建ProjectEntityMapper对象，mybatis自动生成mapper代理对象
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        //调用projectEntity的方法
        ProjectEntity projectEntity =new ProjectEntity();
        projectEntity.setId("1");
        int i = projectEntityMapper.deleteProjectById(projectEntity);
        if(i==0){
            // 记录error级别的信息
        }else{
            System.out.println(i);
            // 记录info级别的信息
            log.info(">>delete项目删除测试成功");
        }
    }

}
