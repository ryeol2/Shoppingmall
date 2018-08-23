package spring.project.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.project.shopping.top_service.OuterService;
import spring.project.shopping.topdto.TopDTO;

@Controller
public class PurchaseController {
	@Resource(name = "uploadPath")
	private String path;
	@Autowired
	private OuterService outerSerivce;

	private String category;
	private String url;
	private int outerGroup;

	@RequestMapping(value = "purchase", method = RequestMethod.GET)
	public String item_puchase(HttpServletRequest request, @RequestParam("item") int outerGroup, Model model,
			@RequestParam("stockCount") int stock) {

		this.outerGroup = outerGroup;
		category = request.getParameter("shopping_category");
		model.addAttribute("userinfo", request.getSession().getAttribute("logined"));
		model.addAttribute("path", path);
		model.addAttribute("stock", stock);

		if (category.equals("top_outer")) {
			TopDTO outerinfo = outerSerivce.detailOuter(outerGroup);
			model.addAttribute("item_info", outerinfo);
			url = "/purchase/purchaseForm";
		} else if (category.equals("top_jacket")) {

			url = "/purchase/purchaseForm";
		} else if (category.equals("top_kniteWear")) {

			url = "/purchase/purchaseForm";
		} else if (category.equals("top_shirt")) {

			url = "/purchase/purchaseForm";
		} else if (category.equals("bottom_jean")) {

			url = "/purchase/purchaseForm";
		} else if (category.equals("bottom_trouser")) {

			url = "/purchase/purchaseForm";
		} else if (category.equals("acc")) {

			url = "/purchase/purchaseForm";
		} else if (category.equals("sale")) {

			url = "/purchase/purchaseForm";
		}

		return url;
	}

	@RequestMapping(value = "purchased", method = RequestMethod.GET)
	public String purchased(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("stockCount") int stockCount) throws IOException {
		TopDTO outerDto = new TopDTO();
		if(request.getSession().getAttribute("logined") !=null) {

		if (category.equals("top_outer")) {
			outerDto.setStock(stockCount);
			outerDto.setProductId(outerGroup);
			System.out.println(stockCount + "//" + outerGroup);
			outerSerivce.purchaseOuter(outerDto);

			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('구매가 완료하였습니다.');</script>");
			writer.flush();
			url = "main";
		}
		}else {
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('로그인을 먼저하세요.');</script>");
			writer.flush();
			url = "/Login/loginPage";
		}

		return url;
	}
}
