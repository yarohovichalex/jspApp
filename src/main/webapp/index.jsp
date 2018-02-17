<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>first page</title>
</head>
<body>
	<header>
    	<h1>Welcome to our library</h1>
    	<h3>login to get the necessary access rights</h3>
    	<div class="subscribe">
	    	<form action="SimpleServlet" method="post">
	    		<input type = "hidden" name="action"  value = "action">
	    	    <input type="text" name="login" placeholder="enter your login" required>
	    	    <input type="password" name="password" placeholder="enter password" required>
	     	    <input type="submit" value="check in">
	   		 </form>
       
    </div>
        <p>*You can not use without registering.</p>

</header>
    
<section>
    <article>
       
    </article>
</section>
</body>
</html>