/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class StudentInfoFrame extends javax.swing.JFrame {
    
    private String name;
    private DatabaseHandler dbHandler;



    public StudentInfoFrame(String name) {
        initComponents();
        retrieveAndDisplayData(name);
        this.name = name;
        try {
        dbHandler.connect("jdbc:mysql://localhost:3306/guidance_management_system", "root", "");
        } catch (SQLException ex) {
            // Handle exceptions
        }
    }
    
     public String getName() {
        return name;
    }
    
    
//private void displayDataOnTable() {
//    // Create the column names for the table
//    String[] columnNames = {"Date Occurred", "Misconduct", "Reported By"};
//
//    // Create a DefaultTableModel with the column names
//    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//    try {
//        // Create a PreparedStatement to execute the SQL query
//        String query = "SELECT date_occurred, misconduct, reported_by FROM student WHERE Name=?";
//        PreparedStatement pstmt = dbHandler.getConnection().prepareStatement(query);
//        pstmt.setString(1, name);
//
//        // Execute the query and get the ResultSet
//        ResultSet rs = pstmt.executeQuery();
//
//        // Iterate through the ResultSet and add rows to the model
//        while (rs.next()) {
//            String dateOccurred = rs.getString("date_occurred");
//            String misconduct = rs.getString("misconduct");
//            String reportedBy = rs.getString("reported_by");
//
//            // Create an array of data for each row
//            Object[] rowData = {dateOccurred, misconduct, reportedBy};
//
//            // Add the row to the model
//            model.addRow(rowData);
//        }
//
//        // Set the model for the JTable
//        table.setModel(model);
//
//        // Close the ResultSet and PreparedStatement
//        rs.close();
//        pstmt.close();
//
//    } catch (SQLException ex) {
//        // Handle any SQL errors
//        ex.printStackTrace();
//    }
//}



    
public void retrieveAndDisplayData(String name) {
    try {
        // Establish a database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guidance_management_system", "root", "");
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student WHERE name = ?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        // Process the retrieved data and update the JTextFields
        if (rs.next()) {
            // Retrieve the data from the result set
            int grade = rs.getInt("grade");
            String section = rs.getString("section");
            String strand = rs.getString("strand");
            String lrn = rs.getString("lrn");
            String address = rs.getString("address");
            String email = rs.getString("email");
            String dob = rs.getString("dob");
            String gender = rs.getString("gender");
            String contactNumber = rs.getString("contact_number");
            String emergencyName = rs.getString("emergency_name");
            String emergencyContactNumber = rs.getString("emergency_contact_number");
            String emergencyAddress = rs.getString("emergency_address");
            String emergencyEmail = rs.getString("emergency_email");
            String relationshipToStudent = rs.getString("relationship_to_student");

            // Update the JTextFields with the retrieved data
            nameTextField.setText(name);
            gradeTextField.setText(String.valueOf(grade));
            sectionTextField.setText(section);
            strandTextField.setText(strand);
            lrnTextField.setText(lrn);
            addressTextField.setText(address);
            emailTextField.setText(email);
            dobTextField.setText(dob);
            genderTextField.setText(gender);
            contactNumberTextField.setText(contactNumber);
            emergencyNameTextField.setText(emergencyName);
            emergencyContactNumberTextField.setText(emergencyContactNumber);
            emergencyAddressTextField.setText(emergencyAddress);
            emergencyEmailTextField.setText(emergencyEmail);
            relationshipToStudentTextField.setText(relationshipToStudent);
        }
            
        Blob imageBlob = rs.getBlob("image");
      if (imageBlob != null) {
          // Convert the Blob to bytes
          byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());

          // Create an ImageIcon from the byte array
          ImageIcon imageIcon = new ImageIcon(imageData);

          // Scale the ImageIcon to fit the label
          Image image = imageIcon.getImage();
          Image scaledImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);

          // Update the existing JLabel with the scaled image
          imageLabel.setIcon(new ImageIcon(scaledImage));
      } else {
          // No image data found, set the default blank picture
        String defaultImagePath = "/Asset/Blank.png";
        ImageIcon defaultImageIcon = new ImageIcon(getClass().getResource(defaultImagePath));
        Image defaultImage = defaultImageIcon.getImage();
        Image scaledDefaultImage = defaultImage.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledDefaultImage));
      }

        
        // Close the result set, statement, and connection
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception appropriately
    }
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();
        namelbl = new javax.swing.JLabel();
        gradelbl = new javax.swing.JLabel();
        sectionlbl = new javax.swing.JLabel();
        strandlbl = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        gradeTextField = new javax.swing.JTextField();
        sectionTextField = new javax.swing.JTextField();
        strandTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        dobTextField = new javax.swing.JTextField();
        genderTextField = new javax.swing.JTextField();
        contactNumberTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        emergencyNameTextField = new javax.swing.JTextField();
        emergencyContactNumberTextField = new javax.swing.JTextField();
        emergencyAddressTextField = new javax.swing.JTextField();
        emergencyEmailTextField = new javax.swing.JTextField();
        relationshipToStudentTextField = new javax.swing.JTextField();
        strandlbl1 = new javax.swing.JLabel();
        lrnTextField = new javax.swing.JTextField();
        backbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnImage.setText("Choose");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        namelbl.setText("Name:");

        gradelbl.setText("Grade:");

        sectionlbl.setText("Section:");

        strandlbl.setText("Strand:");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date Occured", "Misconduct", "Reported By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("STUDENT RECORD");

        jLabel2.setText("Address:");

        jLabel3.setText("Email Address:");

        jLabel4.setText("Date Of Birth:");

        jLabel5.setText("Gender:");

        jLabel6.setText("Contact Number:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("STUDENT EMERGENCY CONTACT");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText(" STUDENT INFORMATION");

        jLabel9.setText("Name:");

        jLabel10.setText("Contact Number:");

        jLabel11.setText("Address:");

        jLabel12.setText("Email Address:");

        jLabel13.setText("Relationship to the student:");

        relationshipToStudentTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relationshipToStudentTextFieldActionPerformed(evt);
            }
        });

        strandlbl1.setText("LRN:");

        backbutton.setText("Back");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(207, 207, 207))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(gradelbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(gradeTextField))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(namelbl)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                        .addComponent(jLabel7)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(emergencyNameTextField))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(emergencyAddressTextField))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(emergencyContactNumberTextField))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(emergencyEmailTextField))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(relationshipToStudentTextField))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(sectionlbl)
                                                .addComponent(strandlbl)
                                                .addComponent(strandlbl1))
                                            .addGap(4, 4, 4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lrnTextField)
                                                .addComponent(strandTextField)
                                                .addComponent(sectionTextField))))
                                    .addComponent(backbutton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emailTextField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dobTextField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(genderTextField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(contactNumberTextField)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnImage)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(backbutton)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namelbl)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gradelbl)
                            .addComponent(gradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sectionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectionlbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(strandlbl)
                            .addComponent(strandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(strandlbl1)
                            .addComponent(lrnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImage)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(emergencyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(emergencyContactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(emergencyAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(emergencyEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(relationshipToStudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed

    }//GEN-LAST:event_btnImageActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void relationshipToStudentTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relationshipToStudentTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relationshipToStudentTextFieldActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
            int choice = JOptionPane.showConfirmDialog(StudentInfoFrame.this, "Are you sure you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            // Hide the current StudentInfoFrame
            setVisible(false);
            
            // Show the Homepage frame again
            Homepage homepageFrame = new Homepage();
            homepageFrame.setVisible(true);
        }
    }//GEN-LAST:event_backbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton backbutton;
    private javax.swing.JButton btnImage;
    private javax.swing.JTextField contactNumberTextField;
    private javax.swing.JTextField dobTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField emergencyAddressTextField;
    private javax.swing.JTextField emergencyContactNumberTextField;
    private javax.swing.JTextField emergencyEmailTextField;
    private javax.swing.JTextField emergencyNameTextField;
    private javax.swing.JTextField genderTextField;
    private javax.swing.JTextField gradeTextField;
    private javax.swing.JLabel gradelbl;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lrnTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel namelbl;
    private javax.swing.JTextField relationshipToStudentTextField;
    private javax.swing.JTextField sectionTextField;
    private javax.swing.JLabel sectionlbl;
    private javax.swing.JTextField strandTextField;
    private javax.swing.JLabel strandlbl;
    private javax.swing.JLabel strandlbl1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
