package cn.edu.bupt.opensource.hrm.springboot.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>Title: HrmSpringBootConfig</p>
 * <p>Description: </p>
 * <p>Company: bupt.edu.cn</p>
 * <p>Created: 2018-05-11 11:18</p>
 * @author ChengTengfei
 * @version 1.0
 */
@Configuration
@EnableWebMvc
public class HrmSpringBootConfig extends WebMvcConfigurerAdapter {

    //@Autowired
    //private AuthorizedInterceptor authorizedInterceptor;

    // SpringMVC拦截器
    //@Override
    //public void addInterceptors(InterceptorRegistry registry) {
    //    registry.addInterceptor(authorizedInterceptor).addPathPatterns("/*");
    //}

}