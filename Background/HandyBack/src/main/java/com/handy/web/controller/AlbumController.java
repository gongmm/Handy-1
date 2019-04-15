package com.handy.web.controller;

import com.handy.support.entity.Album;
import com.handy.support.entity.Course;
import com.handy.support.pojo.album.dto.AlbumCourseDto;
import com.handy.support.pojo.album.dto.AlbumDto;
import com.handy.support.pojo.album.vo.AlbumCourseVO;
import com.handy.support.pojo.album.vo.AlbumVO;
import com.handy.support.service.Album.IAlbumService;
import com.handy.support.service.Course.ICourseSevice;
import com.handy.support.utils.status.ErrorEnum;
import com.handy.support.utils.status.ReturnCode;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pan on 2019/4/14.
 */
@RestController
public class AlbumController {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private IAlbumService albumService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private ICourseSevice courseSevice;
    
    @RequestMapping(value = "/album/recommend",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    public String getRecommendAlbum(int uid){
        List<AlbumVO> dtos = albumService.getRecommendedAlbum(uid);
        ErrorEnum error = null;
        if(dtos== null){
            error = ErrorEnum.USER_NOT_EXIST;
        }else{
            error = ErrorEnum.SUCCESS;
        }

        ReturnCode<List<AlbumVO>> code = new ReturnCode<List<AlbumVO>>(error,dtos);
        return code.returnHandler();
    }

    @RequestMapping(value = "/album/mylist",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    public String getMyAlbumList(int uid){
        List<AlbumDto> dtos = albumService.getAlbumList(uid);
        List<AlbumVO> vos = new ArrayList<AlbumVO>();
        for(AlbumDto dto:dtos){
            if(dto.getAlbumState()){
                AlbumVO vo = new AlbumVO(dto);
                vos.add(vo);
            }
        }
        ReturnCode<List<AlbumVO>> code = new ReturnCode<List<AlbumVO>>(vos);
        return code.returnHandler();
    }

    @RequestMapping(value = "/album/collection",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    public String getListCollection(int uid){
        List<AlbumDto> dtos = albumService.getAlbumList(uid);
        List<AlbumVO> vos = new ArrayList<AlbumVO>();
        for(AlbumDto dto:dtos){
            if(!dto.getAlbumState()){
                AlbumVO vo = new AlbumVO(dto);
                vos.add(vo);
            }
        }
        ReturnCode<List<AlbumVO>> code = new ReturnCode<List<AlbumVO>>(vos);
        return code.returnHandler();
    }

    @RequestMapping(value = "/album/detail",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    public String getListDetail(int uid, int albumid,int page,int n){
        List<AlbumCourseDto> list = albumService.getAlbumDetail(albumid);
        AlbumCourseVO vo = new AlbumCourseVO();
        if(list.size()!=0)
            vo.setAlbumId(list.get(0).getAlbumId());
        for(AlbumCourseDto dto:list){
            Course course = courseSevice.getCourseByID(dto.getCourseId().toString());
        }
        ReturnCode<AlbumCourseVO> code = new ReturnCode<AlbumCourseVO>(vo);
        return code.returnHandler();
    }

}
