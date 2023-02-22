package sg.edu.nus.iss.app.workshop24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.app.workshop24.exception.OrderException;
import sg.edu.nus.iss.app.workshop24.models.LineItem;
import sg.edu.nus.iss.app.workshop24.models.Order;
import sg.edu.nus.iss.app.workshop24.models.OrderResult;
import sg.edu.nus.iss.app.workshop24.services.PurchaseOrderService;

@Controller
@RequestMapping(path="/checkout") // Maps incoming HTTP requests to the "/checkout" path to this controller
public class CheckoutController {
    
    @Autowired
    // PurchaseOrderService object, will be used to create a purchase order
    private PurchaseOrderService poSvc;

    @PostMapping
     // Method to handle checkout confirmation and returns a string "checkout"
    public String confirmCheckout(Model model, HttpSession sess) throws OrderException{
        // Retrieves a list of LineItems from the session, stored under the "cart" key
        List<LineItem> lineItems = (List<LineItem>) sess.getAttribute("cart");
        // Retrieves an Order object from the session, stored under the "checkoutCart" key
        Order ord = (Order)sess.getAttribute("checkoutCart");
        // Calls the createPurchaseOrder method of PurchaseOrderService to create a purchase order
        OrderResult r = poSvc.createPurchaseOrder(ord);
        // Invalidates the current HTTP session
        sess.invalidate();
        // Adds the total number of line items to the model
        model.addAttribute("total", lineItems.size());
        // Returns the string "checkout", which is used as the name of the view to be rendered
        return "checkout";
    }
    
}
