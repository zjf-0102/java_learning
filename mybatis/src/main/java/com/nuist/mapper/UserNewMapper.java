package com.nuist.mapper;

import com.nuist.pojo.UserNew;
import com.nuist.pojo.UserNewExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserNewMapper {
    int countByExample(UserNewExample example);

    int deleteByExample(UserNewExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserNew record);

    int insertSelective(UserNew record);

    List<UserNew> selectByExample(UserNewExample example);

    UserNew selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserNew record, @Param("example") UserNewExample example);

    int updateByExample(@Param("record") UserNew record, @Param("example") UserNewExample example);

    int updateByPrimaryKeySelective(UserNew record);

    int updateByPrimaryKey(UserNew record);
}