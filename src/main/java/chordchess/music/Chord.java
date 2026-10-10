/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.music;

import chordchess.util.ChordMapUtil;

import java.util.ArrayList;

public class Chord {
    private final Note root;
    private final ChordQuality quality;
    private final ArrayList<Alteration> alterations;
    private final ArrayList<Note> notes;
    private final int[] chroma;

    public Chord(Note root, ChordQuality quality, ArrayList<Alteration> alterations) {
        this.root = root;
        this.quality = quality;
        this.alterations = alterations;
        this.notes = generateNotes(root, quality, alterations);
        this.chroma = ChordMapUtil.generateChroma(ChordMapUtil.applyAlterations(quality.getMap(), alterations), root);
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

    public  int[] getChroma() {
        return chroma;
    }

    private ArrayList<Note> generateNotes(Note root, ChordQuality quality, ArrayList<Alteration> alterations) {
        return ChordMapUtil.generateNotes(ChordMapUtil.applyAlterations(quality.getMap(), alterations), root);
    }


}
