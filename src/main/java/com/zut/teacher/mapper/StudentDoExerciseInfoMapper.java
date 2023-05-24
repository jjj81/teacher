package com.zut.teacher.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;

import com.zut.teacher.entity.StudentDoExerciseInfo;

@Mapper
public interface StudentDoExerciseInfoMapper {
	@Select("select * from studentDoExerciseInfo ")
	List<StudentDoExerciseInfo> searchAll();

	@Select("select * from studentDoExerciseInfo order by solveExerciseNumber")
	List<StudentDoExerciseInfo> searchAllOrderBySolveExerciseNumber();

	@Select("select * from studentDoExerciseInfo where doExerciseWebSiteUrl=#{url} and doExerciseWebSiteAccount=#{account}")
	StudentDoExerciseInfo selectDoExerciseByUrlAndAccount(String url, String account);

	@Select("select * from studentDoExerciseInfo where studentId=#{studentId}")
	List<StudentDoExerciseInfo> selectDoExerciseInfoByStudentId(String studentId);

	@Update("update studentDoExerciseInfo set review=#{review}   where doExerciseWebSiteUrl=#{url} and doExerciseWebSiteAccount=#{account}")
	int updateReview(String review, String url, String account);

	@Update("update studentDoExerciseInfo set teacherComment=#{teacherComment}   where doExerciseWebSiteUrl=#{url} and doExerciseWebSiteAccount=#{account}")
	int updateTeacherComment(String teacherComment, String url, String account);

}
