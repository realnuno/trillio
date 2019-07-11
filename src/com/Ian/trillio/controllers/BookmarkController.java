package com.Ian.trillio.controllers;

import com.Ian.trillio.entities.Bookmarks;
import com.Ian.trillio.entities.User;
import com.Ian.trillio.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();

    public static BookmarkController getInstance() {
        return instance;
    }

    private BookmarkController() {}

    public void saveUserBookmark(User user, Bookmarks bookmarks) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmarks);
    }
}
