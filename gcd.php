<!--
Write a PHP script to calculate the Greatest Common Divisor (GCD) of
two numbers using loops
-->

<!DOCTYPE html>
<html>
<body>
    <center>
    <h1>GCD of two Numbers</h1>
    <form action="gcd.php" method="post">
        <h2>Number 1: <input type="number" name="n1"></h2>
        <h2>Number 2: <input type="number" name="n2"></h2><br>
        <input type="submit" value="submit">
    </form><br>
      
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {   
    $num1 = $_POST['n1'];
    $num2 = $_POST['n2'];
    if($num1>$num2)
        $gcd = gcd($num1, $num2);
    else
        $gcd = gcd($num2, $num1);
    echo "GCD of $num1 and $num2 is $gcd";
}
function gcd($a, $b) {
    if ($b == 0) {
        return $a;
    }
    return gcd($b, $a % $b);
}
?>

</center>
</body>
</html>
