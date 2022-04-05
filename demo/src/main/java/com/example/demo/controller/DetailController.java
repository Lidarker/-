package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.service.CollectionService;
import com.example.demo.service.CommentService;
import com.example.demo.service.RoomService;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
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
    @Autowired
    private CommentService commentService;
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
    @RequestMapping(value="/getCommentByRoomId",method = RequestMethod.GET)
    public List<CommentAndUser> getCommentByRoomId(@RequestParam("rid")int id){
        List<Comment>comments=commentService.getCommentByRoomId(id);
        List<CommentAndUser>commentAndUsers=new ArrayList<>();
        for(Comment comment:comments){
            commentAndUsers.add(new CommentAndUser(comment,userService.findById(comment.getUid())));
        }
        return commentAndUsers;
    }
}
