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
	
	@RequestMapping("cartList")
	public String cartPage(Model model, HttpServletRequest request) {
		userId = request.getParameter("userid");
		List<CartDTO> cartList =  cartService.cartList(userId);
		model.addAttribute("cartList", cartList );
		System.out.println(userId);
		System.out.println(cartList.size());
		return "cart/cartList";
	}
	
	@RequestMapping(value="cart", method=RequestMethod.POST)
	public String insertCart(HttpServletRequest request,@RequestParam("category")String category,@RequestParam("productName")String pName,
			@RequestParam("item")int productId,@RequestParam("cartStock")int stock, @RequestParam("price") String price) throws IOException {
		userId = request.getParameter("userid");
	
		CartDTO cartDto = new CartDTO(userId, category, productId, pName, stock, price);
		cartService.insertCart(cartDto);
		System.out.println("īƮdb�� ��ϿϷ�"+userId);
		
		return "redirect:/detail?category="+category+"&item="+productId;
	}
}
