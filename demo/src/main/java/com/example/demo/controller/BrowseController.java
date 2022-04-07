package com.example.demo.controller;

import com.example.demo.bean.Browse;
import com.example.demo.bean.Room;
import com.example.demo.bean.User;
import com.example.demo.service.BrowseService;
import com.example.demo.service.RoomService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/browse")
@CrossOrigin
@RestController
public class BrowseController {
    @Autowired
    private BrowseService browseService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @RequestMapping(value="/getAllBrowse",method = RequestMethod.GET)
    public List<Room> getRoomByAccount(@RequestParam("account")String account){
        User user=userService.findByAccount(account);
        List<Browse>browses=browseService.getBrowseByUserId(user.getUid());
        List<Room>rooms=new ArrayList<>();
        for(Browse browse:browses){
            Room room=roomService.getRoomById(browse.getSid());
            rooms.add(room);
        }
        return rooms;
    }
    @RequestMapping(value = "/browseHouse",method = RequestMethod.GET)
    public String insertBrowse(@RequestParam("account")String account,@RequestParam("rid")int rid){
        User user=userService.findByAccount(account);
        List<Browse>browses=browseService.getBrowseByUserAndRoom(rid,user.getUid());
        if(!browses.isEmpty()){
            return "已收藏该房";
        }
        Browse browse=new Browse(user.getUid(),rid);
        return browseService.insertBrowse(browse);
    }
    @RequestMapping(value = "/deleteBrowse",method = RequestMethod.GET)
    public String deleteBrowse(@RequestParam("account")String account,@RequestParam("rid")int rid){
        User user=userService.findByAccount(account);
        int res=browseService.deleteByRidAndUid(rid,user.getUid());
        if(res==1)return "取消收藏成功";
        else return "取消失败";
    }
}
