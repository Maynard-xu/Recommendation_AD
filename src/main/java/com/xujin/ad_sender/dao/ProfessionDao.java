package com.xujin.ad_sender.dao;

import com.xujin.ad_sender.entity.ProfessionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProfessionDao {
    @Select("SELECT * from profession")
    ProfessionEntity SearchProfession();
}
