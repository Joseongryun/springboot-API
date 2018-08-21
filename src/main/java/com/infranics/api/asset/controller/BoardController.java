package com.infranics.api.asset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infranics.api.asset.model.BoardModel;
import com.infranics.api.asset.model.LikeModel;
import com.infranics.api.asset.service.BoardService;

@Transactional
@RestController
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/boards", method = RequestMethod.GET)
	public List<BoardModel> getBoards(@RequestHeader(value = "token", required = false) String token) throws Exception {
		return boardService.getBoards(token);
	}

	@RequestMapping(value = "/boards", method = RequestMethod.POST)
	public boolean writeBoard(@RequestHeader(value = "token", defaultValue = "") String token,
			@RequestParam("title") String title, @RequestParam("link") String link) throws Exception {
		BoardModel boardModel = new BoardModel();
		boardModel.setTitle(title);
		boardModel.setLink(link);
		return boardService.writeBoard(token, boardModel);
	}

	@RequestMapping(value = "/boards/{boardIndex}/like", method = RequestMethod.POST)
	public boolean userLike(@RequestHeader(value = "token", defaultValue = "") String token,
			@RequestParam("userLike") String userLike, @PathVariable("boardIndex") long boardIndex) {
		LikeModel likeModel = new LikeModel();
		likeModel.setGid(boardIndex);
		likeModel.setToken(token);
		likeModel.setLikeYN(userLike);
		return boardService.userLike(likeModel);
	}
}
