package com.zut.teacher.controller;

import com.zut.teacher.mapper.StudentDoExerciseInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/studentDoExerciseInfo")
public class StudentDoExerciseInfoController {
	@Autowired
	StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@GetMapping("/searchAll")
	String searchAllStudentDoExerciseInfo(Model model) {
		model.addAttribute("searchAllList", studentDoExerciseInfoMapper.searchAll());
		return "searchAllStudentDoExerciseInfo";
	}

	@GetMapping("/searchAllOrderBySolveExerciseNumber")
	String searchAllOrderBySolveExerciseNumber(Model model) {
		model.addAttribute("orderByNumber", studentDoExerciseInfoMapper.searchAllOrderBySolveExerciseNumber());
		return "searchAllStudentDoExerciseInfoOrderBySolveExerciseNumber";
	}
}
