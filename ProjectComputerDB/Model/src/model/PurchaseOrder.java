/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author user1
 */
public class PurchaseOrder implements Serializable{
    private Customer customer;
    private ArrayList <Product>productsList;
    private LocalDate orderDate;

    
    public PurchaseOrder() {
        orderDate=LocalDate.now();
    }
    
    public PurchaseOrder(Customer customer, ArrayList<Product> productsList,LocalDate date) {
        this.customer = customer;
        this.productsList = productsList;
        this.orderDate = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
       return  "In OrderDate:  "+orderDate+"  |  "+customer.toString()+
               "\n\n  | The Order:[  \n"
               +Product.toString(productsList)+" ]" ;
             
    }
    
}
