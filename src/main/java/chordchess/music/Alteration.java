/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * Chord Chess
 */

package chordchess.shared.music;

public enum Alteration {
    FLAT_5("b5"),
    SHARP_5("#5"),
    FLAT_9("b9"),
    SHARP_9("#9"),
    SHARP_11("#11"),
    FLAT_13("b13");

    private final String symbol;

    Alteration(String symbol) {
        this.symbol = symbol;
    }

    public String format() {
        return symbol;
    }

    public static Alteration getAlteration(String symbol) {
        for  (Alteration a : Alteration.values()) {
            if(a.format().equals(symbol)) {
                return a;
            }
        }
        return null;
    }
}
