/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

// Maps;
// [1, b9, 9, #9/b3, 3, 11, #11/b5, 5, #5/b13, 13, b7, 7]

// For alterations, maps are XOR'd if need to get rid of current degree, eg b5, and OR'd if not, eg #9

package chordchess.music;

import chordchess.util.Operation;

public enum Alteration {
    FLAT_5("b5",    0b000000110000, Operation.XOR),
    SHARP_5("#5",   0b000000011000, Operation.XOR),
    FLAT_9("b9",    0b010000000000, Operation.OR),
    SHARP_9("#9",   0b000100000000, Operation.OR),
    SHARP_11("#11", 0b000000100000, Operation.OR),
    FLAT_13("b13",  0b000000001000, Operation.OR);

    private final String symbol;
    private final int map;
    private final Operation operation;

    Alteration(String symbol, int map, Operation operation) {
        this.symbol = symbol;
        this.map = map;
        this.operation = operation;
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

    public int getMap() {
        return map;
    }

    public Operation getOperation() {
        return operation;
    }
}
