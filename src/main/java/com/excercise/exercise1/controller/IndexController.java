package com.excercise.exercise1.controller;

import com.excercise.exercise1.dto.CarDto;
import com.excercise.exercise1.dto.UserDto;
import com.excercise.exercise1.service.CarService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class IndexController {

    final private CarService carService;
    /**
     * 홈페이지 이동
     * @return home.html 이랑 렌더링
     */
    @GetMapping("/")
    public String home(){
        return "home";
    }

    /**
     * 로그인 페이지로 이동
     * @return login.html 이랑 렌더링
     */
    @GetMapping("/login")
    public String loginForm(){

        return "login";
    }

    /**
     * 로그인한 상태로만 차량 페이지 이동가능
     * 로그인하지 않은 상태로 이동 불가능
     * @param session
     * @return
     */
    @GetMapping("/car")
    public String cars(HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("user");
        // 로그인 안했을 경우 로그인 화면으로 이동
        if(userDto==null){
            return "redirect:/login";
        }
        return "car";
    }

    /**
     * 차량 등록 페이지 이동
     * @param session
     * @return
     */
    @GetMapping("/car/add")
    public String carAddForm(HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("user");
        // 로그인 안했을 경우 로그인 화면으로 이동
        if(userDto==null){
            return "redirect:/login";
        }
        return "caradd";
    }

    /**
     * 차랑 수정페이지로 이동
     * @param model 해당 아이디 차량의 정보를 담기
     * @param session
     * @param id
     * @return
     */
    @GetMapping("/car/update")
    public String carUpdateForm(Model model, HttpSession session, @RequestParam Long id){
        UserDto userDto = (UserDto) session.getAttribute("user");
        // 로그인 안했을 경우 로그인 화면으로 이동
        if(userDto==null){
            return "redirect:/login";
        }
        CarDto carDto = CarDto.of(carService.findById(id));
        model.addAttribute("car", carDto);
        return "carupdate";
    }
}
