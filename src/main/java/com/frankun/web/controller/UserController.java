package com.frankun.web.controller;

import com.frankun.domain.dto.UserOverviewDto;
import com.frankun.service.UserService;
import com.frankun.web.validator.UserFormDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2016/11/21
 * @author frankun
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserFormDtoValidator userFormDtoValidator;

    @RequestMapping("overview")
    public String overview(UserOverviewDto overviewDto, Model model){
        overviewDto = userService.loadUserOverviewDto(overviewDto);
        model.addAttribute("overviewDto", overviewDto);
        return "user_overview";
    }
}
