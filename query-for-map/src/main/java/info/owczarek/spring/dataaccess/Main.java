package info.owczarek.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);
        int numberOfProducts = productsRepository.getNumberOfProducts();
        System.out.println("Number of products: " + numberOfProducts);

        int numberOfProductsWithPriceGreaterThan = productsRepository.getNumberOfProductsWithPriceGreaterThan(70);
        System.out.println("Number of products: " + numberOfProductsWithPriceGreaterThan);

        Map<String, Object> product = productsRepository.getProductByProductCode("S10_1678");
        System.out.println(product);

    }
}
