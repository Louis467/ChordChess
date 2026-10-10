/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * Chord Chess
 */

package chordchess.shared.music;

public enum ChordQuality {
    MAJOR("maj"),
    MINOR("m"),
    DIM("dim"),
    AUG("aug"),
    MAJOR7("maj7"),
    MINOR7("m7"),
    DOM7("7"),
    DIM7("dim7");

    private final String symbol;

    ChordQuality(String symbol) {
        this.symbol = symbol;
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
}
