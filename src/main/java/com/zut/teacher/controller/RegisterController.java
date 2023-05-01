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
public class RegisterController {
	BCryptPasswordEncoder bcrCryptPasswordEncoder = new BCryptPasswordEncoder();
	@Autowired
	private TeacherLoginInfoMapper teacherLoginInfoMapper;

	@GetMapping("/register")
	String getRegisterPage(Model model) {
		model.addAttribute("teacherRegisterInfo", new TeacherLoginInfo());
		return "register";
	}

	@PostMapping("/registerCreate")
	String insertTeacherRegisterInfo(final TeacherLoginInfo teacherLoginInfo) {
		if (teacherLoginInfoMapper.searchByTeacherId(teacherLoginInfo.getTeacherId()) != null)
			return "teacherIdExist";
		teacherLoginInfo.setPassWord(bcrCryptPasswordEncoder.encode(teacherLoginInfo.getPassWord()));
		teacherLoginInfoMapper.insertTeacherInfo(teacherLoginInfo);
		return "registerSuccess";
	}

}
