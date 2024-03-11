package com.CompanyREST.CompanyEmployeeRest.dto;

// napravit cu pomocni plain company dto da izbjegnen beskonacnu petlju kod deserializacije

public class PlainCompanyDto {

    private Long id;

    private String name;

    private String industry;

    private String location;

    public PlainCompanyDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
