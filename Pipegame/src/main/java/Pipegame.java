/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Pipegame extends Message{
    String message;
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
    public static void main(String[] args) {//Untuk memulai program mulai dari sini run-nya!! ok... OK!
        Pipegame pipegame = new Pipegame();
        pipegame.setMessage("Program Pipegame dimulai!!");
        Login Login = new Login();
        Login.setVisible(true);
        Login.pack();
        Login.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(Login, pipegame.getMessage());
    }
}
