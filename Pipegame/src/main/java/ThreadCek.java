public class ThreadCek {
    public void run(){
        while (Ingame.isThreadOn()) {
            Ingame.setWaktu(0.1+Ingame.getWaktu());
            Ingame.aturWaktu();
            try {
                Thread.sleep(10);
            }catch(Exception e) {
            }
        }
        Ingame.setThreadOn(false);
    }
}
