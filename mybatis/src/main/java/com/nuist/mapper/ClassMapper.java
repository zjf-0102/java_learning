package com.nuist.mapper;

import com.nuist.pojo.Class;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {

//    分步查询第二步
    Class selectByStepTwo(@Param("cid") Integer cid);

//    同样也是分步
    Class selectDetailClass(@Param("cid") Integer cid);
}
