<?php
require "init.php";
$table_name = $_POST["table_name"];

$sql_query = "select Name from $table_name;";

$result = mysqli_query($connection, $sql_query);
while($row = mysqli_fetch_assoc($result))
{
echo $row["Name"].",";
}

?>
