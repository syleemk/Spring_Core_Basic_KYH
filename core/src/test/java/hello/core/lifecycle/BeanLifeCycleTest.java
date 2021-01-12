package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LiefCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);

        //기본 ApplicationContext는 close 메서드 지원안함
        ac.close();
    }

    @Configuration
    static class LiefCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();

            //객체를 생성한 후 url을 넣어줌
            //위의 객체를 생성 (-> 외부 연결 설정 셋팅) 후에 초기화(아래 set으로 값설정)해줘야 할 때가 많음
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}