package com.sys.appstore;

import com.sys.appstore.annotation.CheckTokenInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class AppstoreApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AppstoreApplication.class, args);
    }

    @Bean
    public CheckTokenInterceptor CheckTokenInterceptor() {return new CheckTokenInterceptor();}

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(CheckTokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/**/*.css", "/**/*.js");
    }
}
