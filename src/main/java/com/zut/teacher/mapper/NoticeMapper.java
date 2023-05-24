package com.zut.teacher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;

import com.zut.teacher.entity.Notice;

@Mapper
public interface NoticeMapper {

	@Select("select * from notice where teacherId=#{teacherId}")
	List<Notice> seleceNoticeByTeacherId(String teacherId);

	@Insert("insert into notice(teacherId,title,body) values(#{teacherId},#{title},#{body})")
	int insertNotice(Notice n);

	@Delete("delete from notice where title=#{title}")
	int deleteNoticeByTitle(String title);
}
