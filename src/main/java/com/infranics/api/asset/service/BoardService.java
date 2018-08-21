package com.infranics.api.asset.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public long writeBoard(String token, BoardModel boardModel) {
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("boardModel", boardModel);
		boardMapper.writeBoard(map);
		return (long) map.get("gid");
	}
	
	public boolean userLike(LikeModel likeModel) {
		boardMapper.deleteLike(likeModel);
		return boardMapper.insertLike(likeModel);
	}

	public BoardModel getBoard(String token, int boardIndex) {
		Map<String, Object> map = new HashMap<>();
		map.put("token",token);
		map.put("boardIndex", boardIndex);
		BoardModel boardModel = boardMapper.getBoard(map);
		return boardModel;
	}

}
