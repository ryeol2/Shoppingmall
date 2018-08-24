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

import spring.project.shopping.top_service.JacketService;
import spring.project.shopping.top_service.OuterService;
import spring.project.shopping.topdto.TopDTO;

@Controller
public class PurchaseController {
	@Resource(name = "uploadPath")
	private String path;
	@Autowired
	private OuterService outerSerivce;
	@Autowired
	private JacketService jacketService;

	private String category;
	private String url;
	private int productId;

	@RequestMapping(value = "purchase", method = RequestMethod.GET)
	public String item_puchase(HttpServletRequest request, @RequestParam("category") String category,
			@RequestParam("item") int pid, Model model, @RequestParam("stockCount") int stock) {
this.category = category;
		this.productId = pid;
		model.addAttribute("userinfo", request.getSession().getAttribute("logined"));
		model.addAttribute("path", path);
		model.addAttribute("stock", stock);

		if (category.equals("outers")) {
			TopDTO outerinfo = outerSerivce.detailOuter(pid);
			model.addAttribute("item_info", outerinfo);
			url = "/purchase/purchaseForm";
		} else if (category.equals("jackets")) {
			TopDTO jacketinfo = jacketService.detailJacket(pid);
			model.addAttribute("item_info", jacketinfo);
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
		TopDTO itemDto = new TopDTO();
		if (request.getSession().getAttribute("logined") != null) {

			if (category.equals("outers")) {
				itemDto.setStock(stockCount);
				itemDto.setProductId(productId);
				System.out.println(stockCount + "//" + productId);
				outerSerivce.purchaseOuter(itemDto);

				PrintWriter writer = response.getWriter();
				writer.println("<script> alert('구매가 완료하였습니다.');</script>");
				writer.flush();
				url = "main";
			} else if (category.equals("jackets")) {
				itemDto.setStock(stockCount);
				itemDto.setProductId(productId);
				System.out.println(stockCount + "//" + productId);
				jacketService.purchaseJacket(itemDto);

				PrintWriter writer = response.getWriter();
				writer.println("<script> alert('구매가 완료하였습니다.');</script>");
				writer.flush();
				url = "main";

			}
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('로그인을 먼저하세요.');</script>");
			writer.flush();
			url = "/Login/loginPage";
		}

		return url;
	}
}
