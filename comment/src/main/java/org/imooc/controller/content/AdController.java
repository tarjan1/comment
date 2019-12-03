package org.imooc.controller.content;

import java.util.List;

import org.imooc.constant.PageCodeEnum;
import org.imooc.dto.AdDto;
import org.imooc.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ad")
public class AdController {
	
	@Autowired
	private AdService adService;
	
	//列表页面
	@RequestMapping("/initList")
	public String initList(Model model,AdDto daDto) {
		System.out.println(daDto);
		List<AdDto> ls = adService.searchByPage(daDto);
		model.addAttribute("list",ls);
		model.addAttribute("searchParam",daDto);
		return "/content/list";
	}
	
	//维护页面
	@RequestMapping("/initModify")
	public String initModify() { 
		return "/content/modify";
	}
	
	
	
	
	
	//广告新增
	@RequestMapping("/addPage")
	public String adAddUI() {
		
		return "/content/modify";
	}
	
		
	@RequestMapping("/add")
	public String adAdd(AdDto adDto,Model model) {
		
		if(adService.add(adDto)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
		}else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
		}

		return "/content/modify";
	}
	
	
}