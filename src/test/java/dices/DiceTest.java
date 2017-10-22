package dices;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;
    private static final int NB_ROLLS = 100;

    private static Dice dice = new Dice();

    /**
     * Creates a 6 dice
     */
    @BeforeAll
    public static void setUpBeforeClass() {
        List<Integer> values = new ArrayList<>();
        for(int i = MIN_VALUE; i <= MAX_VALUE; i++)
            values.add(i);

        dice.setSides(values);
        dice.setNbSides(MAX_VALUE);
    }


    /**
     * Tests the roll() method on NB_ROLLS rolls, making sure the values are always within bounds
     */
    @Test
    void rollTest() {
        int result;
        for(int i = 0; i < NB_ROLLS; i++) {
            result = (int) dice.roll();
            assertTrue(result >= MIN_VALUE, "Rolled value (" + result + ") is inferior to MIN_VALUE (" + MIN_VALUE + ")");
            assertTrue(result <= MAX_VALUE, "Rolled value (" + result + ") is superior to MAX_VALUE (" + MAX_VALUE + ")");
        }
    }

    /**
     * Tests the roll(int nbRolls) method on NB_ROLLS rolls, making sure the values are always within bounds and that the
     * correct amount of rolls is executed.
     */
    @Test
    void rollSeveralTest() {
        List<Integer> results = dice.roll(NB_ROLLS);
        int result;

        assertEquals(NB_ROLLS, results.size());
        for(int i = 0; i < NB_ROLLS; i++) {
            result = results.get(i);
            assertTrue(result >= MIN_VALUE, "Rolled value (" + result + ") is inferior to MIN_VALUE (" + MIN_VALUE + ")");
            assertTrue(result <= MAX_VALUE, "Rolled value (" + result + ") is superior to MAX_VALUE (" + MAX_VALUE + ")");
        }
    }

}