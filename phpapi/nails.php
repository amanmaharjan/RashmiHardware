<?php
 require_once('dbConnect.php');

 
 if($_SERVER['REQUEST_METHOD']=='POST')
 {
	  $Category = $_POST['Category'];
	 $Size = $_POST['Size'];
	 $Quantity=$_POST['Quantity'];
	 $ActualPrice = $_POST['ActualPrice'];  
	$SellingPrice = $_POST['SellingPrice'];
		
		
	$conn = mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die('unable to connect to db');
	 $stmt = $conn->prepare("INSERT INTO tbl_nails (Category,Size,Quantity,ActualPrice,SellingPrice) VALUES('$Category','$Size','$Quantity','$ActualPrice','$SellingPrice')");
		    
        $result = $stmt->execute();
		  $stmt->close();
		if ($result) {
				 echo "Successfully Uploaded";
	 }
	 else{
		  echo "unSuccessfully Uploaded";
		 }
	 	 
 }
 else if($_SERVER['REQUEST_METHOD']=='GET')
 {
	  //open connection to mysql db
   // $connection = mysqli_connect("hostname","username","password","db_employee") or die("Error " . mysqli_error($connection));
 $connection= mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die('unable to connect to db');
    //fetch table rows from mysql db
    $sql = "SELECT * FROM tbl_nails";
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