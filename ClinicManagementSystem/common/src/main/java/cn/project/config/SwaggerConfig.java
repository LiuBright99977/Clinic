package cn.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.basePackage}")
    private String basePackage;
    @Value("${swagger.title}")
    private String swaggerTitle;
    @Value("${swagger2.enable}")
    private boolean swagger2Enable;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                //要扫描的Controller的位置
                .apis(RequestHandlerSelectors
                        .basePackage(basePackage))
                //通过paths方法配置路径
                .paths(PathSelectors.any())
                .build()
                //生产环境可以配置成false禁用
                .enable(swagger2Enable);
    }

    /**
     * 构建文档的基本信息
     * 描述，联系人信息，版本，标题等
     *
     * @return
     */
    public ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title(swaggerTitle)
                .contact(new Contact("LiuMingLiang", "https://github.com/LiuBright99977",
                        "275168452@qq.com"))
                .version("1.0")
                .build();
    }
}
