<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVO> memList = (List<MemberVO>)request.getAttribute("memList");

	String msg = session.getAttribute("msg") == null ?
			"" : (String) session.getAttribute("msg");
	session.removeAttribute("msg"); // 꺼내온 속성값 저장하기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 </title>
</head>
<body>

<table border="1">
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>첨부파일ID</th>
	</tr>
	
<%
int memSize = memList.size();
 if(memSize > 0) {
	 for(int i = 0; i < memSize; i++){
%>
	<tr>
		<td><%= memList.get(i).getMemId() %></td>
		<td><a href="detail.do?memId=<%= memList.get(i).getMemId() %>"><%= memList.get(i).getMemName() %></a></td>
		<td><%= memList.get(i).getMemTel() %></td>
		<td><%= memList.get(i).getMemAddr() %></td>
		<td><%= memList.get(i).getAtchFileId() %></td>
	</tr>
	
<%
	 }
 }else{
%>

	<tr>
		<td colspan="5">회원정보가 없습니다.</td>
		<td>홍길동</td>
		<td>1111-1111</td>
		<td>대전</td>
	</tr>

<%
 }
%>
	<tr>
		<td colspan="5"><a href="insert.do">[회원정보 등록]</a></td>
	</tr>
</table>

<%
	if(msg.equals("성공")){
%>
	<script>
		alert("정상적으로 처리되었슴둥")
	</script>

<%
	}
%>

</body>
</html>