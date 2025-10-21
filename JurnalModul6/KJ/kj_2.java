// Penerapan seharusnya yaitu dengan memanfaatkan interface, 
// sehingga jika ingin menambahkan jenis kopi baru (Arabica, Robusta, dll.), 
// kode pada MesinKopi tidak perlu diubah. Cukup menambahkan kelas baru 
// yang mengimplementasikan interface biji kopi.

// 1. Abstraksi (Interface) untuk biji kopi
interface IBijiKopi {
    void giling();
}

// 2. Implementasi biji kopi Arabica
class BijiKopiArabica implements IBijiKopi {
    @Override
    public void giling() {
        System.out.println("Menggiling biji kopi Arabica.");
    }
}

// 3. Implementasi biji kopi Robusta (contoh jenis lain)
class BijiKopiRobusta implements IBijiKopi {
    @Override
    public void giling() {
        System.out.println("Menggiling biji kopi Robusta.");
    }
}

// 4. MesinKopi yang bergantung pada Interface IBijiKopi
class MesinKopi {
    private IBijiKopi bijiKopi;

    // Injeksi biji kopi melalui konstruktor
    public MesinKopi(IBijiKopi bijiKopi) {
        this.bijiKopi = bijiKopi;
    }

    public void seduhKopi() {
        bijiKopi.giling();
        System.out.println("Sedang menyeduh kopi...");
    }
}

// 5. Demo penggunaan
public class kj_2 {
    public static void main(String[] args) {
        // Menggunakan biji kopi Arabica
        IBijiKopi arabica = new BijiKopiArabica();
        MesinKopi mesinArabica = new MesinKopi(arabica);
        mesinArabica.seduhKopi();

        // Menggunakan biji kopi Robusta
        IBijiKopi robusta = new BijiKopiRobusta();
        MesinKopi mesinRobusta = new MesinKopi(robusta);
        mesinRobusta.seduhKopi();
    }
}
