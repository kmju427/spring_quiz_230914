package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {

	// Quiz01
	// input : name, url / output : X
	public void insertBookmark(
			@Param("name") String name, 
			@Param("url") String url);
	
	// input : X / output : BookmarkList
	public List<Bookmark> selectBookmarkList();
	
	// Quiz02
	// input : url / output : List<Bookmark>
	public List<Bookmark> selectBookmarkListByUrl(String url);
	
	// input : id / output : 삭제된 행의 수
	public int deleteBookmarkById(int id);
	
} // public interface BookmarkMapper