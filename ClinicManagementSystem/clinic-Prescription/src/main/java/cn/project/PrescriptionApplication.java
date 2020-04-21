package cn.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@MapperScan(basePackages = "cn.project.mapper")
@EnableOAuth2Sso
public class PrescriptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrescriptionApplication.class,args);
    }
}
