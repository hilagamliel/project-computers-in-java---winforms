/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author user1
 */
public class Model {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HardwareProduct Hard1=new HardwareProduct(2, 1111, "HardThinkped1", "good", 2000);
        HardwareProduct Hard2=new HardwareProduct(3, 2222, "HardThinkped2", "verygood", 3000);
        //System.out.println(Hard1.toString());
        //System.out.println(Hard1.toString());
        SoftwareProduct Soft1=new SoftwareProduct(2, 1111, "SoftThinkped1", "good", 2000);
        SoftwareProduct Soft2=new SoftwareProduct(3, 2222, "SoftThinkped2", "verygood", 3000);
        //System.out.println(Soft1.toString());
        //System.out.println(Soft1.toString());
        Customer customer1=new Customer(1212,"hila","remez");
        Customer customer2=new Customer(1313,"tamar","pardo");
        //System.out.println(customer1.toString());
        //System.out.println(customer2.toString());
        ArrayList<Product> ListProduct=new ArrayList<>();
        ListProduct.add(Soft2);
        ListProduct.add(Soft1);
        ListProduct.add(Hard1);
//        PurchaseOrder purchaseOrder=new PurchaseOrder(customer1,ListProduct);
//        purchaseOrder.getProductsList().add(new HardwareProduct(3, 3333, "tushiba", "nice", 1000));
//        System.out.println( purchaseOrder.toString());
    }
    
}
