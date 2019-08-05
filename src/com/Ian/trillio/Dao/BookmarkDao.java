package com.Ian.trillio.Dao;

import com.Ian.trillio.entities.WebLink;
import com.Ian.trillio.general.DataStore;
import com.Ian.trillio.entities.Bookmark;
import com.Ian.trillio.entities.UserBookmark;

import java.util.ArrayList;
import java.util.List;

public class BookmarkDao {
    public List<List<Bookmark>> getBookmarks() {
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }

    public List<WebLink> getAllWebLinks() {
        List<WebLink> result = new ArrayList<>();
        List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
        List<Bookmark> allLinks = bookmarks.get(0);

        for(Bookmark bookmark : allLinks) {
            result.add((WebLink)bookmark);
        }
        return result;
    }

    public List<WebLink> getWebLinks(WebLink.DownloadStatus downloadStatus) {
        List<WebLink> result = new ArrayList<>();

        List<WebLink> allWebLinks = getAllWebLinks();

        for(WebLink webLink : allWebLinks) {
            if(webLink.getDownloadStatus().equals(downloadStatus)) {
                result.add(webLink);
            }
        }
        return result;
    }
}
