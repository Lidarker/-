package com.example.demo.serviceImpl;

import com.example.demo.bean.Room;
import com.example.demo.bean.RoomExample;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomMapper roomMapper;
    @Override
    public List<Room> findAllRoom() {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        return roomMapper.selectByExample(roomExample);
    }

    @Override
    public List<Room> getRoomByCity(String city) {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        if(city.equals("其他"))
        {
            criteria.andRaddressNotLike("%北京%");
            criteria.andRaddressNotLike("%深圳%");
            criteria.andRaddressNotLike("%上海%");
            criteria.andRaddressNotLike("%广州%");
            criteria.andRaddressNotLike("%武汉%");
            return roomMapper.selectByExample(roomExample);
        }else {
            criteria.andRaddressLike('%'+city+'%');
            return roomMapper.selectByExample(roomExample);
        }
    }

    @Override
    public List<Room> getRoomByMoney(int lowMoney,int highMoney) {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        criteria.andRpriceBetween(lowMoney,highMoney);
        return roomMapper.selectByExample(roomExample);
    }

    @Override
    public List<Room> getRoomByType(String type) {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        if(type.equals("四室以上"))
        {
            criteria.andRtypeNotLike("%一室%");
            criteria.andRtypeNotLike("%二室%");
            criteria.andRtypeNotLike("%三室%");
            criteria.andRtypeNotLike("%四室%");
            return roomMapper.selectByExample(roomExample);
        }else{
            criteria.andRtypeLike('%'+type+'%');
            return roomMapper.selectByExample(roomExample);
        }
    }

    @Override
    public List<Room> getRoomByDcr(String word) {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria=roomExample.createCriteria();
        criteria.andDescriptionLike('%'+word+'%');
        return roomMapper.selectByExample(roomExample);
    }

    @Override
    public Room getRoomById(int id) {
        return roomMapper.selectByPrimaryKey(id);
    }

    @Override
    public String deleteRoomById(int id) {
        int res=roomMapper.deleteByPrimaryKey(id);
        if(res==1)
        {
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @Override
    public String addRoom(Room room) {
        int res=roomMapper.insertSelective(room);
        if(res==1)
        {
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @Override
    public String updateRoom(Room room) {
        int res=roomMapper.updateByPrimaryKeySelective(room);
        if(res==1)
        {
            return "更新成功";
        }else{
            return "更新失败";
        }
    }

}
