/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.util;

import chordchess.music.Alteration;
import chordchess.music.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChordMapUtil {
    public static int applyAlteration(int map, Alteration alteration) {
        return switch (alteration.getOperation()) {
            case OR -> map | alteration.getMap();
            case XOR -> map ^ alteration.getMap();
        };
    }

    public static int applyAlterations(int map, ArrayList<Alteration> alterations) {
        for (Alteration alteration : alterations) {
            map = applyAlteration(map, alteration);
        }

        return map;
    }

    public static ArrayList<Note> generateNotes(int map, Note rootNote) {
        ArrayList<Note> notes = new ArrayList<>(Arrays.asList(Note.values()));

        // Shift the notes array so that it starts with the root note
        notes = Util.shift(notes, rootNote.getId());

        ArrayList<Note> chordNotes = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            if ((map & (1 << i)) != 0) {
                chordNotes.add(notes.get(11 - i));
            }
        }

        Collections.reverse(chordNotes);

        return chordNotes;
    }

    public static int[] generateChroma(int map, Note rootNote) {
        return bitmaskToArray(rotate12(map, rootNote.getId()));
    }

    public static int rotate12(int bits, int n) {
        n = Math.floorMod(n, 12);

        return ((bits >>> n) | (bits << (12 - n))) & 0xFFF;
    }

    public static int[] bitmaskToArray(int mask) {
        int[] result = new int[12];

        for (int i = 0; i < 12; i++) {
            result[i] = (mask >> (11 - i)) & 1;
        }

        return result;
    }
}
