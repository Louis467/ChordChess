/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.util;

import java.util.ArrayList;

public class Util {
    public static <T> ArrayList<T> shift(ArrayList<T> list, int n) {
        // [1,2,3,4] -> [2,3,4,1]
        ArrayList<T> shifted = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            shifted.add(list.get((i + n) % list.size()));
        }

        return shifted;
    }
}
