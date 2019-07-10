package com.Ian.trillio;

import com.Ian.trillio.entities.Bookmarks;
import com.Ian.trillio.entities.User;

public class View {
    public static void bookmark(User user, Bookmarks[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
            int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
            int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

            Bookmarks bookmark = bookmarks[typeOffset][bookmarkOffset];

        }
    }
}
