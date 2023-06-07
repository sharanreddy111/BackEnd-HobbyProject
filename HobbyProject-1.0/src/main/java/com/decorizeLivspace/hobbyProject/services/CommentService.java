package com.decorizeLivspace.hobbyProject.services;

import com.decorizeLivspace.hobbyProject.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);

}
