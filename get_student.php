<?php
require "init.php";
$table_name = $_POST["table_name"];
$student_name = $_POST["student_name"];

$sql_query = "select * from $table_name where Name = '$student_name';";

$result = mysqli_query($connection, $sql_query);
while ($row = mysqli_fetch_assoc($result))
{
echo $row["Name"]." ";
echo $row["Test"];
}

?>
