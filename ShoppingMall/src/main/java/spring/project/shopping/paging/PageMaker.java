package spring.project.shopping.paging;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; // 총 게시글 수.
	private int startPage; // 시작페이지
	private int endPage; // 마지막 페이지
	private boolean prev; // 이전
	private boolean next; // 다음

	private int displayPageNum = 10; // 페이지수 1~10페이지까지

	private Criteria criteria = new Criteria();

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setTotalCount(int totalCount) { // 전체 게시글수
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {
		int endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);
		int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum())); // 전체 게시글수 / 출력되는 게시글수
																								// ->보여줄 페이지

		if (endPage > tempEndPage) { // getendPage 즉 1~10페이지 표시되는데 temp에서 얻은 페이지 표시가 적을경우 적은걸 end페이지로 해줌.
			setEndPage(tempEndPage);
		} else {
			setEndPage(endPage);
		}
		
		getEndPage();
		getStartPage();

		isPrev();
		isNext();

	}

	public int getStartPage() {

		if(getEndPage()<displayPageNum) {
			startPage = 1;
		}else {
		startPage = (getEndPage() - displayPageNum) + 1; // 시작페이지를 1 11 21 31 시작하는 페이지
		}
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		prev = getCriteria().getPage() == 1 ? false : true;
		return prev;
	}

	public boolean isNext() {
		next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
		return next;
	}

	public String makeQuery(int page) {
		UriComponents uriCom = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", criteria.getPerPageNum()).build();
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
