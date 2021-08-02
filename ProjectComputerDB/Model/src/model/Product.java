/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author user1
 */
public abstract class  Product implements Serializable{

    private long Id;
    private String Name;
    private String Description;
    private float PricePerUnit ;

    public Product() {
    }

    
    public Product(long Id, String Name, String Description, float PricePerUnit) {
        this.Id = Id;
        this.Name = Name;
        this.Description = Description;
        this.PricePerUnit = PricePerUnit;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public float getPricePerUnit() {
        return PricePerUnit;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPricePerUnit(float PricePerUnit) {
        this.PricePerUnit = PricePerUnit;
    }

    @Override
    public String toString() {
        return " The Id:  "+getId()+" ,  Name:  "+getName()+" ,  Description:  "+
                getDescription()+" ,  PricePerUnit:  "+getPricePerUnit();
    }
    public abstract float GetPrice();
    
    public static String toString(ArrayList <Product> p) {
        String str="The Products: ";
        int i=1;
        for (Product object : p) {
            str+="p_"+i+" { ";
            str+=object.toString();
            str+=" } ,  ";
            i++;
        }
       
        return str;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

   

    
}
