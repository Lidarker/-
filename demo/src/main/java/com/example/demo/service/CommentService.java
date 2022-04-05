package com.example.demo.service;

import com.example.demo.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByRoomId(int id);
}
