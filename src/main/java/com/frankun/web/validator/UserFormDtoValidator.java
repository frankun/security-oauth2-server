package com.frankun.web.validator;

import com.frankun.domain.dto.UserFormDto;
import com.frankun.domain.user.Privilege;
import com.frankun.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * 2016/11/21
 * @author frankun
 */
public class UserFormDtoValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserFormDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserFormDto userFormDto = (UserFormDto) target;

        validateUsername(errors, userFormDto);
        validatePassword(errors, userFormDto);
        validatePrivileges(errors, userFormDto);
    }

    private void validateUsername(Errors errors, UserFormDto userFormDto){
        final String username = userFormDto.getUsername();
        if (StringUtils.isBlank(username)){
            errors.rejectValue("username", null, "Username is required");
            return;
        }

        boolean exist = userService.isUsernameExisted(username);
        if (exist){
            errors.rejectValue("username", null, "Username is existed");
        }

    }

    private void validatePassword(Errors errors, UserFormDto userFormDto){
        final String password = userFormDto.getPassword();
        if (StringUtils.isBlank(password)){
            errors.rejectValue("password", null, "Password is required");
        }
    }

    private void validatePrivileges(Errors errors, UserFormDto userFormDto){
        final List<Privilege> privileges = userFormDto.getPrivileges();
        if (null == privileges && privileges.isEmpty()){
            errors.rejectValue("privileges", null, "Privileges is required");
        }
    }
}
