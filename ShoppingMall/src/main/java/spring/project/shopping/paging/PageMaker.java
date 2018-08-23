package spring.project.shopping.paging;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; //총 게시글 수.
	private int startPage; // 시작페이지
	private int endPage; // 마지막 페이지
	private boolean prev; // 이전
	private boolean next; // 다음

	private int displayPageNum = 10; // 페이지수 1~10페이지까지

	private Criteria criteria;

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public void setTotalCount(int totalCount) { //전체 게시글수
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {

		getEndPage();
		getStartPage();

		int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum())); // 전체 게시글수 / 한 페이지에 출력할 게시글 수

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
