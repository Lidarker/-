package com.example.demo.controller;

import com.example.demo.bean.Room;
import com.example.demo.service.RoomService;
import com.example.demo.serviceImpl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("")
@RestController
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService roomService;
    @RequestMapping(value = "/getAllRoom",method = RequestMethod.GET)
    public List<Room>getAllRoom(){return roomService.findAllRoom();}
    @RequestMapping(value = "/getRoom",params = {"city"},method = RequestMethod.GET)
    public List<Room>getRoomByCity(@RequestParam("city")String city)
    {
        System.out.println(city);
        return roomService.getRoomByCity(city);
    }
    @RequestMapping(value = "/getRoom",params = {"lowmoney","highmoney"},method = RequestMethod.GET)
    public List<Room>getRoomByMoney(@RequestParam("lowmoney")int lowMoney,
                                    @RequestParam("highmoney")int highMoney)
    {
        return roomService.getRoomByMoney(lowMoney,highMoney);
    }
    @RequestMapping(value = "/getRoom",params = {"type"},method = RequestMethod.GET)
    public List<Room>getRoomByType(@RequestParam("type")String type){
        return roomService.getRoomByType(type);
    }
    @RequestMapping(value = "/getRoom",params = {"word"},method = RequestMethod.GET)
    public List<Room>getRoomByDcr(@RequestParam("word")String word)
    {
        return roomService.getRoomByDcr(word);
    }
    @RequestMapping(value = "/getRoom",params = {"id"},method = RequestMethod.GET)
    public Room getRoomById(@RequestParam("id")int id){return roomService.getRoomById(id);}
    @RequestMapping(value = "deleteRoom",method = RequestMethod.GET)
    public String deleteRoom(@RequestParam("id")int id){return roomService.deleteRoomById(id);}
}
