<!--
Develop a PHP script that takes a person's age as input and categorizes
them into different age groups (e.g., child, teenager, adult, senior)
-->

<!DOCTYPE html>
<html>
<body>
    <center>
    <h1>Age Checker</h1>
    <form action="age.php" method="post">
        <h2>Enter your age: <input type="number" name="age"></h2><br>
        <input type="submit" value="submit">
    </form>
      
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {   
    $age = $_POST['age'];
    if($age<12)
        echo "<h2>You are still a Kid, my dear!</h2>";
    elseif($age<20)
        echo "<h2>Hey Teen... how you doing?!</h2>";
    elseif($age<56)
        echo "<h2>Go as long as you can! <br>Being a adult is not easy, but you must be proud...</h2>";
    else
         echo "<h2>Hello senior citizen! <br>give me a hug!</h2>";
}
?>
</center>
</body>
</html>
