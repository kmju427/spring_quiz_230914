package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	// input : name, url / output : X
	public void insertBookmark(
			@Param("name") String name, 
			@Param("url") String url);
	
	// input : X / output : BookmarkList
	public List<Bookmark> selectBookmarkList();
	
} // public interface BookmarkMapper