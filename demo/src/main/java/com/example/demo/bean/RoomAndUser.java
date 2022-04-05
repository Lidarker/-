package com.example.demo.bean;

public class RoomAndUser {
    private Room room;
    private User user;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoomAndUser() {
    }

    public RoomAndUser(Room room, User user) {
        this.room = room;
        this.user = user;
    }
}
