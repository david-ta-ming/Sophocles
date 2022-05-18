/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.noisynarwhal.sophocles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author lioudt
 */
public class WordLists {

    /**
     * The minimum length (inclusive) of any word from the lists.
     */
    public static final int MIN_WORD_LENGTH = 1;

    /**
     * Load and return a sorted set containing words in the specified resource.
     *
     * @param resource
     * @return
     * @throws IOException
     */
    public static SortedSet<String> load(String resource) throws IOException {

        final SortedSet<String> words = new TreeSet<>();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(resource), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (!(line.length() <= MIN_WORD_LENGTH || line.matches(".*[^a-z].*"))) {
                    words.add(line);
                }
            }
        }

        return words;
    }

    /**
     * Print out the words contained in the specified resource.
     *
     * @param resource
     * @throws IOException
     */
    public static void print(String resource) throws IOException {

        final SortedSet<String> words = WordLists.load(resource);

        for (final String word : words) {
            System.out.println(word);
        }
    }
}
