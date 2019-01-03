<?php
	session_start();//starts the session
	session_destroy();//destroys the session
    echo("Goodbye"); //ecco the message
		 
	header("Location: loginform.html");//loads the html page 
?>

