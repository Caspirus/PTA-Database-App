<?php
require "init.php";
$user_name = $_POST["user_name"];
$user_password = $_POST["user_password"];

$sql_query = "select Name from Login_Information where User_Name like '$user_name' and Password like '$user_password';";

$result = mysqli_query($connection, $sql_query);

if(mysqli_num_rows($result) > 0)
{
$row = mysqli_fetch_assoc($result);
$name = $row["Name"];
echo $name;
}
else
{
echo "Login Failed! Try Again.";
}
?>
