package com.semiboard.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/response") //클라이언트이 요청(url)에 맞는 클래스나 메서드를 연결시켜주는 어노테이션
public class boardController {
    private static long visitorCount = 0;

    @GetMapping("/board/redirect") //요청 url에 대한 GET 요청을 메소드와 mapping시키는 것
    public String htmlFile() {
        return "redirect:/board.html";
    }

    @GetMapping("/board")
    public String htmlTemplates() {
        return "board";
    }

    @GetMapping("/visitcounter")
    public String helloHtmlFile(Model model) {
        visitorCount++;
        model.addAttribute("visitor", visitorCount);
        return "board-visit";
    }


    @ResponseBody //body 부분이 그대로 전달됨
    @GetMapping("/board/html")
    public String helloStringHTML() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head><meta charset=\"UTF-8\"><title>ResponseBody</title></head>" +
                "<body> Static board web page</body>" +
                "</html>";
    }

    @ResponseBody
    @GetMapping("/board/string")
    public String helloStringJson() {
        String returnValue = "This is string value from java, and using responsebody. responsebody is response of original string value.";
        return returnValue;
    }

    @ResponseBody
    @GetMapping("/board/jsonlist")
    public List<DefaultBoardData> helloJson() {
        System.out.println("im here");
        ArrayList<DefaultBoardData> boardDataList = new ArrayList<>();
        boardDataList.add(new DefaultBoardData("spring","spring","yyyy-MM-dd HH:mm:ss"));
        boardDataList.add(new DefaultBoardData("boot","boot","yyyy-MM-dd HH:mm:ss"));
        boardDataList.add(new DefaultBoardData("is","is","yyyy-MM-dd HH:mm:ss"));
        boardDataList.add(new DefaultBoardData("so","very","yyyy-MM-dd HH:mm:ss"));
        boardDataList.add(new DefaultBoardData("easy","good","yyyy-MM-dd HH:mm:ss"));
        return boardDataList;
    }




}
