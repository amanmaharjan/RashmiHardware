<?php
 require_once('dbConnect.php');

 
 if($_SERVER['REQUEST_METHOD']=='POST')
 {
	  $id = $_POST['id'];
	 $conn = mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die('unable to connect to db');
	// $stmt = $conn->prepare("UPDATE  jobseekerexperience SET(CompanyName=?,JobTitle=?,DurationOfWork=?,FuctionArea=?) WHERE id=? //VALUES('$CompanyName','$JobTitle','$DurationOfWork','$FuctionArea','$id')");
	
	 $stmt = $conn->prepare("DELETE FROM jobseekereducation WHERE id='$id'");
		$result = $stmt->execute();
		  $stmt->close();
		if ($result) {
			$response['message'] = "Successfully Deleted";
				 echo json_encode($response);
	 				}
		 else{
			 $response['message'] = "Unsuccess Deletion";
				 echo json_encode($response);
			 }
			 
 }
 else
 {
 	echo "Error"."errero aayo";
 }
 
 ?>