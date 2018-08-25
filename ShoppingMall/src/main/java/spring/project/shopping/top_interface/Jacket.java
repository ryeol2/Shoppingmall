package spring.project.shopping.top_interface;

import java.util.List;

import spring.project.shopping.paging.PageSet;
import spring.project.shopping.topdto.TopDTO;

public interface Jacket {
	List<TopDTO> itemList(PageSet criteria);
	int itemCount();
	void registryJacket(TopDTO jacketDto);
	TopDTO detailJacket(int productId);
	void purchaseJacket(TopDTO jacketDto);
	void modifyJacket(TopDTO jacketDto);
	void deleteJacket(int productId);

}
