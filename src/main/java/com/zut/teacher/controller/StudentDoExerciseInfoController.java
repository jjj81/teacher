package com.zut.teacher.controller;

import com.zut.teacher.mapper.StudentDoExerciseInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doExerciseInfo")
public class StudentDoExerciseInfoController {
	@Autowired
	StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@GetMapping("/{teacherId}")
	String searchAllStudentDoExerciseInfo(Model model, @PathVariable("teacherId") String teacherId) {
		model.addAttribute("teacherId", teacherId);
		model.addAttribute("searchAllList", studentDoExerciseInfoMapper.searchAll());
		return "doExerciseInfo";
	}

	@GetMapping("/searchAllOrderBySolveExerciseNumber")
	String searchAllOrderBySolveExerciseNumber(Model model) {
		model.addAttribute("orderByNumber", studentDoExerciseInfoMapper.searchAllOrderBySolveExerciseNumber());
		return "searchAllStudentDoExerciseInfoOrderBySolveExerciseNumber";
	}
}
