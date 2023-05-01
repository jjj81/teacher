package com.zut.teacher.controller;

import com.zut.teacher.entity.TeacherLoginInfo;
import com.zut.teacher.mapper.TeacherLoginInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoManagerController {
	@Autowired
	private TeacherLoginInfoMapper teacherLoginInfoMapper;

	@GetMapping("/getPage/{id}")
	String getPersonalInfoUpdatePage(@PathVariable("id") String teacherId, Model model) {
		model.addAttribute("teacherInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		return "personalPage";
	}

	@GetMapping("/getUpdateName/{id}")
	String updateTeacherName(@PathVariable("id") String teacherId, Model model) {
		model.addAttribute("teacherInfo", teacherLoginInfoMapper.searchByTeacherId(teacherId));
		return "updateName";
	}

	@PostMapping("/updateName/{teacherId}")
	String updateName(@PathVariable("teacherId") String teacherId, Model model,
			final TeacherLoginInfo teacherLoginInfo) {
		teacherLoginInfo.setTeacherId(teacherId);
		teacherLoginInfoMapper.updateTeacherNameByTeacherId(teacherLoginInfo);
		model.addAttribute("teacherInfo", teacherLoginInfoMapper.searchByTeacherId(teacherLoginInfo.getTeacherId()));
		return "personalPage";
	}
}
