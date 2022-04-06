package com.example.demo.service;

import com.example.demo.bean.Browse;
import com.example.demo.bean.Collect;

import java.util.List;

public interface BrowseService {
    List<Browse> getAllBrowse();
    List<Browse> getBrowseByRoomId(int id);
    List<Browse> getBrowseByUserId(int id);
    String insertBrowse(Browse browse);
    Integer deleteByRid(int rid);
    List<Browse> getBrowseByUserAndRoom(int rid,int uid);
    String updateBrowse(Browse browse);
}
