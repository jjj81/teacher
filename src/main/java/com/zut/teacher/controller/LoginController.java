package com.zut.teacher.controller;

import com.zut.teacher.entity.TeacherLoginInfo;
import com.zut.teacher.mapper.TeacherLoginInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	private TeacherLoginInfoMapper teacherLoginInfoMapper;

	BCryptPasswordEncoder bcrCryptPasswordEncoder = new BCryptPasswordEncoder();

	@GetMapping("/login")
	String returnLoginPage(Model model) {
		model.addAttribute("teacherLoginInfo", new TeacherLoginInfo());
		return "login.html";

	}

	@PostMapping("/login/confirm")
	String confirmPassWord(Model model, TeacherLoginInfo teacherLoginInfo) {

		if (bcrCryptPasswordEncoder.matches(teacherLoginInfo.getPassWord(),
				teacherLoginInfoMapper.searchByTeacherId(teacherLoginInfo.getTeacherId()).getPassWord()) == false)
			return "passWordError";
		model.addAttribute("teacherId", teacherLoginInfo.getTeacherId());
		return "teacherIndex";
	}
}
