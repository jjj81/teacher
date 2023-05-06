package com.zut.teacher.controller;

import java.util.List;

import com.zut.teacher.entity.StudentInfo;
import com.zut.teacher.entity.TeacherPowerToClass;
import com.zut.teacher.mapper.StudentInfoMapper;
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
@RequestMapping("/studentInfo")
public class StudentInfoController {
	BCryptPasswordEncoder bcrCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	List<StudentInfo> searchTeacherCanManagerStudentAll(String teacherId) {
		List<StudentInfo> result = null;
		List<TeacherPowerToClass> teacherCanManagerClass = teacherPowerToClassMapper
				.searchTeacherPowerToClassById(teacherId);
		for (TeacherPowerToClass teacherPowerToClass : teacherCanManagerClass) {
			if (result == null)
				result = studentInfoMapper.searchStudentByClassName(teacherPowerToClass.getClassName());
			else
				for (StudentInfo studentInfo : studentInfoMapper
						.searchStudentByClassName(teacherPowerToClass.getClassName())) {
					result.add(studentInfo);
				}

			;

		}
		return result;

	}

	@GetMapping("/index/{teacherId}")
	String studentInfoManagerPage(@PathVariable("teacherId") String teacherId, Model model) {
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("canManageClassList", teacherPowerToClassMapper.searchTeacherPowerToClassById(teacherId));
		model.addAttribute("studentList", searchTeacherCanManagerStudentAll(teacherId));
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
		model.addAttribute("studentList", searchTeacherCanManagerStudentAll(teacherId));

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

}
