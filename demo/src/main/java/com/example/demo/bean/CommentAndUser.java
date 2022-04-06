package com.example.demo.bean;

public class CommentAndUser {
    private Comment comment;
    private User user;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CommentAndUser() {
    }

    public CommentAndUser(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    @Override
    public String toString() {
        return "com.example.demo.bean.CommentAndUser{" +
                "comment=" + comment +
                ", user=" + user +
                '}';
    }
}
