package sg.edu.nus.iss.app.workshop24.exception;

public class OrderException extends Exception {

    // Default constructor, calls the constructor of the superclass (Exception)
    public OrderException () {
        super();
    }

    // Parameterized constructor, calls the constructor of the superclass (Exception) with the given message
    public OrderException(String msg){
        super(msg);
    }
}
