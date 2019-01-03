<?php
session_start();
if (isset($_SESSION['loggedin'])){//adding seasion to is if the loogedin is true and if it is the session starts 
echo <<<_END
    
    <head>
	<link rel="stylesheet" type="text/css" href="Main.css">
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
   $sql = "SELECT * FROM fixture WHERE homeTeam = '$_GET[team]' OR awayTeam = '$_GET[team]'";

	
   $query = $dbhandle->prepare($sql);

   if ( $query->execute() === FALSE ) {
      die('Error Running Query: ' . implode($query->errorInfo(),' ')); 
   }
		
   // Put the results into a nice big associative array
   $results = $query->fetchAll();
	
   // Printing out the details of each club
?>
   <h1>Task 4</h1>

<div id="homelink">
   <a href="task3.php"><button type="button">Back</button></a>
   </div>
   <br>   
   	  <table>
      <tr>
         <th>Home Team</th><th>Away Team</th><th>Date</th><th>Home Team Score</th><th>Away Team Score</th>
      </tr>
      


<?php		
   foreach ($results as $row) {
             echo "<tr><td>".$row['homeTeam']."</td><td>".$row['awayTeam']."</td><td>".$row['onDate']."</td><td>".$row['homeTeamScore']."</td><td>".$row['awayTeamScore']."</td></tr>";// echoing table data in row and to the right fomate,location
     }
echo <<<_END
   </table>   
</body>
_END;
} 
else {
	header("Location: loginform.html");//loads the html page 
}
?>
