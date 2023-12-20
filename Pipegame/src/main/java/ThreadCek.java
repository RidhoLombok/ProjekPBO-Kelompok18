import javax.swing.JLabel;

public class ThreadCek extends Thread{
    private Ingame ingame;
    public ThreadCek(Ingame ingame){
        this.ingame=ingame;
    }
    public void run(){
        JLabel pipa[] = new JLabel[45];// untuk mengambil seluruh label pipa/tembok dari class Ingame
        JLabel current, currentB; // untuk pengecek jalur pipa, currentB adalah current before
        int panjang = 0;// untuk panjang pipa dari start hingga finish
        boolean ketemu = false;// untuk menyatakan ketemu taua tidak
        while (ketemu!=true && Ingame.isThreadOn()) {// selama belum ketemu dan thread masuh nyala
            panjang = 0; // untuk diatur kembali menjadi 0
            int currentNumber = 0;// untuk nomor index dari current
            int currentBNumber = 0;// untuk nomor index dari current before / sebelum
            pipa = Ingame.getallpipa();// mengambil seluruh pipa dan tembok
            current = currentB = pipa[0];// mengatur lokasi ke 0 atau start semua current
            while(true){//melakukan perulangan tanpa syarat
                if(currentB.getText()=="finishH" || currentB.getText()=="finishV"){// jika current before di pipa finish
                    ketemu = true;// KETEMU
                    break;// pengecekan selesai karena sudah ketemu
                }else if(current.getText()=="finishV"){// jika current di pipa finish ver
                    if(currentBNumber==currentNumber-9){// jika current before berada di atas current
                        currentB=current;// current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                    }
                    else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="finishH" ){// jika current di pipa finish hor
                    if(currentBNumber==currentNumber-1){// jika current before berada di kiri current
                        currentB=current;// current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                    }
                    else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="startH"){// jika current di pipa start hor
                    currentB=current;// current before ke posisi current
                    currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                    currentNumber+=1;// nomor indeks current ditambah 1 sehingga ke kanan
                    current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                }else if(current.getText()=="startV"){// jika current di pipa start ver
                    currentB=current;// current before ke posisi current
                    currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                    currentNumber+=9;// nomor indeks current ditambah 9 sehingga ke bawah
                    current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                }else if(current.getText()=="ver"){// jika current di pipa ver
                    if((currentNumber >= 0 && currentNumber <= 8) || (currentNumber >= 36 && currentNumber <= 44)){//jika di ujung atas atau bawah
                        break;// ulangi pengecekan
                    }else if(currentBNumber==currentNumber-9){// jika current before berada di atas current
                        currentB=current;// current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber+=9;// nomor indeks current ditambah 9 sehingga ke bawah// ke bawah
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else if(currentBNumber==currentNumber+9){// jika current before berada di bawah current
                        currentB=current;// current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber-=9;// nomor indeks current dikurang 9 sehingga ke atas
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="hor"){// jika current di pipa hor
                    if(currentNumber % 9 == 0 || currentNumber % 9 == 8){// jika di ujung kiri atau kanan
                        break;// ulangi pengecekan
                    }else if(currentBNumber==currentNumber-1){// jika current before berada di kiri current
                        currentB=current;// current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber+=1;// nomor indeks current ditambah 1 sehingga ke kanan
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru// mengatur current ke posisi indeks current baru
                    }else if(currentBNumber==currentNumber+1){// jika current before berada di kanan current
                        currentB=current;// current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber-=1;// nomor indeks current dikurang 1 sehingga ke kiri
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="RD"){// jika current di pipa belok right down
                    if((currentNumber >= 36 && currentNumber <= 44) || currentNumber % 9 == 8){// jika di ujung kanan atau bawah
                        break;// ulangi pengecekan
                    }else if(currentBNumber==currentNumber+9){// jika current before berada di bawah current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber+=1;// nomor indeks current ditambah 1 sehingga ke kanan
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else if(currentBNumber==currentNumber+1){// jika current before berada di kanan current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber+=9;// nomor indeks current ditambah 9 sehingga ke bawah
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="LD"){// jika current di pipa belok left down
                    if(currentNumber % 9 == 0 || (currentNumber >= 36 && currentNumber <= 44)){// jika di ujung kiri atau bawah
                        break;// ulangi pengecekan
                    }else if(currentBNumber==currentNumber+9){// jika current before berada di bawah current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber-=1;// nomor indeks current dikurang 1 sehingga ke kiri
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else if(currentBNumber==currentNumber-1){// jika current before berada di kiri current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber+=9;// nomor indeks current ditambah 9 sehingga ke bawah
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="LU"){// jika current di pipa belok left up
                    if(currentNumber % 9 == 0 || (currentNumber >= 0 && currentNumber <= 8)){// jika di unjung kiri atau atas
                        break;// ulangi pengecekan
                    }else if(currentBNumber==currentNumber-9){//jika current before di atas current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber-=1;// nomor indeks current dikurang 1 sehingga ke kiri
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else if(currentBNumber==currentNumber-1){// jika current before berada di kiri current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber-=9;// nomor indeks current dikurang 9 sehingga ke atas
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="RU"){// jika current di pipa belok right up
                    if((currentNumber >= 0 && currentNumber <= 8) || currentNumber % 9 == 8){// jika di ujung kanan atau atas
                        break;// ulangi pengecekan
                    }else if(currentBNumber==currentNumber-9){//jika current before di atas current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber+=1;// nomor indeks current ditambah 1 sehingga ke kanan
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else if(currentBNumber==currentNumber+1){// jika current before berada di kanan current
                        currentB=current;//current before ke posisi current
                        currentBNumber=currentNumber;// nomor indeks current before sama dengan current
                        currentNumber-=9;// nomor indeks current dikurang 9 sehingga ke atas
                        current=pipa[currentNumber];// mengatur current ke posisi indeks current baru
                    }else{
                        break;// ulangi pengecekan
                    }
                }else if(current.getText()=="wall"){
                    break;// ulangi pengecekan
                }
                panjang++;
            }
            try{
                Thread.sleep(100);// setiap 0.1 detik diulang
            }catch(Exception e) {
            }
        }
        if(Ingame.isThreadOn()){// jika thread masih menyala di class Ingame
            Ingame.setThreadOn(false);// matikan
            ingame.dispose();
            ingame.menang(panjang);//memanggil menang dengan membawa panjang dari pipanya
        }
    }
}
