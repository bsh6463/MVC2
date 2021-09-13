package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//@Controller는 반환되는 String은 view이름을 나타냄.
@Slf4j
@RestController //RestController는 String반환 시 STring이 그대로 반환됨.
public class LogTestController {

   // private final Logger log = LoggerFactory.getLogger(LogTestController.class); //getClass()현재 클래스 지정.

    @GetMapping("/log-test")
    public String logTest(){
        String name = "spring";
        log.trace("trace log={}", name); // f
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
