package storemanagerguiview;

import controller.Backend_DAO_DB;
import controller.Backend_DAO_List;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.EnumOfComobox;
import model.HardwareProduct;
import model.Product;
import model.SoftwareProduct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user1
 */
public class AddNewProductForm extends javax.swing.JFrame {
    ManageCatalogForm _managerform;
    DefaultComboBoxModel <model.EnumOfComobox> comoboxModel;
    /**
     * Creates new form AddNewProductForm
     */
    public void clear(){
        Description.setText("");
        Price.setText("");
        Name.setText("");
        jTextField1.setText("");
        TextId.setText("");
    }

  public AddNewProductForm(ManageCatalogForm Manager) {
       comoboxModel= new DefaultComboBoxModel<>(model.EnumOfComobox.values());
       _managerform=Manager;
        initComponents();
          Types.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Description = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Types = new javax.swing.JComboBox<>();
        OfType = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextId = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(200, 50));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Product information ");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1133, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Product Name:");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Description:");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Price per item:");

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Description.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Description.setToolTipText("");
        Description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionActionPerformed(evt);
            }
        });

        Price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceActionPerformed(evt);
            }
        });
        Price.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!((e.getKeyChar()<='9' && e.getKeyChar() >= '0')||e.getKeyChar()=='.')) {
                    e.consume();
                }
            }

        });

        Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Types.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Types.setForeground(new java.awt.Color(0, 102, 102));
        Types.setModel(comoboxModel);
        Types.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypesActionPerformed(evt);
            }
        });
        Types.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TypesKeyPressed(evt);
            }
        });

        OfType.setText(String.valueOf(Types.getSelectedIndex()));
        OfType.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        OfType.setForeground(new java.awt.Color(0, 102, 102));
        OfType.setText("  ");

        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() > '9' || e.getKeyChar() < '0') {
                    e.consume();
                }
            }

        });
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        jLabel5.setText("type of product");

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Id Product");

        TextId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() > '9' || e.getKeyChar() < '0') {
                    e.consume();
                }
            }

        });
        TextId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Types, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 515, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(OfType, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                            .addComponent(Price)
                            .addComponent(Description)
                            .addComponent(Name)
                            .addComponent(TextId))
                        .addGap(107, 107, 107))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(TextId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(14, 14, 14)
                        .addComponent(OfType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Types, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionActionPerformed

    private void PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceActionPerformed
    private boolean IsSoft(){
     return "SOFTWARE".equals(Types.getSelectedItem().toString());
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
             if (jTextField1.getText().length() == 0 || Name.getText().length() == 0
                        || Description.getText().length() == 0) {
                    throw new MyExpetion("חובה למלא את כל הפרטים!");
                }
             if(TextId.getText().length()!=9)
                 throw new MyExpetion("קוד המוצר חייב להיות בעל 9 ספרות!");
             TryAdd();
        }
        catch(MyExpetion ex)
        {
            JOptionPane.showMessageDialog(
                        AddNewProductForm.this, ex.getMessage(),  "!שגיאה", JOptionPane.HEIGHT);
        } catch (Exception ex) {
            Logger.getLogger(AddNewProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       

    }//GEN-LAST:event_jButton1ActionPerformed
    private void TryAdd() {
        boolean b = false;
        Product p;
        if (IsSoft()) {
            p = new SoftwareProduct(
                    Integer.parseInt(jTextField1.getText()),Long.parseLong(TextId.getText()), Name.getText(),
                    Description.getText(), Float.parseFloat(Price.getText()));
        } else {
            p = new HardwareProduct(
                    Integer.parseInt(jTextField1.getText()), Long.parseLong(TextId.getText()), Name.getText(),
                    Description.getText(), Float.parseFloat(Price.getText()));
        }

        try {
            Object[] listP = Backend_DAO_DB.get_bdl_singleton()
                    .getAllProducts().toArray();
            for (Object object : listP) {
                if (object instanceof Product && ((Product) object).equals(p)) {
                    JOptionPane.showMessageDialog(
                            AddNewProductForm.this, "ההוספה נכשלה המוצר קיים", "אישור", JOptionPane.HEIGHT);
                    b = true;
                    break;
                }
            }
            if (!b) {
                Backend_DAO_DB.get_bdl_singleton().AddProduct(p);
                JOptionPane.showMessageDialog(
                        AddNewProductForm.this, "המוצר נוסף בהצלחה", "אישור", JOptionPane.HEIGHT);
                _managerform.Refresh(); 
                _managerform.store.placeOrderForm.AddProduct(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddNewProductForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            b = false;
        }
    }
    private void TypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypesActionPerformed
        // TODO add your handling code here:
       OfType.setText((Types.getSelectedItem().toString()=="SOFTWARE")?"Number of users:":"warranty period:");
    }//GEN-LAST:event_TypesActionPerformed

    private void TypesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TypesKeyPressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_TypesKeyPressed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Description.setText("");
        Price.setText("");
        Name.setText("");
        jTextField1.setText("");
        TextId.setText("");

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        jPanel1.setBackground(new Color(146, 146, 146));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        // TODO add your handling code here:
        jPanel1.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_jPanel1MouseExited

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Description;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel OfType;
    private javax.swing.JTextField Price;
    private javax.swing.JTextField TextId;
    private javax.swing.JComboBox<EnumOfComobox> Types;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

   
}
