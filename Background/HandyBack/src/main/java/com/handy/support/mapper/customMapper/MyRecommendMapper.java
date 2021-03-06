package com.handy.support.mapper.customMapper;

import com.handy.support.entity.Course;
import com.handy.support.pojo.course.vo.CourseSimpleVO;
import com.handy.support.pojo.recommend.dto.UserItemLike;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MyRecommendMapper {
    void insertSelective(UserItemLike item);
    void updateRecord(UserItemLike item);
    List<UserItemLike> selectRecord(@Param("userId") int uid, @Param("itemId") int item);
    List<Integer> getCoursesFromAlbum(@Param("albumId")int albumId,@Param("startRow") int page_no,@Param("size") int n);
    List<UserItemLike> getUpdates(@Param("updateTime")String updateTime);
    List<Course>getCourseList(@Param("courseIDs")List<Long> longs);
    void deleteRecord(@Param("userId") int uid, @Param("itemId") int item);
}
