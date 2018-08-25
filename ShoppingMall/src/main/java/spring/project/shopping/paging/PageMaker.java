package spring.project.shopping.paging;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount; // �� �Խñ� ��.
	private int startPage; // ����������
	private int endPage; // ������ ������
	private boolean prev; // ����
	private boolean next; // ����

	private int displayPageNum = 10; // �������� 1~10����������

	private PageSet pageSet = new PageSet();

	public void setpageSet(PageSet pageSet) {
		this.pageSet = pageSet;
	}

	public PageSet getpageSet() {
		return pageSet;
	}

	public void setTotalCount(int totalCount) { // ��ü �Խñۼ�
		this.totalCount = totalCount;
		calcData();
	}

	private void calcData() {
		// ->1 ~ n���� ǥ�õ� ������ ����.
		int endPage = (int) (Math.ceil(pageSet.getPage() / (double) displayPageNum) * displayPageNum);
		int tempEndPage = (int) (Math.ceil(totalCount / (double) pageSet.getPerPageNum())); // ��ü �Խñۼ� / ��µǴ� �Խñۼ�
																								

		if (endPage > tempEndPage) { // getendPage �� 1~10������ ǥ�õǴµ� temp���� ���� ������ ǥ�ð� ������� ������ end�������� ����.
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
		startPage = (getEndPage() - displayPageNum) + 1; // ������������ 1 11 21 31 �����ϴ� ������
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
		prev = getpageSet().getPage() == 1 ? false : true;
		return prev;
	}

	public boolean isNext() {
		next = endPage * pageSet.getPerPageNum() >= totalCount ? false : true;
		return next;
	}

	public String makeQuery(int page) {
		if(page<=0) {
			page =1;
		}
		UriComponents uriCom = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", pageSet.getPerPageNum()).build();
		
		return uriCom.toUriString();
	}

//	public String makeSearch(int page) {
//		UriComponents uricom = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("perPageNum", pageSet.getPerPageNum()).queryParam("searchType", ((SearchpageSet) pageSet).getSearchType())
//				.queryParam("keyword", encoding(((SearchpageSet) pageSet).getKeyword())).build();
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
