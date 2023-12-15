/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;
/**
 *
 * @author LENOVO
 */
public class Ingame extends javax.swing.JFrame {
    private int id;
    private String jenisLevel;
    private static int putaran = 0;
    private static double waktu = 0.0;
    private static boolean threadOn = false;
    private static DecimalFormat decimalFormat = new DecimalFormat("0.0");
    private static JLabel pipa[] = new JLabel[45];
    public static double getWaktu() {
        return waktu;
    }
    public static void setWaktu(double waktu) {
        Ingame.waktu = waktu;
    }
    public static boolean isThreadOn() {
        return threadOn;
    }
    public static void setThreadOn(boolean threadOn) {
        Ingame.threadOn = threadOn;
    }
    public static void aturWaktu(){
        jLabel3.setText("Waktu : " + decimalFormat.format(waktu));
    }
    public static void reshuffle(JLabel pipa){
        Random rand = new Random();
        int random1 = rand.nextInt(2);
        int random2 = rand.nextInt(4);
        String png = "";
        String text = "";
        if(pipa.getText()=="startH" || pipa.getText()=="finishH" || pipa.getText()=="startV" || pipa.getText()=="finishV" || pipa.getText()=="wall"){
            return;
        }
        else if(pipa.getText()=="ver" || pipa.getText()=="hor"){
            if(random1==1){
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\verPipe.png";
                text = "ver";
            }else{
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\horPipe.png";
                text = "hor";
            }
        }else if(pipa.getText()=="RD" || pipa.getText()=="LD" || pipa.getText()=="LU" || pipa.getText()=="RU"){
            if(random2==1){
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\RDPipe.png";
                text = "RD";
            }else if(random2==2){
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\LDPipe.png";
                text = "LD";
            }else if(random2==3){
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\LUPipe.png";
                text = "LU";
            }else{
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\RUPipe.png";
                text = "RU";
            }
        }
        pipa.setIcon(new javax.swing.ImageIcon(png));
        pipa.setText(text);
    }
    public static JLabel[] getallpipa(){
        return pipa;
    }
    public void menang(int panjang){
        int nilai = 10000 + putaran*(-100)+panjang*250+(int)Math.round(waktu*-50);//setiap putaran - 100, panjang pipa +250, dan waktu/detik -50
        JOptionPane.showMessageDialog(this, "Anda Menang dengan score "+nilai);
        ThreadCek.setCount();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pipegame?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            Statement st = con.createStatement();
            String query = "INSERT INTO record(id,jenislevel,putaran,waktu,ppipa,nilai) VALUES ('"+id+"','"+jenisLevel+"','"+putaran+"','"+decimalFormat.format(waktu)+"','"+panjang+"','"+nilai+"')";
            st.executeUpdate(query);
            query = "UPDATE profil SET jmain = jmain + 1 , jmenang = jmenang + 1 WHERE id = '"+id+"'";
            st.executeUpdate(query);
            if(jenisLevel == "Level 1"){
                query = "UPDATE profil SET rlevel = 1 WHERE id = '"+id+"'";
                st.executeUpdate(query);
            }
            int jawab = JOptionPane.showOptionDialog(this, "Apakah anda ingin mengulanginya?", "Main lagi?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(jawab == JOptionPane.YES_OPTION){
                putaran = 0;
                waktu = 0;
                Ingame Ingame = new Ingame(jenisLevel,id);
                Ingame.setVisible(true);
                Ingame.pack();
                Ingame.setLocationRelativeTo(null);
                this.dispose();
            }
            else{
                putaran = 0;
                waktu = 0;
                MainMenu MainMenu = new MainMenu(id);
                MainMenu.setVisible(true);
                MainMenu.pack();
                MainMenu.setLocationRelativeTo(null);
                this.dispose();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * Creates new form Ingame
     */
    public Ingame() {
        initComponents();
    }
    
    public Ingame(String jenisLevel,int id) {
        this.jenisLevel = jenisLevel;
        this.id = id;
        initComponents();
        ThreadWaktu threadWaktu = new ThreadWaktu();
        threadOn = true;
        ThreadCek threadCek = new ThreadCek(this);
        threadWaktu.start();
        threadCek.start();
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
        jLabel1.setText(jenisLevel);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 30, 440, 40);

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Putaran : " + putaran);
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
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\startHPipe.png";
                text = "startH";
            }else if(i==44){
                png = "C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\finishHPipe.png";
                text = "finishH";
            }
            else if(jenisLevel=="Level 1"){
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
                public void mousePressed(MouseEvent e) {
                    if(pipa[j].getText()=="ver"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\horPipe.png"));
                        pipa[j].setText("hor");
                    }else if(pipa[j].getText()=="hor"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\verPipe.png"));
                        pipa[j].setText("ver");
                    }else if(pipa[j].getText()=="RD"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\RUPipe.png"));
                        pipa[j].setText("RU");
                    }else if(pipa[j].getText()=="RU"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\LUPipe.png"));
                        pipa[j].setText("LU");
                    }else if(pipa[j].getText()=="LU"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\LDPipe.png"));
                        pipa[j].setText("LD");
                    }else if(pipa[j].getText()=="LD"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\RDPipe.png"));
                        pipa[j].setText("RD");
                    }else if(pipa[j].getText()=="startV"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\startHPipe.png"));
                        pipa[j].setText("startH");
                    }else if(pipa[j].getText()=="startH"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\startVPipe.png"));
                        pipa[j].setText("startV");
                    }else if(pipa[j].getText()=="finishV"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\finishHPipe.png"));
                        pipa[j].setText("finishH");
                    }else if(pipa[j].getText()=="finishH"){
                        pipa[j].setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Pipegame\\src\\main\\icon\\finishVPipe.png"));
                        pipa[j].setText("finishV");
                    }
                    if(pipa[j].getText()!="wall"){
                        putaran++;
                    }
                    jLabel2.setText("Putaran : " + putaran);
                }
            });
            pipa[i].setText(text);
            if(jenisLevel!="Randomizer"){
                reshuffle(pipa[i]);
            }
            pipa[i].setPreferredSize(new java.awt.Dimension(70, 70));
            jPanel2.add(pipa[i]);
        }

        jPanel1.add(jPanel2);
        jPanel2.setBounds(50, 140, 680, 380);

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Waktu : " + waktu);
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
            threadOn = false;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pipegame?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
                Statement st = con.createStatement();
                String query = "UPDATE profil SET jmain = jmain + 1 , jkalah = jkalah + 1 WHERE id = '"+id+"'";
                st.executeUpdate(query);
            }catch(Exception e){
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(this, "Anda telah keluar dari game");
            putaran = 0;
            waktu = 0;
            MainMenu MainMenu = new MainMenu(id);
            MainMenu.setVisible(true);
            MainMenu.pack();
            MainMenu.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        threadOn = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pipegame?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            Statement st = con.createStatement();
            String query = "UPDATE profil SET jmain = jmain + 1 , jkalah = jkalah + 1 WHERE id = '"+id+"'";
            st.executeUpdate(query);
        }catch(Exception e){
                System.out.println(e);
        }
        JOptionPane.showMessageDialog(this, "Anda telah mengulangi game");
        putaran = 0;
        waktu = 0;
        Ingame Ingame = new Ingame(jenisLevel,id);
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
    private static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
