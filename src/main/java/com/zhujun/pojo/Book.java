package com.zhujun.pojo;


public class Book {

    private long id;
    private String bookName;
    private long bookNumber;
    private double bookPrice;
    private java.sql.Timestamp bookDate;
    private String bookImage;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(long bookNumber) {
        this.bookNumber = bookNumber;
    }


    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }


    public java.sql.Timestamp getBookDate() {
        return bookDate;
    }

    public void setBookDate(java.sql.Timestamp bookDate) {
        this.bookDate = bookDate;
    }


    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

}
