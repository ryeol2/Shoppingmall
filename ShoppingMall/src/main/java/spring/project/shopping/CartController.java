package spring.project.shopping;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.project.shopping.cart_service.CartService;
import spring.project.shopping.cartdto.CartDTO;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;

	private String userId;
	private String url;

	@RequestMapping("cartList")
	public String cartPage(Model model, @RequestParam("userid") String userid) {
		userId = userid;
		List<CartDTO> cartList = cartService.cartList(userId);
		model.addAttribute("cartList", cartList);
		System.out.println(userId);
		System.out.println(cartList.size());
		return "cart/cartList";
	}

	@RequestMapping(value = "cart", method = RequestMethod.POST)
	public String insertCart(@RequestParam("userid") String userid, @RequestParam("category") String category,
			@RequestParam("productName") String pName, @RequestParam("item") int productId,
			@RequestParam("cartStock") int stock, @RequestParam("price") String price,
			@RequestParam("judgeCart") boolean judge) throws IOException {
		userId = userid;

		CartDTO cartDto = new CartDTO(userId, category, productId, pName, stock, price);
		cartService.insertCart(cartDto);
		System.out.println("카트db에 등록완료" + userId + judge);

		if (judge) {
			url = "redirect:/cartList?userid=" + userId;
		} else {
			url = "redirect:/detail?category=" + category + "&item=" + productId;
		}

		return url;
	}
}
