package com.example.demo.serviceImpl;

import com.example.demo.bean.Room;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room find(int id) {
        return roomMapper.selectByPrimaryKey(id);
    }
}
