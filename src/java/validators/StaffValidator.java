package validators;

import entities.Staff;
import java.util.ArrayList;
import java.util.List;


public class StaffValidator {
     public List<String> errorList = new ArrayList<String>();
    
    public StaffValidator()
    {
        
    }
    
    public List<String> checkAddition(Staff staff)
    {
        if (staff.getSurname().isEmpty())
        {
            errorList.add("Surname is not indicated!");
        }
        if (staff.getName().isEmpty())
        {
            errorList.add("Name is not indicated!");
        }
        if (staff.getGender().isEmpty())
        {
            errorList.add("Gender is not indicated!");
        }
        if (staff.getFunction().isEmpty())
        {
            errorList.add("Function is not indicated!");
        }
        if (staff.getFunction().isEmpty())
        {
            errorList.add("Function is not indicated!");
        }
        if (staff.getSalary() < 500)
        {
            errorList.add("Salary must be higher than 500!");
        }

        return errorList;
    }
}
