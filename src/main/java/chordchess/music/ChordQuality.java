/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

// Maps:
// [1, b9, 9, #9/b3, 3, 11, #11/b5, 5, #5/b13, 13, b7, 7]

package chordchess.music;

public enum ChordQuality {
    MAJOR("maj",    0b100010010000),
    MINOR("m",      0b100100010000),
    DIM("dim",      0b100100100000),
    AUG("aug",      0b100010001000),
    MAJOR7("maj7",  0b100010010001),
    MINOR7("m7",    0b100100010010),
    DOM7("7",       0b100010010010),
    DIM7("dim7",    0b100100100100),
    SUS7("7sus4",   0b100001010010),
    MAJOR9("maj9",  0b101010010001),
    MINOR9("m9",    0b101100010010),
    DOM9("9",       0b101010010010),
    MINOR11("m11",  0b101101010010),
    DOM11("11",     0b101011010010),
    MAJOR13("maj13",0b101010010101),
    MINOR13("m13",  0b101101010110),
    DOM13("13",     0b101011010110),
    MMAJ7("mMaj7",  0b100100010001);

    private final String symbol;
    private final int map;

    ChordQuality(String symbol, int map) {
        this.symbol = symbol;
        this.map = map;
    }

    public String format() {
        return symbol;
    }

    public static ChordQuality getQuality(String symbol) {
        for  (ChordQuality q : ChordQuality.values()) {
            if(q.format().equals(symbol)) {
                return q;
            }
        }
        return null;
    }

    public int getMap() {
        return map;
    }
}
