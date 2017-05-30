<?php
require "init.php";
$table_name = $_POST["table_name"];
$col_name = $_POST["col_name"];

$sql_query = "alter table $table_name drop column $col_name;";

mysqli_query ($connection, $sql_query);
?>
