/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Product;
import model.PurchaseOrder;

/**
 *
 * @author user1
 */
public class Backend_DAO_List implements Backend{
    
    private Map<Long, Customer> Customers;
    private Set<Product> Products;
    private ArrayList<PurchaseOrder> purchaseOrder;

    private Backend_DAO_List() {
        Customers = new HashMap<>();
        Products = new HashSet<>();
        purchaseOrder = new ArrayList<>();
    }
    private static Backend_DAO_List bdl_singleton;  // המופע היחיד

    public static Backend_DAO_List get_bdl_singleton() // הפונקציה שמחזירה את המופע היחיד
    {
        if (bdl_singleton == null) {
            bdl_singleton = new Backend_DAO_List();
        }
        return bdl_singleton;
    }

    @Override
    public void AddCustomer(Customer c) throws Exception {
      Customers.put(c.getId(),c);
    }

    @Override
    public void AddProduct(Product c) throws Exception {
        Products.add(c);
    }

    @Override
    public HashMap<Long, Customer> getAllCustomers() throws Exception {
       return (HashMap<Long, Customer>) Customers;
    }

    @Override
    public HashSet<Product> getAllProducts() throws Exception {
       return (HashSet<Product>) Products;
    }

    @Override
    public void PlaceOrder(PurchaseOrder po) throws Exception {
       purchaseOrder.add(po);
    }

    @Override
    public void RemoveProduct(Product c) throws Exception {
        Products.remove(c);
    }

    @Override
    public ArrayList<PurchaseOrder> getCustomersOrders(Customer c) throws Exception {
        
        ArrayList<PurchaseOrder> Allp=new ArrayList<>();
        for (PurchaseOrder Product : purchaseOrder) {
            if(Product.getCustomer().equals(c)==true)
                Allp.add(Product);

        }
        return Allp;
    }

    @Override
    public Float CalcProductsTotalCost(Product[] products) throws Exception {
       Float sum=new Float(0);
//        for (Product Product : Products) {
            for(int i=0;i<products.length;i++)
            {
//                if(products[i].equals(Product)==true)
                    sum+=products[i].GetPrice();
            }
//        }
        return sum;
    }
    public void printAllCustomers(){
        for (Map.Entry<Long, Customer> entry : Customers.entrySet()) {
            Long key = entry.getKey();
            Customer value = entry.getValue();
            System.out.println("The key: "+key);
            System.out.println("The value: "+value.toString());
            System.out.println("");
        }
        
    }
    public void printAllProduct(){
        for (Iterator<Product> iterator = Products.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
            System.out.println("");
        }
        
    }

    public void printAllpurchaseOrder(){
        for (PurchaseOrder purchaseOrder1 : purchaseOrder) {
            System.out.println(purchaseOrder1.toString());
            System.out.println("");
        }
    }
    
    public void savaCustomers(){
         FileOutputStream FileCustomer;
        FileOutputStream FileNumCustomer;
        int i=0;
        
         try {
            FileCustomer = new FileOutputStream(new File("Customers.txt"));
            FileNumCustomer = new FileOutputStream(new File("NumCustomer.txt"));

            ObjectOutputStream o = new ObjectOutputStream(FileCustomer);
            BufferedOutputStream B=new BufferedOutputStream(FileNumCustomer);
             for (Customer Customer : Customers.values()) {
                 o.writeObject(Customer);
             }

            B.write(Customers.size());
            o.close();
            B.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void savaProducts(){
         FileOutputStream FileProducts;
        FileOutputStream FileNumProduct;
        int i=0;
        
         try {
            FileProducts = new FileOutputStream(new File("Products.txt"));
            FileNumProduct = new FileOutputStream(new File("NumProduct.txt"));

            ObjectOutputStream o = new ObjectOutputStream(FileProducts);
            BufferedOutputStream B=new BufferedOutputStream(FileNumProduct);
             for (Product product : Products) {
                 o.writeObject(product);
             }

            B.write(Products.size());
            o.close();
            B.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    public void savaOrdersProduct(){
        FileOutputStream FileOrdersProducts;
        FileOutputStream FileNumOrdersProducts;
        int i=0;
        
         try {
            FileOrdersProducts = new FileOutputStream(new File("OrdersProduct.txt"));
            FileNumOrdersProducts = new FileOutputStream(new File("NumOrdersProduct.txt"));

            ObjectOutputStream o = new ObjectOutputStream(FileOrdersProducts);
            BufferedOutputStream B=new BufferedOutputStream(FileNumOrdersProducts);
             for (PurchaseOrder purchaseOrder : purchaseOrder) {
                 o.writeObject(purchaseOrder);
             }

            B.write(purchaseOrder.size());
            o.close();
            B.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadDataCustomer(){
        int num=0;
         try {
             Customer customer;
             File f1 = new File("NumCustomer.txt");
                 FileInputStream f = new FileInputStream(f1);
                 BufferedInputStream B = null;
                 B = new BufferedInputStream(f);
                 int i = B.read();
                 if (i!=48) {
                     ObjectInputStream ReadCustomer = 
                             new ObjectInputStream(new FileInputStream("Customers.txt"));
                     FileInputStream fileIn = new FileInputStream("Customers.txt");
                     ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                     while (num < i) {
                         customer = (Customer) ReadCustomer.readObject();
                         Customers.put(customer.getId(), customer);
                         num++;
                     }
                     System.out.println(i);
                 }
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadDataProduct()
    {
         int num=0;
         try {
             Product product;
             File f1 = new File("NumProduct.txt");
                 FileInputStream f = new FileInputStream(f1);
                 BufferedInputStream B = null;
                 B = new BufferedInputStream(f);
                 int i = B.read();
                 if (i!=48) {
                     ObjectInputStream ReadProduct =
                             new ObjectInputStream(new FileInputStream("Products.txt"));
                     FileInputStream fileIn = new FileInputStream("Products.txt");
                     ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                     while (num < i) {
                         product = (Product) ReadProduct.readObject();
                         Products.add(product);
                         num++;
                     }
                     System.out.println(i);
                 }
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void loadDataOrdersProduct(){
        int num=0;
         try {
             PurchaseOrder product;
             File f1 = new File("NumOrdersProduct.txt");
                 FileInputStream f = new FileInputStream(f1);
                 BufferedInputStream B = null;
                 B = new BufferedInputStream(f);
                 int i = B.read();
                 if (i!=48) {
                     ObjectInputStream ReadOrdersProduct =
                             new ObjectInputStream(new FileInputStream("OrdersProduct.txt"));
                     FileInputStream fileIn = new FileInputStream("OrdersProduct.txt");
                     ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                     while (num < i) {
                         product = (PurchaseOrder) ReadOrdersProduct.readObject();
                         purchaseOrder.add(product);
                         num++;
                     }
                     System.out.println(i);
                 }
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void savaDataToFile(){
        
       savaCustomers();
       savaProducts();
       savaOrdersProduct();
    }
     public void loadDataFromFile(){
        
         loadDataCustomer();
         loadDataProduct();
         loadDataOrdersProduct();

    }
}
