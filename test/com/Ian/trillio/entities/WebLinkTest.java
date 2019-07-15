package com.Ian.trillio.entities;

import com.Ian.trillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebLinkTest {

    @Test
    void isKidsFriendlyEligible() {
        // Test 1 : porn in url -- false
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",	"http://www.javaworld.com");
        boolean isKidsFriendlyEligible = webLink.isKidsFriendlyEligible();
        assertFalse(isKidsFriendlyEligible, "For porn in url, isKidsFriendlyEligible() returns false.");


        // Test 2 : porn in title -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming porn, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
        isKidsFriendlyEligible = webLink.isKidsFriendlyEligible();
        assertFalse(isKidsFriendlyEligible, "For porn in url, isKidsFriendlyEligible() returns false.");


        // Test 3 : adult in host -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.adult.com");
        isKidsFriendlyEligible = webLink.isKidsFriendlyEligible();
        assertFalse(isKidsFriendlyEligible, "For adult in host, isKidsFriendlyEligible() returns false.");


        // Test 4 : adult in url, but not in host part -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",	"http://www.javaworld.com");
        isKidsFriendlyEligible = webLink.isKidsFriendlyEligible();
        assertTrue(isKidsFriendlyEligible, "For adult in adult, isKidsFriendlyEligible() returns true.");


        // Test 5 : adult in title only -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming adult, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
        isKidsFriendlyEligible = webLink.isKidsFriendlyEligible();
        assertTrue(isKidsFriendlyEligible, "For adult in title, isKidsFriendlyEligible() returns true.");

    }
}