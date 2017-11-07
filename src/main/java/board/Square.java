package board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square {

    private List<IPlaceable> tokens = new ArrayList<>();
    private int[] coordinates;


    Square(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public List<IPlaceable> getTokens() {
        return tokens;
    }

    public void setTokens(List<IPlaceable> tokens) {
        this.tokens = tokens;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void addToken(IPlaceable token){
        tokens.add(token);
    }

    public void addTokens(List<IPlaceable> tokenList){
        tokens.addAll(tokenList);
    }

    public void removeToken(IPlaceable token){
        tokens.remove(token);

    }

    public void removeAllToken(){
        tokens.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square aSquare = (Square) o;

        if (tokens != null ? !tokens.equals(aSquare.tokens) : aSquare.tokens != null) return false;
        return Arrays.equals(coordinates, aSquare.coordinates);
    }

    @Override
    public int hashCode() {
        int result = tokens != null ? tokens.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(coordinates);
        return result;
    }
}
