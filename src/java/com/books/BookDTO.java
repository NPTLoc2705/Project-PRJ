/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tab135
 */
public class BookDTO {

    private String Title;
    private String Author;
    private String Description;
    private String DownloadLink;
    private String Cover;
    private int BookID;
    private double AverageRating;
    private String Username;
    private List<String> categories;
    public BookDTO(String Title, String Author, String Description, String DownloadLink, String Cover) {
        this.Title = Title;
        this.Author = Author;
        this.Description = Description;
        this.DownloadLink = DownloadLink;
        this.Cover = Cover;
    }

    public BookDTO() {
        this.categories = new ArrayList<>();
    }
    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    public void addCategory(String category) {
        this.categories.add(category);
    }


    public double getAverageRating() {
        return AverageRating;
    }

    public void setAverageRating(double AverageRating) {
        this.AverageRating = AverageRating;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public String getCover() {
        return Cover;
    }

    public void setCover(String Cover) {
        this.Cover = Cover;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDownloadLink() {
        return DownloadLink;
    }

    public void setDownloadLink(String DownloadLink) {
        this.DownloadLink = DownloadLink;
    }

}
