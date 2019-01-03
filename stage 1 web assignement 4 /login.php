<?php
	session_start();
	
	$secret_username = "a3";// specifing the username for login 
	$secret_password = "testing";//specifing the password for login 
	
	if (($_POST['username'] == $secret_username ) &&
		($_POST['password'] == $secret_password)) //if statment to is if the username and password match to the userinput 
	{
		$_SESSION["loggedin"] = "true";
        header("Location: menu.php");
    }
	else {
        
      echo "<script language=\"JavaScript\">\n";
     echo "alert('Username or Password was incorrect!');\n";//printing out the erro message if the login detail are wrong
     echo "window.location='loginform.html'";//lodding the form page again if the user or password is wrong
     echo "</script>";      
        
    }

?>

