package spring.project.shopping;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.project.shopping.paging.PageMaker;
import spring.project.shopping.paging.PageSet;
import spring.project.shopping.top_service.JacketService;
import spring.project.shopping.top_service.OuterService;
import spring.project.shopping.topdto.TopDTO;

@Controller
public class MainController {
	@Autowired
	private OuterService outerService;
	@Autowired
	private JacketService jacketService;
	
	@Resource(name="uploadPath") // 표준 java api임 bean id를 name에 적어준다.
	private String path;
	
	private PageMaker pageMaker = new PageMaker();
	private Checking checking = new Checking();
	private int page; // 인스턴스 변수
	@RequestMapping("menu")
	public String sMenu() {
	
		return "menu";
	}

	@RequestMapping("main") // url에서 들어오는 페이지명
	public String sMain() {
		checking.setLoginCheck(true); //로그인 체크
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
	
	@RequestMapping(value="getPrevPage", method=RequestMethod.GET)
	public @ResponseBody int getPrev(@RequestParam("category")String category, PageSet pageSet) {
		
		System.out.println(category+"// 현재페이지 : "+page);
//		if(category.equals("outers")) {
//			page = pageMaker.getStartPage()-1;
//			//cmd = "Outers"+pageMaker.makeQuery(pageMaker.getpageSet().getPage()-1); //현재 페이지에서 -1
//		}else if(category.equals("jackets")) {
//			page = pageMaker.getpageSet().getPage()-1;
//		}
		
	
		System.out.println("이전페이지 : "+page);
		return pageMaker.getStartPage()-1;
	}
//	
	@RequestMapping(value="getNextPage", method=RequestMethod.GET)
	public @ResponseBody int getNext(@RequestParam("category")String category) {
//		System.out.println(category);
//		String url="";
//		if(category.equals("outers")) {
//			System.out.println(pageMaker.getEndPage());
//			url = "Outers"+pageMaker.makeQuery(pageMaker.getEndPage()+1);
//		}else if(category.equals("jackets")) {
//			url = "Jackets"+pageMaker.makeQuery(pageMaker.getEndPage()+1);
//		}
		return pageMaker.getEndPage()+1 ;
	}
//	
	@RequestMapping(value="getPageSite", method=RequestMethod.GET)
	public @ResponseBody List<TopDTO> getPageSite(@RequestParam("category")String category, @RequestParam("page") String page,
			PageSet pageSet) {
		List<TopDTO> list = null;
		System.out.println(category+"//"+page);
		//String url="";
		if(category.equals("outers")) {
			this.page = Integer.parseInt(page);
			list = outerService.itemList(pageSet);
		//url = "Outers"+pageMaker.makeQuery(Integer.parseInt(page));
		}else if(category.equals("jackets")) {
			this.page = Integer.parseInt(page);
			list = jacketService.itemList(pageSet);
			//url="Jackets"+pageMaker.makeQuery(Integer.parseInt(page));
		}
		
		return list;
	}
	
	
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
