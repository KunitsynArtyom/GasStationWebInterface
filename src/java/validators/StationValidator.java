package validators;

import entities.Station;
import java.util.ArrayList;
import java.util.List;


public class StationValidator {
    
    public List<String> errorList = new ArrayList<String>();
    
    public StationValidator()
    {
        
    }
    
    public List<String> checkAddition(Station station)
    {
        if (station.getOrgname().isEmpty())
        {
            errorList.add("Organisation name isn't binded!");
        }
        if (station.getCountry().isEmpty())
        {
            errorList.add("Country isn't binded!");
        }
        if (station.getCity().isEmpty())
        {
            errorList.add("City isn't binded!");
        }
        if (station.getStreet().isEmpty())
        {
            errorList.add("Street isn't binded!");
        }
        if (station.getStoragecap() < 300)
        {
            errorList.add("Storagecap can't be less than 300 litres!");
        }

        return errorList;
    }
}
