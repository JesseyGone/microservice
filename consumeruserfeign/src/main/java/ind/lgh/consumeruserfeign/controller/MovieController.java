package ind.lgh.consumeruserfeign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import ind.lgh.consumeruserfeign.service.UserFeignClient;
import ind.lgh.pojos.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgh
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 加入一个简单断路器，更多更灵活的配置属性请参考官网
     * 当停掉提供服务的client时，服务断路，调用回退方法
     * 结合actuator可以实现断路器的状态监控：
     * 1.http://.../health
     * 2.http://.../hystrix.stream
     * 3.可视化监控hystrix-dashboard，了解一下
     * 4.以上都是单点监控，如何监控整个架构的微服务？turbine了解一下
     * 5.微服务与turbine间网络不通？消息中间件了解一下
     */
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/findUserById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}
