package sg.edu.nus.iss.app.workshop24.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.workshop24.models.LineItem;
import sg.edu.nus.iss.app.workshop24.models.Order;

import static sg.edu.nus.iss.app.workshop24.repositories.Queries.*;


// Indicates this class is a Spring Data repository, responsible for handling data access for LineItem objects
@Repository
public class LineItemRepo {


    @Autowired
    // JdbcTemplate object, will be used to execute database operations
    private JdbcTemplate template;

    // Method to add line items to the database, but currently empty
    public void addLineItems(Order ord){
        
    }

    // Method to add a list of LineItem objects to the database
    public void addLineItems(List<LineItem> lineItems, String orderId) {
        // Streams the list of LineItem objects and maps them to arrays of objects
        List<Object[]> arrData =  lineItems.stream()
        .map( li -> {
            // For each LineItem, creates an array of objects representing the line item data
            Object[] l = new Object[5];
            // Converts the stream back to a list of arrays of objects
            l[0] = li.getProduct();
            l[1] = li.getQuantity();
            l[2] = orderId;
            l[3] = li.getUnitPrice();
            l[4] = li.getDiscount();
            return l;
        }).toList();
    
        // Executes a batch update using the JdbcTemplate, inserting the line item data into the database
        template.batchUpdate(SQL_INSERT_LINEITEM_TABLE, arrData);
        
    }

    // Method to retrieve the count of line items for a specific order, but currently returns 0
    public int getLineItemsCountByOrderId(){
        return 0; 
    }
}
