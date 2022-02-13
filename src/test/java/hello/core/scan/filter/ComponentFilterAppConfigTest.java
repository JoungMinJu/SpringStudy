package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {
    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        // 아래는 조회도 안된다.
//        BeanB beanB = ac.getBean("beanB", BeanB.class);
//        Assertions.assertThat()


        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB",BeanB.class)
        );
    }

    @Configuration
    @ComponentScan(includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
                    excludeFilters = @Filter(type=FilterType.ANNOTATION, classes = MyExcludeComponent.class))

    //BeanA도 빼고 싶다면?

//    @ComponentScan(
//            includeFilters = {@Filter(type=FilterType.ANNOTATION, classes = MyIncludeComponent.class),},
//            excludeFilters = {
//                    @Filter(type= FilterType.ANNOTATION, classes=MyExcludeComponent.class),
//                    @Filter(type = FilterType.ASSIGNABLE_TYPE, classes=BeanA.class),
//            }
//    )
    static class ComponentFilterAppConfig{

    }
}
