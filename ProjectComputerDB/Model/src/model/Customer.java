/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author user1
 */
public class Customer implements Serializable{
    private  long Id;
    private String Name;
    private String Address ;

    public Customer() {
    }
    public Customer(long Id, String Name, String Address) {
        this.Id = Id;
        this.Name = Name;
        this.Address = Address;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
      return "The Id: "+getId()+" , \n The Name: "+getName()+" , \n The Address: "+getAddress();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer)
        {
            if(((Customer)obj).getId()==Id)
                return true;
        }
        return false;
    }
    
}
