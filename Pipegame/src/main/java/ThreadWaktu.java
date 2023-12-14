import javax.swing.*;
public class ThreadWaktu extends Thread{
    public void run(){
        while (Ingame.isThreadOn()) {
            Ingame.setWaktu(0.1+Ingame.getWaktu());
            Ingame.aturWaktu();
            try {
                Thread.sleep(100);
            }catch(Exception e) {
            }
        }
        Ingame.setThreadOn(false);
    }
}
