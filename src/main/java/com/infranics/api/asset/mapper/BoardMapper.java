package com.infranics.api.asset.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.infranics.api.asset.model.BoardModel;
import com.infranics.api.asset.model.LikeModel;

@Mapper
public interface BoardMapper {

	List<BoardModel> getBoards(String token);

	boolean writeBoard(@Param("token") String token, @Param("boardModel") BoardModel boardModel);

	void deleteLike(@Param("likeModel")LikeModel likeModel);

	boolean insertLike(@Param("likeModel")LikeModel likeModel);
}
