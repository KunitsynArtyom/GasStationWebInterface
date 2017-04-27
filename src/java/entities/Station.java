package entities;


public class Station {
    private Integer stationId;
    private String orgname;
    private String country;
    private String city;
    private String street;
    private int storagecap;
    
    public Station(Integer stationId, String orgname, String country, String city, String street, int storagecap) 
    {
        this.stationId = stationId;
        this.orgname = orgname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.storagecap = storagecap;
    }
    
    public Station(String orgname, String country, String city, String street, int storagecap) 
    {
        this.orgname = orgname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.storagecap = storagecap;
    }
    
    public Integer getStationId() 
    {
        return stationId;
    }

    public String getOrgname() 
    {
        return orgname;
    }

    public String getCountry() 
    {
        return country;
    }

    public String getCity() 
    {
        return city;
    }

    public String getStreet() 
    {
        return street;
    }

    public int getStoragecap() {
        return storagecap;
    }
    
    public Integer showStationId()
    {
        return this.stationId;
    } 
}
