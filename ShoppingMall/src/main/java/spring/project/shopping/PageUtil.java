package spring.project.shopping;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
	private static final int countPerpage = 10;
	private static final int unitPage =10;
	
	public static Map<String, Object> setPageinfo(Map<String, Object> reqParam, int defaultCountPage){
		int pageNo = Integer.parseInt(reqParam.get("pageNo").toString());
		int countPerPage = Integer.parseInt(reqParam.get("countPerPage").toString());
		
		countPerPage = countPerPage<100 ? countPerPage : 100;
		int pageStart = ((pageNo -1) * countPerPage) +1;
		int pageLast = pageStart + countPerPage -1;
		
		reqParam.put("countPerPage", countPerPage);
		reqParam.put("pageStart", pageStart); reqParam.put("pageLast", pageLast);
		
		return reqParam;
	}
	
	public static Map<String, Object> getPage(int totalCount, int currentPageNo){
		
		return getPage(totalCount,currentPageNo,10);
	}
	
public static Map<String, Object> getPage(int totalCount, int currentPageNo, int countPerPage){
		
		return getPage(totalCount,currentPageNo,countPerPage,10);
	}

public static Map<String, Object> getPage(int totalCount, int currentPageNo, int countPerPage, int unitPage){
	int currPage = currentPageNo;
	int unitCount = 100;
	
	boolean ispageStart = false;
	
	if(totalCount ==0) {
		countPerPage = unitPage;
	}else if(totalCount< countPerPage) {
		countPerPage = totalCount / unitCount * unitCount;
		if(totalCount % unitCount > 0) {
			countPerPage += unitCount;
		}
	}
	
	int totalPage = getMaxNum(totalCount, countPerPage);
	
	if(totalPage<currPage) {
		currPage = totalPage;
	}
	int currStartCount;
	int currEndCount;
	
	if(currPage != 1) {
		currEndCount = currPage * countPerPage;
		currStartCount = currEndCount - countPerPage;
	}else {
		currEndCount = countPerPage;
		currStartCount = 0;
	}
	if(currEndCount>totalCount) {
		currEndCount = totalCount;
	}
	
	int currStartPage;
	int currEndPage;
	
	if(totalPage <= unitPage) {
		currEndPage = totalPage;
		currStartPage = 1;
	}else {
		currEndPage = (currPage - 1) / unitPage * unitPage + unitPage;
		currStartPage = currEndPage - unitPage +1;
	}
	
	if(currEndPage> totalPage) {
		currEndPage = totalPage;
		
	}
	
	int prePage;
	boolean isPrePage;
	
	if(currStartPage != 1) {
		isPrePage = true;
		prePage = currStartPage -1;
	}else {
		isPrePage = false;
		prePage = 0;
	}
	
	int nextPage;
	boolean isNextPage;
	
	if(currEndPage != totalPage) {
		isNextPage = true;
		nextPage = currEndPage +1;
	}else {
		isNextPage = false;
		nextPage = 0;
	}
	
	Map<String, Object> tmpJson = new HashMap<String, Object>();
	
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
		tmpJson.put("currPage", Integer.valueOf(currPage));
		tmpJson.put("unitPage", Integer.valueOf(unitPage));
		tmpJson.put("prePage", Integer.valueOf(prePage));
		tmpJson.put("isPrePage", Boolean.valueOf(isPrePage));
		tmpJson.put("nextPage", Integer.valueOf(nextPage));
		tmpJson.put("isNextPage", Boolean.valueOf(isNextPage));
		tmpJson.put("currStartPage", Integer.valueOf(currStartPage));
		tmpJson.put("currEndPage", Integer.valueOf(currEndPage));
		
		tmpJson.put("totalCount", Integer.valueOf(totalCount));
		tmpJson.put("unitPage", Integer.valueOf(unitPage));
	}
	return tmpJson;
}

private static int getMaxNum(int allPage, int list_num) {
	if(allPage % list_num ==0) {
		return allPage / list_num;
	}
	return allPage / list_num +1;
}

}
