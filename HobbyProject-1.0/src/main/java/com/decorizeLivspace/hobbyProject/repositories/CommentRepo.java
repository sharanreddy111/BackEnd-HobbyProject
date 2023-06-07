package com.decorizeLivspace.hobbyProject.repositories;

import com.decorizeLivspace.hobbyProject.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo  extends JpaRepository<Comment, Integer> {

}
