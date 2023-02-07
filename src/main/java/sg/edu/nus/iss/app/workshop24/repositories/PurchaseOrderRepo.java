package sg.edu.nus.iss.app.workshop24.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.workshop24.models.Order;

import static sg.edu.nus.iss.app.workshop24.repositories.Queries.*;


// Indicates this class is a Spring Data repository, responsible for handling data access for Purchase Order objects
@Repository
public class PurchaseOrderRepo {

    @Autowired
    // JdbcTemplate object, will be used to execute database operations
    private JdbcTemplate template;

    // Method to insert a purchase order into the database
    public boolean insertPO(Order ord){
        // Executes an update using the JdbcTemplate
        // SQL_INSERT_PO_TABLE is the SQL statement for inserting a purchase order
        return template.update(SQL_INSERT_PO_TABLE, 
                ord.getOrderId(),
                ord.getNotes(), 
                ord.getCustomerName(),
                ord.getShippingAddress(),
                ord.getTax() ) > 0;
    } // Returns true if the update was successful (i.e., at least one row was affected), false otherwise

    // Method to retrieve the count of line items for a specific order, but currently returns 0
    public int getLineItemsCountByOrderId(){
        return 0; 
    }
}
