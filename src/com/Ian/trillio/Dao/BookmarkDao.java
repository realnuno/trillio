package com.Ian.trillio.Dao;

import com.Ian.trillio.general.DataStore;
import com.Ian.trillio.entities.Bookmarks;
import com.Ian.trillio.entities.UserBookmark;

public class BookmarkDao {
    public Bookmarks[][] getBookmarks() {
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
