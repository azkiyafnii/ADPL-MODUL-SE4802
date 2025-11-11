import java.sql.*;
import java.util.Scanner;

// Class Database sesuai template praktikum
class Database {
    static final String url = "jdbc:mysql://localhost:3306/theater_db"; // Ganti sesuai nama DB
    static final String user = "root";
    static final String pass = "";
    static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

    public void connect() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
    }

    public void query(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Kesalahan Query: " + ex.getMessage());
        }
    }

    public ResultSet view(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Kesalahan View: " + ex.getMessage());
        }
        return rs;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Kesalahan Saat Menutup Koneksi" + ex.getMessage());
        }
    }
}

// Entity Class Room
abstract class Room {
    protected String theaterName;
    protected String type;
    protected int capacity;
    protected int price;

    public Room(String theaterName, String type, int capacity, int price) {
        this.theaterName = theaterName;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
    }

    public abstract void showFacilities();
}

class RegularRoom extends Room {
    public RegularRoom(String theaterName, int capacity, int price) {
        super(theaterName, "Regular", capacity, price);
    }

    @Override
    public void showFacilities() {
        System.out.println("Fasilitas: Kursi Standar");
    }
}

class PremiumRoom extends Room {
    public PremiumRoom(String theaterName, int capacity, int price) {
        super(theaterName, "Premium", capacity, price);
    }

    @Override
    public void showFacilities() {
        System.out.println("Fasilitas: Kursi Premium, Layar Lebar");
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(String theaterName, int capacity, int price) {
        super(theaterName, "Suite", capacity, price);
    }

    @Override
    public void showFacilities() {
        System.out.println("Fasilitas: Kursi Sofa, Private Room, Layar Super Besar");
    }
}

// Repository Class
class RoomRepository {
    private final Database db;

    public RoomRepository(Database db) {
        this.db = db;
    }

    public void insert(Room room) {
        String sql = "INSERT INTO room(theater_name, type, capacity, price) VALUES ('"
                + room.theaterName + "','" + room.type + "'," + room.capacity + "," + room.price + ")";
        db.query(sql);
    }

    public void getAllRoom() {
        String sql = "SELECT * FROM room";
        ResultSet rs = db.view(sql);
        try {
            System.out.println("--- Data Semua Room ---");
            while (rs.next()) {
                System.out.println("Nama Theater: " + rs.getString("theater_name"));
                System.out.println("Jenis Room: " + rs.getString("type"));
                System.out.println("Kapasitas: " + rs.getInt("capacity"));
                System.out.println("Harga: " + rs.getInt("price"));
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan Select: " + e.getMessage());
        }
    }
}

// Service Class
class RoomService {
    private final RoomRepository repo;

    public RoomService(RoomRepository repo) {
        this.repo = repo;
    }

    public void inputAndSaveRoom(Scanner input) {
        System.out.print("Nama Theater: ");
        String theaterName = input.nextLine();

        System.out.print("Jenis Room (1. Regular | 2. Premium | 3. Suite): ");
        int type = input.nextInt();
        input.nextLine();

        System.out.print("Kapasitas: ");
        int capacity = input.nextInt();

        System.out.print("Harga: ");
        int price = input.nextInt();
        input.nextLine();

        Room room;
        if (type == 1) {
            room = new RegularRoom(theaterName, capacity, price);
        } else if (type == 2) {
            room = new PremiumRoom(theaterName, capacity, price);
        } else {
            room = new SuiteRoom(theaterName, capacity, price);
        }

        repo.insert(room);
        room.showFacilities();
    }
}

// Main Program
public class kj {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Database db = new Database();
        RoomRepository repo = new RoomRepository(db);
        RoomService service = new RoomService(repo);

        System.out.println("=== Room Management System (Refactor SOLID with Database.java) ===");

        db.connect();

        for (int i = 0; i < 2; i++) {
            System.out.println("--- Input Data Room ke-" + (i + 1) + " ---");
            service.inputAndSaveRoom(input);
        }

        repo.getAllRoom();

        db.disconnect();

        System.out.println("Program Selesai.");
    }
}
