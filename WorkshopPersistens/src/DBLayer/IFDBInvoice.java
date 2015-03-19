package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBInvoice {
    public ArrayList<Invoice> getAllInvoices();
    public Invoice findInvoice(int invoiceNo);
    
    public Invoice insertInvoice(Invoice inv) throws Exception;
}
