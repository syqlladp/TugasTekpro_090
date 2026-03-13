public class GenericsMethods {                                                         // ini itu adalah class utama namanya GenericsMtehods
                                                                                        // fungsinya itu adalah untuk menunjukkan contoh penggunaan Generic Method di java
                                                                                        // beda sama Generic pada class, disini Generics digunakan pada method

    // Java Generic Method
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {         // <T> ini adalah parameter generics yang berfungsi sebagai penanda tipe data
                                                                                        // artinya method ini bisa bekerja dengan berbagai tipe data seperti string, inteher, double dll.
                                                                                        // boolean ini adalah tipe nilai yang dikembalikan method yang menghasilkan true or false 
                                                                                        // GenericsType<T> g1, GenericsType<T> g2 , Method menerima dua parameter object dari class GenericsType
                                                                                        // contohnya jika T = String maka: GenericsType<String> , artinya kedua object tersebut harus memiliki tipe data yang sama
        return g1.get().equals(g2.get());                                               // g1.get() g2.get() -> mengambil nilai dari object g1, g2
                                                                                        // .equals() digunakan untuk membandingkan isi kedua nilai tersebut. jika sama -> true , jika tidak -> false  
    }

    public static void main(String args[]) {
        GenericsType<String> g1 = new GenericsType<>();                                 // g1 dengan tipe data string , artinya objek ini hanya bisa menyimpan string
        g1.set("Java");                                                             // method set() digunakan untuk menyimpan nilai kedalam ojek 

        GenericsType<String> g2 = new GenericsType<>();                                 // ini juga bertipe  string , nilai yang disimpan juga java
        g2.set("Java");                                                             // g1.get() dan g2.get() method akan dibandingkan 

        boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);                      // program ini memanggil method isEqual()
                                                                                        // <String> menentukan bhawa tipe generics yang digunakan adalah string 
        // above statement can be written simply as 
        isEqual = GenericsMethods.isEqual(g1, g2);                                      // java otomatis bisa menebak tipe generics yang digunakan 
                                                                                        // fitur ini disebut tipe interface

        /*
         * This feature, known as type inference, allows you to invoke
         * a generic method as an ordinary method, without specifying 
         * a type between angle brackets 
         */
        
        // Compiler will infer the type that is needed

        System.out.println(GenericsMethods.isEqual(g1, g2));
    }
}
