package hello2.core2.lifecycle;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//해당 인터페이스를 이용한 방법은 더이상 사용하지 않음 - 단점이 많음
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: "+ url);
    }
    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

/*
* 아래의 메서드들은 인터페이스에서 구현해야되는 메서드로 이 방식은 사용하지 않음*/
    //의존관계가 끝나면 호출해주겠다 - 이게 호출되고 나서 외부 연결작업을 해주면 된다.
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    //빈 소멸 직전에 호출
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
/*
* 빈에 추가로 파라미터값을 줘서 하는 방법 - 외부라이브러리에 적용시에는 이것을 써야됨*/
//    public void init(){
//        System.out.println("NetworkClient.init");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    public void close() {
//        System.out.println("NetworkClient.close");
//        disconnect();
//    }

    /*
    * 외부라이브러리에는 적용불가, 다른 상황에서는 이것을 쓰면됨.*/
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }


}
