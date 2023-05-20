package com.zut.teacher.controller;

import com.zut.teacher.mapper.StudentDoExerciseInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/imageInfo")
public class ImageController {
	@Autowired
	private StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@GetMapping("/get")
	String getImageByUrlAndAccount(@RequestParam("url") String url, @RequestParam("account") String account,
			Model model, @RequestParam("studentId") String studentId) {
		model.addAttribute("photo1",
				studentDoExerciseInfoMapper.selectDoExerciseByUrlAndAccount(url, account).getDoExercisePhoto1());
		model.addAttribute("photo2",
				studentDoExerciseInfoMapper.selectDoExerciseByUrlAndAccount(url, account).getDoExercisePhoto2());
		model.addAttribute("photo3",
				studentDoExerciseInfoMapper.selectDoExerciseByUrlAndAccount(url, account).getDoExercisePhoto3());
		model.addAttribute("photo4",
				studentDoExerciseInfoMapper.selectDoExerciseByUrlAndAccount(url, account).getDoExercisePhoto4());
		model.addAttribute("photo5",
				studentDoExerciseInfoMapper.selectDoExerciseByUrlAndAccount(url, account).getDoExercisePhoto5());
		model.addAttribute("studentId", studentId);
		return "imageInfo";
	}

}
