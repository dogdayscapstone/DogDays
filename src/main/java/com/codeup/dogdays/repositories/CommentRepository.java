package com.codeup.dogdays.repositories;

import com.codeup.dogdays.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {


}
