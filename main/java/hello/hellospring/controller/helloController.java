package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello"); // key는 data, 값은 hello
        return "hello"; // return의 이름이 hello.
        // hello.html로 가서 랜더링 시켜라 라는 뜻. thymeleaf 템플릿이 처리함
        // 컨트롤러에서 리턴값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리함
        // resources:temlplates/ + {ViewName} + .html

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templates";
    }

    @GetMapping("hello-string")
    @ResponseBody // 이걸 붙이면 html 이런거 없이 그냥 그대로 보여줌
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // name이 spring일경우 : "hello spring"
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
