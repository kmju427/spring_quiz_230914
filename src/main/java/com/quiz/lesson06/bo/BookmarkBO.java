package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	// Quiz01
	// input : name, url / output : X
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input : X / output : BookmarkList
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// Quiz02
	// input : url / output : boolean
	public boolean isDuplicationUrl(String url) {
		// 중복 없다면 : [], 중복이면 List는 채워져 있음
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		
		return bookmarkList.isEmpty() ? false : true;
		// return !bookmarkList.isEmpty();
	}
	
	// input : id / output : 삭제된 행의 수
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
	
} // public class BookmarkBO