package com.cafesync.CafeSync.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long categoryId;

	    @Column(nullable = false, unique = true)
	    private String categoryName;

	    @Enumerated(EnumType.STRING)
	    private Status status;

	    public Category() {
	    }

	    public Long getCategoryId() {
	        return categoryId;
	    }

	    public void setCategoryId(Long categoryId) {
	        this.categoryId = categoryId;
	    }

	    public String getCategoryName() {
	        return categoryName;
	    }

	    public void setCategoryName(String categoryName) {
	        this.categoryName = categoryName;
	    }

	    public Status getStatus() {
	        return status;
	    }

	    public void setStatus(Status status) {
	        this.status = status;
	    }
	}


