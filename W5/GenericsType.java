public class GenericsType<T> {                          // <T> adalah type parameter dalam generics 
                                                        // T adalah placeholder untuk tipe data yang akan ditentukan saat objek dibuat
                                                        // Class ini bisa digunkan untuk berbagai tipe data
    private T t;                                        // variabel t digunkan untuk menyimpan nilai
                                                        // T -> tipe datanya mengikuti tipe yang diberikan saat objek dibuat

    public T get() {                                    // method ini untuk mengambil data dari variabel t 
        return this.t;                                  // bedanya dengan GenericsTypeOld ini itu tidak perlu type casting 
    }

    public void set(T t1) {                             // method untuk menyimpan data ke variabel t 
                                                        // T t1 -> parameter dengan tipe yang sama dengan generics 
        this.t = t1;                                    // menyimpan nilai parameter ke variabel instnace
    }                                                   // artinya jika generics yang digunakan adalah String, maka method ini hanya menerima String.

    public static void main(String args[]) {                          // titik awal eksekusi program oleh JVM 
        GenericsType<String> type = new GenericsType<>();             // baris ini membuat objek dengan generic String, T = String
                                                                      // sehingga semua T di class berubah menjadi string 
        type.set("Java"); // valid                                    // menyimpan data "JAVA" ke variabel t 
                                                                      // karena generics yang digunakan adalah String, maka hanya String yang coleh dimasukkan. 

        GenericsType type1 = new GenericsType(); // raw type          // class generics ini digunakan tanpa menentukan tipe data 
                                                                      // akibatnya java tidak akan meperlakukan generics tersebut seperti objek      
        type1.set("Java");                                         // valid karena "JAVA" adalah objek String
        type1.set(10);                                             // valid and autoboxing support
                                                                     // autoboxing adalah proses mengubah tipe primitif menjadi onjek secara otomatis
        
        System.out.println(type.get());
        System.out.println(type1.get());                              
    }                                                                 
}                          // perbedaan dengan yang GenericsTypeOld itu menggunakan objek jadi bisa menyimpan semua tipe data, harus melakukan casting, berpotensi eror
                           // sedangkan yang menggunakan Generics itu menggunakan <T> jadi tipe data lebih jelas, tidak perlu casting, lebih aman dari eror  
