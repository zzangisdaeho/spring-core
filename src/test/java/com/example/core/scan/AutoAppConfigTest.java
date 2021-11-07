package com.example.core.scan;

import com.example.core.AutoAppConfig;
import com.example.core.member.MemberService;
import com.example.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);

    }
}
