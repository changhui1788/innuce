package com.mc.innuce.domain.search.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mc.innuce.domain.news.dto.NewsDTO;
import com.mc.innuce.domain.search.dto.KeywordDTO;
import com.mc.innuce.domain.search.dto.KeysDTO;

@Repository
@Mapper
public interface KeywordDAO {
	
	public List<NewsDTO> getNewsList(Map<String,Integer> map);
	public List<NewsDTO> getNewsListLimit(Map<String,Object> map);
	public int getTotalNews(int keyword_key);
	public List<Long> getNewKeys(String keyword);
	public List<Long> getNewKeys2(String place);
	public List<String> getCategoryContent(String number);
	
	KeywordDTO oneKeyword(String keyword);
	int updateKeyword(String keyword);
	int insertKeyword(String keyword);
	void insertKeywordNews(KeysDTO keysDTO);
	
//	public List<Long> getNewsKeys2(String keyword);
}
