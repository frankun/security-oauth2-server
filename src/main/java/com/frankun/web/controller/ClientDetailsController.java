package com.frankun.web.controller;

import com.frankun.service.OauthService;
import com.frankun.web.oauth.OauthClientDetailsDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
