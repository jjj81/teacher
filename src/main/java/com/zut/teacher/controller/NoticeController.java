package com.zut.teacher.controller;

import com.zut.teacher.entity.Notice;
import com.zut.teacher.mapper.NoticeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeMapper noticeMapper;

	@GetMapping("/{teacherId}")
	String getIndex(Model model, @PathVariable("teacherId") String teacherId) {
		model.addAttribute("noticeList", noticeMapper.seleceNoticeByTeacherId(teacherId));
		model.addAttribute("notice", new Notice());
		model.addAttribute("teacherId", teacherId);

		return "notice";
	}

	@PostMapping("/insert")
	String insertNotice(Model model, @RequestParam("teacherId") String teacherId, final Notice notice) {
		notice.setTeacherId(teacherId);
		noticeMapper.insertNotice(notice);
		model.addAttribute("noticeList", noticeMapper.seleceNoticeByTeacherId(teacherId));
		model.addAttribute("notice", new Notice());
		model.addAttribute("teacherId", teacherId);

		return "notice";

	}

	@GetMapping("/delete")
	String deleteNotice(Model model, @RequestParam("title") String title,@RequestParam("teacherId")String teacherId) {
		noticeMapper.deleteNoticeByTitle(title);
		model.addAttribute("noticeList", noticeMapper.seleceNoticeByTeacherId(teacherId));
		model.addAttribute("notice", new Notice());
		model.addAttribute("teacherId", teacherId);

		return "notice";

	}

}
