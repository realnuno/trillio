package com.Ian.trillio.Dao;

import com.Ian.trillio.DataStore;
import com.Ian.trillio.entities.Bookmarks;

public class BookmarkDao {
    public Bookmarks[][] getBookmarks() {
        return DataStore.getBookmarks();
    }
}
