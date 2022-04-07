package com.example.demo.service;

import com.example.demo.bean.Browse;
import com.example.demo.bean.Collect;

import java.util.List;

public interface BrowseService {
    List<Browse> getAllBrowse();
    List<Browse> getBrowseByRoomId(int id);
    List<Browse> getBrowseByUserId(int id);
    String insertBrowse(Browse browse);
    Integer deleteByRidAndUid(int rid,int uid);
    List<Browse> getBrowseByUserAndRoom(int rid,int uid);
    String updateBrowse(Browse browse);
}
