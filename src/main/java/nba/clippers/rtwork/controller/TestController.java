package nba.clippers.rtwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /*
     * 测试一下*/
    @GetMapping("/api/project-ledger")
    public String getProjectLedger() {
        System.out.println("进入了这个方法");
        return "{\"message\": \"项目台账数据\"}";
    }
}
