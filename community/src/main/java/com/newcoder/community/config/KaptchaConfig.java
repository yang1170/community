package com.newcoder.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {
    @Bean
//    通过bean被spring装备，核心的对象是一个接口，一个是创建文字，一个是根据文字创建图片。
//    有个实现类，简单说就是实例化接口，
    public Producer kaptchaProducer() {
            Properties properties = new Properties();
//            宽度长度的单位默认是像素，分别是宽度，高度，字号，颜色，字符串，字符串长度，加上一些干扰（点线干扰等等）
            properties.setProperty("kaptcha.image.width", "100");
            properties.setProperty("kaptcha.image.height", "40");
            properties.setProperty("kaptcha.textproducer.font.size", "32");
            properties.setProperty("kaptcha.textproducer.font.color", "0,0,0");
            properties.setProperty("kaptcha.textproducer.char.string", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            properties.setProperty("kaptcha.textproducer.char.length", "4");
            properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
            DefaultKaptcha kaptcha = new DefaultKaptcha();
            Config config = new Config(properties);
            kaptcha.setConfig(config);
            return kaptcha;

        }


}
