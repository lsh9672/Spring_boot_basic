package hello2.core2.web;

import hello2.core2.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    //request scope이므로 고객이 들어와야 스프링빈에 빈이 등록이 되는데, 여기서 이미 등록되지 않은 빈을 요청해서 에러남
    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;

    //프록시 기능을 사용하면 이 주입시점에 가짜객체를 넣어둠
    private final MyLogger myLogger;
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException{

        String requestURL = request.getRequestURL().toString();
        //생성자 주입으로 생성시점에 의존관계를 주입받는게 아닌, provider를 이용하여 사용자 request가 들어온시점에 의존관계를 주입받음
//        MyLogger myLogger= myLoggerProvider.getObject();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
//        Thread.sleep(1000L);
        logDemoService.logic("testId");
        return "OK";

    }
}
