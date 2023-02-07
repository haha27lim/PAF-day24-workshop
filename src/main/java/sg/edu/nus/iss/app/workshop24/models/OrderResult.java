package sg.edu.nus.iss.app.workshop24.models;

public class OrderResult {

    // Count of the number of rows inserted into PO (Purchase Order) table
    private int inserCntForPO;
    // Count of the number of rows inserted into LineItem table
    private int inserCntForLineItem;

    // Getters and setters    
    public int getInserCntForPO() {
        return inserCntForPO;
    }
    public void setInserCntForPO(int inserCntForPO) {
        this.inserCntForPO = inserCntForPO;
    }
    public int getInserCntForLineItem() {
        return inserCntForLineItem;
    }
    public void setInserCntForLineItem(int inserCntForLineItem) {
        this.inserCntForLineItem = inserCntForLineItem;
    }
    
    
}
