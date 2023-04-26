package com.zut.teacher.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.teacher.entity.StudentDoExerciseInfo;

@Mapper
public interface StudentDoExerciseInfoMapper {
	@Select("select * from studentDoExerciseInfo ")
	List<StudentDoExerciseInfo> searchAll();

	@Select("select * from studentDoExerciseInfo order by solveExerciseNumber")
	List<StudentDoExerciseInfo> searchAllOrderBySolveExerciseNumber();

}
