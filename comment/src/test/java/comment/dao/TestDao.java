package comment.dao;


import java.util.List;

import org.imooc.bean.Ad;
import org.imooc.dao.AdDao;
import org.imooc.service.AdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml" ,"classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-web.xml"})
public class TestDao {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
		AdDao adDao = (AdDao) ctx.getBean("adDao");
		
		Ad ad = new Ad();
		
		ad.setImgFileName("11");
		ad.setLink("www.");
		ad.setTitle("hehe");
		ad.setWeight((long) 111);
		
		
		int insert = adDao.insert(ad);
		System.out.println(insert);
	
	}
	
	@Test
	public void test2() {
		
		System.out.println("-------");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
		AdService adServiceImpl = (AdService) ctx.getBean("adServiceImpl");
		
		System.out.println(adServiceImpl);
		
	}
	
	
	@Test
	public void testSelectByPage() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
		AdDao adDao = (AdDao) ctx.getBean("adDao");
		Ad condition = new Ad();
		condition.setTitle("1");
		List<Ad> searchByPage = adDao.searchByPage(condition);
		for (Ad ad : searchByPage) {
			System.out.println(ad);
		}
	}
	
}
