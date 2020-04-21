package cn.project.config;

import cn.project.utils.HttpClientHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class HttpClientHelperConfig {
    @Bean
    HttpClientHelper httpClientHelper(HttpServletRequest request){
        return new HttpClientHelper(request);
    }
}
