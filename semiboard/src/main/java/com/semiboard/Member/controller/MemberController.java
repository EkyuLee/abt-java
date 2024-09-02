package com.semiboard.member.controller;

import com.semiboard.member.controller.MemberModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class MemberController {
    @GetMapping("/pathvariabletest")
    public String pathParamTest() {
        System.out.println("hello");
        return "request-sample";
    }
    private int countcall = 0;

    @GetMapping("/path/var/{name}/{id}") // /test/path/var/a/a
    @ResponseBody
    public String pathParameterResponseMethod(@PathVariable String name, @PathVariable String id) { //@PathVariable을 통해 path 내부에 있는 variable 값을 가져올 수 있다.
        String returnValue = String.format("[%d] 당신의 아이디 : %s, 당신의 이름 : %s [YOU USING THAT PATHVARIABLE]", countcall, id, name);
        countcall++;
        return returnValue;
    }

    @ResponseBody
    @GetMapping("/path/request/param")
    public String pathParamRequestTest(@RequestParam String id, @RequestParam String name) {
        String returnValue = String.format("[%d] Your ID is '%s', Name is '%s' [YOU USING THAT GET REQUESTPARAM]", countcall, id, name);
        countcall++;
        return returnValue;
    }

    @ResponseBody
    @PostMapping("/path/request/param")
    public String pathParamRequestPostTest(@RequestParam String id, @RequestParam String name) {
        String returnValue = String.format("[%d] Your ID is '%s', Name is '%s' [YOU USING THAT POST REQUEST PARAM]", countcall, id, name);
        countcall++;
        return returnValue;
    }

    @PostMapping("/model/body/att/model")
    @ResponseBody
    public String modelBodyAttributeModel(@ModelAttribute MemberModel model){
        String resultValue = String.format("[%d] String result value %s, %s [YOU USING THAT MODELATTRIBUTE]", countcall, model.getId(), model.getName());
        countcall++;
        return resultValue;
    }

    @PostMapping("/model/body/req/body")
    @ResponseBody
    public String bodyRequest(@RequestBody MemberModel model){
        String resultValue = String.format("[%d] String result value %s, %s [YOU USING THAT REQUESTBODY WITH MODEL]", countcall, model.getId(), model.getName());
        countcall++;
        return resultValue;
    }

}
