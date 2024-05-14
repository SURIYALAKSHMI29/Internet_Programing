<!--
Create a PHP form that collects user input for their address, city, and state. Perform form validation to
ensure that all fields are filled out and that the state is a valid two-letter abbreviation. Insert the data 
into a MySQL database table called "addresses". Finally, display a message to the user indicating whether the 
insertion was successful or not.
-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>php_form_validation</title>
        <style>
            body{
                background-color: seashell;
                margin-left: 44%;
            }
            input{
                margin: 10px;
            }
            h2{
                margin-left: 5%;
            }
            input[type="submit"]{
                height: 30px;
                width: 80px;
                font-size: 14px;
                font-weight: bold;
                margin-left: 75px;
                background-color: whitesmoke;
            }
        </style>
    </head>
    <body>
        <h2>Form Validation</h2>
        <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>" method="POST">
            Name: <input type="text" name="username"><br>
            Address: <input type="text" name="address"><br>
            City: <input type="text" name="city"><br>
            State: <input type="text" name="state"><br>
            <input type="submit" value="Submit" name="submit"><br>
        </form>
        <?php
            if(isset($_POST['submit'])){
                $cleanData = cleanInput($_POST);
                $errormsg = validate($cleanData);
                if($errormsg==null){
                    $host="localhost:3390"; 
                    $username="root";
                    $password="";
                    $db = "php_db";
                    $con = new mysqli($host,$username, $password, $db);
                    if($con->connect_error)
                        die("Connection Failed: ".$con->connect_error);
                    $name =$cleanData['username'];
                    $address = $cleanData['address'];
                    $city = $cleanData['city'];
                    $state = $cleanData['state'];
                    $query = "Insert into user_address Values('$name','$address','$city','$state');";
                    $result = $con->query($query);
                    echo '<h3>Inserted Successfully!</h3>';
                }
                else{
                    echo '<h3>Please correct the following input(s)</h3>';
                    foreach($errormsg as $key=>$value){
                        echo $value."<br>";
                    }
                }
            }
            function cleanInput($input){
                foreach($input as $key=>$value){
                    $data = trim($value);
                    $data = stripcslashes($data);
                    $data = htmlspecialchars($data);
                    return $input;
                }
            }
            function validate($cleanData){
                $error = array();
                foreach($cleanData as $key=>$value){
                    switch($key){
                        case "username":
                            if(empty($value))
                                $error['username']="Name cannot be empty!";
                            break;
                        case "address":
                            if(empty($value))
                                $error['address']="Address cannot be empty!";
                            break;
                        case "city":
                            if(empty($value))
                                $error['city']="City cannot be empty!";
                            break;
                        case "state":
                            $pattern = "/[a-zA-Z]{2}$/";
                            if(!preg_match($pattern, $value))
                                    $error["state"] = "State must be a valid 2 letter abbreviation!";
                            break;
                    }
                }
                return $error;
            }
        ?>
    </body>
</html>
