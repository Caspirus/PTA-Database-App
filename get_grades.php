<?php
require "init.php";
$table_name = $_POST["table_name"];
$col_name = $_POST["col_name"];
$student_name = $_POST["student_name"];

$col_query = "show columns from $table_name;";
$sql_query = "select $col_name from $table_name where Name = '$student_name';";
$result = mysqli_query ($connection, $sql_query);
$col_result = mysqli_query ($connection, $col_query);

while($row = mysqli_fetch_assoc($result))
{
while($col = mysqli_fetch_array($col_result))
{
echo $row[$col['Field']]." ";
}
}
?>
