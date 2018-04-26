package ind.lgh.consumeruser.controller;

import ind.lgh.consumeruser.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

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
}
