/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

// This code is heavily based off of the paper:
// A Computational Model of Tonal Tension Profile of Chord Progressions in the Tonal Interval Space
// Written by Maria Navarro-Caceres et al.

package chordchess.music.tonaltension;

import org.apache.commons.math3.complex.Complex;

public class TISMetrics {
    // Euclidean distance between two chords, t1 and t2
    public static double euclideanDistance(Complex[] t1, Complex[] t2) {
        double sum = 0.0;

        for (int k = 0; k < 6;  k++) {
            double realDiff = t1[k].getReal() - t2[k].getReal();
            double imagDiff = t1[k].getImaginary() - t2[k].getImaginary();
            sum += (realDiff * realDiff) + (imagDiff * imagDiff);
        }

        return Math.sqrt(sum);
    }

    public static double getDissonance(Complex[] tiv) {
        Complex[] origin = new Complex[6];

        for (int i = 0; i <= 6; i++) origin[i] = Complex.ZERO;

        return euclideanDistance(tiv, origin);
    }

    public static double vectorAngle(Complex[] t1, Complex[] t2) {
        Complex dotProduct = Complex.ZERO;

        for (int i = 0; i < 6; i++) {
            // Dot product for complex numbers: t1 * conjugate(t2) or real parts multiplication depending on space definition
            dotProduct = dotProduct.add(t1[i].multiply(t2[i].conjugate()));
        }

        double norm1 = getDissonance(t1);
        double norm2 = getDissonance(t2);

        if (norm1 == 0.0 || norm2 == 0.0)
            return 0.0;

        double cosTheta = dotProduct.getReal() / (norm1 * norm2);
        // Clamp to valid arccos range to avoid NaN errors
        cosTheta = Math.max(-1.0, Math.min(1.0, cosTheta));

        return Math.acos(cosTheta);
    }
}
