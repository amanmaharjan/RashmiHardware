<?php

     if(isset($_POST['searchQuery']))
     {
     	  require_once('dbConnect.php');
	  $search_query=$_POST['searchQuery'];
   	 $connection= mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die('unable to connect to db');
    //fetch table rows from mysql db
    $sql = "SELECT * from tbl_nails where ((Category) LIKE('%$search_query%') OR (Size) LIKE('%$search_query%') OR (Quantity) LIKE('%$search_query%') OR (SellingPrice) LIKE('%$search_query%') )";
    $result = mysqli_query($connection, $sql) or die("Error in Selecting " . mysqli_error($connection));
	
	while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
	echo json_encode(array('Data' => $emparray));

    //close the db connection
    mysqli_close($connection);
		
    
	 
}
 else
 {
 	echo "Error"."errero aayo";
 }
 
		  
?>