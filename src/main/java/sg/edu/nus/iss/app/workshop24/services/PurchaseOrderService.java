package sg.edu.nus.iss.app.workshop24.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.app.workshop24.exception.OrderException;
import sg.edu.nus.iss.app.workshop24.models.Order;
import sg.edu.nus.iss.app.workshop24.models.OrderResult;
import sg.edu.nus.iss.app.workshop24.repositories.LineItemRepo;
import sg.edu.nus.iss.app.workshop24.repositories.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {
    
    // Autowired annotation is used to mark the purchase order repository to be autowired by Spring
    @Autowired
    private PurchaseOrderRepo poRepo;

    // Autowired annotation is used to mark the line item repository to be autowired by Spring
    @Autowired
    private LineItemRepo lineRepo;

    // Marking the method as transactional with rollback behavior defined for OrderException
    @Transactional(rollbackFor = OrderException.class)
    public OrderResult createPurchaseOrder(Order ord) throws OrderException{
        // Generates a unique order ID for the purchase order
        String orderId= UUID.randomUUID().toString().substring(0, 8);
        ord.setOrderId(orderId);
        
        // Inserting the purchase order into the database
        poRepo.insertPO(ord);
        // Checking if the order has more than 3 line items, throw an OrderException if does. 
        if(ord.getLineItems().size() > 3){
            throw new OrderException();
        }
        // Add the line items for the order to the database
        lineRepo.addLineItems(ord.getLineItems(), orderId);
        // Create an OrderResult object
        OrderResult r =new OrderResult();
        // Return the OrderResult object
        return r;
    }
}
