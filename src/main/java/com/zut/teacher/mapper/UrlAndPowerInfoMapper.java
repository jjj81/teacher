package com.zut.teacher.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.teacher.entity.UrlAndPowerInfo;


@Mapper
public interface UrlAndPowerInfoMapper {
	@Select("select * from webSiteUrlAndPower")
	List<UrlAndPowerInfo> selectAll();
}
