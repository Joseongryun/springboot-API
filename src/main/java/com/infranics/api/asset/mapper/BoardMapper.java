package com.infranics.api.asset.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.infranics.api.asset.model.BoardModel;
import com.infranics.api.asset.model.LikeModel;

@Mapper
public interface BoardMapper {

	List<BoardModel> getBoards(String token);

	boolean writeBoard(Map map);

	void deleteLike(LikeModel likeModel);

	boolean insertLike(LikeModel likeModel);

	BoardModel getBoard(Map map);
}
