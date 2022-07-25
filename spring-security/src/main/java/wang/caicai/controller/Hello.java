package wang.caicai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeixu
 * @date 2022/6/29 22:56
 * @description TODO(一句话描述该类的功能)
 */
@RestController
public class Hello {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
