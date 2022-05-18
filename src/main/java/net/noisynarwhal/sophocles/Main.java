/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.noisynarwhal.sophocles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lioudt
 */
public class Main {

    /**
     * Location of the adjectives list resource file
     */
    public static final String ADJECTIVES_RESOURCE = "adjectives.txt";

    /**
     * Location of the animals list resource file
     */
    public static final String ANIMALS_RESOURCE = "animals.txt";
    //private static final Pattern MATCH_PATTERN = Pattern.compile("^([^aeiouy]+[aeiouy]+|[aeiouy]+[^aeiouy])");
    private static final Pattern MATCH_PATTERN = Pattern.compile("(?i)^(ph|sh|ch|qu|wh|th|kn|[aeiouy]+|[a-z])");

    /**
     * The length of the output of code names.
     */
    public static final int OUTPUT_LIST_LENGTH = 50;
    private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(Main.class.getName());

    /**
     * Prints out a random list of generated code names.
     *
     * @param args
     */
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {

        try {

            final Set<String> names = new HashSet<>();

            final SortedSet<String> adjectives = WordLists.load(ADJECTIVES_RESOURCE);
            final SortedSet<String> animals = WordLists.load(ANIMALS_RESOURCE);

            for (final String adjective : adjectives) {
                final String adjBegin;
                {
                    final Matcher matcher = MATCH_PATTERN.matcher(adjective);
                    if (matcher.find()) {
                        adjBegin = matcher.group();
                    } else {
                        adjBegin = adjective;
                    }
                }
                for (final String animal : animals) {
                    final String animalBegin;
                    {
                        final Matcher matcher = MATCH_PATTERN.matcher(animal);
                        if (matcher.find()) {
                            animalBegin = matcher.group();
                        } else {
                            animalBegin = animal;
                        }
                    }

                    if (adjBegin.equals(animalBegin) && !(adjective.startsWith(animal) || animal.startsWith(adjective))) {
                        names.add(adjective + ' ' + animal);
                    }
                }
            }

            final List<String> namesList = new ArrayList<>();
            namesList.addAll(names);
            Collections.shuffle(namesList);

            final Iterator<String> namesIterator = namesList.iterator();
            for (int i = 0; i < OUTPUT_LIST_LENGTH && namesIterator.hasNext(); i++) {
                final String name = namesIterator.next();
                System.out.println(name);
            }

        } catch (Throwable th) {

            LOGGER.debug(th);

            System.err.println(th.getMessage());
            System.exit(1);
        }

        System.exit(0);
    }
}