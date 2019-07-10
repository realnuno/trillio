package com.Ian.trillio;

import com.Ian.trillio.entities.Bookmarks;
import com.Ian.trillio.entities.User;
import com.Ian.trillio.managers.BookmarkManager;
import com.Ian.trillio.managers.UserManager;

public class Launch {
    private static User[] users;
    private static Bookmarks[][] bookmarks;

    private static void loadData() {
        System.out.println("1. Loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println("Printing data...");
        printUserData();
        printBookmarkData();
    }

    private static void printUserData() {
        for(User user : users) {
            System.out.println(user);
        }
    }

    private static void printBookmarkData() {
        for(Bookmarks[] bookmarkList : bookmarks) {
            for(Bookmarks bookmark : bookmarkList) {
                System.out.println(bookmark);
            }
        }
    }

    public static void main(String[] args) {
        loadData();
    }
}
