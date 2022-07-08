/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.noisynarwhal.sophocles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author lioudt
 */
public class RandomAdjectives {

    /**
     * Test of print method, of class WordLists.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testPrint() throws Exception {

        final List<String> adjectives = new ArrayList<>(WordLists.load(net.noisynarwhal.sophocles.Main.ADJECTIVES_RESOURCE));
        Collections.shuffle(adjectives);

        final Iterator<String> it = adjectives.iterator();
        for (int i = 0; i < 10 && it.hasNext(); i++) {
            System.out.print(it.next());
            System.out.print(" ");
        }
        System.out.println();
    }
}
