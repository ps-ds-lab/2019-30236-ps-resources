package ro.utcluj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import ro.utcluj.api.StudentService;
import ro.utcluj.service.StudentServiceImpl;

import java.sql.SQLException;

/**
 * Hello world!
 */
@SpringBootApplication
public class Server {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Server.class, args);
    }

    @Bean(name = "/student")
    public HttpInvokerServiceExporter studentServiceExporter(StudentServiceImpl service){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(StudentService.class);
        return exporter;
    }
}
