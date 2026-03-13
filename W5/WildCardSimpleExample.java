import java.util.ArrayList;                                     // berfungsi untuk mengimpor Class yang ada di library java
import java.util.Collection;                                    // Collection -> interface utama untuk kumpulan data di java
import java.util.HashSet;                                       // array list -> class yang digunakan untuk menyimpan data dalam bentuk lis berbasis array
import java.util.LinkedList;                                    // linkedList -> class yang menyimpan data dalam bentuk linked list.
                                                                // hashSet -> class yang menyimpan data unik (tidak boleh ada duplikat)
                                                                // ketiga class ini merupakan implementasi dari interface Collection

/**
 * Wildcard Arguments With An Unknown Type
 * @author javaguides.net
 **/
public class WildCardSimpleExample {                            // class utama yang berisi method untuk menjalankan program 

    public static void printCollection(Collection<?> c) {               // method ini digunakan untuk menampilkan isi dari sebuah collection
                                                                        // Collerction<?> tanda <?> disebut wildcard yaitu tipe data tidak diketahuo atau bisa apa aja
                                                                        // jadi method ini bisa menerima berbagai jenis collection (lebih fleksibel) 
        for (Object e : c) {                                            // perulangan For-Each
                                                                        // digunakan untuk mengambil elemen dalam collection 
                                                                        // obeject e -> setiap elemen dianggap sebagai object
                                                                        // c -> collection yang dikirim ke method
                                                                        // kenapa pakai onject ? karena wilcard ? membuat tipe data tidak diketahui, sehingga java menganggapnya sebagai object
            System.out.println(e);                                      // menmapilkan data 
        }
    }

    public static void main(String[] args) {                                // method utama 
        Collection<String> collection = new ArrayList<>();                  // disini dibuat sebuah collection bertipe String yang menggunakan ArrayList sebagai implementasinya
        collection.add("ArrayList Collection");                           // digunakan untuk menambahkan data ke dalam collection 
        printCollection(collection);                                         // collection tesrsebut lalu dikirim ke method printCollection() untuk ditampilkan 

        Collection<String> collection2 = new LinkedList<>();                 // dibuat collection menggunakan LinkedList
        collection2.add("LinkedList Collection");
        printCollection(collection2);

        Collection<String> collection3 = new HashSet<>();
        collection3.add("HashSet Collection");
        printCollection(collection3);
    }
}
