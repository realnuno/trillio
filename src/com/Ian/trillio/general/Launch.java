package com.Ian.trillio.general;

import com.Ian.trillio.entities.Bookmark;
import com.Ian.trillio.entities.User;
import com.Ian.trillio.managers.BookmarkManager;
import com.Ian.trillio.managers.UserManager;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData() {
        System.out.println("1. Loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

//        System.out.println("Printing data...");
//        printUserData();
//        printBookmarkData();
    }

    private static void printUserData() {
        for(User user : users) {
            System.out.println(user);
        }
    }

    private static void printBookmarkData() {
        for(Bookmark[] bookmarkList : bookmarks) {
            for(Bookmark bookmark : bookmarkList) {
                System.out.println(bookmark);
            }
        }
    }

    public static void main(String[] args) {
        loadData();
        start();
    }

    private static void start() {
//        System.out.println("\n2. Bookmarking...");
        for(User user : users) {
            View.browser(user, bookmarks);
        }
    }
}
