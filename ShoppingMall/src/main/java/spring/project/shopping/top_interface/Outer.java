package spring.project.shopping.top_interface;

import java.util.List;
import java.util.Map;

import spring.project.shopping.paging.Criteria;
import spring.project.shopping.topdto.TopDTO;

public interface Outer {
	List<TopDTO> itemList(Criteria criteria);
	int itemCount();
	void registryOuter(TopDTO outerDto);
	TopDTO detailOuter(int productId);
	void purchaseOuter(TopDTO outerDto);
	void modifyOuter(TopDTO outerDto);
	void deleteOuter(int productId);

}
