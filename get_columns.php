<?php
require "init.php";
$table_name = $_POST["table_name"];

$sql_query = "show columns from $table_name;";

$result = mysqli_query($connection, $sql_query);
while($col = mysqli_fetch_array($result))
{
echo $col['Field']." ";
}
?>
