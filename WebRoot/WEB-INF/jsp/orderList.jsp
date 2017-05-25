<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="container header">
		<div class="span5">
			<div class="logo">
				
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障" />
			</div>
		</div>

		<%@ include file="menu.jsp"%>

	</div>

	<div class="container cart">

		<div class="span24">

			<div class="step step1">
				<ul>

					<li class="current"></li>
					<li>我的订单</li>
				</ul>
			</div>


			<table>
				<tbody>
					<c:forEach items="${pageBean.list }" var="p">
					
						<tr>
							<th colspan="5">订单编号:${p.oid }&nbsp;&nbsp;&nbsp;&nbsp;订单金额:<font
								color="red">${p.total }
							</font>
							&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">
								
							</font>
							</th>
						</tr>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
							<c:forEach items="${p.orderItems}" var="o">
							<tr>
								<td width="60"><img
									src="${ pageContext.request.contextPath }/${o.product.image}" />
								</td>
								<td>${o.product.pname }</td>
								<td>${o.product.shop_price }</td>
								<td class="quantity" width="60">${o.count }</td>
								<td width="140"><span class="subtotal">￥${o.subtotal }
								</span></td>
							</tr>
						</c:forEach>
					</c:forEach>
						<tr>
						<th colspan="5">
						<div class="pagination">
							<span>第${pageBean.page}/${pageBean.totalPage }页 </span>
								<c:if test="${pageBean.page!=1 }">
									<a
									href="${ pageContext.request.contextPath }/order/findByUid.do?page=1"
									class="firstPage">&nbsp;</a>
								<a
									href="${ pageContext.request.contextPath }/order/findByUid.do?page=${pageBean.page-1}"
									class="previousPage">&nbsp;</a>
								</c:if>
								
								<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
									<c:choose>
										<c:when test="${pageBean.page!=i }">
											<a
											href="${ pageContext.request.contextPath }/order/findByUid.do?page=${i}">${i }
											</a>
										</c:when>
										<c:otherwise>
											<span class="currentPage">${i }
											</span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							
							
							<c:if test="${pageBean.page!=pageBean.totalPage }">
								<a class="nextPage"
									href="${ pageContext.request.contextPath }/order/findByUid.do?page=${pageBean.page+1}">&nbsp;</a>
								<a class="lastPage"
									href="${ pageContext.request.contextPath }/order/findByUid.do?page=${pageBean.totalPage}">&nbsp;</a>
							</c:if>
							
							</div>
							</th>
					</tr>
					
					
				</tbody>
			</table>


		</div>

	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势"
					title="我们的优势" height="52" width="950">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>SHOP++官网</a> |</li>
				<li><a>SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>