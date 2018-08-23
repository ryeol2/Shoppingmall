package spring.project.shopping.paging;

public class Criteria {
	private int page; //현재 페이지 번호
	private int perPageNum; //페이지당 출력되는 게시글 갯수
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 12;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page =1;
			
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100) {
			this.perPageNum = 12;
			
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
	

}
