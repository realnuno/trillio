package com.Ian.trillio.entities;

public class UserBookmark {
    private User user;
    private Bookmarks bookMark;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bookmarks getBookMark() {
        return bookMark;
    }

    public void setBookMark(Bookmarks bookMark) {
        this.bookMark = bookMark;
    }
}
