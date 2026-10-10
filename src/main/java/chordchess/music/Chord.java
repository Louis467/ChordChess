/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * Chord Chess
 */

package chordchess.shared.music;

import java.util.ArrayList;

public class Chord {
    private final Note root;
    private final ChordQuality quality;
    private final ArrayList<Alteration> alterations;
    private final ArrayList<Note> notes;

    public Chord(Note root, ChordQuality quality, ArrayList<Alteration> alterations) {
        this.root = root;
        this.quality = quality;
        this.alterations = alterations;
        this.notes = new ArrayList<>();
    }

    public String format() {
        StringBuilder text = new StringBuilder(root.format() + quality.format());

        for (Alteration alteration : alterations) {
            text.append(alteration.format());
        }

        return text.toString();
    }

    public Note getRoot() {
        return root;
    }
    public ChordQuality getQuality() {
        return quality;
    }

    public ArrayList<Alteration> getAlterations() {
        return alterations;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
