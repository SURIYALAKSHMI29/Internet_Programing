
<?php

class Ticket {
    private $eventName;
    private $venue;
    private $date;
    private $price;
    private $isBooked;

    public function __construct($eventName, $venue, $date, $price) {
        $this->eventName = $eventName;
        $this->venue = $venue;
        $this->date = $date;
        $this->price = $price;
        $this->isBooked = false;
    }
    public function bookTicket() {
        if (!$this->isBooked) {
            $this->isBooked = true;
            return "Ticket booked successfully for {$this->eventName} at {$this->venue} on {$this->date} for {$this->price} USD.";
        } else {
            return "Ticket is already booked.";
        }
    }
    public function cancelTicket() {
        if ($this->isBooked) {
            $this->isBooked = false;
            return "Ticket for {$this->eventName} at {$this->venue} on {$this->date} has been canceled.";
        } else {
            return "Ticket is not booked yet.";
        }
    }  
    public function generateTicketForm() {
        echo '
            <form method="post" action="' . htmlspecialchars($_SERVER["PHP_SELF"]) . '">
                <label for="eventName">Event Name:</label>
                <input type="text" name="eventName" id="eventName" value="' . $this->eventName . '" readonly><br>
                <label for="venue">Venue:</label>
                <input type="text" name="venue" id="venue" value="' . $this->venue . '" readonly><br>
                <label for="date">Date:</label>
                <input type="text" name="date" id="date" value="' . $this->date . '" readonly><br>
                <label for="price">Price:</label>
                <input type="text" name="price" id="price" value="' . $this->price . '" readonly><br>
                <input type="submit" name="book" value="Book Ticket">
                <input type="submit" name="cancel" value="Cancel Ticket">
            </form>';
    }
  }
$ticket = new Ticket("Concert", "Stadium", "2024-04-20", 50);
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (isset($_POST["book"])) {
        echo $ticket->bookTicket();
    } elseif (isset($_POST["cancel"])) {
        echo $ticket->cancelTicket();
    }
$ticket->generateTicketForm();
}
?>
