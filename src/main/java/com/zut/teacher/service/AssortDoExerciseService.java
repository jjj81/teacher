package com.zut.teacher.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.zut.teacher.entity.StudentDoExerciseInfo;

@Service
public class AssortDoExerciseService {

	public List<StudentDoExerciseInfo> assort(List<StudentDoExerciseInfo> list, String review) {
		List<StudentDoExerciseInfo> result = new ArrayList<>();
		for (StudentDoExerciseInfo sde : list) {
			if (sde.getReview().equals(review) == true) {
				result.add(sde);
			}
		}

		return result;
	}
}
