package cn.project;

import cn.project.OauthServerApplication;
import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class JiaMiTest {

    @Test
    public void test1() throws Exception {
        ConfigTools configTools = new ConfigTools();
        String password = "root";
        String[] arr = configTools.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        //私钥加密
        String jiaMi = configTools.encrypt(arr[0], password);
        System.out.println("加密后的password:" + jiaMi);
        //公钥解密
        System.out.println("解密后的password：" + configTools.decrypt(arr[1], jiaMi));
    }
}
