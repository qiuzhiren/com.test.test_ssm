package com.test.domain;

import java.io.Serializable;

public class BooksSetting implements Serializable {
    private String name;
    private String author;
    private String press;
    private String press_time;
    private String category;
    private Integer reserve_num;
    private Double price;
    private String ISBN;
    private String desc;

    public BooksSetting() {
    }

    public BooksSetting(String name, String author, String press, String press_time, String category, Integer reserve_num, Double price, String ISBN, String desc) {
        this.name = name;
        this.author = author;
        this.press = press;
        this.press_time = press_time;
        this.category = category;
        this.reserve_num = reserve_num;
        this.price = price;
        this.ISBN = ISBN;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPress_time() {
        return press_time;
    }

    public void setPress_time(String press_time) {
        this.press_time = press_time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getReserve_num() {
        return reserve_num;
    }

    public void setReserve_num(Integer reserve_num) {
        this.reserve_num = reserve_num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
