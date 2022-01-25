package com.example.demo.controller;

import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public String test1(int roomId){
        return roomService.find(roomId).getName();
    }
}
