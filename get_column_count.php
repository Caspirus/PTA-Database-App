<?php
require "init.php";
$table_name = $_POST["table_name"];

$sql_query = "select count(*) from information_schema.columns where table_name = '$table_name';";
$result = mysqli_query ($connection, $sql_query);

while($row = mysqli_fetch_assoc($result))
{
echo $row["count(*)"];
}
?>
