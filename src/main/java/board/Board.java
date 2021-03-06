package board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Square> squares = new ArrayList<>();
    private int lines;
    private int columns;
    private String name;


    public Board(String name,int lines, int column) {
        this.lines = lines;
        this.columns = column;
        this.name = name;
        for(int i=0;i<column*lines;i++){
            int[] coord = new int[2];
            coord[0]=i%column;
            coord[1]=((i-i%column)/column);
            squares.add(new Square(coord));
        }
    }

    public Board(String name, List<Square> squares, int column, int lines){
        this.name = name;
        this.squares = squares;
        this.columns = column;
        this.lines = lines;
    }
    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumn() {
        return columns;
    }

    public void setColumn(int column) {
        this.columns = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;

        Board board = (Board) o;

        if (lines != board.lines) return false;
        if (columns != board.columns) return false;
        if (squares != null ? !squares.equals(board.squares) : board.squares != null) return false;
        return name != null ? name.equals(board.name) : board.name == null;
    }

    @Override
    public int hashCode() {
        int result = squares != null ? squares.hashCode() : 0;
        result = 31 * result + lines;
        result = 31 * result + columns;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /**
     *
     * @param token
     * @param direction    1 (default) :TOP 2:TOP/RIGHT 3:RIGHT 4:BOTTOM/RIGHT 5:BOTTOM 6:BOTTOM/LEFT 7:LEFT 8: (default) TOP/LEFT
     * @param nbSquares
     */
    public void movement(IPlaceable token, int direction, int nbSquares) {
        int[] initialCoordinate = token.getSquare().getCoordinates();
        token.getSquare().removeToken(token);
        int tabPlacment = this.columns*initialCoordinate[1]+initialCoordinate[0];

        //TODO: Traiter l'erreur et la faire remonter
        try{
        switch(direction) {
            case 2: this.squares.get(tabPlacment-(this.columns*nbSquares)+nbSquares).addToken(token);
            break;
            case 3: this.squares.get(tabPlacment+nbSquares);
            break;
            case 4: this.squares.get(tabPlacment+(this.columns*nbSquares)+nbSquares).addToken(token);
            break;
            case 5: this.squares.get(tabPlacment+(this.columns*nbSquares)).addToken(token);
            break;
            case 6: this.squares.get(tabPlacment+(this.columns*nbSquares)-nbSquares).addToken(token);
            break;
            case 7: this.squares.get(tabPlacment-nbSquares);
            break;
            case 8: this.squares.get(tabPlacment-(this.columns*nbSquares)-nbSquares).addToken(token);
            break;
            default: this.squares.get(tabPlacment-(this.columns*nbSquares)).addToken(token);
            break;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
