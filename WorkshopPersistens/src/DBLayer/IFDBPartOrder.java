package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBPartOrder {
    public ArrayList<PartOrder> getAllPartOrders();
    public PartOrder findPartOrder(int id);
    public PartOrder insertPartOrder(PartOrder par) throws Exception;
}
