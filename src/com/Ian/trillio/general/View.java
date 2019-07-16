package com.Ian.trillio.general;

import com.Ian.trillio.constants.KidsFriendlyStatus;
import com.Ian.trillio.constants.UserType;
import com.Ian.trillio.controllers.BookmarkController;
import com.Ian.trillio.entities.Bookmark;
import com.Ian.trillio.entities.User;
import com.Ian.trillio.partner.Sharable;

import java.util.List;

public class View {
    public static void browser(User user, List<List<Bookmark>> bookmarks) {
        System.out.println("\n" + user.getEmail() + " is browsing items...");
        int bookmarkCount = 0;
        for(List<Bookmark> bookmarkList : bookmarks) {
            for(Bookmark bookmark : bookmarkList) {
                //if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if(isBookmarked) {
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("New item Bookmarked -- " + bookmark);
                    }
                    if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
                        if(bookmark.isKidsFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidsFriendlyStatus.UNKNOWN)) {
                            String kidFriendlyStatus = getKidFriendlyDecision(bookmark);
                            if(!kidFriendlyStatus.equals(KidsFriendlyStatus.UNKNOWN)) {
                                BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
                            }
                        }

                        //Sharing!!
                        if(bookmark.getKidFriendlyStatus().equals(KidsFriendlyStatus.APPROVED) && bookmark instanceof Sharable) {
                            boolean isShared = getShareDecision();
                            if(isShared) {
                                BookmarkController.getInstance().share(user, bookmark);
                            }
                        }
                    }
                //}
            }
        }
    }


    //TODO : Below methods simulate user input. After IO, we take input via console.
    private static boolean getShareDecision() {
        return Math.random() < 0.5 ? true : false;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true : false;
    }

    private static String getKidFriendlyDecision(Bookmark bookmark) {
        return Math.random() < 0.4 ? KidsFriendlyStatus.APPROVED :
                (Math.random() >= 0.4 && Math.random() < 0.8 ? KidsFriendlyStatus.REJECTED : KidsFriendlyStatus.UNKNOWN);
    }


//    public static void bookmark(User user, Bookmark[][] bookmarks) {
//        System.out.println("\n" + user.getEmail() + " is bookmarking");
//        for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
//            int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
//            int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
//
//            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//
//            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//
//            System.out.println(bookmark);
//        }
//    }
}
