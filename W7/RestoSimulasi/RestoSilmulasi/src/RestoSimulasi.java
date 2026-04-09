class Resto {
    private int chickenStock = 100;     // shared  resource 

    public synchronized void serveCustomer(String cashierName) {        // synchronized: hanya 1 thread yang boleh masuk method ini dalam satu waktu
        if (chickenStock > 0) {     // cek stok sebelum menjual
            try { Thread.sleep(10); } // simulasi delay (thread masuk state waiting)
            catch (InterruptedException e) {}
            
            chickenStock--; // pengurangan stok (operasi write yang harus diamankan)
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");    // jika stok habis
        }
    }

    public int getRemainingStock() {
        return chickenStock;    // mengambil sisa stok
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        Runnable task = () -> { // task yang akan dijalankan oleh setiap thread
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());    // setiap thread mencoba menjual sebanyak 4o kali
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");    // thread kasir A
        Thread kasir2 = new Thread(task, "Kasir-B");    // thread kasir B
        Thread kasir3 = new Thread(task, "Kasir-C");    // thread kasir c 

        kasir1.start(); // menjalankan thread secara concurrent
        kasir2.start();
        kasir3.start();

        kasir1.join();  // menunggu semua thread selesai
        kasir2.join();
        kasir3.join();

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}
