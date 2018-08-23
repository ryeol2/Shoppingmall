package spring.project.shopping;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.project.shopping.top_service.JacketService;
import spring.project.shopping.top_service.OuterService;
import spring.project.shopping.topdto.TopDTO;

@Controller
public class AdminController {
	@Autowired
	OuterService outerService;
	@Autowired
	JacketService jacketService;
	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "item_registry", method = RequestMethod.POST)
	public String registry_item(MultipartHttpServletRequest request) throws Exception {
		String Select_items = request.getParameter("items");
		String itemName = request.getParameter("itemName");
		int itemStock = Integer.parseInt(request.getParameter("itemStock"));
		String itemDescribe = request.getParameter("itemDescribe");
		String Price = request.getParameter("Price");
		// String path =
		// "C:\\Users\\�����\\Desktop\\Spring\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\images\\";
		UUID uuid = UUID.randomUUID(); // �̹����� �ĺ����ִ�
		String imgName = uuid.toString() + "_" + request.getFile("imgFile").getOriginalFilename();
		File imgDir = new File(uploadPath, imgName);
		FileCopyUtils.copy(request.getFile("imgFile").getBytes(), imgDir);

		if (Select_items.equals("����")) {
			TopDTO outerDto = new TopDTO(itemName, itemStock, imgName, itemDescribe, Price);
			outerService.registryOuter(outerDto);

		} else if (Select_items.equals("��Ʈ")) {

		} else if (Select_items.equals("����")) {
			TopDTO jacketDto = new TopDTO(itemName, itemStock, imgName, itemDescribe, Price);
			jacketService.registryJacket(jacketDto);

		} else if (Select_items.equals("����")) {

		} else if (Select_items.equals("����")) {

		} else if (Select_items.equals("Ʈ�����")) {

		} else if (Select_items.equals("�ݹ���")) {

		} else if (Select_items.equals("�Ǽ��縮")) {

		}

		return "main";
	}
	
	@RequestMapping("modify")
	public String modifyItem(@RequestParam("itemNumber")int Group, Model model) {
		TopDTO outerDto = outerService.detailOuter(Group);
		model.addAttribute("modify_item", outerDto);
		model.addAttribute("path", uploadPath);
		return "admin/modify";
	}
	
	@RequestMapping(value="modified", method=RequestMethod.POST)
	public String modified(HttpServletRequest request) {
		String number = request.getParameter("group");
		System.out.println(number);
		String itemName = request.getParameter("itemName");
		String itemDescribe = request.getParameter("itemDescribe");
		int itemStock = Integer.parseInt(request.getParameter("itemStock"));
		String itemPrice = request.getParameter("itemPrice");
		TopDTO outerDto = new TopDTO();
		outerDto.setProductName(itemName); outerDto.setPdescribe(itemDescribe); 
		outerDto.setStock(itemStock); outerDto.setPrice(itemPrice); outerDto.setProductId(Integer.parseInt(number));
		outerService.modifyOuter(outerDto);
		return"redirect:/detail?item="+number;
	}
	
	@RequestMapping("delete")
	public String deleteItem(@RequestParam("category")String category,@RequestParam("itemNum")int num, HttpServletResponse response) throws IOException {
		if(category.equals("outers")) {
		outerService.deleteOuter(num);
		PrintWriter writer = response.getWriter();
		writer.println("<script> alert('������ �Ϸ�Ǿ����ϴ�.'); </script>");
		writer.flush();
		}else if(category.equals("jackets")) {
			jacketService.deleteJacket(num);
			PrintWriter writer = response.getWriter();
			writer.println("<script> alert('������ �Ϸ�Ǿ����ϴ�.'); </script>");
			writer.flush();
		}
		
		return"main";
	}
}
