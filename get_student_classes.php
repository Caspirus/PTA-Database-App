<?php
require "init.php";
$student_name = $_POST["student_name"];

$sql_query = "select All_Classes from Students where Name = '$student_name';";
$result = mysqli_query ($connection, $sql_query);

while ($row = mysqli_fetch_assoc ($result))
{
echo $row["All_Classes"];
}
?>
