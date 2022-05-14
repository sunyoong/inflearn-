package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello"); // key는 data, 값은 hello
        return "hello"; // return의 이름이 hello.
        // hello.html로 가서 랜더링 시켜라 라는 뜻. thymeleaf 템플릿이 처리함
        // 컨트롤러에서 리턴값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리함
        // resources:temlplates/ + {ViewName} + .html

    }
}
