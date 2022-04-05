package com.example.demo.controller;

import com.example.demo.bean.Collect;
import com.example.demo.bean.Room;
import com.example.demo.bean.RoomAndUser;
import com.example.demo.bean.User;
import com.example.demo.service.CollectionService;
import com.example.demo.service.RoomService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("")
@RestController
@CrossOrigin
public class DetailController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @RequestMapping(value = "/getOwner",method = RequestMethod.GET)
    public User getOwnerByRoomId(@RequestParam("rid")int rid){
        List<Collect> collects=collectionService.getCollectionByRoomId(rid);
        int uid=collects.get(0).getUid();
        return userService.findById(uid);
    }
    @RequestMapping(value="/getRoomAndUser",method = RequestMethod.GET)
    public List<RoomAndUser> getRoomAndUser(){
        List<Room>rooms=roomService.findAllRoom();
        List<RoomAndUser>roomAndUsers=new ArrayList<>();
        for(Room room:rooms){
            User user=userService.findById(collectionService.getCollectionByRoomId(room.getRid()).get(0).getUid());
            roomAndUsers.add(new RoomAndUser(room,user));
        }
        return roomAndUsers;
    }
    @RequestMapping(value = "/getRoomByAccount",method = RequestMethod.GET)
    public List<Room> getRoomByAccount(@RequestParam("account")String account){
        User user=userService.findByAccount(account);
        List<Collect>collects=collectionService.getCollectionByUserId(user.getUid());
        List<Room>rooms=new ArrayList<>();
        for(Collect collect:collects){
            Room room= roomService.getRoomById(collect.getRid());
            rooms.add(room);
        }
        return rooms;
    }
}