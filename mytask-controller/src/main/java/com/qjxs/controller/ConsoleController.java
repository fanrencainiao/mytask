package com.qjxs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.qjxs.common.login.LoginSign;
import com.qjxs.common.utils.Result;
import com.qjxs.common.utils.ResultCode;
import com.qjxs.domain.User;
import com.qjxs.service.ConsoleService;
/**
 * 系统后台管理
 * @author cf
 * @date 2019年8月21日 下午12:03:14
 */
@RestController
@RequestMapping("/console/")
public class ConsoleController {

	@Autowired
	ConsoleService consoleService;

	@PostMapping(value = "login")
	public Object login(String name, String password, HttpServletRequest request) {
		User login = consoleService.login(name, password);
		if (login != null) {
			request.getSession().setAttribute(LoginSign.LOGIN_USER_KEY, login);
			System.out.println(login.getRoles());
			String s=JSONObject.toJSONString(login);
			JSONObject json=JSONObject.parseObject(s);
			return Result.success(json);
		}
		return Result.failure(ResultCode.USER_LOGIN_ERROR);

	}

	@PostMapping(value = "logout")
	public Object logout(HttpServletRequest request) {
		request.getSession().removeAttribute(LoginSign.LOGIN_USER_KEY);
		System.out.println(request.getSession().getAttribute(LoginSign.LOGIN_USER_KEY));
		return Result.success();

	}

}
