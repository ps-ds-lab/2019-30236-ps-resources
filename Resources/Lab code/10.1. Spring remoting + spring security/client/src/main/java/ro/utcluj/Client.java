package ro.utcluj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import ro.utcluj.api.AnotherService;
import ro.utcluj.api.StudentService;

@SpringBootApplication
public class Client {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Client.class);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("user", "userPass"));

        StudentService service = context.getBean(StudentService.class);

        System.out.println(service.getStudent(39));
    }

}
