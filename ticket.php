<!-- 
Develop a PHP class representing a ticket with properties like event name, venue, date, and price. 
Implement methods for booking and canceling tickets, as well as generating tickets for customers.
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
            height: 300px;
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
            margin-left: 50px;
        }
    </style>
</head>
<body>
    <center>
        <h2>BOOK YOUR TICKET...</h2><br>
        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <fieldset class="form">
                <legend>Ticket details</legend>
                <strong>
                    <br>Name: <input type="text" name="name" class="inner"><br><br>
                    Event Name: 
                    <select class="inner" name="event" >
                        <option disabled selected>Select concert</option>
                        <option value="taylor swift">Taylor Swift Concert</option>
                        <option value="harry styles">Harry Style Concert</option>
                        <option value="aadhi">Hip Pop Aadhi Concert</option>
                        <option value="gv">G.V Prakash Concert</option>
                    </select><br><br>
                    Venue: <input type="text" name="venue" class="inner"><br><br>
                    Date: <input type="date" name="date" class="inner" min="<?php echo date('Y-m-d'); ?>"><br><br>
                    Fair: <input type="number" name="amt" class="inner"><br><br><br>
                    <input type="submit" name="book" value="Book" class="bt">
                    <input type="submit" name="cancel" value="Cancel" class="bt"><br><br>
                </strong>
            </fieldset>
        </form>
    </center>

    <?php
        session_start();

        class Ticket {
            public $eventName;
            public $venue;
            public $date;
            public $price;

            public function __construct($eventName, $venue, $date, $price) {
                $this->eventName = $eventName;
                $this->venue = $venue;
                $this->date = $date;
                $this->price = $price;
            }

            public function bookTicket() {
                if (!isset($_SESSION['bookedTickets'])) {
                    $_SESSION['bookedTickets'] = array(); 
                }

                foreach ($_SESSION['bookedTickets'] as $ticket) {
                    if ($ticket['eventName'] == $this->eventName && $ticket['venue'] == $this->venue && $ticket['date'] == $this->date) {
                        return "alreadyBooked";
                    }
                }

                $_SESSION['bookedTickets'][] = array(
                    'eventName' => $this->eventName,
                    'venue' => $this->venue,
                    'date' => $this->date,
                    'price' => $this->price
                );
                return "booked";
            }

            public function cancelTicket() {
                if (isset($_SESSION['bookedTickets'])) {
                // Check if the ticket is booked and cancel it
                    foreach ($_SESSION['bookedTickets'] as $key => $ticket) {
                        if ($ticket['eventName'] == $this->eventName && $ticket['venue'] == $this->venue && $ticket['date'] == $this->date) {
                            unset($_SESSION['bookedTickets'][$key]);
                            return "canceled";
                        }
                    }
                }
                return "notBooked";
            }
        }

        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $name = $_POST['name'];
            $eventName = $_POST['event'];
            $venue = $_POST['venue'];
            $date = $_POST['date'];
            $price = $_POST['amt'];

            $ticket = new Ticket($eventName, $venue, $date, $price);

            if (isset($_POST["book"])) {
                $result = $ticket->bookTicket();
                if ($result === "booked") {
                    echo '<script>alert("hey ' . $name . ', Ticket booked successfully for ' . $eventName . ' at ' . $venue . ' on ' . $date . ' for ' . $price . ' Rupees.");</script>';
                } else {
                    echo '<script>alert("Sorry ' . $name . ', Ticket is already booked.");</script>';
                }
            } elseif (isset($_POST["cancel"])) {
                $result = $ticket->cancelTicket();
                if ($result === "canceled") {
                    echo '<script>alert("hey ' . $name . ', Ticket for ' . $eventName . ' at ' . $venue . ' on ' . $date . ' has been canceled.");</script>';
                } else {
                    echo '<script>alert("Sorry ' . $name . ', Ticket is not booked yet.");</script>';
                }
            }
        }
    ?>

</body>
</html>
