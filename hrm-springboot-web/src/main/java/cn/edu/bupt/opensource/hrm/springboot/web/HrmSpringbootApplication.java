package cn.edu.bupt.opensource.hrm.springboot.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <p>Title: HrmSpringbootApplication</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-11 10:56</p>
 * @author ChengTengfei
 * @version 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.edu.bupt.opensource.hrm.springboot.dao")
@ComponentScan(basePackages = "cn.edu.bupt.opensource.hrm.springboot.*")
@EnableTransactionManagement                                            // 启动注解事务管理
@EnableWebMvc
public class HrmSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmSpringbootApplication.class, args);
    }

}
