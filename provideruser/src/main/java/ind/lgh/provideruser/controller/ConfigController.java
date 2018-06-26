package ind.lgh.provideruser.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    /**
     * 通过Config server访问Git仓库配置文件中的属性
     */
    @Value("${author}")
    private String author;

    @GetMapping("/author")
    public String author() {
        return author;
    }
}
