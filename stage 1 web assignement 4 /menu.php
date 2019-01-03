<?php
session_start();//starts the session
if (isset($_SESSION['loggedin'])){//adding seasion to is if the loogedin is true and if it is the session starts 
echo <<<_END
    
    <head>
	<link rel="stylesheet" type="text/css" href="Main.css">
</head>


<body>
 <div id="logout">
	Congrates a3 you have loged in!<br><br><a href="logout.php" id="loginbutton">Logout</a>
	</div>

   <h1>Menu</h1>

      
<a href="task1.php"><button type="button">Task 1</button></a><br><br>
<a href="task2.php"><button type="button">Task 2</button></a><br><br>
<a href="task3.php"><button type="button">Task 3</button></a>


 </body>
_END;
} 
else {
	header("Location: loginform.html");//loads the html page 
}    
?>

    


