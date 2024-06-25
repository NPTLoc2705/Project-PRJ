/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books;

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

    public BookDTO(String Title, String Author, String Description, String DownloadLink, String Cover) {
        this.Title = Title;
        this.Author = Author;
        this.Description = Description;
        this.DownloadLink = DownloadLink;
        this.Cover = Cover;
    }


    BookDTO() {
        
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
