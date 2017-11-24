package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    protected List<Card> cards;

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    /**
     * draw(nb)
     *
     * Get 'nb' cards on the top of the Deck.
     * @param nb : Number of cards drawn.
     * @return List of cards drawn.
     */
    public List<Card> draw(int nb){
        List<Card> drawedCards = new ArrayList<>();
        for(int i=0; (i<cards.size() && i<nb); i++){
            drawedCards.add(cards.get(0));
            cards.remove(0);
        }
        return drawedCards;
    }

    /**
     * draw(int index, int nb)
     *
     * Get 'nb' cards from the 'index' position in the Deck.
     * @param index : Position from where the draw start.
     * @param nb : Number of cards drawn.
     * @return List of cards drawn.
     */
    public List<Card> draw(int index, int nb){
        if(index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
        List<Card> drawedCards = new ArrayList<>();
        for(int i=0; ((i+index)<cards.size() && i<nb); i++){
            drawedCards.add(cards.get(index));
            cards.remove(index);
        }
        return drawedCards;
    }

    /**
     * shuffle()
     *
     * Shuffle the deck, use the method shuffle from Collections.
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * cut(int index)
     *
     * Cut the deck in two part, the cut is made at the 'index' position
     * @param index : Position from where the deck is cut
     * @return List of cards in the second pack of cards
     */
    public List<Card> cut(int index){
        if(index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
        List<Card> secondPart = new ArrayList<>();

        // Look if index is in the second half of the deck
        if(index > (cards.size()/2)) {
            for (int i = index; i < cards.size(); i++) {
                secondPart.add(cards.get(index));
                cards.remove(index);
            }
        }
        // If not, take all card before the index
        else {
            for(int i = index; i>=0; i--){
                secondPart.add(cards.get(i));
                cards.remove(i);
            }
        }
        return secondPart;
    }

    /**
     * reveal(int index, int nb)
     *
     * Reveal 'nb' cards from the 'index' position
     * @param index : Position from where cards started to be revealed
     * @param nb : Number of cards to be revealed
     * @return List of cards revealed
     */
    public List<Card> reveal(int index, int nb){
        if(index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
        List<Card> revealedCards = new ArrayList<>();
        for(int i=0; ((i+index)<cards.size() && i<nb); i++){
            revealedCards.add(cards.get(i+index));
        }
        return revealedCards;
    }

    /**
     * addCards(List addedCards, int index)
     *
     * Add a pack of cards in the deck at a fixed position
     * @param addedCards : List of cards to be add in the deck
     * @param index : Position from where cards will be add
     */
    public void addCards(List<Card> addedCards, int index){
        if(index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
        for (Card card:addedCards) {
            cards.add(index, card);
        }
    }

    public void addCard(Card addedCard, int index){
        if(index >= cards.size()){
            throw new IndexOutOfBoundsException();
        }
            cards.add(index, addedCard);
    }
}
