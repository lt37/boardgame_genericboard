package boards;

import board.Board;
import board.IPlaceable;
import board.PlaceableBehavior;
import board.Square;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {


    private class Token implements IPlaceable{

        private int id;
        private PlaceableBehavior placeableBehavior ;

        public Token(int id, Square square){

            this.id = id;
            this.placeableBehavior = new PlaceableBehavior(square);
        }

        public int getId() {
            return id;
        }

        @Override
        public Square getSquare() {
            return placeableBehavior.getSquare();
        }

        @Override
        public void setSquare(Square newSquare) {
            placeableBehavior.setSquare(newSquare);

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Token token = (Token) o;

            return id == token.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }



    /**
     * Test of putTokenOn
     */
    @Test
    public void putTokenOnTest(){
        Board board = new Board("Test",5,5);
        IPlaceable token = new Token(5,null);
        board.putTokenOn(token,1,0);
        assertTrue(token.equals(board.getSquares().get(1).getTokens().get(0)));

    }


    @Test
    public void getSquareOnCoordTestTrue(){
        Board board = new Board("Test",5,5);
        assertTrue(board.getSquares().get(1).equals(board.getSquareOnCoord(1,0)));
    }

    @Test
    public void getSquareOnCoordTestFalse(){
        Board board = new Board("Test",5,5);
        assertFalse(board.getSquares().get(1).equals(board.getSquareOnCoord(0,1)));
    }


    @Test
    public void convertCoordToIndexTest(){
        Board board = new Board("Test",5,5);
        IPlaceable token = new Token(5,null);
        board.getSquares().get(board.convertCoordToIndex(1,0)).addToken(token);
        assertTrue(token.equals(board.getSquares().get(1).getTokens().get(0)));
    }


    @Test
    public void moveTokenDiagTest(){
        Board board = new Board("Test",5,5);
        IPlaceable token = new Token(5,null);
        board.getSquares().get(board.convertCoordToIndex(1,0)).addToken(token);
        board.movement(token,4,1);
        assertTrue(token.equals(board.getSquares().get(7).getTokens().get(0)));
    }

}
