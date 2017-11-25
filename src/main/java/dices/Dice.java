package dices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents the concept of a dice that contains a list of sides and can be rolled.
 * @param <T> The type of sides, in case the dice doesn't have integer values on it.
 */

@Entity
public class Dice<T>  implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    int id;

    protected List<T> sides;
    protected int nbSides;


    /**
     * Rolls the dice once
     * @return a random value from "sides"
     */
    public T roll() {
        return sides.get(new Random().nextInt(nbSides));
    }


    /**
     * Rolls the dice "nbRolls" times
     * @param nbRolls the amount of times to roll the dice
     * @return a list of random values from "sides"
     */
    public List<T> roll(int nbRolls) {
        List<T> results = new ArrayList<>();
        for(int i = 0; i < nbRolls; i++)
            results.add(roll());
        return results;
    }

    /**
     * Constructor
     * @param sides : The list containing all of the dice's sides
     * @param nbSides : The amount of sides
     */
    public Dice(List<T> sides, int nbSides) {
        this.sides = sides;
        this.nbSides = nbSides;
    }

    /**
     * Constructor
     * @param nbSides : The amount of sides
     */
    public Dice(int nbSides) {
        this.sides = new ArrayList<>();
        this.nbSides = nbSides;
    }

    /**
     * Constructor
     */
    public Dice() {
        this.sides = new ArrayList<>();
        this.nbSides = 0;
    }


    public List<T> getSides() {
        return sides;
    }

    public void setSides(List<T> sides) {
        this.sides = sides;
    }

    public int getNbSides() {
        return nbSides;
    }

    public void setNbSides(int nbSides) {
        this.nbSides = nbSides;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "id=" + id +
                ", sides=" + sides +
                ", nbSides=" + nbSides +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dice<?> dice = (Dice<?>) o;

        if (id != dice.id) return false;
        if (nbSides != dice.nbSides) return false;
        return sides != null ? sides.equals(dice.sides) : dice.sides == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sides != null ? sides.hashCode() : 0);
        result = 31 * result + nbSides;
        return result;
    }
}
