<?php
require "init.php";
$table_name;
$int_record;

$sql_query = "insert into '$table_name' values (''$int_record'');";

mysqli_query ($connection, $sql_query);
?>
