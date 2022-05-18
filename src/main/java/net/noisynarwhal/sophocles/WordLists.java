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
import static net.noisynarwhal.sophocles.Main.ADJECTIVES_RESOURCE;
import static net.noisynarwhal.sophocles.Main.ANIMALS_RESOURCE;

/**
 *
 * @author lioudt
 */
public class WordLists {

    public static final int MIN_LENGTH = 1;

    public static void main(String[] args) throws IOException {
        final SortedSet<String> adjectives = WordLists.load(ADJECTIVES_RESOURCE);
        final SortedSet<String> animals = WordLists.load(ANIMALS_RESOURCE);
        
        for(final String word : animals) {
            System.out.println(word);
        }
    }

    public static SortedSet<String> load(String resource) throws IOException {

        final SortedSet<String> words = new TreeSet<>();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(resource), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (!(line.length() <= MIN_LENGTH || line.matches(".*[^a-z].*"))) {
                    words.add(line);
                }
            }
        }

        return words;
    }
}
