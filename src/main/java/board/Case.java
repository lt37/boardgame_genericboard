package board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Case {

    private List<IPlaceable> tokens = new ArrayList<>();
    private int[] coordonate;


    Case(int[] coordonate) {
        this.coordonate = coordonate;
    }

    public List<IPlaceable> getTokens() {
        return tokens;
    }

    public void setTokens(List<IPlaceable> tokens) {
        this.tokens = tokens;
    }

    public int[] getCoordonate() {
        return coordonate;
    }

    public void setCoordonate(int[] coordonate) {
        this.coordonate = coordonate;
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
        if (!(o instanceof Case)) return false;

        Case aCase = (Case) o;

        if (tokens != null ? !tokens.equals(aCase.tokens) : aCase.tokens != null) return false;
        return Arrays.equals(coordonate, aCase.coordonate);
    }

    @Override
    public int hashCode() {
        int result = tokens != null ? tokens.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(coordonate);
        return result;
    }
}
