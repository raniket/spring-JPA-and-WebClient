package com.frankmoley.lil.learningspring.data;


public class Todo {
    private Long userId;
    private Long id;
    private String title;
    private boolean completed;

    public Todo(Long userId, Long id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        return "Todo [userId=" + this.userId + ", id=" + this.id + ", title=" + this.title + ", completed=" + this.completed + "]";
    }

}
