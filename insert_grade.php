<?php
require "init.php";
$table_name = $_POST["table_name"];
$col_name = $_POST["col_name"];
$record = $_POST["record"];
$student_name = $_POST["student_name"];

$sql_query = "update $table_name set $col_name = '$record' where Name = '$student_name';";

mysqli_query ($connection, $sql_query);
?>
