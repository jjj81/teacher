package com.zut.teacher.controller;

import com.zut.teacher.entity.TeacherLoginInfo;
import com.zut.teacher.mapper.TeacherLoginInfoMapper;
import com.zut.teacher.mapper.TeacherPowerToClassMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoManagerController {
	BCryptPasswordEncoder bcRCryptPasswordEncoder = new BCryptPasswordEncoder();
    
	@Autowired
	private TeacherLoginInfoMapper teacherLoginInfoMapper;

	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	@GetMapping("/getPage/{teacherId}")
	String getPersonalInfoUpdatePage(@PathVariable("teacherId") String teacherId, Model model) {

		model.addAttribute("allClassList", teacherLoginInfoMapper.selectAllClass());
		model.addAttribute("canManagerClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("teacherInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		return "personalPage";
	}

	@PostMapping("/updateName/{teacherId}")
	String updateTeacherName(@PathVariable("teacherId") String teacherId, Model model,
			final TeacherLoginInfo teacherLoginInfo) {
		teacherLoginInfoMapper.updateTeacherNameByTeacherId(teacherId, teacherLoginInfo.getTeacherName());
		model.addAttribute("allClassList", teacherLoginInfoMapper.selectAllClass());
		model.addAttribute("canManagerClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("teacherInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		return "personalPage";
	}

	@PostMapping("/updateLeaveMessage/{teacherId}")
	String updateLeaveMessage(@PathVariable("teacherId") String teacherId, Model model,
			final TeacherLoginInfo teacherLoginInfo) {
		teacherLoginInfoMapper.updateLeaveMessageByTeacherId(teacherId, teacherLoginInfo.getWantToManageClass());
		model.addAttribute("allClassList", teacherLoginInfoMapper.selectAllClass());
		model.addAttribute("canManagerClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("teacherInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		return "personalPage";
	}

	@PostMapping("/updatePassWord/{teacherId}")
	String updatePassWord(@PathVariable("teacherId") String teacherId, Model model,
			final TeacherLoginInfo teacherLoginInfo) {
		teacherLoginInfoMapper.updatePassWord(bcRCryptPasswordEncoder.encode(teacherLoginInfo.getPassWord()),
				teacherId);
		model.addAttribute("teacherId", teacherId);
		return "updatePassWordSuccess";
	}

}
