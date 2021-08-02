/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.corba.se.spi.orbutil.fsm.Guard;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.naming.spi.DirStateFactory;
import model.Customer;
import model.HardwareProduct;
import model.Product;
import model.PurchaseOrder;
import model.SoftwareProduct;

/**
 *
 * @author student
 */
public class Backend_DAO_DB implements Backend{
    private Connection connection;
    
        private static Backend_DAO_DB bdl_singleton;  // המופע היחיד

    public static Backend_DAO_DB get_bdl_singleton() // הפונקציה שמחזירה את המופע היחיד
    {
        if (bdl_singleton == null) {
            bdl_singleton = new Backend_DAO_DB();
        }
        return bdl_singleton;
    }
    public Backend_DAO_DB() {
        try {
             connection= DriverManager.getConnection("jdbc:derby://localhost:1527/DBcomputers","ccc","ccc");
        } catch (SQLException ex) {
            Logger.getLogger(Backend_DAO_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void AddCustomer(Customer c) throws Exception {

        PreparedStatement prepareStatement = connection.prepareStatement("insert into customers values(?,?,?)");
        prepareStatement.setLong(1, c.getId());
        prepareStatement.setString(2, c.getName());
        prepareStatement.setString(3, c.getAddress());
        prepareStatement.execute();
        prepareStatement.close();
                
    }

    @Override
    public void AddProduct(Product p) throws Exception {
        PreparedStatement prepareStatement = connection.prepareStatement("insert into product values(?,?,?,?,?,?)");
        prepareStatement.setLong(1, p.getId());
        prepareStatement.setString(2, p.getName());
        prepareStatement.setString(3, p.getDescription());
        prepareStatement.setFloat(4, p.getPricePerUnit());
        if (p instanceof HardwareProduct) {
            prepareStatement.setString(5, "HardwareProduct");
            prepareStatement.setInt(6, ((HardwareProduct) p).getIntWarrantyPeriod());

        } else {
            prepareStatement.setString(5, "SoftwareProduct");
            prepareStatement.setInt(6, ((SoftwareProduct) p).getIntNumberOfUsers());

        }
        prepareStatement.execute();
    }

    @Override
    public HashMap<Long, Customer> getAllCustomers() throws Exception {
        HashMap<Long, Customer>AllCustomers=new HashMap<>();
        
        Statement createStatement = connection.createStatement();
        ResultSet executeQuery = createStatement.executeQuery("SELECT * FROM CCC.CUSTOMERS");
        while (executeQuery.next()) {            
            Customer c=new Customer();
            c.setId(executeQuery.getInt("ID"));
            c.setName(executeQuery.getString("NAME"));
            c.setAddress(executeQuery.getString("ADRRES"));
            AllCustomers.put(c.getId(), c);
        }
        
        
        return AllCustomers;
    }

    @Override
    public HashSet<Product> getAllProducts() throws Exception {
        HashSet<Product> Products=new HashSet<>();
        Statement createStatement = connection.createStatement();
        ResultSet executeQuery = createStatement.executeQuery("select * from product");
        while (executeQuery.next()) {   
            String type=executeQuery.getString(5);
            if(type.compareTo("HardwareProduct")==0)
                Products.add(new HardwareProduct(executeQuery.getInt(6), executeQuery.getLong(1)
                        , executeQuery.getString(2), executeQuery.getString(3), executeQuery.getFloat(4)));
            else
                 Products.add(new SoftwareProduct(executeQuery.getInt(6), executeQuery.getLong(1)
                        , executeQuery.getString(2), executeQuery.getString(3), executeQuery.getFloat(4)));
        }
        return Products;
    }

    @Override
    public void PlaceOrder(PurchaseOrder po) throws Exception {
//        Statement createStatement = connection.createStatement();
//        createStatement.executeQuery
//        ("INSERT INTO CCC.ORDERS (CUSTOMERID, \"DATE\")VALUES ("+po.getCustomer().getId()+",'"+
//                po.getOrderDate()+"');");
//

       PreparedStatement prepareStatement = connection.prepareStatement
                ("INSERT INTO CCC.ORDERS (CUSTOMERID, DATE)VALUES (?,?)");


        prepareStatement.setLong(1,po.getCustomer().getId() );
        prepareStatement.setDate(2,Date.valueOf(LocalDate.now()));
        prepareStatement.execute();
        Statement createStatement1 = connection.createStatement();
        ResultSet executeQuery = createStatement1.executeQuery("SELECT MAX(ID) FROM CCC.ORDERS");
        PreparedStatement prepareStatement1 = connection.prepareStatement(
                "insert into PRODUCTINORDERS values(?,?)");
        //executeQuery.getMetaData().getColumnCount();
        //String s=executeQuery.getString(0);
        boolean next = executeQuery.next();
        long aLong = executeQuery.getLong(1);
        for (Product p : po.getProductsList()) {
            prepareStatement1.setLong(1 ,aLong);
            prepareStatement1.setLong(2 ,p.getId());
            prepareStatement1.execute();
        }
        
    }

    @Override
    public void RemoveProduct(Product p) throws Exception {
        PreparedStatement prepareStatement = connection.prepareStatement("delete from product where id=?");
        prepareStatement.setLong(1, p.getId());
        prepareStatement.execute();
    }

    @Override
    public ArrayList<PurchaseOrder> getCustomersOrders(Customer c) throws Exception {
        ArrayList<PurchaseOrder>purchaseOrders=new ArrayList<>();
        
        PreparedStatement GETFROMORDERS = connection.prepareStatement("SELECT * FROM ORDERS WHERE CUSTOMERID=?");
        GETFROMORDERS.setLong(1, c.getId());
        ResultSet IDORDERS = GETFROMORDERS.executeQuery();
        
        PreparedStatement GETFROMPRODUCTINORDERS = connection.prepareStatement("SELECT * FROM PRODUCTINORDERS WHERE ID=?");
      
        PreparedStatement GETFROMPRODUCT = connection.prepareStatement("SELECT * FROM PRODUCT WHERE ID=?");
        while(IDORDERS.next())
        {
            ArrayList<Product>arrp=new ArrayList<>();
            GETFROMPRODUCTINORDERS.setLong(1, IDORDERS.getLong(1));
            ResultSet IDRODUCTINORDERS = GETFROMPRODUCTINORDERS.executeQuery();
            while (IDRODUCTINORDERS.next()) {                
                GETFROMPRODUCT.setLong(1, IDRODUCTINORDERS.getLong(2));
                ResultSet IDPRODUCT = GETFROMPRODUCT.executeQuery();
                IDPRODUCT.next();
                Product p;
                if(IDPRODUCT.getString(5).compareTo("HardwareProduct")==0)
                    p=new HardwareProduct(IDPRODUCT.getInt(6), IDPRODUCT.getLong(1)
                        , IDPRODUCT.getString(2), IDPRODUCT.getString(3), IDPRODUCT.getFloat(4));
                else
                    p=new SoftwareProduct(IDPRODUCT.getInt(6), IDPRODUCT.getLong(1)
                        , IDPRODUCT.getString(2), IDPRODUCT.getString(3), IDPRODUCT.getFloat(4));
                arrp.add(p);
            }
             
            PurchaseOrder purchaseOrder=new PurchaseOrder(c, arrp, IDORDERS.getDate(3).toLocalDate());
            purchaseOrders.add(purchaseOrder);
        }
        return purchaseOrders;
    }

    @Override
    public Float CalcProductsTotalCost(Product[] products) throws Exception {
            Float sum=new Float(0);
            for(int i=0;i<products.length;i++)
            {
                    sum+=products[i].GetPrice();
            }
        return sum;


    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
    }
    
    
    
}
