package board;

import java.io.Serializable;

public class PlaceableBehavior  implements Serializable {
        private Square square;

        public PlaceableBehavior(Square square) {
                this.square = square;
        }

        public Square getSquare() {
                return square;
        }

        public void setSquare(Square square) {
                this.square = square;
        }
}
