package spring.project.shopping.cart_service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.project.shopping.cart_interface.Cart;
import spring.project.shopping.cartdto.CartDTO;

@Repository
public class CartService implements Cart{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertCart(CartDTO cartDto) {
		// TODO Auto-generated method stub
		sqlSession.insert("spring.project.shopping.cartMapper.insertCart", cartDto);
		
	}
	
	@Override
	public List<CartDTO> cartList(String userId) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("spring.project.shopping.cartMapper.cartList", userId);
	}

}
