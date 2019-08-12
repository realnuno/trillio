package com.Ian.trillio.general;

import com.Ian.trillio.bgjobs.WebpageDownloaderTask;
import com.Ian.trillio.entities.Bookmark;
import com.Ian.trillio.entities.User;
import com.Ian.trillio.managers.BookmarkManager;
import com.Ian.trillio.managers.UserManager;

import java.util.List;

public class Launch {
    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;

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
        for(List<Bookmark> bookmarkList : bookmarks) {
            for(Bookmark bookmark : bookmarkList) {
                System.out.println(bookmark);
            }
        }
    }

    public static void main(String[] args) {
        loadData();
        start();

        //Background jobs
//        runDownloaderJob();
    }

    private static void runDownloaderJob() {
        WebpageDownloaderTask task = new WebpageDownloaderTask(true);
        (new Thread(task)).start();
    }

    private static void start() {
//        System.out.println("\n2. Bookmarking...");
        for(User user : users) {
            View.browser(user, bookmarks);
        }
    }
}
