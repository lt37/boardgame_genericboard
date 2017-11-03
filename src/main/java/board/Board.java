package board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Case> cases= new ArrayList<>();
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
            cases.add(new Case(coord));
        }
    }

    public Board(String name,List<Case> cases, int column,int lines){
        this.name = name;
        this.cases = cases;
        this.columns = column;
        this.lines = lines;
    }
    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
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
        if (cases != null ? !cases.equals(board.cases) : board.cases != null) return false;
        return name != null ? name.equals(board.name) : board.name == null;
    }

    @Override
    public int hashCode() {
        int result = cases != null ? cases.hashCode() : 0;
        result = 31 * result + lines;
        result = 31 * result + columns;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /**
     *
     * @param token
     * @param direction    1 (default) :TOP 2:TOP/RIGHT 3:RIGHT 4:BOTTOM/RIGHT 5:BOTTOM 6:BOTTOM/LEFT 7:LEFT 8: (default) TOP/LEFT
     * @param nbCase
     */
    public void movement(IPlaceable token, int direction, int nbCase) {
        int[] initialCoordinate = token.getCase().getCoordonate();
        token.getCase().removeToken(token);
        int tabPlacment = this.columns*initialCoordinate[1]+initialCoordinate[0];

        //TODO: Traiter l'erreur et la faire remonter
        try{
        switch(direction) {
            case 1: default: this.cases.get(tabPlacment-(this.columns*nbCase)).addToken(token);
            break;
            case 2: this.cases.get(tabPlacment-(this.columns*nbCase)+nbCase).addToken(token);
            break;
            case 3: this.cases.get(tabPlacment+nbCase);
            break;
            case 4: this.cases.get(tabPlacment+(this.columns*nbCase)+nbCase).addToken(token);
            break;
            case 5: this.cases.get(tabPlacment+(this.columns*nbCase)).addToken(token);
            break;
            case 6: this.cases.get(tabPlacment+(this.columns*nbCase)-nbCase).addToken(token);
            break;
            case 7: this.cases.get(tabPlacment-nbCase);
            break;
            case 8: this.cases.get(tabPlacment-(this.columns*nbCase)-nbCase).addToken(token);
            break;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
