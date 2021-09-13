package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(MappingController.class);

    /**
     * url Mapping
     */
    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");

        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수 명이 같으면 생략 가능
     * @PathVariable("userId") String userId --> @PathVariable String userId
     * /mapping.userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userID") String data){

        log.info("mappingPath userID = {}", data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userID}/orders/{orderId}")
    public String mappingPth(@PathVariable("userId") String userID,
                             @PathVariable("orderID") String orderID){
        log.info("mappingPath userID = {}, orderID = {}", userID, orderID);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
