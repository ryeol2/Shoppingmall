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

	private int displayPageNum = 5; // �������� 1~5����������

	private Criteria criteria = new Criteria();

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	public Criteria getCriteria() {
		return criteria;
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
		
		isPrev();
		isNext();

	}

	public int getStartPage() {
		if(getEndPage()<displayPageNum) {
			startPage =1;
		}else {
		 startPage = (getEndPage() - displayPageNum) +1;
		}
		return startPage;
	}

	

	public int getEndPage() {
	
		endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);
		
		return endPage;
	}

	

	public boolean isPrev() {
		prev = startPage == 1 ? false : true;
		return prev;
	}

	

	public boolean isNext() {
		next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
		return next;
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
