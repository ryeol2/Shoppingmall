package spring.project.shopping;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.util.MethodInvocationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.project.shopping.paging.PageSet;
import spring.project.shopping.paging.PageMaker;
import spring.project.shopping.top_service.JacketService;
import spring.project.shopping.top_service.OuterService;
import spring.project.shopping.topdto.TopDTO;

@Controller
public class MainController {
	@Autowired
	private OuterService outerService;
	@Autowired
	private JacketService jacketService;
	
	@Resource(name="uploadPath")
	private String path;
	
	private PageMaker pageMaker = new PageMaker();
	private Checking checking = new Checking();
	
	@RequestMapping("menu")
	public String sMenu() {
		return "menu";
	}

	@RequestMapping("main")
	public String sMain() {
		checking.setLoginCheck(true);
		return "main";
	}
	@RequestMapping("mainSub")
	public String sMainSub() {
		return "mainSub";
	}

	@RequestMapping("join")
	public String sJoin(Model model) {

		return "/Join/joinForm";
	}

	@RequestMapping(value="Outers", method=RequestMethod.GET)
	public String sOuter(Model model, PageSet pageSet) {
		List<TopDTO> listOuter = outerService.itemList(pageSet);
		
		pageMaker.setpageSet(pageSet);
		pageMaker.setTotalCount(outerService.itemCount());
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("listOuter", listOuter);
	

		return "/Top/Outers";
	}
	
//	@RequestMapping(value="getPrevPage", method=RequestMethod.GET)
//	public @ResponseBody String getPrev(@RequestParam("category")String category) {
//		System.out.println(category);
//		String url="";
//		if(category.equals("outers")) {
//			url = "Outers"+pageMaker.makeQuery(pageMaker.getpageSet().getPage()-1); //현재 페이지에서 -1
//		}else if(category.equals("jackets")) {
//			url = "Jackets"+pageMaker.makeQuery(pageMaker.getpageSet().getPage()-1);
//		}
//		return url;
//	}
//	
//	@RequestMapping(value="getNextPage", method=RequestMethod.GET)
//	public @ResponseBody String getNext(@RequestParam("category")String category) {
//		System.out.println(category);
//		String url="";
//		if(category.equals("outers")) {
//			System.out.println(pageMaker.getEndPage());
//			url = "Outers"+pageMaker.makeQuery(pageMaker.getEndPage()+1);
//		}else if(category.equals("jackets")) {
//			url = "Jackets"+pageMaker.makeQuery(pageMaker.getEndPage()+1);
//		}
//		return url;
//	}
//	
//	@RequestMapping(value="getPageSite", method=RequestMethod.GET)
//	public @ResponseBody String getPageSite(@RequestParam("category")String category, @RequestParam("page") String page,
//			PageSet pageSet) {
//		
//		System.out.println(category+"//"+page);
//		String url="";
//		if(category.equals("outers")) {
//	
//		url = "Outers"+pageMaker.makeQuery(Integer.parseInt(page));
//		}else if(category.equals("jackets")) {
//			
//			url="Jackets"+pageMaker.makeQuery(Integer.parseInt(page));
//		}
//		return url;
//	}
	
	
	@RequestMapping("detail")
	public String outerDetail(@RequestParam("category")String category, @RequestParam("item") int productId, Model model) {
		String url ="";
		if(category.equals("outers")) {
		TopDTO outerinfo = outerService.detailOuter(productId);
		model.addAttribute("detail", outerinfo);
		model.addAttribute("path", path);
		model.addAttribute("category", category);
		url =  "/details/itemDetail";
	}else if(category.equals("jackets")) {
		TopDTO jacketinfo = jacketService.detailJacket(productId);
		model.addAttribute("detail", jacketinfo);
		model.addAttribute("path", path);
		model.addAttribute("category", category);
		url =  "/details/itemDetail";
	}
		return url;
	}

	@RequestMapping(value="Jackets", method=RequestMethod.GET)
	public String sJacket(Model model, PageSet pageSet) {
List<TopDTO> listJacket = jacketService.itemList(pageSet);
		
		pageMaker.setpageSet(pageSet);
		pageMaker.setTotalCount(jacketService.itemCount());
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("listJacket", listJacket);
		
		return "/Top/Jackets";
	}

	@RequestMapping("Shirts")
	public String sShirt() {
		return "/Top/Shirts";
	}

	@RequestMapping("KniteWears")
	public String sKnite() {
		return "/Top/KniteWears";
	}

	@RequestMapping("registry")
	public String sRegistry() {
		
		
		return "/admin/registry";
	}

}
