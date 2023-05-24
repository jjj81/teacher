package com.zut.teacher.controller;

import com.zut.teacher.entity.PassWord;
import com.zut.teacher.entity.TeacherLoginInfo;
import com.zut.teacher.mapper.TeacherLoginInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoManagerController {
	BCryptPasswordEncoder bcRCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private TeacherLoginInfoMapper teacherLoginInfoMapper;

	@GetMapping("/getPage/{teacherId}")
	String getPersonalInfoUpdatePage(@PathVariable("teacherId") String teacherId, Model model) {
		model.addAttribute("personalInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("teacherInfo", new TeacherLoginInfo());

		model.addAttribute("passWord", new PassWord());
		return "personalPage";
	}

	@PostMapping("/updateMessage")
	String updateMessage(Model model, @RequestParam("teacherId") String teacherId,
			final TeacherLoginInfo teacherLoginInfo) {
		teacherLoginInfoMapper.updateLeaveMessageByTeacherId(teacherId, teacherLoginInfo.getWantToManageClass());
		model.addAttribute("personalInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("teacherInfo", new TeacherLoginInfo());

		model.addAttribute("passWord", new PassWord());
		return "personalPage";

	}

	@PostMapping("/updateName")
	String updateName(Model model, @RequestParam("teacherId") String teacherId,
			final TeacherLoginInfo teacherLoginInfo) {
		teacherLoginInfoMapper.updateTeacherNameByTeacherId(teacherId, teacherLoginInfo.getTeacherName());

		model.addAttribute("personalInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("teacherInfo", new TeacherLoginInfo());
		model.addAttribute("passWord", new PassWord());
		return "personalPage";

	}

	@PostMapping("/updatePassWord")
	String updatePassWord(Model model, final PassWord passWord, @RequestParam("teacherId") String teacherId) {
		if (bcRCryptPasswordEncoder.matches(passWord.getOriginalPassWord(),
				teacherLoginInfoMapper.searchByTeacherId(teacherId).getPassWord()) == false) {
			model.addAttribute("originalError", "原密码错误");

			model.addAttribute("personalInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
			model.addAttribute("teacherId", teacherId);
			model.addAttribute("teacherInfo", new TeacherLoginInfo());
			model.addAttribute("passWord", new PassWord());
			return "personalPage";

		}
		if (passWord.getNewPassWord().equals(passWord.getConfirmNew()) == false) {
			model.addAttribute("confirmError", "两次输入的密码不一致");
			model.addAttribute("personalInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
			model.addAttribute("teacherId", teacherId);
			model.addAttribute("teacherInfo", new TeacherLoginInfo());
			model.addAttribute("passWord", new PassWord());
			return "personalPage";

		}
		teacherLoginInfoMapper.updatePassWord(bcRCryptPasswordEncoder.encode(passWord.getNewPassWord()), teacherId);
		model.addAttribute("personalInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("teacherInfo", new TeacherLoginInfo());
		model.addAttribute("passWord", new PassWord());

		model.addAttribute("passWordChangeSuccess", "个人密码修改成功，下次登陆请使用新密码");

		return "personalPage";
	}

}
