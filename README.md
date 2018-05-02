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
