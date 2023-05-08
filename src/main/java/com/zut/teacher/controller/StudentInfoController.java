package com.zut.teacher.controller;

import com.zut.teacher.entity.StudentInfo;
import com.zut.teacher.entity.TeacherPowerToClass;
import com.zut.teacher.mapper.StudentInfoMapper;
import com.zut.teacher.mapper.TeacherPowerToClassMapper;
import com.zut.teacher.service.TeacherInfoService;

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
@RequestMapping("/studentInfo")
public class StudentInfoController {
	BCryptPasswordEncoder bcrCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	@Autowired
	private TeacherInfoService teacherInfoService;

	@GetMapping("/index/{teacherId}")
	String studentInfoManagerPage(@PathVariable("teacherId") String teacherId, Model model) {
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("canManageClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));
		model.addAttribute("studentList", teacherInfoService.searchTeacherCanManagerStudentAll(teacherId));
		return "studentManager";
	}

	@PostMapping("/insert/{teacherId}")
	String insertStudent(Model model, final StudentInfo studentInfo, @PathVariable("teacherId") String teacherId) {
		if (studentInfoMapper.searchStudentByStudentId(studentInfo.getStudentId()) != null) {
			model.addAttribute("teacherId", teacherId);
			return "studentExist";
		}
		studentInfo.setPassWord(bcrCryptPasswordEncoder.encode(studentInfo.getStudentId()));
		studentInfoMapper.insertStudentInfo(studentInfo);

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("canManageClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));
		model.addAttribute("studentList", teacherInfoService.searchTeacherCanManagerStudentAll(teacherId));

		return "studentManager";
	}

	@PostMapping("/searchByClassName/{teacherId}")
	String searchStudentInfoByClassName(final StudentInfo studentInfo, Model model,
			@PathVariable("teacherId") String teacherId) {

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("canManageClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));
		model.addAttribute("studentList", studentInfoMapper.searchStudentByClassName(studentInfo.getClassName()));

		return "studentManager";
	}

	@PostMapping("/searchByStudentId/{teacherId}")
	String searchStudentByStudentId(final StudentInfo studentInfo, Model model,
			@PathVariable("teacherId") String teacherId) {

		if (studentInfoMapper.searchStudentByStudentId(studentInfo.getStudentId()) == null) {

			model.addAttribute("teacherId", teacherId);
			return "studentNotExist";
		}

		int flag = 0;
		for (TeacherPowerToClass teacherPowerToClass : teacherPowerToClassMapper
				.searchTeacherPowerToClassById(teacherId)) {

			if (studentInfoMapper.searchStudentByStudentId(studentInfo.getStudentId())
					.getClassName().equals(teacherPowerToClass.getClassName()) == true)
				flag = 1;
		}
		if (flag == 0) {
			model.addAttribute("teacherId", teacherId);
			return "noPower";
		} else {

			model.addAttribute("teacherId", teacherId);
			model.addAttribute("studentInfo", new StudentInfo());
			model.addAttribute("canManageClassList",
					teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));
			model.addAttribute("studentList", studentInfoMapper.searchStudentByStudentId(studentInfo.getStudentId()));
			return "studentManager";
		}
	}

	@GetMapping("/delete")
	String deleteStudentByStudentId(@RequestParam("studentId") String studentId,
			@RequestParam("teacherId") String teacherId, Model model) {

		studentInfoMapper.deleteStudentByStudentId(studentId);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("canManageClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));
		model.addAttribute("studentList", teacherInfoService.searchTeacherCanManagerStudentAll(teacherId));

		return "studentManager";
	}

}
