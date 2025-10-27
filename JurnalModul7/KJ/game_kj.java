import java.util.*;

// Program utama
class game_kj {
    public static void main(String[] args) {
        Attackable player = new Healer("Soraka");
        Monster monster = new Monster("Goblin", 80);

        player.attack(monster);

        if (monster.isDefeated()) {
            System.out.println(monster.name + " dikalahkan!");
        }

        if (player instanceof Healable) {
            ((Healable) player).heal();
        }

        if (player instanceof Defendable) {
            ((Defendable) player).defend();
        }

        if (player instanceof Sneakable) {
            ((Sneakable) player).sneak();
        }

        PlayerDataManager manager = new PlayerDataManager(new DatabaseStorage());
        manager.savePlayer(((Player) player).getName());
    }
}

// ===================== INTERFACES =========================

interface Attackable {
    void attack(Monster monster);
}

interface Defendable {
    void defend();
}

interface Healable {
    void heal();
}

interface Sneakable {
    void sneak();
}

interface DataStorage {
    void save(String data);
}

// ===================== ABSTRACT BASE ======================

abstract class Player implements Attackable {
    protected String name;
    protected int health = 100;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// ===================== IMPLEMENTASI PLAYER ======================

class Warrior extends Player implements Defendable {
    public Warrior(String name) {
        super(name);
    }

    public void attack(Monster monster) {
        System.out.println(name + " menyerang dengan pedang!");
        monster.takeDamage(20);
    }

    public void defend() {
        System.out.println(name + " bertahan dengan perisai!");
    }
}

class Healer extends Player implements Healable {
    public Healer(String name) {
        super(name);
    }

    public void attack(Monster monster) {
        System.out.println(name + " menyerang dengan tongkat sihir!");
        monster.takeDamage(10);
    }

    public void heal() {
        System.out.println(name + " menyembuhkan dirinya.");
        health += 20;
    }
}

class Thief extends Player implements Sneakable {
    public Thief(String name) {
        super(name);
    }

    public void attack(Monster monster) {
        System.out.println(name + " menyerang dari bayangan!");
        monster.takeDamage(15);
    }

    public void sneak() {
        System.out.println(name + " menghilang dalam kegelapan.");
    }
}

// ===================== LOGIKA PENYIMPANAN ======================

class PlayerDataManager {
    private final DataStorage storage;

    public PlayerDataManager(DataStorage storage) {
        this.storage = storage;
    }

    public void savePlayer(String name) {
        storage.save("Menyimpan data " + name);
    }
}

class DatabaseStorage implements DataStorage {
    public void save(String data) {
        System.out.println(">> " + data);
    }
}

// ===================== MONSTER ======================

class Monster {
    String name;
    int health;

    public Monster(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " terkena " + damage + " damage! Sisa HP: " + health);
    }

    public boolean isDefeated() {
        return health <= 0;
    }
}
