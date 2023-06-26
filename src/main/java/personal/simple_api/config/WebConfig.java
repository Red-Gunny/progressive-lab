package personal.simple_api.config;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import personal.simple_api.filter.ApiCallLogFilter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean apiCallLogFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new ApiCallLogFilter());       // 필터 등록
        filterRegistrationBean.setOrder(1);                             // 필터 체인에서 순서 설정
        filterRegistrationBean.addUrlPatterns("/*");                    // 필터 실행될 URL 패턴 등록
        return filterRegistrationBean;
    }

}
