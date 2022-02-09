package com.example.demo.service;

import com.example.demo.bean.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAllRoom();
    List<Room> getRoomByCity(String city);
    List<Room> getRoomByMoney(int lowMoney,int highMoney);
    List<Room> getRoomByType(String type);
    List<Room> getRoomByDcr(String word);
    Room getRoomById(int id);
    String deleteRoomById(int id);
    String addRoom(Room room);
    String updateRoom(Room room);
}
