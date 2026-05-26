package com.haziq.fintrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransactionRequestDto {

    // transaction title
    @NotBlank(message = "Title is required")
    private String title;

    // transaction amount
    @NotNull(message = "Amount is required")

    @Positive(message = "Amount must be positive")
    private Double amount;

    // income or expense
    @NotBlank(message = "Type is required")
    private String type;

    // category ID from frontend
    @NotNull(message = "Category is required")
    private Long categoryId;

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

    // getter for categoryId
    public Long getCategoryId() {
        return categoryId;
    }

    // setter for categoryId
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}