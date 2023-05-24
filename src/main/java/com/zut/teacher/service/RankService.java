package com.zut.teacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.zut.teacher.entity.Rank;
import com.zut.teacher.entity.StudentDoExerciseInfo;
import com.zut.teacher.entity.StudentInfo;
import com.zut.teacher.entity.UrlAndPowerInfo;
import com.zut.teacher.mapper.StudentDoExerciseInfoMapper;
import com.zut.teacher.mapper.StudentInfoMapper;

@Service
public class RankService {

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	public List<StudentDoExerciseInfo> selectCanManagerStudentDoExercise(List<StudentInfo> s) {
		List<StudentDoExerciseInfo> cmsd = new ArrayList<>();

		for (StudentInfo studentInfo : s) {
			for (StudentDoExerciseInfo studentDoExerciseInfo : studentDoExerciseInfoMapper
					.selectDoExerciseInfoByStudentId(studentInfo.getStudentId())) {
				cmsd.add(studentDoExerciseInfo);
			}
		}

		return cmsd;
	}

	public List<StudentDoExerciseInfo> isReviewPass(List<StudentDoExerciseInfo> sde) {
		List<StudentDoExerciseInfo> reviewPass = new ArrayList<>();
		for (StudentDoExerciseInfo s : sde) {
			if (s.getReview().equals("1")) {
				reviewPass.add(s);
			}
		}

		return reviewPass;
	}

	public List<Rank> sureTheCompositeSocre(List<StudentDoExerciseInfo> std, List<UrlAndPowerInfo> upi) {
		List<Rank> rankList = new ArrayList<>();

		for (StudentDoExerciseInfo s : std) {
			for (UrlAndPowerInfo u : upi) {
				if (u.getWebSiteUrl().equals(s.getDoExerciseWebSiteUrl()) == true) {
					Rank r = new Rank();
					Float tmp = s.getSolveExerciseNumber() * u.getUrlPower();
					r.setCompositeScore(tmp);
					r.setStudentId(s.getStudentId());
					r.setStudentName(studentInfoMapper.searchStudentByStudentId(s.getStudentId()).getStudentName());
					rankList.add(r);
				}
			}

		}

		return rankList;
	}

	public List<Rank> mergeTheListByStudentId(List<Rank> r, List<StudentInfo> student) {
		List<Rank> rankList = new ArrayList<>();

		int flag = 0;
		for (StudentInfo l : student) {
			Float sum = 0.0f;
			for (Rank rank : r) {
				if (rank.getStudentId().equals(l.getStudentId()) == true) {
					sum += rank.getCompositeScore();
					flag = 1;
				}

			}
			if (flag == 1) {
				Rank mergeRank = new Rank();
				mergeRank.setStudentId(l.getStudentId());
				mergeRank.setStudentName(l.getStudentName());
				mergeRank.setCompositeScore(sum);
				rankList.add(mergeRank);
			}
		}
		Collections.sort(rankList, new Comparator<Rank>() {
			@Override
			public int compare(Rank r1, Rank r2) {
				return r1.getCompositeScore().compareTo(r2.getCompositeScore());
			}
		});
		return rankList;
	}

}
