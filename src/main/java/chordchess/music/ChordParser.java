/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.music;

import java.util.ArrayList;

public class ChordParser {
    public static Chord parseChord(String chordText) {
        int currentIndex;

        Note root;
        ChordQuality chordQuality;
        ArrayList<Alteration> alterations = new ArrayList<>();

        // Chord root is invalid
        if (Note.getNote(chordText.substring(0, 1)) == null) {
            throw new IllegalArgumentException("Invalid root note: " + chordText);
        }

        // Check if root note has accidental
        if (chordText.charAt(1) == 'b' || chordText.charAt(1) == '#') {
            // There is an accidental
            root = Note.getNote(chordText.substring(0, 2));
            currentIndex = 2;
        } else {
            // There is not an accidental
            root = Note.getNote(chordText.substring(0, 1));
            currentIndex = 1;
        }

        ChordQuality currentValid = null;

        // Find what the chord quality is
        for (ChordQuality q : ChordQuality.values()) {
            if (chordText.startsWith(q.format(), currentIndex)) {
                if (currentValid == null || q.format().length() > currentValid.format().length()) {
                    currentValid = q;
                }
            }
        }

        // Invalid chord quality
        if (currentValid == null) {
            throw new IllegalArgumentException("Invalid chord quality: " + chordText);
        }

        chordQuality = currentValid;
        currentIndex += currentValid.format().length();

        // Alterations
        // Each alteration is 2 characters long
        if (chordText.substring(currentIndex).length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid alterations: " + chordText);
        }

        for (int i = currentIndex; i < chordText.length(); i += 2) {
            if (Alteration.getAlteration(chordText.substring(i, i + 2)) != null) {
                alterations.add(Alteration.getAlteration(chordText.substring(i, i + 2)));
            } else {
                throw new IllegalArgumentException("Invalid alterations: " + chordText);
            }
        }

        return new Chord(root, chordQuality, alterations);
    }
}
