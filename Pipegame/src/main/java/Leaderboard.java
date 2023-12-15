/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public class Leaderboard extends javax.swing.JFrame {
    int id;
    /**
     * Creates new form Leaderboard
     */
    public Leaderboard() {
        initComponents();
    }
    public Leaderboard(int id) {
        this.id = id;
        int i = 0;
        int level1Count = 0;
        int randomizerCount = 0;
        int score[] = new int[13];
        int scoreR[] = new int[13];
        String username[] = new String[13];
        String usernameR[] = new String[13];
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pipegame?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            Statement st = con.createStatement();
            String query = "SELECT username,nilai FROM record, user WHERE user.id = record.id AND jenislevel = 'Level 1' ORDER BY nilai DESC limit 13";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                username[i] = rs.getString("username");
                score[i] = rs.getInt("nilai");
                i++;
            }
            level1Count = i;
            i = 0;
            query = "SELECT username,nilai FROM record, user WHERE user.id = record.id AND jenislevel = 'Randomizer' ORDER BY nilai DESC limit 13";
            rs = st.executeQuery(query);
            while(rs.next()){
                usernameR[i] = rs.getString("username");
                scoreR[i] = rs.getInt("nilai");
                i++;
            }
            randomizerCount = i;

        }catch(Exception e){
            System.out.println(e);
        }

        initComponents();

        JLabel[] topLevel1 = new JLabel[13];
        JLabel[] topRandomizer = new JLabel[13];

        for(i=0;i<level1Count;i++){
            topLevel1[i] = new javax.swing.JLabel();
            topLevel1[i].setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
            topLevel1[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            topLevel1[i].setText(i+1+". "+username[i]+" | "+score[i]+"");
            topLevel1[i].setPreferredSize(new java.awt.Dimension(200, 17));
            jPanel4.add(topLevel1[i]);
        }
        for(i=0;i<randomizerCount;i++){
            topRandomizer[i] = new javax.swing.JLabel();
            topRandomizer[i].setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
            topRandomizer[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            topRandomizer[i].setText(i+1+". "+usernameR[i]+" | "+scoreR[i]+"");
            topRandomizer[i].setPreferredSize(new java.awt.Dimension(200, 17));
            jPanel5.add(topRandomizer[i]);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Leaderboard");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 10, 160, 40);

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Level 1");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 60, 140, 22);

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Randomizer");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 60, 140, 22);

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 20, 90, 22); 

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 90, 220, 290);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(260, 90, 220, 290);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu MainMenu = new MainMenu(id);
        MainMenu.setVisible(true);
        MainMenu.pack();
        MainMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
