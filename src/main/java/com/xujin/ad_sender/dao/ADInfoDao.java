package com.xujin.ad_sender.dao;

import com.xujin.ad_sender.entity.ADInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ADInfoDao {
    @Select("select * from ad_information")
    List<ADInfoEntity> getAllADInformation();
    @Insert("insert into ad_information(ADTitle,SelectCrowd,SelectGender,UploadPicture,ADClasses,ADDescribe,PTBPrice)" + " " +
            "values(#{ADTitle},#{SelectCrowd},#{SelectGender},#{UploadPicture},#{ADClasses},#{ADDescribe},#{PTBPrice})")
    void addADInfo(ADInfoEntity adInfoEntity);

}