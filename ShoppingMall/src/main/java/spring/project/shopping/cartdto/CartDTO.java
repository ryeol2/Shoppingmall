package spring.project.shopping.cartdto;

public class CartDTO {
	private int cartId;
	private String userId;
	private String category;
	private int productId;
	private String productName;
	private int stock;
	private String price;

	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(String userId, String category, int productId, String productName, int stock, String price) {
		super();
		this.userId = userId;
		this.category = category;
		this.productId = productId;
		this.productName = productName;
		this.stock = stock;
		this.price = price;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
