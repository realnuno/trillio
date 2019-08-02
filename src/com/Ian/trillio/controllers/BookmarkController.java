package com.Ian.trillio.controllers;

import com.Ian.trillio.constants.KidsFriendlyStatus;
import com.Ian.trillio.entities.Bookmark;
import com.Ian.trillio.entities.User;
import com.Ian.trillio.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();

    public static BookmarkController getInstance() {
        return instance;
    }

    private BookmarkController() {}

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }

    public void setKidFriendlyStatus(User user, KidsFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
        BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
    }
    public void share(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().share(user, bookmark);
    }
}
