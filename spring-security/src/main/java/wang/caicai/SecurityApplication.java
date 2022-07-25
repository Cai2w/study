package wang.caicai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author wangpeixu
 * @date 2022/6/29 22:48
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SecurityApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SecurityApplication.class);
        System.out.println("111");
    }
}
