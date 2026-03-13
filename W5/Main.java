interface MinMax<T extends Comparable<T>> {                     // bagian ini itu mendefinisikan interface bernama MinMax yang menggunakan generics 
                                                                // T extends Comparable<T> artinya tipe T harus merupakan tipe yang bisa dibandingkan 
    T max();                                                    // method bernama Max, mengembalikan nilai bertipe T 
                                                                // fungsinya itu adalah mencari nilai terbesar
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {   // class ini harus membuat implementasi method Max()
                                                                // dan bagian T extends Comparable<T> itu tipe data T harus memiliki method compareTo()
    T[] vals;                                                   // array yang menyimpan data bertipe T 

    MyClass(T[] o) {                                            // ini adalah constructor, digunakan untuk menerima array data dari luar class
        vals = o;                                               // parameter o adalah array bertipe T, nilai tersebut disimpan ke variabel vals
    }                                                           // artinya ketika objek dibuat, array data langsung dimasukkan ke dalam class

    public T max() {                                            // digunakan untuk mnecari nilai terbesar dalam array 
        T v = vals[0];                                          // variabel v diisi dengan elemen pertama array, variabel ini akan digunakan sebagai nilai terbesar sementara
        
        for (int i = 1; i < vals.length; i++) {                                 // perulangan, ini digunakan untuk memeriksa semua elemen dari array
                                                                                // dimulai dari indeks 1, karena indeks 0 sudah disimpan di v 
            // Menggunakan method compareTo dari interface Comparable
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] inums = {3, 6, 2, 8, 6};                              // array ini berisi beberapa nilai integer
        Character[] chs = {'b', 'r', 'p', 'w'};                         // ini berisi karakter

        MyClass<Integer> a = new MyClass<>(inums);                      // artinya T = Integer jadi class bekerja dengan tipe integer
        MyClass<Character> b = new MyClass<>(chs);                      // T = Karakter jadi class bekerja dengan tipe karakter

        System.out.println("Nilai Integer Terbesar: " + a.max());       // menmapilkan hasil , program memanggil method max() untuk mencari nilai integer terbesar dalam array 
        System.out.println("Karakter Terbesar: " + b.max());            // prgram mencari karakter terbesar dalam array, dalam ASCII 
    }
}
