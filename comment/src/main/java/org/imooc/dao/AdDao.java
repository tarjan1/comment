package org.imooc.dao;

import java.util.List;

import org.imooc.bean.Ad;

public interface AdDao {

	int insert(Ad ad);

	List<Ad> searchByPage(Ad condition);
	
	
	
}
