package ind.lgh.consumeruserfeign.service;

import ind.lgh.pojos.User;
import org.springframework.stereotype.Component;

/**
 * SpringCloud默认已为Feign整合了Hystrix，
 * 只要Hystrix在项目的classpath中，Feign默认就会用断路器包裹所有方法，这个就是Client的回退实现
 */
@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("Feign断路器用户");
        return user;
    }
}
