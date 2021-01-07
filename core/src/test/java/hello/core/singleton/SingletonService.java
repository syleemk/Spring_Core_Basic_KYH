package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * main 코드에 영향주지 않기 위해 test 패키지에 생성했다
 * cf) 싱글톤 패턴을 구현하는 방법은 여러가지 있음. 
 * 여기서는 객체를 미리 생성해두는 가장 단순하고 안전한 방법을 선택
 */
public class SingletonService {

    /**
     * 자기 자신을 내부에 private으로 하나 가지고 있는데, static으로 가지고 있음
     * class level에 올라가기 때문에 딱 하나만 존재하게 됨
     * JVM 위에 SingletonService 클래스 로드될때, static 키워드 보고
     * SingletonService 객체 생성해서 참조값을 instance 참조변수에 넣어둠
     */
    private static final SingletonService instance = new SingletonService();

    //위에 만들어놓은 static instance에 대해 조회하는 메서드 (getter)
    public static SingletonService getInstance() {
        return instance;
    }

    /**
     * private 생성자를 사용함으로써
     * 클래스 외부에서 임의로 SingletonService 생성하는 것 막아버림 !!!
     * 이 클래스의 인스턴스 생성은 이 클래스 안에서밖에 못함
     */
    private SingletonService() {
    }

    public void login() {
        System.out.println("싱글톤 객체 호출");
    }
}
