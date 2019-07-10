package com.Ian.trillio.entities;

public class Book extends Bookmark {
    private int publicationYear;
    private String publisher;
    private String[] authors;
    private String genre;
    private String amazonRating;

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(String amazonRating) {
        this.amazonRating = amazonRating;
    }
}
