package DBLayer;

import java.util.ArrayList;

import ModelLayer.*;

public interface IFDBZipCode {
    public ArrayList<ZipCode> getAllZipCodes(boolean retriveAssociation);
}
