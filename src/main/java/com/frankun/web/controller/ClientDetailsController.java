package com.frankun.web.controller;

import com.frankun.domain.dto.OauthClientDetailsDto;
import com.frankun.service.OauthService;
import com.frankun.web.oauth.OauthClientDetailsDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 2016/11/17
 * @author frankun
 */

@Controller
public class ClientDetailsController {

    @Autowired
    private OauthService oauthService;

    @Autowired
    private OauthClientDetailsDtoValidator oauthClientDetailsDtoValidator;

    @RequestMapping("/client_details")
    public String clientDetails(Model model){
        List<OauthClientDetailsDto> oauthClientDetailsDtoList = oauthService.loadOauthClientDetailsDtos();
        model.addAttribute("oauthClientDetailsDtoList", oauthClientDetailsDtoList);
        return "clientdetails/client_details";
    }
}
