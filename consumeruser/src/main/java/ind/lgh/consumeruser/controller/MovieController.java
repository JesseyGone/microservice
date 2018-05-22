package ind.lgh.consumeruser.controller;

import ind.lgh.consumeruser.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lgh
 */
@RestController
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 方式一：把提供者的网络地址（IP+Port）硬编码在代码中
     */
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8000/user/" + id, User.class);
    }

    /**
     * 方式二：把提供者的网络地址提取到配置文件中
     */
    @GetMapping("/uu/{id}")
    public User find(@PathVariable Long id) {
        System.out.println(userServiceUrl);
        return restTemplate.getForObject(userServiceUrl + id, User.class);
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient
                .choose("microservice-provider-user");
        log.info("{}:{}:{}", serviceInstance.getServiceId(),
                serviceInstance.getHost(), serviceInstance.getPort());
    }
}
