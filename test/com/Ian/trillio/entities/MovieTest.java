package com.Ian.trillio.entities;

import com.Ian.trillio.constants.MovieGenre;
import com.Ian.trillio.managers.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void isKidsFriendlyEligible() {
        Movie movie = BookmarkManager.getInstance().createMovie(3000,	"Citizen Kane",	"", 1941, new String[]{"Orson Welles", "Joseph Cotten"},	new String[]{"Orson Welles"}, MovieGenre.HORROR,	8.5);
        boolean isKidsFriendlyEligible = movie.isKidsFriendlyEligible();
        assertFalse(isKidsFriendlyEligible, "Horror movie! false!");

        movie = BookmarkManager.getInstance().createMovie(3000,	"Citizen Kane",	"", 1941, new String[]{"Orson Welles", "Joseph Cotten"},	new String[]{"Orson Welles"}, MovieGenre.THRILLERS,	8.5);
        isKidsFriendlyEligible = movie.isKidsFriendlyEligible();
        assertFalse(isKidsFriendlyEligible, "Thriller movie! false!");
    }
}