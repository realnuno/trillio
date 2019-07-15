package com.Ian.trillio.entities;

import com.Ian.trillio.constants.BookGenre;
import com.Ian.trillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void isKidsFriendlyEligible() {
        Book book = BookmarkManager.getInstance().createBook(4000,	"Walden",	1854,	"Wilder Publications",	new String[]{"Henry David", "Thoreau"}, BookGenre.PHILOSOPHY,	4.3);
        boolean isKidsFriendlyEligible = book.isKidsFriendlyEligible();
        assertFalse(isKidsFriendlyEligible, "This book is Philosophy");

        book = BookmarkManager.getInstance().createBook(4000,	"Walden",	1854,	"Wilder Publications",	new String[]{"Henry David", "Thoreau"}, BookGenre.SELF_HELP,	4.3);
        isKidsFriendlyEligible = book.isKidsFriendlyEligible();
        assertFalse(isKidsFriendlyEligible, "This book is Self-help");
    }
}