package com.zut.teacher.controller;

import com.zut.teacher.entity.StudentDoExerciseInfo;
import com.zut.teacher.mapper.StudentDoExerciseInfoMapper;
import com.zut.teacher.service.AssortDoExerciseService;
import com.zut.teacher.service.TeacherInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/doExerciseInfo")
public class StudentDoExerciseInfoController {
	@Autowired
	StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@Autowired
	private AssortDoExerciseService assortDoExerciseService;

	@Autowired
	private TeacherInfoService teacherInfoService;

	@GetMapping("/{teacherId}")
	String searchAllStudentDoExerciseInfo(Model model, @PathVariable("teacherId") String teacherId) {
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("doExerciseInfo", new StudentDoExerciseInfo());

		model.addAttribute("notReview", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "0"));
		model.addAttribute("reviewPass", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "1"));
		model.addAttribute("reviewNotPass",
				assortDoExerciseService.assort(teacherInfoService
						.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)),
						"3"));
		model.addAttribute("doubt", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "4"));

		return "doExerciseInfo";
	}

	@PostMapping("/review")
	String checkTheDoExerciseInfo(Model model, final StudentDoExerciseInfo studentDoExerciseInfo,
			@RequestParam("teacherId") String teacherId, @RequestParam("url") String url,
			@RequestParam("account") String account) {
		studentDoExerciseInfoMapper.updateReview(studentDoExerciseInfo.getReview(), url, account);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("doExerciseInfo", new StudentDoExerciseInfo());

		
		model.addAttribute("notReview", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "0"));
		model.addAttribute("reviewPass", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "1"));
		model.addAttribute("reviewNotPass",
				assortDoExerciseService.assort(teacherInfoService
						.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)),
						"3"));
		model.addAttribute("doubt", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "4"));



		return "doExerciseInfo";
	}

	@PostMapping("/updateComment")
	String updateTeacherComment(Model model, final StudentDoExerciseInfo studentDoExerciseInfo,
			@RequestParam("teacherId") String teacherId, @RequestParam("url") String url,
			@RequestParam("account") String account) {
		studentDoExerciseInfoMapper.updateTeacherComment(studentDoExerciseInfo.getTeacherComment(), url, account);
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("doExerciseInfo", new StudentDoExerciseInfo());


		model.addAttribute("notReview", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "0"));
		model.addAttribute("reviewPass", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "1"));
		model.addAttribute("reviewNotPass",
				assortDoExerciseService.assort(teacherInfoService
						.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)),
						"3"));
		model.addAttribute("doubt", assortDoExerciseService.assort(teacherInfoService
				.teacherCantManageDoExerciseInfo(teacherInfoService.teacherCanManagerStudents(teacherId)), "4"));


		return "doExerciseInfo";
	}
}
