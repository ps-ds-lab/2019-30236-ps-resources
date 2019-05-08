package ro.utcluj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import ro.utcluj.api.AnotherService;
import ro.utcluj.api.StudentService;

@Configuration
public class ServerConfig {

    @Bean(name = "/student")
    HttpInvokerServiceExporter studentService(StudentService studentService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(studentService);
        exporter.setServiceInterface(StudentService.class);
        return exporter;
    }

    @Bean(name = "/another")
    HttpInvokerServiceExporter anotherService(AnotherService anotherService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(anotherService);
        exporter.setServiceInterface(AnotherService.class);
        return exporter;
    }
}
