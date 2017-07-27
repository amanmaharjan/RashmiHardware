<?php
 require_once('dbConnect.php');
 
if($_SERVER['REQUEST_METHOD']=='POST')
 {
	 $email=$_POST['email'];
	  //open connection to mysql db
   // $connection = mysqli_connect("hostname","username","password","db_employee") or die("Error " . mysqli_error($connection));
 $connection= mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die('unable to connect to db');
    //fetch table rows from mysql db
    $sql = "SELECT * FROM jobseekereducation WHERE email='$email'";
    $result = mysqli_query($connection, $sql) or die("Error in Selecting " . mysqli_error($connection));
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
	echo json_encode(array('Data' => $emparray));

    //close the db connection
    mysqli_close($connection);
 }
 
 ?>