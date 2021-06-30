package com.github.ratel.controllers.impl.comment;

import com.github.ratel.dto.CommentDto;
import com.github.ratel.entity.Comment;
import com.github.ratel.services.impl.CommentService;
import com.github.ratel.validations.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.github.ratel.utils.TransferObj.toComment;

@CrossOrigin
@RestController
@RequestMapping(path = "/{product-id}")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<Comment> findAllCommentByProductId(@PathVariable("product-id") long productId) {
        return commentService.findCommentByProductId(productId);
    }

    @PostMapping("/comment")
    public Comment createCommentByProductId(@RequestBody CommentDto commentDto, @PathVariable("product-id") long productId) {
        return commentService.saveCommentByProductId(toComment(commentDto), productId);
    }

    @PutMapping("/comment")
    public Comment editCommentByProductId(@RequestBody CommentDto commentDto, @PathVariable("product-id") long productId) {
        return commentService.updateCommentByProductId(toComment(commentDto), productId);
    }

}
