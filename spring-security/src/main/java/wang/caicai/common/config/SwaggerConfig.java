package wang.caicai.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author wangpeixu
 * @date 2021/12/5 1:21
 * @description swagger视图配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(PathSelectors.regex("/error.*").negate())
                .paths(PathSelectors.regex("/admin/.*").negate())
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("spring-security学习")
                .description("本文档描述了spring-security学习过程中的接口定义")
                .version("1.0")
                .contact(new Contact("菜菜", "http://cai2.wang/",
                        "1732804469@qq.com"))
                .build();
    }

}
