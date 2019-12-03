package org.imooc.service;

import java.util.List;

import org.imooc.dto.AdDto;

public interface AdService {
	
	/**
	 * 新增广告
	 * @param adDto
	 * @return 是否新增成功
	 */
	public boolean add(AdDto adDto);

	public List<AdDto> searchByPage(AdDto daDto);
}
