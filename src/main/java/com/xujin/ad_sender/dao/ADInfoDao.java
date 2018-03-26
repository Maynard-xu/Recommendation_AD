package com.xujin.ad_sender.dao;

import com.xujin.ad_sender.entity.ADInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ADInfoDao {
    @Select("select * from ad_information")
    List<ADInfoEntity> getAllADInformation();
}