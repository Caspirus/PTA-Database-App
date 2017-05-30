<?php
require "init.php";
$table_name = $_POST["table_name"];
$col_name = $_POST["col_name"];
$record = $_POST["record"];

$sql_query = "insert into $table_name ($col_name) values ('$record');";

mysqli_query ($connection, $sql_query);
?>
