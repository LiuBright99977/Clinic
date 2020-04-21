package cn.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class QianDuanCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        //初始化cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();
        //允许跨域的域名，如果要携带cookie，不能写*，*代表所有的域名都可以跨域访问
        configuration.setAllowCredentials(true);//允许携带cookies
        configuration.addAllowedOrigin("http://localhost:63342");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");

        //初始化cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        //返回corsFilters实例，参数：cors配置源对象
        return new CorsFilter(configurationSource);
    }
}
