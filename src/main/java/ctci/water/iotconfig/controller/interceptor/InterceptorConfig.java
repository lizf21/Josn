package ctci.water.iotconfig.controller.interceptor;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
java web配置支持,配置加载拦截器属性，配置跨域，配置跨域配置可以在这里配置，也可以在实现token拦截器的prehand里面配置
@auth JenterMei
 */

@Configuration
@Component
public class InterceptorConfig extends WebMvcConfigurationSupport {  //WebMvcConfigurerAdapter已经过时

    private static Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);
    /*
        @Value("${file.staticAccessPath}")
        private String staticAccessPath;
        @Value("${file.uploadFolder}")
        private String uploadFolder;
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+ uploadFolder);
        //super.addResourceHandlers(registry);
    }

    /**
     * 配置servlet处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //设置（模糊）匹配的url
        List<String> urlPatterns = Lists.newArrayList();
        urlPatterns.add("/api/citiwater/**");
        registry.addInterceptor(authTokenInterceptor()).addPathPatterns(urlPatterns).excludePathPatterns("/api/citiwater/index/getRunningMode");
        super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("ceshiyixia");
        registry.addMapping("/api/citiwater/**")
                .allowedOrigins("*").allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                .maxAge(3600);
        super.addCorsMappings(registry);
    }


    private CorsConfiguration addcorsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        List<String> list = new ArrayList<>();
        list.add("*");
        corsConfiguration.setAllowedOrigins(list);
    /*
    // 请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
    */
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }


    //将拦截器作为bean写入配置中
    @Bean
    public AuthTokenInterceptor authTokenInterceptor() {
        return new AuthTokenInterceptor();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", addcorsConfig());
        return new CorsFilter(source);
    }

}