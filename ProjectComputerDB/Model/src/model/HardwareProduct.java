/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user1
 */
public class HardwareProduct extends Product{
    private int intWarrantyPeriod;

    public HardwareProduct() {
    }

    
    public HardwareProduct(int intWarrantyPeriod, long Id, String Name, String Description, float PricePerUnit) {
        super(Id, Name, Description, PricePerUnit);
        this.intWarrantyPeriod = intWarrantyPeriod;
    }

    @Override
    public float GetPrice() {
       return super.getPricePerUnit()+intWarrantyPeriod;
    }

    public int getIntWarrantyPeriod() {
        return intWarrantyPeriod;
    }

    public void setIntWarrantyPeriod(int intWarrantyPeriod) {
        this.intWarrantyPeriod = intWarrantyPeriod;
    }

    @Override
    public String toString() {
        return super.toString()+"  The intWarrantyPeriod: "+
                getIntWarrantyPeriod();
    }
    
}
