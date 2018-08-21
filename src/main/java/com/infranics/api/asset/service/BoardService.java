package com.infranics.api.asset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infranics.api.asset.mapper.BoardMapper;
import com.infranics.api.asset.model.BoardModel;
import com.infranics.api.asset.model.LikeModel;

@Transactional
@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;

	public List<BoardModel> getBoards(String token) {
		return boardMapper.getBoards(token);
	}

	public boolean writeBoard(String token, BoardModel boardModel) {
		return boardMapper.writeBoard(token, boardModel);
	}
	
	public boolean userLike(LikeModel likeModel) {
		boardMapper.deleteLike(likeModel);
		boolean insertResult = boardMapper.insertLike(likeModel);
		
		return (insertResult);
	}

}
