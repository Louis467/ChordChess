/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.music.tonaltension.model;

import org.apache.commons.math3.complex.Complex;

public class TIVResult {
    public Complex[] tiv;
    public double modC;

    public TIVResult(Complex[] tiv, double modC) {
        this.tiv = tiv;
        this.modC = modC;
    }
}