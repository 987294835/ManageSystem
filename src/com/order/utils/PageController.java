package com.order.utils;

/*需要知道的条件：
1)总记录数	totalRows
2)每一页显示的记录数	pageSize
3)当前页	currPage

计算出来的数据：
总页数 totalPages：
	if(totalRows%pageSize==0){
		totalPages = totalRows/pageSize;
	}else{
		totalPages = totalRows/pageSize+1;
	}
开始行startRow：
	startRow = (currPage-1)*pageSize;
结束行endRow：
	endRow = currPage*pageSize;
上一页prePage：
	prePage = currPage-1;
下一页nextPage：
	nextPage = currPage+1;
是否有上一页：
是否有下一页：*/
public class PageController {

  //总行数
  int totalRowsAmount;
  //每页行数
  int pageSize = 3;
  //总页数
  int totalPages;
  //当前页码
  int currentPage = 1;
  //下一页
  int nextPage;
  //上一页
  int previousPage;
  //是否有下一页
  boolean hasNext;
  //是否有上一页
  boolean hasPrevious;

  //当前页开始行
  int pageStartRow;

  //当前页要显示的行数
  int pageEndRow;
  /**
   * 构造函数。
   * @param totalRows 总行数
   * @param currentPage 当前页码
   */
  
  public PageController(int totalRows,int currentPage) {
    setPageController(totalRows,currentPage);
  }

  public PageController(int totalRows,int currentPage,int pageSize){
      this.pageSize = pageSize;
      this.setPageController(totalRows,currentPage);
  }

  public void setPageController(int totalRows,int currentPage){

    setTotalRowsAmount(totalRows);
    setCurrentPage(currentPage);
  }

  /**
   * 设置总行数和总页数。
   * @param i 总行数。
   */
  private void setTotalRowsAmount(int rows) {

    if(rows <0 ){
      totalRowsAmount =  0;
    }else{
      totalRowsAmount = rows;
    }

    if(totalRowsAmount%pageSize==0){
      totalPages = totalRowsAmount / pageSize;
    }else{
      totalPages = totalRowsAmount / pageSize + 1;
    }
  }

  /**
   * 设置当前页数。
   * @param i
   */
  public void setCurrentPage( int curPage) {

	//计算当前页码
    if(curPage <= 0){
      currentPage = 1;
    }else if(curPage > totalPages){
      currentPage = totalPages;
    }else{
      currentPage = curPage;
    }

    //计算是否有上一页,是否有下一页
    if(currentPage <= 1){
      hasPrevious = false;
    }else{
      hasPrevious = true;
    }

    if(currentPage >= totalPages){
      hasNext = false;
    }else{
      hasNext = true;
    }

    //计算上一页和下一页
    nextPage = currentPage + 1;
    previousPage = currentPage - 1;

    //计算开始行和结束行
    if(currentPage != totalPages){
      pageStartRow = (currentPage-1)*pageSize;
      //记录索引从0开始
      pageEndRow = currentPage*pageSize;
    }else{
      pageStartRow = (currentPage - 1)*pageSize;
      //记录索引从0开始
      pageEndRow = totalRowsAmount - pageStartRow;
    }
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public boolean isHasNext() {
    return hasNext;
  }

  public boolean isHasPrevious() {
    return hasPrevious;
  }

  public int getNextPage() {
    return nextPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public int getPreviousPage() {
    return previousPage;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public int getTotalRowsAmount() {
    return totalRowsAmount;
  }

  public int getPageStartRow() {
    return pageStartRow;
  }

  public int getPageEndRow(){
      return pageEndRow;
  }

  public String description() {
    String description = "Total:" + this.getTotalRowsAmount() +
        " items " + this.getTotalPages() + " pages,Current page:" +
        this.currentPage + " Previous " + this.hasPrevious +
        " Next:" + this.hasNext +
        " start row:" + this.pageStartRow +
        " end row:" + this.pageEndRow;
    return description;
  }
}
