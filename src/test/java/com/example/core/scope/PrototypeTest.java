package com.example.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close();
    }

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    static class PrototypeBean{

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        // 프로토 타입 빈은 스프링 컨테이너가 생성까지만 관리한다.
        // 고로 초기화 콜백은 있어도 소멸 전 콜백은 일어나지 않는다.
        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }

    }
}
