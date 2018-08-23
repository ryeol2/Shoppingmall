package spring.project.shopping.cart_interface;

import java.util.List;

import spring.project.shopping.cartdto.CartDTO;

public interface Cart {
	public void insertCart(CartDTO cartDto);
	public List<CartDTO> cartList(String userId);

}
