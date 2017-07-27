<?php
 require_once('dbConnect.php');

 
 if($_SERVER['REQUEST_METHOD']=='POST')
 {
	  $id = $_POST['id'];
	 $Category = $_POST['Category'];
	 $Size = $_POST['Size'];
	 $ActualPrice = $_POST['ActualPrice'];  
	$SellingPrice = $_POST['SellingPrice'];
		
	$conn = mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die('unable to connect to db');
	
	 $stmt = $conn->prepare("UPDATE tbl_nails SET  Category=?,Size=?,ActualPrice=?,SellingPrice=? WHERE id=?");
		$stmt->bind_param("sssss", $Category,$Size,$ActualPrice,$SellingPrice,$id);		    
        $result = $stmt->execute();
		  $stmt->close();
		if ($result) {
				 echo "Successfully Uploaded";
	 }
	 else{
		  echo "unSuccessfully Uploaded";
		 }
	 	 
 }
 
 else
 {
 	echo "Error"."errero aayo";
 }
 
 ?>