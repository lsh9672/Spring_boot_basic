package hello2.core2.web;

import hello2.core2.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    //얘도 지연로딩필요
//   private final ObjectProvider<MyLogger> myLoggerProvider;

    private final MyLogger myLogger;
    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
