package org.imooc.service.impl.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.imooc.bean.Ad;
import org.imooc.dao.AdDao;
import org.imooc.dto.AdDto;
import org.imooc.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AdServiceImpl implements AdService{
	
	

	/*@Override
	public String toString() {
		return "AdServiceImpl [adDao=" + adDao + ", adImageSavePath=" + adImageSavePath + "]";
	}*/


	@Autowired
	AdDao adDao;
	
	
	@Value("${adImage.savePath}")
	public String adImageSavePath;
	
	
	public boolean add(AdDto adDto) {
		
		Ad ad = new Ad();
		ad.setLink(adDto.getLink());
		ad.setTitle(adDto.getTitle());
		ad.setWeight(adDto.getWeight());
		
		MultipartFile imgFile = adDto.getImgFile();
		if(imgFile!=null  && imgFile.getSize()>0) {
			
			String fileSaveName = System.currentTimeMillis()+ "_" + imgFile.getOriginalFilename();
					
			File file = new File(adImageSavePath);
			//adImageSavePath可能不存在
			if(!file.exists()) {			
				file.mkdirs();			
			}
						
			try {
			
				imgFile.transferTo(new File(adImageSavePath+fileSaveName));
				ad.setImgFileName(fileSaveName);
				int insert = adDao.insert(ad);
				
			} catch (Exception e) {
				return false;
			} 
			
			return true;
		
		}else {
			return false;
		}
		
		
	}


	public List<AdDto> searchByPage(AdDto daDto) {
		List<AdDto> result = new ArrayList<AdDto>();
		
		Ad condition = new Ad();
		//这里的dto只用了title吧
		BeanUtils.copyProperties(daDto, condition);
		
		List<Ad> adList = adDao.searchByPage(condition);
		
		
		for (Ad ad : adList) {
			AdDto tempDto = new AdDto();
			BeanUtils.copyProperties(ad, tempDto);
			result.add(tempDto);
			
		}
		
		return result;
	}

}
