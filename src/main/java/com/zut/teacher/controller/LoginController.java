package com.zut.teacher.controller;

import com.zut.teacher.entity.TeacherLoginInfo;
import com.zut.teacher.mapper.TeacherLoginInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

		if (teacherLoginInfoMapper.searchByTeacherId(teacherLoginInfo.getTeacherId()) == null) {
			model.addAttribute("userNotExist", "该工号在数据库中没有记录，请检查工号是否填错或联系管理员添加");
			model.addAttribute("teacherLoginInfo", new TeacherLoginInfo());
			return "login.html";

		}
		if (bcrCryptPasswordEncoder.matches(teacherLoginInfo.getPassWord(),
				teacherLoginInfoMapper.searchByTeacherId(teacherLoginInfo.getTeacherId()).getPassWord()) == false) {
			model.addAttribute("passWordError", "密码错误,请检查密码");
			model.addAttribute("teacherLoginInfo", new TeacherLoginInfo());
			return "login.html";
		}
		model.addAttribute("teacherId", teacherLoginInfo.getTeacherId());
		return "teacherIndex";
	}

	@GetMapping("/index/{teacherId}")
	String getTeacherIndexPage(Model model, @PathVariable("teacherId") String teacherId) {
		model.addAttribute("teacherId", teacherId);
		return "teacherIndex";
	}
}
