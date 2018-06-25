package ind.lgh.gatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author lgh
 */
@SpringBootApplication
@EnableEurekaClient
// 声明一个Zuul代理，它在Eureka中注册，使用Ribbon定位注册的微服务，在Hystrix中执行
@EnableZuulProxy
public class GatewayZuulApplication {

//    /**
//     * 正则指定Zuul路由匹配规则
//     */
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//        // servicePattern指定微服务正则
//        // routePattern指定路由正则
//        return new PatternServiceRouteMapper("","");
//    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
