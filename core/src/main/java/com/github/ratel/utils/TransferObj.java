package com.github.ratel.utils;

import com.github.ratel.dto.*;
import com.github.ratel.entity.*;

public class TransferObj {

    public static Product toProduct(ProductDto data) {
        return new Product(
                data.getName(),
                data.getPrice(),
                data.getBrand(),
                data.getQuantity(),
                data.getArticle(),
                data.getImg(),
                data.getSupplier(),
                data.getSpecification()
        );
    }

    public static ProductDto fromProduct(Product data) {
        return new ProductDto(
                data.getName(),
                data.getPrice(),
                data.getBrand(),
                data.getQuantity(),
                data.getArticle(),
                data.getImg(),
                data.getSupplier(),
                data.getSpecification()
        );
    }

    public static User toUser(UserAuthDto data) {
        return new User(
                data.getLogin(),
                data.getPassword()
        );
    }

    public static UserAuthDto fromUserAuth(User data) {
        return new UserAuthDto(
                data.getLogin(),
                data.getPassword()
        );
    }

    public static User toUser(UserRegDto data) {
        return new User(
                data.getFirstname(),
                data.getLastname(),
                data.getEmail(),
                data.getLogin(),
                data.getPassword(),
                data.getPhone(),
                data.getAddress(),
                data.getCreatedAt(),
                data.getVerification()
        );
    }

    public static UserRegDto fromUserReg(User data) {
        return new UserRegDto(
                data.getFirstname(),
                data.getLastname(),
                data.getEmail(),
                data.getLogin(),
                data.getPassword(),
                data.getPhone(),
                data.getAddress(),
                data.getCreatedAt(),
                data.getVerification()
        );
    }

    public static Order toOrder(OrderDto data) {
        return new Order(
                data.getOrder_item_id(),
                data.getPrice(),
                data.getCreatedAt(),
                data.getEmail(),
                data.getAddress()
        );
    }

    public static OrderDto fromOrder(Order data) {
        return new OrderDto(
                data.getOrderItemId(),
                data.getPrice(),
                data.getCreatedAt(),
                data.getEmail(),
                data.getAddress()
        );
    }

    public static Brand toBrand(BrandDto data) {
        return new Brand(data.getBrandName());
    }

    public static BrandDto fromBrand(Brand data) {
        return new BrandDto(data.getBrandName());
    }

    public static Category toCategory(CategoryDto data) {
        return new Category(
                data.getCategoryName(),
                data.getSubcategoryId());
    }

    public static CategoryDto fromCategory(Category data) {
        return new CategoryDto(
                data.getCategoryName(),
                data.getSubcategoryId()
        );
    }

    public static Comment toComment(CommentDto data) {
        return new Comment(
                data.getUserId(),
                data.getProductId(),
                data.getCommentText(),
                data.getCreatedAt()
        );
    }

    public static CommentDto fromComment(Comment data) {
        return new CommentDto(
                data.getProductId(),
                data.getUserId(),
                data.getCommentText(),
                data.getCreatedAt()
        );
    }
}
