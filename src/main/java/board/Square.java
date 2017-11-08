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
        for(IPlaceable token : this.tokens) {
            token.setSquare(null);
        }
        this.tokens = tokens;
        for(IPlaceable token : this.tokens) {
            token.setSquare(this);
        }
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void addToken(IPlaceable token){
        tokens.add(token);
        token.setSquare(this);
    }

    public void addTokens(List<IPlaceable> tokenList){
        tokens.addAll(tokenList);
        for (IPlaceable token : tokenList){
            token.setSquare(this);
        }
    }

    public void removeToken(IPlaceable token){
        tokens.remove(token);
        token.setSquare(null);

    }

    public void removeAllToken(){
        tokens.clear();
        for (IPlaceable token : tokens){
            token.setSquare(null);
        }
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
