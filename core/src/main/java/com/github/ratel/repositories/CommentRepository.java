package com.github.ratel.repositories;

import com.github.ratel.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findCommentByProductId(long productId);

    public List<Comment> findCommentByUserId(long userId);

}
