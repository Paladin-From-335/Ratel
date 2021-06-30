package com.github.ratel.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Category entity")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false, unique = true, columnDefinition = "BIGINT")
    private long categoryId;

    @ApiModelProperty(value = "category name", example = "Computers")
    @Column(name = "category_name", nullable = false, unique = true, columnDefinition = "TEXT")
    private String categoryName;

    @ApiModelProperty(value = "subcategory id", example = "Notebooks")
    @Column(name = "subcategory_id", nullable = false, columnDefinition = "BIGINT")
    private String subcategoryId;

    public Category(String categoryName, String subcategoryId) {
        this.categoryName = categoryName;
        this.subcategoryId = subcategoryId;
    }
}
