/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.music;

public enum Note {
    C(0, "C"),
    D_FLAT(1, "C#", "Db"),
    D(2, "D"),
    E_FLAT(3, "Eb"),
    E(4, "E"),
    F(5, "F"),
    G_FLAT(6, "F#", "Gb"),
    G(7, "G"),
    A_FLAT(8, "G#", "Ab"),
    A(9, "A"),
    B_FLAT(10, "A#", "Bb"),
    B(11, "B");

    private final String[] symbols;
    private final int id;

    Note(int id, String... symbols) {
        this.symbols = symbols;
        this.id = id;
    }

    public String format() {
        return this.symbols[0];
    }

    public String[] getSymbols() {
        return symbols;
    }

    public int getId() {
        return id;
    }

    public static Note getNote(String symbol) {
        for (Note note : Note.values()) {
            if (note.symbols[0].equals(symbol) || note.symbols[1].equals(symbol)) {
                return note;
            }
        }

        return null;
    }

    public static Note getNote(int id) {
        for (Note note : Note.values()) {
            if (note.id == id) {
                return note;
            }
        }

        return null;
    }
}
