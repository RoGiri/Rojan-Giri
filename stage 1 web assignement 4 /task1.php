<?php
session_start();
if (isset($_SESSION['loggedin'])){//adding seasion to is if the loogedin is true and if it is the session starts 
echo <<<_END
    
    <head>
	<link rel="stylesheet" type="text/css" href="main.css">
</head>


<body>
 <div id="logout">
	Congrates a3 you have loged in!<br><br><a href="logout.php" id="loginbutton">Logout</a>
	</div>

_END;
    
    
   // Connect to database, and complain if it fails
   try {
      $dbhandle = new PDO('mysql:host=dragon.kent.ac.uk; dbname=co323',
                          'co323', 'pa33word');
   } 
   catch (PDOException $e) {
      // The PDO constructor throws an exception if it fails
      die('Error Connecting to Database: ' . $e->getMessage());
   }

   // Run the SQL query, and print error message if it fails.
   $sql = "SELECT * FROM member WHERE clubID ='C02' ORDER BY  member.gender,member.surname";

	
   $query = $dbhandle->prepare($sql);

   if ( $query->execute() === FALSE ) {
      die('Error Running Query: ' . implode($query->errorInfo(),' ')); 
   }
		
   // Put the results into a nice big associative array
   $results = $query->fetchAll();
	
   // Printing out the details of each club
?>


   <h1>Task 1</h1>
<div id="home">
   <a href="menu.php"><button type="button">Main Menu</button></a>
    </div>
   <br>   


     <table>
      <tr>
         <th>Club ID</th>
          <th>Forename</th>
          <th>Surname</th>
          <th>DOB</th>
          <th>Gender</th>
      </tr>      
         
<?php		
   foreach ($results as $row) {
          echo "<tr><td>".$row['clubID']."</td><td>".$row['forename']."</td><td>".$row['surname']."</td><td>".$row['dob']."</td><td>".$row['gender']."</td></tr>";// echoing table data in row and to the right fomate,location
   }
    echo <<<_END
   </table>   
</body>
_END;
} 
else {
	header("Location: loginform.html");
}
?>	


