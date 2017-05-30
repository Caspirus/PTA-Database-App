<?php
require "init.php";
$table_name = $_POST["table_name"];
$col_name = $_POST["col_name"];

$sql_query = "alter table $table_name add $col_name varchar(25);";

mysqli_query ($connection, $sql_query);
?>
