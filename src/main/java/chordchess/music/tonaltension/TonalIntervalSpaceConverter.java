/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

// This code is heavily based off of the paper:
// A Computational Model of Tonal Tension Profile of Chord Progressions in the Tonal Interval Space
// Written by Maria Navarro-Caceres et al.

package chordchess.music.tonaltension;

import chordchess.music.Chord;
import chordchess.music.tonaltension.model.TIVResult;
import org.apache.commons.math3.complex.Complex;

public class TonalIntervalSpaceConverter {
    public static TIVResult chordToTIV(Chord chord) {

    }

    public static TIVResult computeCustomDFT(double[] chroma) {
        double modC = 0;

        for (double val : chroma) {
            modC += val;
        }

        int N = 12;
        Complex[] fullDFT = new Complex[N];

        // Fourier transform
        for (int k = 0; k < N; k++) {
            Complex sum = Complex.ZERO;
            for (int n = 0; n < N; n++) {
                double angle = -2.0 * Math.PI * k * n / N;

                Complex exponential = new Complex(Math.cos(angle), Math.sin(angle));
                sum = sum.add(exponential.multiply(chroma[n]));
            }
            fullDFT[k] = sum;
        }

        // Extract indices 1 to 6 and apply weights W = [2, 11, 17, 16, 19, 7]
        double[] w = {2.0, 11.0, 17.0, 16.0, 19.0, 7.0};
        Complex[] tiv = new Complex[6];
        for (int k = 0; k < 6; k++) {
            double scalingFactor = w[k] / modC;
            tiv[k] = fullDFT[k + 1].multiply(scalingFactor);
        }

        return new TIVResult(tiv, modC);
    }
}
