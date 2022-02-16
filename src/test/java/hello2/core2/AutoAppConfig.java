package hello2.core2;

import hello2.core2.member.MemberRepository;
import hello2.core2.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        //탐색시작위치를 설정할수 있음 - 지정하지 않으면 이 클래스 파일의 패키지가 디폴트가 됨(관례를 사용하는것이 좋음)
        basePackages = "hello2.core2",
        //AppConfig 클래스는 제외하기 위해서
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)//@Component가 붙은것을 전부 빈으로 등록
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
