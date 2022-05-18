/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.noisynarwhal.sophocles;

import static net.noisynarwhal.sophocles.Main.ANIMALS_RESOURCE;
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
     */
    @Test
    public void testPrint() throws Exception {
        System.out.println("print animals");
        WordLists.print(ANIMALS_RESOURCE);
    }

}
