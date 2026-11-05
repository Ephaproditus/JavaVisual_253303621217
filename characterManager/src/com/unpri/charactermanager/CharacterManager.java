package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private final List<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    public boolean addCharacter(Character c) {
        if (c == null) return false;
        for (Character existing : characterList) {
            if (existing.equals(c)) {
                System.out.println("[WARNING] Karakter dengan nama '" + c.getName() + "' sudah ada! Penambahan ditolak.");
                return false;
            }
        }
        characterList.add(c);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) return null;
        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean removeCharacter(String name) {
        Character target = findByName(name);
        if (target != null) {
            return characterList.remove(target);
        }
        return false;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    public List<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }
        double totalLevel = 0;
        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }
        return totalLevel / characterList.size();
    }

    public List<Character> findByType(CharacterType type) {
        List<Character> result = new ArrayList<>();
        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

    public boolean renameCharacter(String oldName, String newName) {
        if (oldName == null || newName == null || newName.trim().isEmpty()) {
            return false;
        }
        Character target = findByName(oldName);
        if (target == null) {
            System.out.println("[ERROR] Karakter '" + oldName + "' tidak ditemukan.");
            return false;
        }
        if (!oldName.equalsIgnoreCase(newName) && findByName(newName) != null) {
            System.out.println("[ERROR] Nama baru '" + newName + "' sudah digunakan oleh karakter lain!");
            return false;
        }
        target.setName(newName);
        return true;
    }
}