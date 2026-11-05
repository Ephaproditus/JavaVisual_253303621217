package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO CHARACTER MANAGER SPRINT #2 ===");

        CharacterManager manager = new CharacterManager();

        System.out.println("\n--- [BAGIAN A] Pengujian CRUD & Penolakan Duplikat ---");
        Character c1 = new Character("Arthur", CharacterType.WARRIOR, 5, 200, 40, 50);
        Character c2 = new Character("Gandalf", CharacterType.MAGE, 10, 300, 80, 200);
        Character c3 = new Character("Legolas", CharacterType.ARCHER, 3, 160, 30, 80);
        Character cDuplicate = new Character("arthur", CharacterType.HEALER);

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3);

        System.out.println("Mencoba menambahkan duplikat 'arthur':");
        manager.addCharacter(cDuplicate);

        System.out.println("Total Karakter dalam Manager: " + manager.getTotalCharacters());

        System.out.println("\n--- [BAGIAN A] Pengujian Defensive Copying ---");
        List<Character> copyList = manager.getAllCharacters();
        copyList.clear();
        System.out.println("Ukuran list salinan setelah clear(): " + copyList.size());
        System.out.println("Ukuran list asli dalam Manager (tetap utuh): " + manager.getTotalCharacters());

        System.out.println("\n--- [BAGIAN B] Pengujian Mini-Challenge ---");
        System.out.println("Rata-rata level saat ada data: " + manager.getAverageLevel());

        List<Character> mages = manager.findByType(CharacterType.MAGE);
        System.out.println("Karakter tipe MAGE: " + mages);

        CharacterManager emptyManager = new CharacterManager();
        System.out.println("Rata-rata level pada manager kosong: " + emptyManager.getAverageLevel());

        System.out.println("\n--- [BAGIAN C] Pengujian Fitur Mandiri renameCharacter() ---");
        System.out.println("Mencoba merename 'Legolas' -> 'Gandalf' (harus bentrok):");
        manager.renameCharacter("Legolas", "Gandalf");

        System.out.println("Mencoba merename 'Legolas' -> 'RobinHood' (harus berhasil):");
        boolean renameSuccess = manager.renameCharacter("Legolas", "RobinHood");
        System.out.println("Status Rename: " + renameSuccess);
        System.out.println("Data Legolas setelah rename: " + manager.findByName("RobinHood"));

        System.out.println("\n--- [STATIC TRACKING] ---");
        System.out.println("Total instance Character yang dibuat secara global: " + Character.getTotalCharacterCreated());
    }
}