package entities;

import java.sql.Date;


public class Staff {
    private Integer staffId;
    private Integer stationId;
    private String surname;
    private String name;
    private String gender;
    private String function;
    private int salary;
    
    public Staff(Integer staffId, Integer stationId, String surname, String name, String gender, String function, int salary)
    {
        this.staffId = staffId;
        this.stationId = stationId;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.function = function;
        this.salary = salary;
    }
    
    public Staff(Integer stationId, String surname, String name, String gender, String function, int salary)
    {
        this.stationId = stationId;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.function = function;
        this.salary = salary;
    }
    
    public Integer getStationId()
    {
        return stationId;
    }
    
    public Integer getStaffId()
    {
        return staffId;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public String getFunction()
    {
        return function;
    }
    
    public int getSalary()
    {
        return salary;
    }
}
