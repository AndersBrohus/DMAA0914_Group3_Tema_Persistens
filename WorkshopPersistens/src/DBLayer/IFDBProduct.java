package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBProduct {
    public ArrayList<Product> getAllProduct();
    public Product findProduct(int id);
    public Product insertProduct(Product pro) throws Exception;
    public Product getLatest();

}
