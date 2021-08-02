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
public class SoftwareProduct extends Product{

    private int intNumberOfUsers;

    public SoftwareProduct(int intNumberOfUsers, long Id, String Name, String Description, float PricePerUnit) {
        super(Id, Name, Description, PricePerUnit);
        this.intNumberOfUsers = intNumberOfUsers;
    }
    
    public int getIntNumberOfUsers() {
        return intNumberOfUsers;
    }

    public void setIntNumberOfUsers(int intNumberOfUsers) {
        this.intNumberOfUsers = intNumberOfUsers;
    }
    
    @Override
    public float GetPrice() {
        return super.getPricePerUnit()+intNumberOfUsers;
    }

    @Override
    public String toString() {
        return super.toString()+" The intNumberOfUsers: "+
             getIntNumberOfUsers(); 
    }
    
}
