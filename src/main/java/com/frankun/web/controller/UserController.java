package com.frankun.web.controller;

import com.frankun.domain.dto.UserFormDto;
import com.frankun.domain.dto.UserOverviewDto;
import com.frankun.service.UserService;
import com.frankun.web.validator.UserFormDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 2016/11/21
 * @author frankun
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFormDtoValidator userFormDtoValidator;

    @RequestMapping("overview")
    public String overview(UserOverviewDto overviewDto, Model model){
        overviewDto = userService.loadUserOverviewDto(overviewDto);
        model.addAttribute("overviewDto", overviewDto);
        return "user_overview";
    }

    @RequestMapping(value = "form/plus", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("formDto", new UserFormDto());
        return "user_form";
    }

    @RequestMapping(value = "form/plus", method = RequestMethod.POST)
    public String submitUserForm(@ModelAttribute("formDto") UserFormDto formDto, BindingResult result){
        userFormDtoValidator.validate(formDto, result);
        if (result.hasErrors()){
            return "user_form";
        }
        userService.saveUserFormDto(formDto);
        return "redirect:../overview";
    }
}
