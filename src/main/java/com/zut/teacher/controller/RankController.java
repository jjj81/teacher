package com.zut.teacher.controller;

import com.zut.teacher.mapper.ClazzMapper;
import com.zut.teacher.mapper.StudentInfoMapper;
import com.zut.teacher.mapper.UrlAndPowerInfoMapper;
import com.zut.teacher.service.RankService;
import com.zut.teacher.service.TeacherInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.zut.teacher.entity.*;

@Controller
@RequestMapping("/rank")
public class RankController {

	@Autowired
	private RankService rankService;

	@Autowired
	private TeacherInfoService teacherInfoService;

	@Autowired
	private ClazzMapper clazzMapper;

	@Autowired
	private UrlAndPowerInfoMapper urlAndPowerInfoMapper;

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@GetMapping("/{teacherId}")
	String getRankPage(Model model, @PathVariable("teacherId") String teacherId) {
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("rank", rankService.mergeTheListByStudentId(
				rankService.sureTheCompositeSocre(
						rankService.isReviewPass(rankService
								.selectCanManagerStudentDoExercise(
										teacherInfoService.teacherCanManagerStudents(teacherId))),
						urlAndPowerInfoMapper.selectAll()),
				teacherInfoService.teacherCanManagerStudents(teacherId)));
		return "rank";
	}
}
