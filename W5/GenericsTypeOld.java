public class GenericsTypeOld {          // class ini berfungsi sebagai wadah untuk menyimpan sebuah data menggunakan variabel bernama t 

    private Object t;                   // mendeklarasikan variabel instance bernama t
                                        // private -> variabel yang hanya bisa di akses di dalam class tersebut
                                        // object -> tipe data paling umum di java (superclass dari semua object)
                                        // t -> nama variabel yang menyimpan data
                                        // dan karena ini menggunakan object, variabel bisa menyimpan banyak tipe data
                                        // tapi ketika mengambil data, kita harus tau tipenya aslinya itu apa.

    public Object get() {               // method ini adalah cara untuk mengambil nilai dari variabel t 
        return t;                       // object -> tipe nilai yang dikembalikan 
    }                                   // retunr t -> mengembalikan isi variabel
                                        // karena tipe return itu adalah object, maka ketika dipakai harus diubah ke tipe asli dengan type casting 

    public void set(Object t) {         // ini digunkan untuk mengisi atau menyimpan nilai ke variabel t.
        this.t = t;                     // object -> parameter yang diterima method
    }                                   // this.t = t; -> nilai parameter dimasukkan ke variabel instance

    public static void main(String args[]) {                // titik awal eksekusi program           
        GenericsTypeOld type = new GenericsTypeOld();       // untuk membuat object dari class
        type.set("Java");                                 // menyimpan data ke dalam object 
                                                            // method set() dipanggil, nilai "java" dimasukkan ke variabel t
        String str = (String) type.get(); // type casting, error prone and can cause ClassCastException -> ini bakal aada warning karena variabel str tidak digunakan 
                                                            // jadi untuk menghilangkan warning tersebut itu pelu membuat print supaya variabelnya itu digunakan 
        System.out.println(str);                            // menampilkan output
    }
}
