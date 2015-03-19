package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBSupplier {
    public ArrayList<Supplier> getAllSupplier();
    public Supplier findSupplier(int id);
    public Supplier insertSupplier(Supplier sup) throws Exception;
}
