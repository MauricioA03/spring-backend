package com.sales.market.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee extends ModelBase {
    private String firstName;
    private String lastName;
    private Byte[] image;

    //    por defecto en fields es EAGER y en colleciones es LAZY y  todo valor booleano es true
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Contract> contracts;
//    mapped by employee es el nombre de la variable en contrato correpondiente a el field Employee
//    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

}
