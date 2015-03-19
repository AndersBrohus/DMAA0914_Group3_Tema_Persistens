package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBStock {
    public ArrayList<Stock> getAllStock();
    public Stock findStock(int id);
    public Stock insertStock(Stock sto) throws Exception;
}
