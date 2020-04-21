package cn.project.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MyCacheConfig {
    private static final Logger logger = LoggerFactory.getLogger(MyCacheConfig.class);

    @Bean("mykeyGenerator")
    public KeyGenerator keyGenerator() {
        //KeyGenerator接口，匿名内部类的方式
        return new KeyGenerator() {
            //generate生成key，o(目标对象)，method（方法），objects（参数）
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                logger.warn("mykeyGenerator被调用");
                return method.getName() + "[" + Arrays.asList(objects).toString() + "]";
            }
        };
    }
}
