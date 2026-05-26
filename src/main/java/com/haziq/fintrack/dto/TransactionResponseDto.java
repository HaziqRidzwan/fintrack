package com.haziq.fintrack.dto;

public class TransactionResponseDto {

    // transaction id
    private Long id;

    // transaction title
    private String title;

    // transaction amount
    private Double amount;

    // income or expense
    private String type;

    // category name only
    // NOT full category object
    private String categoryName;

    // getter for id
    public Long getId() {
        return id;
    }

    // setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // getter for title
    public String getTitle() {
        return title;
    }

    // setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // getter for amount
    public Double getAmount() {
        return amount;
    }

    // setter for amount
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // getter for type
    public String getType() {
        return type;
    }

    // setter for type
    public void setType(String type) {
        this.type = type;
    }

    // getter for categoryName
    public String getCategoryName() {
        return categoryName;
    }

    // setter for categoryName
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}