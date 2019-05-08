package ro.utcluj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.security.remoting.httpinvoker.AuthenticationSimpleHttpInvokerRequestExecutor;
import ro.utcluj.api.AnotherService;
import ro.utcluj.api.StudentService;

@Configuration
public class ClientConfig {

    @Bean
    public AuthenticationSimpleHttpInvokerRequestExecutor httpInvokerRequestExecutor() { // spring-security-remoting dependency (check latest version here https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-dependency-versions.html)
        return new AuthenticationSimpleHttpInvokerRequestExecutor();
    }

    @Bean
    public HttpInvokerProxyFactoryBean studentInvoker(AuthenticationSimpleHttpInvokerRequestExecutor requestExecutor) {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setHttpInvokerRequestExecutor(requestExecutor);
        invoker.setServiceUrl("http://localhost:8080/student");
        invoker.setServiceInterface(StudentService.class);
        return invoker;
    }

    @Bean
    public HttpInvokerProxyFactoryBean anotherInvoker(AuthenticationSimpleHttpInvokerRequestExecutor requestExecutor) {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setHttpInvokerRequestExecutor(requestExecutor);
        invoker.setServiceUrl("http://localhost:8080/another");
        invoker.setServiceInterface(AnotherService.class);
        return invoker;
    }
}
