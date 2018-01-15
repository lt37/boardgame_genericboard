package board;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class PlaceableBehavior  implements Serializable {
    @Id
    int id;

    @OneToOne
    private Square square;

    public PlaceableBehavior() {}

    public PlaceableBehavior(Square square) {
                this.square = square;
        }

    public PlaceableBehavior(int id, Square square) {
        this.id = id;
        this.square = square;
    }

    public Square getSquare() {
                return square;
        }

    public void setSquare(Square square) {
                this.square = square;
        }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
    }
}
