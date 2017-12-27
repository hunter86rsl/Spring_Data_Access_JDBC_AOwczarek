package info.owczarek.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        OfficesRepository officesRepository = context.getBean("officesRepository", OfficesRepository.class);

        List<Office> allOffices = officesRepository.getAllOffices();

        for (Office office : allOffices) {
            System.out.println(office);
        }
    }
}
