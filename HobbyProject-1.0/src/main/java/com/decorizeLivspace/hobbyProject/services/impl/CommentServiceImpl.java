package com.decorizeLivspace.hobbyProject.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decorizeLivspace.hobbyProject.entities.Comment;
import com.decorizeLivspace.hobbyProject.entities.Post;
import com.decorizeLivspace.hobbyProject.exceptions.ResourceNotFoundException;
import com.decorizeLivspace.hobbyProject.payloads.CommentDto;
import com.decorizeLivspace.hobbyProject.repositories.CommentRepo;
import com.decorizeLivspace.hobbyProject.repositories.PostRepo;
import com.decorizeLivspace.hobbyProject.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
	}

}
