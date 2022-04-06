package com.example.demo.serviceImpl;

import com.example.demo.bean.Comment;
import com.example.demo.bean.CommentExample;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> getCommentByRoomId(int id) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andRidEqualTo(id);
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public String insertComment(Comment comment) {
        if(commentMapper.insertSelective(comment)==1){
            return "添加评论成功";
        }else return "添加评论失败";
    }
}
