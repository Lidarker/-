package com.example.demo.service;

import com.example.demo.bean.Collect;
import com.example.demo.bean.User;

import java.util.List;

public interface CollectionService {
    List<Collect> getAllCollection();
    List<Collect> getCollectionByRoomId(int id);
    List<Collect> getCollectionByUserId(int id);
}