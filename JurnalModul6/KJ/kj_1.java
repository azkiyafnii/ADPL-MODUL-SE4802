// Penerapan seharusnya yaitu memanfaatkan beberapa interface (ISP), 
// agar setiap kelas hanya mengimplementasikan metode yang benar-benar ia butuhkan.
// Ketika ada proses baru (misalnya pengharum pakaian), kita bisa membuat 
// interface terpisah dan tidak mengubah kode kelas lain yang tidak memerlukannya.

// 1. Interface khusus penjemputan
interface PickupService {
    void pickUpClothes(String customerName);
}

// 2. Interface khusus pencucian
interface WashingService {
    void washClothes(String customerName);
}

// 3. Interface khusus penyetrikaan
interface IroningService {
    void ironClothes(String customerName);
}

// 4. Interface khusus pengantaran
interface DeliveryService {
    void deliverClothes(String customerName);
}

// ----------------------------------------------
// Kelas Kurir hanya butuh menjemput & mengantar
class Courier implements PickupService, DeliveryService {

    @Override
    public void pickUpClothes(String customerName) {
        System.out.println("Kurir menjemput pakaian milik: " + customerName);
    }

    @Override
    public void deliverClothes(String customerName) {
        System.out.println("Kurir mengantarkan pakaian milik: " + customerName);
    }
}

// Kelas Bagian Cuci hanya butuh mencuci pakaian
class Washer implements WashingService {

    @Override
    public void washClothes(String customerName) {
        System.out.println("Mencuci pakaian milik: " + customerName);
    }
}

// Kelas Bagian Setrika hanya butuh menyetrika pakaian
class Ironer implements IroningService {

    @Override
    public void ironClothes(String customerName) {
        System.out.println("Menyetrika pakaian milik: " + customerName);
    }
}

// ----------------------------------------------
// Contoh penggunaan yang lebih lengkap
public class kj_1 {
    public static void main(String[] args) {
        // Kurir mengambil dan mengantar
        PickupService kurirUntukPickup = new Courier();
        DeliveryService kurirUntukDelivery = new Courier();
        kurirUntukPickup.pickUpClothes("Andi");
        kurirUntukDelivery.deliverClothes("Andi");

        // Bagian cuci menangani proses pencucian
        WashingService bagianCuci = new Washer();
        bagianCuci.washClothes("Andi");

        // Bagian setrika menangani proses penyetrikaan
        IroningService bagianSetrika = new Ironer();
        bagianSetrika.ironClothes("Andi");
    }
}
