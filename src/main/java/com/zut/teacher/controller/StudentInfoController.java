package com.zut.teacher.controller;

import com.zut.teacher.entity.Clazz;
import com.zut.teacher.entity.College;
import com.zut.teacher.entity.Faculty;
import com.zut.teacher.entity.StudentInfo;
import com.zut.teacher.mapper.ClazzMapper;
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

	@Autowired
	ClazzMapper clazzMapper;

	@PostMapping("/fixTheFaculty")
	String fixTheFaculty(Model model, @RequestParam("teacherId") String teacherId, final College college) {

		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());
		model.addAttribute("facultyList", clazzMapper.selectFacultyByParentId(college.getId()));

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("showStudentInfo",
				teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

		return "studentManager";
	}

	@PostMapping("fixTheClazz")
	String fixTheClazz(Model model, @RequestParam("teacherId") String teacherId, final Faculty faculty) {
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("facultyList",
				clazzMapper.selectFacultyById(faculty.getId()));
		model.addAttribute("clazzList", clazzMapper.selectClazzByFacultyId(faculty.getId()));

		model.addAttribute("studentInfo", new StudentInfo());

		model.addAttribute("showStudentInfo",
				teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

		return "studentManager";
	}

	@PostMapping("/sureTheClazzId")
	String sureTheClazzId(Model model, final Clazz clazz, @RequestParam("teacherId") String teacherId) {
		if (teacherPowerToClassMapper.searchByTidAndCid(teacherId, clazz.getId()) == null) {
			model.addAttribute("noPower", "您对该班级没有管理权限，如需管理该班级请向管理员申请");
			model.addAttribute("teacherId", teacherId);
			model.addAttribute("college", new College());
			model.addAttribute("faculty", new Faculty());
			model.addAttribute("clazz", new Clazz());
			model.addAttribute("collegeList", clazzMapper.selectAllCollege());
			model.addAttribute("studentInfo", new StudentInfo());
			model.addAttribute("showStudentInfo",
					teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

			return "studentManager";

		}

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("clazzId", clazz.getId());

		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("showStudentInfo",
				teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

		return "studentManager";
	}

	@PostMapping("/insertStudent")
	String insertStudent(Model model, final StudentInfo studentInfo, @RequestParam("teacherId") String teacherId,
			@RequestParam("clazzId") Integer clazzId) {

		if (studentInfoMapper.searchStudentByStudentId(studentInfo.getStudentId()) != null) {
			System.out.println("java");
			model.addAttribute("studentExist", "该学号在数据库中已有实例，请勿重复添加");
			model.addAttribute("teacherId", teacherId);
			model.addAttribute("college", new College());
			model.addAttribute("faculty", new Faculty());
			model.addAttribute("clazz", new Clazz());
			model.addAttribute("collegeList", clazzMapper.selectAllCollege());
			model.addAttribute("studentInfo", new StudentInfo());
			model.addAttribute("showStudentInfo",
					teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

			return "studentManager";

		}
		studentInfo.setPassWord(bcrCryptPasswordEncoder.encode(studentInfo.getStudentId()));
		studentInfo.setClazzId(clazzId);
		studentInfoMapper.insertStudentInfo(studentInfo);

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());
		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("studentInfo", new StudentInfo());
		model.addAttribute("showStudentInfo",
				teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

		return "studentManager";
	}

	@GetMapping("/index/{teacherId}")
	String studentInfoManagerPage(@PathVariable("teacherId") String teacherId, Model model) {

		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());

		model.addAttribute("showStudentInfo",
				teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

		return "studentManager";
	}

	@GetMapping("/delete")
	String deleteStudent(Model model, @RequestParam("teacherId") String teacherId,
			@RequestParam("studentId") String studentId) {
		studentInfoMapper.deleteStudentByStudentId(studentId);

		model.addAttribute("collegeList", clazzMapper.selectAllCollege());
		model.addAttribute("college", new College());
		model.addAttribute("faculty", new Faculty());
		model.addAttribute("clazz", new Clazz());

		model.addAttribute("teacherId", teacherId);
		model.addAttribute("studentInfo", new StudentInfo());

		model.addAttribute("showStudentInfo",
				teacherInfoService.showStudentInfo(teacherInfoService.teacherCanManagerStudents(teacherId)));

		return "studentManager";

	}

}
