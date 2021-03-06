package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void AutoWiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
        // 이렇게 하면 TestBean이 스프링 빈으로 등록이 된다.
    }
    // 임의의 테스트 클래스
    static class TestBean{
        @Autowired(required = false)
        // Member는 스프링 빈이 관리하는 것이 아님.
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        // Member는 스프링 빈이 관리하는 것이 아님.
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean1 = " + noBean2);
        }

        @Autowired
        // Member는 스프링 빈이 관리하는 것이 아님.
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean1 = " + noBean3);
        }

    }
}
