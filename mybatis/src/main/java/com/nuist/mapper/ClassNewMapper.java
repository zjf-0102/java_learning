package com.nuist.mapper;

import com.nuist.pojo.ClassNew;
import com.nuist.pojo.ClassNewExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassNewMapper {
    int countByExample(ClassNewExample example);

    int deleteByExample(ClassNewExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(ClassNew record);

    int insertSelective(ClassNew record);

    List<ClassNew> selectByExample(ClassNewExample example);

    ClassNew selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") ClassNew record, @Param("example") ClassNewExample example);

    int updateByExample(@Param("record") ClassNew record, @Param("example") ClassNewExample example);

    int updateByPrimaryKeySelective(ClassNew record);

    int updateByPrimaryKey(ClassNew record);
}