package sg.edu.nus.iss.app.workshop24.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.app.workshop24.models.LineItem;
import sg.edu.nus.iss.app.workshop24.models.Order;

@Controller
@RequestMapping(path="/cart")
public class CartController {
    
    // Handles HTTP POST requests to the /cart endpoint
    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess) {

            // Handles HTTP POST requests to the /cart endpoint
            List<LineItem> lineItems = (List<LineItem>)sess.getAttribute("cart");
            // If the line items are not in the session, create a new list
            if(null == lineItems) {
                lineItems = new LinkedList();
                sess.setAttribute("cart", lineItems);
            }

            // Get the item name and quantity from the request body
            String item =form.getFirst("item");
            Integer quantity =Integer.parseInt(form.getFirst("quantity"));
            // Add the line item to the list
            lineItems.add(new LineItem(item, quantity));
            // Create a new order with the customer name and line items
            Order ord = new Order();
            ord.setCustomerName(form.getFirst("name"));
            ord.setLineItems(lineItems);

            // Set the order in the session
            sess.setAttribute("checkoutCart", ord);
            // Set the order in the session
            model.addAttribute("lineItems", lineItems);
            // Return the "cart" view
            return "cart";
    }
}
