package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBSalesOrder {
    public ArrayList<SalesOrder> getAllSalesOrder();
    public SalesOrder findSalesOrder(int id);
    public SalesOrder insertSalesOrder(SalesOrder ord) throws Exception;
}
