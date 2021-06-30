package com.github.ratel.services.impl;

import com.github.ratel.entity.Comment;
import com.github.ratel.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findCommentById(long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findCommentByProductId(long productId) {
        return commentRepository.findCommentByProductId(productId);
    }

    public List<Comment> findCommentByUserId(long userId) {
        return commentRepository.findCommentByUserId(userId);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment saveCommentByProductId(Comment comment, long id) {
        comment.setProductId(id);
        return commentRepository.save(comment);
    }

    public Comment updateCommentByProductId(Comment comment, long id) {
        return commentRepository.findById(comment.getCommentId()).orElseThrow(() -> new EntityExistsException("Comment not found"));
    }
}
