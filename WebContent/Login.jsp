<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
<div class="container-fluid">
        <div class="panel panel-success">
            <div class="panel-heading" align="center">
             <h4><b><font style="color: #1DA1F2" style="font-family: fantasy;"size="20px">Implementation of Twitter API</font> </b></h4>
            <br>
            <img src="https://b-i.forbesimg.com/thumbnails/blog_1427/pt_1427_14356_o.jpg?t=1380936320"/>
            </div>
              <div class="panel-body"align="center">
                  
                <div class="container " style="margin-top: 10%; margin-bottom: 10%;">
    
                    <div class="panel panel-success" style="max-width: 35%;" align="left">
                        
                        <div class="panel-heading form-group">
                            <b><font color="white">
                                </font> </b>
                        </div>
                    
                        <div class="panel-body" >
<form action="updateTwitter.do" method="post" >
<div class=”form-group”>
<label style="color: #1DA1F2">UPDATE STATUS</label>
<input type="text" name="updateField"/>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">UPDATE STATUS</font></b></button>
</div>
</form>
<br>
<br>
<form action="followUser.do" method="post">
<div class=”form-group”>
<label style="color: #1DA1F2">FOLLOW USER</label>
<input type="text" name="followUser"/>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">FOLLOW USER</font></b></button>
</div>
</form>
<br>
<br>
<form action="unfollowUser.do" method="post">
<div class=”form-group”>
<label style="color: #1DA1F2">UNFOLLOW USER</label>
<input type="text" name="unfollowUser"/>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">UNFOLLOW USER</font></b></button>
</div>
</form>
<br>
<br>
<form action="getUserTimeline.do" method="post">
<div class=”form-group”>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">GET USER TIMELINE</font></b></button>
</div>
</form>
<br>
<br>
<form action="getMentionTimeline.do" method="post">
<div class=”form-group”>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">GET MENTION TIMELINE</font></b></button>
</div>
</form>
<br>
<br>
<form action="getFavorites.do" method="post">
<div class=”form-group”>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">GET FAVORITES</font></b></button>
</div>
</form>
<br>
<br>
<form action="getFriendship.do" method="post">
<div class=”form-group”>
<label style="color: #1DA1F2">CHECK FRIENDSHIP</label><br><label><font style="color: #1DA1F2">Enter user name</font></label>
<input type="text" name="friendship"/>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">CHECK FRIENDSHIP</font></b></button>
</div>
</form>
<br>
<br>
<form action="sendDirectMessage.do" method="post">
<div class=”form-group”>
<label style="color: #1DA1F2">SEND DIRECT MESSAGE</label><br>
<label style="color: #1DA1F2"><font style="color: #1DA1F2">Enter Username to send direct message</font></label>
<input type="text" name="userName"/><br>
<label style="color: #1DA1F2"><font style="color: #1DA1F2">Enter message to be send</font></label>
<input type="text" name="message"/>
 <button type="submit" style="width: 100%; font-size:1.1em;" class="btn btn-large btn btn-success btn-lg btn-block" ><b><font style="color: #1DA1F2">Send Message</font></b></button>
</div>
</form>

   </div>
                    </div>
                    
                </div>
                
            </div>
</div></div>
</body>
</html>