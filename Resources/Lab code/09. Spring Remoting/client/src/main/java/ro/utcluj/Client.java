package ro.utcluj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import ro.utcluj.api.StudentBaseDTO;
import ro.utcluj.api.StudentService;

@SpringBootApplication
public class Client {

    public static void main(String[] args) {
        ApplicationContext contex =  SpringApplication.run(Client.class, args);
        StudentService service = contex.getBean(StudentService.class);
        StudentBaseDTO dto = service.getStudent(39);
        System.out.println(dto.getName());
        System.out.println(dto.getEmail());
    }

    @Bean
    public HttpInvokerProxyFactoryBean studentServiceProxy(){
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceInterface(StudentService.class);
        proxy.setServiceUrl("http://localhost:8080/student");
        return proxy;
    }
}
