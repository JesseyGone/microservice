# 微服务架构 microservice
**[github地址](https://github.com/JesseyGone/microservice)**

# init：
一个服务提供方，一个服务消费方，传统方式实现服务调用：
- 将服务提供方网络地址硬编码到服务消费方
- 或者，将服务提供方网络地址写入到服务消费方的配置文件
[参考](https://github.com/JesseyGone/microservice/blob/master/consumeruser/src/main/java/ind/lgh/consumeruser/controller/MovieController.java)

# T01: 
加入服务发现组件Eureka，配置一个Eureka Server和两个Eureka Client
- 配置Client健康检查
- 配置Server关闭自我保护，Client宕机踢出
- 配置Maven插件构建镜像并推送到docker私有仓库
- 构建一个双节点的Eureka Server HA集群
- 添加一个provider，测试Ribbon负载均衡，启动顺序：eureka，provider，customer
- 抽出一个common模块存放dependencies，父模块保持干净整洁，但每次都要先打包common模块
- 记录，Ribbon负载均衡还可以支持自定义配置和非SpringCloud项目支持，这些暂未测试
- 为服务消费者（consumeruserfeign）整合Feign，实现声明式的RESTful API调用
    ``启动顺序：discoveryeureka/provideruser/consumeruserfeign，eureka报错（高可用另一台找不到）不用管``
- Feign自定义配置、配合Security实现的with-auth的微服务，这两部分省略
- Hystrix实现容错处理
    ``雪崩效应：基础服务故障导致级联故障的现象``
    ``如何防止：1.为网络请求设置超时；2.使用断路器模式``
- Feign Client断路器回退方法实现（Feign默认启用Hystrix可以禁用，省略）
- 使用Zuul构建微服务网关
    ``启动顺序：eureka、provideruser、consumer、gatewayzuul``
    ``查看路由表：localhost:8019/routes``


