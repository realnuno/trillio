package com.Ian.trillio.Dao;

import com.Ian.trillio.general.DataStore;
import com.Ian.trillio.entities.Bookmark;
import com.Ian.trillio.entities.UserBookmark;

import java.util.List;

public class BookmarkDao {
    public List<List<Bookmark>> getBookmarks() {
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
