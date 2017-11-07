package cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeckTest {

    private static final int NB_DRAWS = 5;

    private static Deck deck = new Deck();


    /**
     * Create a deck with 20 cards inside
     */
    @BeforeAll
    public static void setUpBeforeClass(){
        List<Card> cards = new ArrayList<>();
        Card card;
        for(int i=0; i<20; i++){
            card = new Card();
            card.setImage("ImageCard#"+String.valueOf(i));
            card.setName("TestCard#"+String.valueOf(i));
            cards.add(card);
        }
        deck.setCards(cards);
    }

    /**
     * Test the draw method on NB_DRAWS draws, making sure we draw the right amount of card
     */
    @Test
    void drawTest(){
        List<Card> drawedCards = deck.draw(NB_DRAWS);
        assertTrue(drawedCards.size() == NB_DRAWS, "Number of drawed cards is equal to (" + NB_DRAWS + ") ? ------> " + drawedCards.size());
    }

}