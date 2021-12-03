package com.codegym.controller;

import com.codegym.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// @SessionAttributes("counter") được sử dụng để lưu trữ model attribute trong session
// model attribute "counter"  sẽ được thêm vào session
// nếu tên attribute của @ModelAttribute và @SessionAttributes giống nhau
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setUpCounter(){
        return new Counter();
    }

//  Hàm increment() có nhiệm vụ tăng giá trị thuộc tính count của đối tượng counter, xem o Class
    @GetMapping("/")
    public String get(@ModelAttribute("counter") Counter counter){
        counter.increment();
        return "/index";
    }
}
