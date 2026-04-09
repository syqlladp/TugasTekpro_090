class Account{              // shared resource (data bersama)
    int balance = 150;      // Menyimpan saldo awal saldo awal
}

public class TransferFulus{
    public static void main(String[] args) throws InterruptedException{
        Account acc1 = new Account();    // membuat objek akun 1 
        Account acc2 = new Account();    // membuat objek akun 2 

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(()-> {
            synchronized (acc1) { // Berikan komentar apa yang dilakukan pada blok ini?
                    System.out.println("Thread 1 mengunci acc1");
                    try{Thread.sleep(100);} catch(Exception e){} //Simulasi dengan memberikan jeda. Mengapa diperlurkan Exception?

                synchronized (acc2) {// Berikan komentar apa yang dilakukan pada blok ini? 
                    System.out.println("Thread 1 mengunci acc2 dan transfer ke acc2");
                    acc2.balance += acc1.balance;
                }
            }
        });

                // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Berikan komentar apa yang dilakukan pada blok ini?
                System.out.println("Thread 2 mengunci acc1");
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Berikan komentar apa yang dilakukan pada blok ini?
                    System.out.println("Thread 2 mengunci acc2 dan tranfer ke acc1");
                    acc1.balance += acc2.balance;   // proses tranfer (modifikasi data bersama)
                }
            }
        });

            t1.start();     // menjalankan thread 1 secara concurrent
            t2.start();     // menjalankan thread 2 secara councurrent

            t1.join();      // menunggu thread 1 selesai
            t2.join();      // menunggu thread 2 selesai

            System.out.println("--- HASIL AKHIR ---");
            System.out.println("Saldo Akhir acc1: " + acc1.balance);    // menampilkan saldo akhir acc 1 
            System.out.println("Saldo Akhir acc2: " + acc2.balance);    // menampilkan saldo akhir acc 2
    }
}

