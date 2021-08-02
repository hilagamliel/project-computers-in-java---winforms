/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanagerguiview;

/**
 *
 * @author user1
 */
import com.sun.xml.internal.ws.handler.HandlerException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import model.Customer;
import controller.Backend_DAO_List;
import controller.Backend;
import controller.Backend_DAO_DB;
import controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.plaf.DimensionUIResource;

public class AddNewCustomerForm extends JFrame {

    PlaceOrderForm placeOrderForm = new PlaceOrderForm();
    StoreManagerGUIViewForm2 store;

    //הגדרות הרכיבים של הוספת לקוח
    private JPanel pAll;

    private JPanel PLabla;
    private JLabel Labla;
    private JPanel Path;
    private GridLayout gLable;
    private GridLayout gpath;

    private JLabel CustomerID;
    private JTextField TextCustomerID;

    private JLabel Name;
    private JTextField TextName;

    private JLabel Address;
    private JTextField TextAddress;

    private JButton AddCustomer;

    private JButton Clear;

    public void clear() {
        TextCustomerID.setText("");
        TextName.setText("");
        TextAddress.setText("");
    }

    public AddNewCustomerForm(StoreManagerGUIViewForm2 store) {

        this.store = store;

        //אתחול הרכיבים
        gLable = new GridLayout();
        gLable.setColumns(1);
        gLable.setRows(11);
        PLabla = new JPanel(gLable);

        Labla = new JLabel("Customers");

        Labla.setFont(new Font("Agency FB", Font.BOLD, 44));
        Labla.setForeground(new java.awt.Color(0, 102, 102));

        Path = new JPanel();
        Path.setBackground(new java.awt.Color(0, 102, 102));
        PLabla.add(new JLabel());
        PLabla.add(new JLabel());
        PLabla.add(new JLabel());
        PLabla.add(Labla);
        PLabla.add(new JLabel());
        PLabla.add(new JLabel());
        PLabla.add(Path);


        PLabla.add(new JLabel());
        PLabla.add(new JLabel());
        PLabla.add(new JLabel());
        PLabla.add(new JLabel());

        CustomerID = new JLabel("      ID:");
        TextCustomerID = new JPasswordField();
        CustomerID.setForeground(new java.awt.Color(0, 102, 102));
        CustomerID.setFont(new Font("Agency FB", Font.BOLD, 33));
        TextCustomerID.setFont(new Font("ariel", Font.BOLD, 22));
        TextCustomerID.setSize(new DimensionUIResource(2, 4));

        Name = new JLabel("      Name:");
        TextName = new JTextField();
        Name.setForeground(new java.awt.Color(0, 102, 102));
        Name.setFont(new Font("Agency FB", Font.BOLD, 33));
        TextName.setFont(new Font("ariel", Font.BOLD, 22));

        Address = new JLabel("      Address:");
        TextAddress = new JTextField();
        Address.setForeground(new java.awt.Color(0, 102, 102));
        Address.setFont(new Font("Agency FB", Font.BOLD, 33));
        TextAddress.setFont(new Font("ariel", Font.BOLD, 22));

        AddCustomer = new JButton("ok");
//        AddCustomer.setPreferredSize(new java.awt.Dimension(200, 70));
        AddCustomer.setFont(new Font("Agency FB", Font.BOLD, 40));
        AddCustomer.setForeground(new java.awt.Color(0, 102, 102));

        Clear = new JButton("Clear");
//        Clear.setPreferredSize(new java.awt.Dimension(40, 20));
        Clear.setForeground(new java.awt.Color(0, 102, 102));

        //  Clear.setSize(new java.awt.Dimension(40, 20));
        Clear.setFont(new Font("Agency FB", Font.BOLD, 30));

        Clear.addActionListener((e) -> {
            TextCustomerID.setText("");
            TextName.setText("");
            TextAddress.setText("");
        }
        );

        //הוספת הרכיבית למסך
        GridLayout g = new GridLayout();
        g.setRows(7);
        g.setColumns(2);
        pAll = new JPanel(g);

        pAll.add(CustomerID);
        pAll.add(TextCustomerID);
        pAll.add(Name);
        pAll.add(TextName);
        pAll.add(Address);
        pAll.add(TextAddress);

        pAll.add(new JPanel());
        pAll.add(new JPanel());
        pAll.add(new JPanel());
        pAll.add(new JPanel());
        pAll.add(Clear);
        pAll.add(AddCustomer);

        //קביעת גודל המסך
        this.setLayout(new GridLayout(2, 1));
        this.setPreferredSize(new Dimension(1700, 800));

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.add(PLabla);
        this.add(pAll);
        this.pack();

        //בדיקות תקינות תעודת זהות
        TextCustomerID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() > '9' || e.getKeyChar() < '0') {
                    e.consume();
                }
            }

        });

        //הוספת אירועים
        AddCustomer.addActionListener((e) -> {
            try {
                if (TextAddress.getText().length() == 0 || TextCustomerID.getText().length() == 0
                        || TextName.getText().length() == 0) {
                    throw new MyExpetion("חובה למלא את כל הפרטים!");
                }

                if (TextCustomerID.getText().length() != 9) {
                    throw new MyExpetion("תעודת הזהות חייבת להיות בעלת 9 ספרות!");
                }
                if (TextName.getText().length() == 0) {
                    throw new MyExpetion("נא למלא את השם!");
                }
                if (TextAddress.getText().length() == 0) {
                    throw new MyExpetion("נא למלא את הכתובת!");
                }
                Customer customer1 = new Customer();
                Long id = new Long(TextCustomerID.getText());
                if (Backend_DAO_DB.get_bdl_singleton().getAllCustomers().get(id) != null) {
                    throw new MyExpetion("הלקוח קיים");
                }
                Customer customer = new Customer(id, TextName.getText(),
                        TextAddress.getText());
                Backend_DAO_DB.get_bdl_singleton().AddCustomer(customer);
                JOptionPane.showMessageDialog(
                        AddNewCustomerForm.this, "הלקוח נוסף בהצלחה", "אישור", JOptionPane.HEIGHT);
                store.getplaceOrderForm().AddCustomer(customer);
                store.viewPurchasesForm.comboBoxModelCustomers.addElement(customer);
            } catch (MyExpetion ex) {
                JOptionPane.showMessageDialog(
                        AddNewCustomerForm.this, ex.getMessage(), "!שגיאה", JOptionPane.HEIGHT);
            }
            catch (SQLIntegrityConstraintViolationException ex)
            {
                JOptionPane.showMessageDialog(
                        AddNewCustomerForm.this, "הלקוח קיים", "!שגיאה", JOptionPane.HEIGHT);
            }
            catch (Exception ex) {
                Logger.getLogger(AddNewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

    }

}
