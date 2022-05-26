/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.noisynarwhal.sophocles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lioudt
 */
public class WordListsTest {

    public WordListsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of print method, of class WordLists.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testPrint() throws Exception {

        if (1 == 0) {
            System.out.println("\nPrint Animals\n");
            WordLists.print(net.noisynarwhal.sophocles.Main.ANIMALS_RESOURCE);
            System.out.println("\nPrint Animals\n");
        } else {
            System.out.println("\nPrint Adjectives\n");
            WordLists.print(net.noisynarwhal.sophocles.Main.ADJECTIVES_RESOURCE);
            System.out.println("\nPrint Adjectives\n");
        }
    }

}
