package spring.project.shopping.topdto;

public class TopDTO {
	private int productId;
	private String productName;
	private int stock;
	// private byte[] imgFile;
	private String imgName;
	private String pdescribe;
	private String price;

	public TopDTO() {
		// TODO Auto-generated constructor stub
	}

	public TopDTO(String productName, int stock, String imgName, String pdescribe, String price) {
		super();
		this.productName = productName;
		this.stock = stock;
		this.imgName = imgName;
		this.pdescribe = pdescribe;
		this.price = price;
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

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getPdescribe() {
		return pdescribe;
	}

	public void setPdescribe(String pdescribe) {
		this.pdescribe = pdescribe;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
