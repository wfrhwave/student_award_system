# StudentManagementSystem
SpringBoot+Layui搭建的评奖评优管理系统，加入了shiro安全框架和Ehcache缓存框架
## 研究背景
近年来，随着国际互联网的告诉发展以及个人电子计算机的发范围普及，越来越多的企业、院校和政府机关开始采用计算机网络来替代现有的办公管理方式，或者作为一种辅助手段来弥补传统方式的不足之处。而传统的校内评价评优，手工完工，填写表单然后提交审批，费时费力。为了解决此问题，特实用在线进行评估评优，很大程度上提高了工作效率。
## 课题任务、要求
本课题要实现的是一个以学校为主题开发的评奖评优系统，主要分为学生、教室和管理员三个角色，其中学生可以管理个人信息和查看奖惩，教室角色可以修改权限范围内的学生和本班信息，管理员课具有编辑学生信息和成绩、分配权限功能。
具体工作内容
（1）管理员设置教师用户和学生用户，只有管理员能够录入学生成绩，指定用户权限，管理数据库安全，评定奖学金；
（2）教师用户可以查看和修改本班级学生基本信息，并查看学生成绩和获奖情况；
（3）学生用户可以查看和修改自己的信息、密码以及查看个人获奖情况和奖惩信息；

[Shiro](https://www.bilibili.com/video/BV1uz4y197Zm)

[体验地址：](evaluation.jinxs.icu)evaluation.jinxs.icu

管理员：

账号：管理员

密码：123456

老师：

账号：马良

密码：123456

学生：

账号：貂小蝉

密码：123456

服务器应该还有1年半，域名只有半年了，大概还能体验半年（现在是2022/10/29）

练手项目，功能大概完成了，但是做的不是很完善
借鉴了此项目[Github](https://github.com/BraisedPanda/StudentManagementSystem)

我的博客[少年有事问春风](https://www.jinxs.icu/)


###管理员功能
- 成绩管理
  - 查看所有学生成绩
  - 修改所有学生成绩
  - 删除学生成绩
  - 录入学生成绩

- 操作管理
  - 学生列表
  - 查看学生信息
  - 添加学生
  - 编辑学生信息
  - 删除学生信息

- 班级列表
  - 查看班级信息
  - 修改班级教师
  - 删除班级信息

- 用户列表
  - 查看用户信息
  - 修改用户信息
  - 删除用户信息
  - 添加用户信息

- 权限管理
  - 所有角色一览
  - 删除角色
  - 角色权限一览
  - 编辑权限
  - 删除权限
  - 新增权限角色
  - 新增角色和权限
  - 授予用户权限
  - 授予用户角色

- 奖惩管理
  - 学生奖惩列表
  - 添加奖励
  - 添加惩罚
  - 奖励发布信息
  - 修改奖励信息
  - 删除奖励信息
  - 惩罚发布信息
  - 修改惩罚信息
  - 删除惩罚信息
- 个人信息查看

###学生

- 成绩管理
  - 查看我的成绩

- 奖惩管理
  - 查看我的奖励
  - 查看我的惩罚
- 个人信息查看
##教师

- 成绩管理
  - 查看我班成绩
  - 
- 奖惩管理
  - 查看我班奖励
  - 查看我班惩罚

- 学生管理 
  - 查看我班学生信息
  - 修改我班学生信息
- 个人信息查看
      
### 介绍
 用ehcache缓存对list集合进行缓存时，layui的表格分页功能就会失效（比如我查询学生列表，并且对这个list添加了缓存，那么在前端展示时，layui的分页功能就会失效，转而显示所有的学生），目前还没有找到解决办法，所以在项目中就没有对list查询进行缓存。


  基本的环境：
  * Spring+SpringMVC+Mybatis
  * 前端：Layui+Thymeleaf模板
  * 安全框架：shiro
  * 缓存：抽象缓存Ehcache
  * 简单的Restful风格开发
  * pagehelper分页助手
  * 加入了Druid数据监控
  

 ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/3925/202210221024491.jpg)
  
  ### 模块
  
      src|——
            |——main |——
                    ├── java/com/braisedpanda |——
                                              |——bean               --:javabean
                                              |——config             --:自定义的各种配置类
                                              |——controller         --:controller层
                                              |——mapper             --:dao层
                                              |——service            --:service层
                                              |——serviceimpl        --:service实现类
                                              |——shiro              --:shiro自定义realm
                                              |——xxxxApplication    --:项目的启动类
                    ├── resource  |——
                                  |——mybatis     --：放置mybatis文件
                                  |——static      --:放置静态资源（图片、js、css之类的）
                                  |——templates   --:themeleaf模板
                                  |——application --：spring配置文件
                
  
#界面展示
![](display/修改学生信息.png)
![](display/修改学生成绩.png)
![](display/删除惩罚.png)
![](display/删除用户.png)
![](display/删除角色.png)
![](display/学生信息表.png)
![](display/学生奖惩列表.png)
![](display/录入学生成绩.png)
![](display/我班学生信息.png)
![](display/我的成绩.png)
![](display/授予用户权限.png)
![](display/权限表.png)
![](display/查看个人信息.png)
![](display/查看奖励发布信息.png)
![](display/查看学生信息.png)
![](display/查看惩罚发布信息.png)
![](display/查看我班奖励.png)
![](display/查看我班惩罚.png)
![](display/查看我的奖励.png)
![](display/查看我的惩罚.png)
![](display/查看所有学生成绩.png)
![](display/查看所有角色.png)
![](display/查看班级信息.png)
![](display/添加奖励.png)
![](display/添加学生信息.png)
![](display/添加惩罚.png)
![](display/添加用户.png)
![](display/添加角色.png)
![](display/班级信息表.png)
![](display/用户信息表.png)
![](display/编辑个人信息.png)
![](display/编辑奖励.png)
![](display/编辑惩罚.png)
![](display/编辑用户.png)

联系我：2260047952