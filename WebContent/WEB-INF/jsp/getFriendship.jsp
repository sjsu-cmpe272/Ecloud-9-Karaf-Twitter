<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" rel="stylesheet">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Files in S3</title>
</head>
<body>
<label style="color: #1DA1F2"><b>Get Favorite Tweets</b></label>
<div class="container">
  <div class="table-responsive">          
<form action="downloadFile.do" method="post">
  <table  id="example" class="table table-striped table-bordered" class="wfl" cellspacing="0" width="100%">
      <tbody>
<c:forEach var="twitterFriendshipList" items="${twitterFriendshipList}">
            <tr>
                <td>"@" ${twitterFriendshipList.screenName} following ${twitterFriendshipList.following} : followed by: ${twitterFriendshipList.followedBy}</td>
            </tr>       
        </c:forEach>
</tbody>
</table>
</form>
</div></div>
</body>
</html>