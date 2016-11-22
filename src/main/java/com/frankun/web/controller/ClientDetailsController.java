package com.frankun.web.controller;

import com.frankun.domain.dto.OauthClientDetailsDto;
import com.frankun.service.OauthService;
import com.frankun.web.validator.OauthClientDetailsDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * 查询出client_details列表并展示在jsp页面
     * @param model
     * @return
     */
    @RequestMapping("/client_details")
    public String clientDetails(Model model){
        List<OauthClientDetailsDto> oauthClientDetailsDtoList = oauthService.loadOauthClientDetailsDtos();
        model.addAttribute("oauthClientDetailsDtoList", oauthClientDetailsDtoList);
        return "clientdetails/client_details";
    }

    /**
     * 跳转到注册页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/register_client", method = RequestMethod.GET)
    public String registerClient(Model model){
        model.addAttribute("formDto", new OauthClientDetailsDto());
        return "clientdetails/register_client";
    }

    /**
     * 提交注册信息
     * @param formDto
     * @param result
     * @return
     */
    @RequestMapping(value = "/register_client", method = RequestMethod.POST)
    public String submitRegisterClient(@ModelAttribute("formDto") OauthClientDetailsDto formDto, BindingResult result){
        oauthClientDetailsDtoValidator.validate(formDto, result);
        if (result.hasErrors()){
            return "clientdetails/register_client";
        }
        oauthService.registerClientDetails(formDto);
        return "redirect:client_details";
    }

    /**
     * 进入客户端测试页面
     * @param clientId
     * @param model
     * @return
     */
    @RequestMapping("test_client/{clientId}")
    public String testClient(@PathVariable("clientId") String clientId, Model model){
        OauthClientDetailsDto clientDetailsDto = oauthService.loadOauthClientDetailsDto(clientId);
        model.addAttribute("clientDetailsDto", clientDetailsDto);
        return "clientdetails/test_client";
    }

    /**
     * 激活archive
     * @param clientId
     * @return
     */
    @RequestMapping("archive_client/{clientId}")
    public String archivedClient(@PathVariable("clientId") String clientId){
        oauthService.updateOauthClientDetailsArchive(clientId);
        return "redirect:../client_details";
    }
}
