package com.example.demo.controller;

import com.example.demo.bean.Collect;
import com.example.demo.bean.Room;
import com.example.demo.service.CollectionService;
import com.example.demo.service.RoomService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RequestMapping("/room")
@RestController
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllRoom", method = RequestMethod.GET)
    public List<Room> getAllRoom() {
        return roomService.findAllRoom();
    }

    @RequestMapping(value = "/getRoom", params = {"city"}, method = RequestMethod.GET)
    public List<Room> getRoomByCity(@RequestParam("city") String city) {
        System.out.println(city);
        return roomService.getRoomByCity(city);
    }

    @RequestMapping(value = "/getRoom", params = {"lowmoney", "highmoney"}, method = RequestMethod.GET)
    public List<Room> getRoomByMoney(@RequestParam("lowmoney") int lowMoney,
                                     @RequestParam("highmoney") int highMoney) {
        return roomService.getRoomByMoney(lowMoney, highMoney);
    }

    @RequestMapping(value = "/getRoom", params = {"type"}, method = RequestMethod.GET)
    public List<Room> getRoomByType(@RequestParam("type") String type) {
        return roomService.getRoomByType(type);
    }

    @RequestMapping(value = "/getRoom", params = {"word"}, method = RequestMethod.GET)
    public List<Room> getRoomByDcr(@RequestParam("word") String word) {
        return roomService.getRoomByDcr(word);
    }

    @RequestMapping(value = "/getRoom", params = {"id"}, method = RequestMethod.GET)
    public Room getRoomById(@RequestParam("id") int id) {
        return roomService.getRoomById(id);
    }

    @RequestMapping(value = "/updateRoom", method = RequestMethod.POST)
    public String updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    @RequestMapping(value = "/insertHouse", method = RequestMethod.POST)
    @ResponseBody
    public String insertHouse(HttpServletRequest request) {
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("picture");
        String picName = params.getParameter("pic_uid") + ".jpg";
        if (!file.isEmpty()) {
            //部署后需要改路径
            String filePath = "/home/liq/rent/" + picName;
            File fileSave = new File(filePath);
            try {
                file.transferTo(fileSave);
            } catch (IOException e) {
                e.printStackTrace();
                return "发布房源失败";
            }
        }
        Room room = new Room(params.getParameter("type"),
                params.getParameter("address"),
                Integer.parseInt(params.getParameter("price")),
                params.getParameter("advance"),
                picName,
                params.getParameter("number"));
        String res = roomService.addRoom(room);
        List<Room> rooms = roomService.getRoomByImg(picName);
        Integer rid = rooms.get(0).getRid();
        String account = params.getParameter("account");
        Integer uid = userService.findByAccount(account).getUid();
        Collect collect = new Collect(uid, rid);
        collectionService.insertCollection(collect);
        return res;
    }

    @RequestMapping(value = "deleteRoom", method = RequestMethod.GET)
    public String deleteRoomById(@RequestParam("rid") int rid) {
        Room room = roomService.getRoomById(rid);
        if (roomService.deleteRoomById(rid) == 1) {
            if (collectionService.deleteByRid(rid) == 1) {
                //需要删除
                File file = new File("/home/liq/rent/" + room.getRimage());
                if (file.exists()) {
                    if (file.delete()) {
                        return "删除成功";
                    }
                }
            }
        }
        return "删除失败";
    }
}