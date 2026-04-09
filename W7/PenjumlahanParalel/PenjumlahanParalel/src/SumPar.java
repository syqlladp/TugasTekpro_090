import java.util.Scanner;

class SumTask extends Thread {
    private int start, end;      // batas awal dan akhir
    private long partialSum;     // hasil parsial

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        partialSum = 0;

        // tampilkan dulu tugas thread
        System.out.println(Thread.currentThread().getName() +
                " mengerjakan: " + start + " - " + end);

        // proses penjumlahan
        for (int i = start; i <= end; i++) {
            partialSum += i;        // mengembalikan hasil parsial
        }
    }

    public long getPartialSum() {
        return partialSum;
    }

    public int getStart() { return start; } // ambil start
    public int getEnd() { return end; }     // ambil end
}

public class SumPar {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = sc.nextInt();

        System.out.print("Masukkan angka akhir: ");
        int angkaAkhir = sc.nextInt();

        SumTask[] threads = new SumTask[jumlahThread];

        int range = angkaAkhir / jumlahThread;
        int start = 1;

        for (int i = 0; i < jumlahThread; i++) {        //pembuatan dan eksekusi thread
            int end = (i == jumlahThread - 1)
                      ? angkaAkhir
                      : start + range - 1;

            threads[i] = new SumTask(start, end);
            threads[i].setName("Thread-" + (i + 1));
            threads[i].start();     // menjalankan thread secara paralel

            start = end + 1;
        }

        long totalSum = 0;

        System.out.println("\n===== HASIL PARSIAL =====");

        for (int i = 0; i < jumlahThread; i++) {    // proses syncronized dan pengembalian hasil
            threads[i].join(); // tunggu selesai

            System.out.println(
                threads[i].getName() +
                " hasil penjumlahan (" +
                threads[i].getStart() + " - " +
                threads[i].getEnd() + ") = " +
                threads[i].getPartialSum()
            );

            totalSum += threads[i].getPartialSum();     //menggabungkan hasil parsial
        }

        System.out.println("\nHasil akhir = " + totalSum);

        sc.close();
    }
}