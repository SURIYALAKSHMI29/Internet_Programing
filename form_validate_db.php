<!--
Create a PHP form that collects user input for their name, email, and preferred date/time for an
appointment. Perform form validation to ensure that all fields are filled out and that the email
is valid. Insert the data into a MySQL database table called "appointments". Finally, display a
message to the user indicating whether the insertion was successful or not.
-->

<!DOCTYPE html>
<html>
<head>
    <style>
        body{
            background-color: lavender;
        }
        .form {
            width: 300px;
            height: auto;
            border: 2px solid black;
            text-align: left;
            padding-left: 50px;
            position: relative;
            background-color: white;
        }
        .inner {
            position: absolute;
            left: 150px;
        }
        .bt {
            margin-left: 100px;
        }
    </style>
</head>
<body>
    <center>
        <h2>Book your Appointments...</h2><br>
        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <fieldset class="form">
                <legend>Appointment details</legend>
                <strong><br>
                    Name: <input type="text" name="name" class="inner"><br><br>
                    Email: <input type="text" name="email" class="inner"><br><br>
                    Date: <input type="date" name="date" class="inner" min="<?php echo date('Y-m-d'); ?>"><br><br>
                    Time: <input type="text" name="time" class="inner"><br><br><br>
                    <input type="submit" name="book" value="Book" class="bt"><br><br>
                </strong>
            </fieldset>
        </form>
    </center>
    <?php 
    if(isset($_POST["book"]))
    {
        $cleandata=cleaninput($_POST);
        $errormsg=validateinput($cleandata);
        if($errormsg == null){
            $host='localhost:3390';
            $username='root';
            $password='';
            $dbname='php_db';
            $con=new mysqli($host,$username,$password,$dbname);
            if($con->connect_error){
                die("Connection failed: ".$con->connect_error);
            }
            $name=$cleandata["name"];
            $email=$cleandata["email"];
            $date=$cleandata["date"];
            $time=$cleandata["time"];
            $sql1="SELECT * FROM appoinments WHERE date='$date' AND time='$time'";
            $result=$con->query($sql1);
            if($result->num_rows>0){
                echo '<center><h3>Appointment already booked</h3></center>';
            }
            else{
                $sql="INSERT INTO appoinments(name,email,date,time) VALUES('$name','$email','$date','$time')";
                $con->query($sql);
                echo '<center><h3>Appointment booked successfully</h3></center>';
            }
            $con->close();
        }
        else{
            echo '<center><h3>Please fix the following errors</h3>';
            foreach($errormsg as $key=>$value){
                echo $value."<br>";
            }
            echo '</center>';
        }
    }
    function cleaninput($input)
    {
        foreach($input as $key=>$value){
            $data=trim($value);
            $data=stripslashes($data);
            $data=htmlspecialchars($data);
            return $input;
        }
    }
    function validateinput($cleandata){   
        $error=array();
        foreach($cleandata as $key=>$value){
            switch($key){
                case "name":
                    if(empty($value))
                        $error["nane"]="*Name cannot be empty";
                    break;
                case "email":
                    if(!filter_var($value,FILTER_VALIDATE_EMAIL))
                        $error["email"]="*email is not valid";
                    break;
                case "date":
                    if(empty($value))
                        $error["date"]="*Date cannot be empty";
                    break;
                case "time":
                    if(empty($value))
                        $error["time"]="*Time cannot be empty";
                    break;
            }
        }
        return $error;
    }
    ?>
</body>
</html>
