package info.owczarek.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");

        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);

        List<String> productLines = Collections.singletonList("Motorcycles");
        List<Map<String, Object>> productsWithProductLine = productsRepository.getProductsWithProductLine(productLines);
        for (Map<String, Object> product : productsWithProductLine) {
            System.out.println(product);
        }

    }
}
