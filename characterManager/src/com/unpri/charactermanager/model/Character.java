package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Attribute Static untuk melacak jumlah total objek Character yang dibuat
    private static int totalCharacterCreated = 0;

    // Constructor Default (Level 1)
    public Character(String name, CharacterType type) {
        this(name, type, 1, 120, 20, 50);
    }

    // Constructor Rekonstruksi Penuh
    public Character(String name, CharacterType type, int level, int hitPoints, int attackPower, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = mana;
        totalCharacterCreated++;
    }

    // Overriding equals() untuk Bagian A: membandingkan nama karakter (case-insensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character other = (Character) obj;
        return Objects.equals(this.name != null ? this.name.toLowerCase() : null, 
                            other.name != null ? other.name.toLowerCase() : null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name != null ? name.toLowerCase() : null);
    }

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CharacterType getType() { return type; }
    public void setType(CharacterType type) { this.type = type; }

    public int getLevel() { return level; }
    public void setLevel(int level) { 
        this.level = level;
        this.hitPoints = 100 + (level * 20);
        this.attackPower = 15 + (level * 5);
    }

    public int getHitPoints() { return hitPoints; }
    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }

    public int getAttackPower() { return attackPower; }
    public void setAttackPower(int attackPower) { this.attackPower = attackPower; }

    public int getMana() { return mana; }
    public void setMana(int mana) { 
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana; 
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void levelUp() {
        setLevel(this.level + 1);
    }

    @Override
    public String toString() {
        return String.format("Character{name='%s', type=%s, level=%d, HP=%d, ATK=%d, Mana=%d}",
                name, type, level, hitPoints, attackPower, mana);
    }
}