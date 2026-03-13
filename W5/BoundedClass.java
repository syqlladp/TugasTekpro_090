class Bound<T extends A> {                              // membuat class generics bernama bound
                                                        // extends A artinya tipe T harus merupakan class A atau turunan dari A
                                                        // class bound tidak bisa menerima sembarang tipe data, hanya tipe berhubungan dengan class A
                                                        // contoh yang boleh digunakan A, B, C karena B, c merupakan turunan dari A 
                                                        // contoh yang tidak boleh seprti integer, String

    private T objRef;                                   // variabel instance yang bertipe T
                                                        // fungsi variabel ini adalah untuk menyimpan objek yang dikirim ke class Bound
                                                        // contoh T = B maka objRef = objek B

    public Bound(T obj) {                               // constructor ini digunakan saat objek dari class bound dibuat
                                                        // parameter obj bertipe T, nilai tersebut disimpan ke dalam variabel objRef
        this.objRef = obj;                              // kalo ini artinya parameter dimasukkan ke variabel milik class 
    }

    public void doRunTest() {                           // method yang menjalankan displayClass()
        this.objRef.displayClass();                     // dari objek yang disimpan di objRef, method ini dipanggila karena T extends A
                                                        // sehingga semua tipe T pasti memiliki method displayClass() yang ada di class A
    }
}

class A {                                                   // super class A (kelas utama)

    public void displayClass() {                             // memiliki method displayClass()                
        System.out.println("Inside super class A");        // yang menampilkan teks inside super class A     
    }
}

class B extends A {                                         // class B adalah turunan dari Class A 
                                                            // karena mewarisi A, maka class B juga memiliki method displayClass()
                                                            // namun di sini method tersebut di-override
    public void displayClass() {                            // jika objek B dipanggil, maka yang muncul adalah inside sub class B 
        System.out.println("Inside sub class B");
    }
}

class C extends A {                                         // turunan dari class A , method displayClass() disini juga di-override 
                                                            // jika objek c dipanggil, maka outputnya inside sub class C 
    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

public class BoundedClass {                                 // class ini adalah class utama yang berisi method main() , 

    public static void main(String a[]) {

        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());               // Bound<C> -> tipe generics adalah C, new C() -> membuat objek dari class C
                                                            // objek tersebut dikirim ke constructor Bound 
        bec.doRunTest();                                    // program akan memanggil dispplayClass() milik C 
                                                            // outputnya inside dub class c 

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        Bound<B> beb = new Bound<B>(new B());               // objek B dikirim ke class Bound 
        beb.doRunTest();                                    // method dijalankan lalu outputnya inside sub class B 

        // similarly passing super class A
        Bound<A> bea = new Bound<A>(new A());               // objek A dikirim ke class bound 
        bea.doRunTest();                                    // mwthod dijalankan lalu outputnya inside super class A 
    }
}

