/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;

import java.util.Random;
/**
 *
 * @author LENOVO
 */
public class Ingame extends javax.swing.JFrame {

    /**
     * Creates new form Ingame
     */
    public Ingame() {
        initComponents();
    }
    String jenisLevel;
    public Ingame(String jenisLevel) {
        this.jenisLevel=jenisLevel;
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JLabel pipa[] = new JLabel[45];

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(50, 30, 100, 30);

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nama_Level");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 30, 440, 40);

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Putaran : 17");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(540, 20, 210, 40);

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jButton2.setText("Ulangi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(50, 70, 100, 30);
        for(int i=0;i<45;i++){
            String png = ""; String text = "";
            if(i==0){
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\startPipe.png";
                text = "start";
            }else if(i==44){
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\finishPipe.png";
                text = "finish";
            }
            else if(jenisLevel=="Level1"){
                if((i>=41 && i<=43) || (i>=1 && i<=3) ){
                    png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\horPipe.png";
                    text = "hor";
                }else if(i==13 || i==22 || i==31){
                    png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\verPipe.png";
                    text = "ver";
                }else if(i==4){
                    png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\LDPipe.png";
                    text = "LD";
                }else if(i==40){
                    png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\RUPipe.png";
                    text = "RU";
                }else{
                    png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\whiteWall.png";
                    text = "wall";
                }
            }
            else if(jenisLevel=="Randomizer"){
                Random rand = new Random();
                int random = rand.nextInt(2);
                if(random==1){
                    random = rand.nextInt(2);
                    if(random==1){
                        png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\verPipe.png";
                        text = "ver";
                    }else{
                        png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\horPipe.png";
                        text = "hor";
                    }
                }
                else{
                    random = rand.nextInt(4);
                    if(random==1){
                        png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\RDPipe.png";
                        text = "RD";
                    }else if(random==2){
                        png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\LDPipe.png";
                        text = "LD";
                    }else if(random==3){
                        png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\LUPipe.png";
                        text = "LU";
                    }else{
                        png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\RUPipe.png";
                        text = "RU";
                    }
                }
            }
            pipa[i] = new javax.swing.JLabel();
            pipa[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            pipa[i].setIcon(new javax.swing.ImageIcon(png)); // NOI18N
            final int j = i;
            pipa[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(pipa[j].getText()=="ver"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\horPipe.png"));
                        pipa[j].setText("hor");
                    }
                    else if(pipa[j].getText()=="hor"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\verPipe.png"));
                        pipa[j].setText("ver");
                    }
                    else{
                        
                    }
                }
            });
            pipa[i].setText(text);
            pipa[i].setPreferredSize(new java.awt.Dimension(70, 70));
            jPanel2.add(pipa[i]);
        }
        

        jPanel1.add(jPanel2);
        jPanel2.setBounds(50, 140, 680, 380);

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Waktu : 00:25.98");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(540, 60, 210, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int jawab = JOptionPane.showOptionDialog(this, "Apakah anda yakin ingin keluar?", "Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    
    if(jawab == JOptionPane.YES_OPTION){
        MainMenu MainMenu = new MainMenu();
        MainMenu.setVisible(true);
        MainMenu.pack();
        MainMenu.setLocationRelativeTo(null);
        this.dispose();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Ingame Ingame = new Ingame(jenisLevel);
        Ingame.setVisible(true);
        Ingame.pack();
        Ingame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JLabel pipa[];
    // End of variables declaration//GEN-END:variables
}
