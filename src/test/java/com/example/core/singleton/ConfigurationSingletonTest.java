package com.example.core.singleton;

import com.example.core.AppConfig;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.order.OrderService;
import com.example.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void configurationTest(){

        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberService = " + memberService);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2).isSameAs(memberRepository);
    }

    @Test
    void ConfigurationDeep(){
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());

    }
}
