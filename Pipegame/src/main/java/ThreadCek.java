import javax.swing.JLabel;

public class ThreadCek extends Thread{
    private Ingame ingame;
    private static int count = 0;
    public ThreadCek(Ingame ingame){
        this.ingame=ingame;
    }
    public static void setCount(){
        count=0;
    }
    public void run(){
        JLabel pipa[] = new JLabel[45];
        JLabel current, currentB;
        int panjang = 0;
        boolean ketemu = false;
        while (ketemu!=true && Ingame.isThreadOn()) {
            panjang = 0;
            int currentNumber = 0;
            int currentBNumber = 0;
            pipa = Ingame.getallpipa();
            current = currentB = pipa[0];
            while(current.getText()!="finishH" || current.getText()!="finishV"){//tetap true walaupun salah satu true
                if(currentB.getText()=="finishH" || currentB.getText()=="finishV"){
                    ketemu = true;
                    break;
                }else if(current.getText()=="finishV"){
                    if(currentBNumber==currentNumber-9){
                        currentB=current;
                        currentBNumber=currentNumber;
                    }
                    else{
                        break;
                    }
                }else if(current.getText()=="finishH" ){
                    if(currentBNumber==currentNumber-1){
                        currentB=current;
                        currentBNumber=currentNumber;
                    }
                    else{
                        break;
                    }
                }else if(current.getText()=="startH"){
                    currentB=current;
                    currentBNumber=currentNumber;
                    currentNumber+=1;
                    current=pipa[currentNumber];
                }else if(current.getText()=="startV"){
                    currentB=current;
                    currentBNumber=currentNumber;
                    currentNumber+=9;
                    current=pipa[currentNumber];
                }else if(current.getText()=="ver"){
                    if((currentNumber >= 0 && currentNumber <= 8) || (currentNumber >= 36 && currentNumber <= 44)){
                        break;
                    }else if(currentBNumber==currentNumber-9){//jika CurrB di atas Curr
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber+=9;//ke bawah
                        current=pipa[currentNumber];
                    }else if(currentBNumber==currentNumber+9){//jika CurrB di bawah Curr
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber-=9;//ke atas
                        current=pipa[currentNumber];
                    }else{
                        break;
                    }
                }else if(current.getText()=="hor"){
                    if(currentNumber % 9 == 0 || currentNumber % 9 == 8){
                        break;
                    }else if(currentBNumber==currentNumber-1){//jika CurrB di kiri Curr
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber+=1;//ke kanan
                        current=pipa[currentNumber];
                    }else if(currentBNumber==currentNumber+1){//jika CurrB di kanan Curr
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber-=1;//ke kiri
                        current=pipa[currentNumber];
                    }else{
                        break;
                    }
                }else if(current.getText()=="RD"){
                    if((currentNumber >= 36 && currentNumber <= 44) || currentNumber % 9 == 8){
                        break;
                    }else if(currentBNumber==currentNumber+9){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber+=1;
                        current=pipa[currentNumber];
                    }else if(currentBNumber==currentNumber+1){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber+=9;
                        current=pipa[currentNumber];
                    }else{
                        break;
                    }
                }else if(current.getText()=="LD"){
                    if(currentNumber % 9 == 0 || (currentNumber >= 36 && currentNumber <= 44)){
                        break;
                    }else if(currentBNumber==currentNumber+9){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber-=1;
                        current=pipa[currentNumber];
                    }else if(currentBNumber==currentNumber-1){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber+=9;
                        current=pipa[currentNumber];
                    }else{
                        break;
                    }
                }else if(current.getText()=="LU"){
                    if(currentNumber % 9 == 0 || (currentNumber >= 0 && currentNumber <= 8)){
                        break;
                    }else if(currentBNumber==currentNumber-9){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber-=1;
                        current=pipa[currentNumber];
                    }else if(currentBNumber==currentNumber-1){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber-=9;
                        current=pipa[currentNumber];
                    }else{
                        break;
                    }
                }else if(current.getText()=="RU"){
                    if((currentNumber >= 0 && currentNumber <= 8) || currentNumber % 9 == 8){
                        break;
                    }else if(currentBNumber==currentNumber-9){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber+=1;
                        current=pipa[currentNumber];
                    }else if(currentBNumber==currentNumber+1){
                        currentB=current;
                        currentBNumber=currentNumber;
                        currentNumber-=9;
                        current=pipa[currentNumber];
                    }else{
                        break;
                    }
                }else if(current.getText()=="wall"){
                    break;
                }
                panjang++;
            }
            
            try{
                Thread.sleep(100);
            }catch(Exception e) {
            }
        }
        if(Ingame.isThreadOn()){
            Ingame.setThreadOn(false);
            count++;
            ingame.dispose();
            if(count==1){
                ingame.menang(panjang);
            }
        }
        //System.out.println("count "+ count);memastikan semua thread mati
    }
}
