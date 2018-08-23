package spring.project.shopping.paging;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; //�� �Խñ� ��.
	private int startPage; // ����������
	private int endPage; // ������ ������
	private boolean prev; // ����
	private boolean next; // ����

	private int displayPageNum = 10; // �������� 1~10����������

	private Criteria criteria;

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public void setTotalCount(int totalCount) { //��ü �Խñۼ�
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {

		getEndPage();
		getStartPage();

		int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum())); // ��ü �Խñۼ� / �� �������� ����� �Խñ� ��

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}

	}

	public int getStartPage() {
		if(endPage<displayPageNum) {
			return startPage =1;
		}else {
		return startPage = (endPage - displayPageNum) +1;
		}
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev = startPage == 1 ? false : true;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	public String makeQuery(int page) {
		UriComponents uriCom = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("perPageNum", criteria.getPerPageNum()).build();
		return uriCom.toUriString();
	}
	
//	public String makeSearch(int page) {
//		UriComponents uricom = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("perPageNum", criteria.getPerPageNum()).queryParam("searchType", ((SearchCriteria) criteria).getSearchType())
//				.queryParam("keyword", encoding(((SearchCriteria) criteria).getKeyword())).build();
//	return uricom.toUriString();	
//	}
	
//	public String encoding(String keyword) {
//		if(keyword == null || keyword.trim().length() == 0) {
//			return "";
//		}
//		try {
//			return URLEncoder.encode(keyword, "utf-8");
//		} catch (Exception e) {
//			// TODO: handle exception
//			return " ";
//		}
//		
//	}

}
