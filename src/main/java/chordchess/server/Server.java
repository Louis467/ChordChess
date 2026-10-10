/*
 * Copyright (c) 2026 Louis Kent
 * All rights reserved.
 * ChordChess
 */

package chordchess.server;

import chordchess.music.Chord;
import chordchess.music.ChordParser;

import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Chord Chess server started.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a chord: ");
            String chordstr = scanner.next();

            // Check the exit condition
            if (chordstr.equals("bye")) {
                System.out.println("Goodbye!");
                break; // This breaks completely out of the while loop
            }

            try {
                Chord chord = ChordParser.parseChord(chordstr);
                System.out.println(chord.getNotes().toString());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}