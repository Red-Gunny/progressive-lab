package personal.simple_api.config;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import personal.simple_api.filter.ApiCallLogFilter;
import personal.simple_api.interceptor.LogInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");
    }

    @Bean
    public FilterRegistrationBean apiCallLogFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new ApiCallLogFilter());       // 필터 등록
        filterRegistrationBean.setOrder(1);                             // 필터 체인에서 순서 설정
        filterRegistrationBean.addUrlPatterns("/*");                    // 필터 실행될 URL 패턴 등록
        return filterRegistrationBean;
    }

}
