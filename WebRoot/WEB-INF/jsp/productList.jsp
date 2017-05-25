<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	
	<%@ include file="menu.jsp" %>
	
</div>	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<c:forEach items="${csList}" var="cs">
						<dl>
							<dt>
								<a href="${ pageContext.request.contextPath }/user/findByCid.do?cid=${cs.cid}&page=1">${cs.cname}</a>
							</dt>
									<c:forEach items="${cs.categorySeconds }" var="cc">
									<dd>
										<a href="${ pageContext.request.contextPath }/user/findByCsid.do?csid=${cc.csid}&page=1">${cc.csname }</a>
									</dd>
									</c:forEach>
						</dl>
					</c:forEach>
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">
					
				<div id="result" class="result table clearfix">
						<ul>
							<c:forEach items="${pageBean.list }" var="p">
								<li>
										<a href="${ pageContext.request.contextPath }/user/findProductByPid.do?pid=${p.pid}">
											<img src="${pageContext.request.contextPath}/${p.image}" width="170" height="170"  style="display: inline-block;">
											   
											<span style='color:green'>
											 ${p.pname}
											</span>
											 
											<span class="price">
												商城价： ￥${p.shop_price}
											</span>
											 
										</a>
								</li>
							</c:forEach>
								
						</ul>
				</div>
	<div class="pagination">
			<span>第 ${pageBean.page }/${pageBean.totalPage }页</span>
			<c:if test="${pageBean.list!=null }">
				<c:if test="${pageBean.page !=1 }">
					<c:choose>
						<c:when test="${pageBean.cid !=0}">
							<a class="firstPage" href="${ pageContext.request.contextPath }/user/findByCid.do?cid=${pageBean.cid }&page=1">&nbsp;</a>
							<a class="previousPage" href="${ pageContext.request.contextPath }/user/findByCid.do?cid=${pageBean.cid }&page=${pageBean.page-1 }">&nbsp;</a>
						</c:when>
						<c:otherwise>
							<a class="firstPage" href="${ pageContext.request.contextPath }/user/findByCsid.do?csid=${pageBean.csid }&page=1">&nbsp;</a>
							<a class="previousPage" href="${ pageContext.request.contextPath }/user/findByCsid.do?csid=${pageBean.csid }&page=${pageBean.page-1 }">&nbsp;</a>
						</c:otherwise>
					</c:choose>
					
				</c:if>
				<c:forEach  var="i" begin="1" end="${pageBean.totalPage }">
					<c:choose>
						<c:when test="${pageBean.cid !=0}">
							<c:choose>
								<c:when test="${pageBean.page !=i}">
									<a href="${ pageContext.request.contextPath }/user/findByCid.do?cid=${pageBean.cid }&page=${i}">${i}</a>
								</c:when>
								<c:otherwise>
								<span class="currentPage">${i}</span>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${pageBean.page !=i}">
									<a href="${ pageContext.request.contextPath }/user/findByCsid.do?csid=${pageBean.csid }&page=${i}">${i}</a>
								</c:when>
								<c:otherwise>
								<span class="currentPage">${i}</span>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					
					
				</c:forEach>
				<c:if test="${pageBean.page !=pageBean.totalPage }">
					<c:choose>
						<c:when test="${pageBean.cid !=0}">
							<a class="nextPage" href="${ pageContext.request.contextPath }/user/findByCid.do?cid=${pageBean.cid }&page=${pageBean.page+1}">&nbsp;</a>
							<a class="lastPage" href="${ pageContext.request.contextPath }/user/findByCid.do?cid=${pageBean.cid }&page=${pageBean.totalPage}">&nbsp;</a>
						</c:when>
						<c:otherwise>
							<a class="nextPage" href="${ pageContext.request.contextPath }/user/findByCsid.do?csid=${pageBean.csid }&page=${pageBean.page+1}">&nbsp;</a>
							<a class="lastPage" href="${ pageContext.request.contextPath }/user/findByCsid.do?csid=${pageBean.csid }&page=${pageBean.totalPage}">&nbsp;</a>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:if>
			
	</div>
			</form>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >官网</a>
						|
					</li>
					<li>
						<a >论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>