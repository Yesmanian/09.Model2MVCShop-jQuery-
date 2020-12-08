<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    





<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/purchase/updatePurchase?tranNo=0" method="post">

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td>${vo.purchaseProd.prodNo }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<td>${vo.buyer.userId }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
		<c:choose>
			<c:when test="${vo.paymentOption == '1' }">
				현금구매			
			</c:when>		
			<c:otherwise>
				신용구매
			</c:otherwise>
		
		
		</c:choose>
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td>${vo.buyer.userName }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td>${vo.receiverPhone }</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<td>${vo.divyAddr }</td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td>${vo.divyRequest }</td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td>${vo.divyDate }</td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>