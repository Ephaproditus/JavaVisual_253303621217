import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO CHARACTER MANAGER (SPRINT #1) ===");

        Character char1 = new Character("Arthur", CharacterType.WARRIOR);
        Character char2 = new Character("Gandalf", CharacterType.MAGE, 5, 200, 40, 150);
        Character char3 = new Character("Legolas", CharacterType.ARCHER, 3, 160, 30, 80);

        System.out.println("\n[ Output 3 Karakter Awal ]");
        System.out.println("1. " + char1);
        System.out.println("2. " + char2);
        System.out.println("3. " + char3);

        System.out.println("\n[ Demo Level Up: Arthur ]");
        System.out.println("Sebelum Level Up : " + char1);
        char1.levelUp();
        System.out.println("Setelah Level Up  : " + char1);

        System.out.println("\n[ Demo Ekstensi Mini-Challenge ]");
        Character char4 = new Character("Mercy", CharacterType.HEALER);
        char4.setMana(120);
        
        System.out.println("Karakter Baru    : " + char4);
        System.out.println("Mana Karakter    : " + char4.getMana());
        System.out.println("Apakah Hidup?    : " + char4.isAlive());

        char4.setHitPoints(0);
        System.out.println("Setelah HP = 0   : " + char4);
        System.out.println("Apakah Hidup?    : " + char4.isAlive());

        try {
            System.out.println("\n[ Uji Validasi Mana Negatif ]");
            char4.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi Exception (Berhasil): " + e.getMessage());
        }
    }
}