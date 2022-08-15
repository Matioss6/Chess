package figures;

import board.ChessBoard;

import java.util.ArrayList;
import java.util.HashMap;

public class Rook extends Figure {

    public Rook(boolean white, char x, char y) {
        super(white, x, y);
    }

    public void move(ArrayList<Character> list) {

        ChessBoard.move(list, this);
        position = list;

    }

    public boolean possibleMoves(HashMap<ArrayList<Character>, Figure> map, boolean print) {

        possibilities.clear();
        char y = position.get(0);
        char x = position.get(1);

        for (char i = (char) (y + 1); i <= '8'; ++i) {

            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(i);
            posTemp.add(x);

            if (!map.containsKey(posTemp)) {
                possibilities.add(posTemp);

            } else if (map.get(posTemp).white != this.white) {
                possibilities.add(posTemp);
                break;
            } else if (map.get(posTemp).white == this.white) {
                break;
            }

        }

        for (char i = (char) (y - 1); i >= '1'; --i) {

            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(i);
            posTemp.add(x);

            if (!map.containsKey(posTemp)) {
                possibilities.add(posTemp);

            } else if (map.get(posTemp).white != this.white) {
                possibilities.add(posTemp);
                break;
            } else if (map.get(posTemp).white == this.white) {
                break;
            }
        }

        for (char i = (char) (x + 1); i <= 'h'; ++i) {

            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(y);
            posTemp.add(i);

            if (!map.containsKey(posTemp)) {
                possibilities.add(posTemp);


            } else if (map.get(posTemp).white != this.white) {
                possibilities.add(posTemp);

                break;
            } else if (map.get(posTemp).white == this.white) {

                break;
            }
        }

        for (char i = (char) (x - 1); i >= 'a'; --i) {

            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(y);
            posTemp.add(i);
            if (!map.containsKey(posTemp)) {
                possibilities.add(posTemp);

            } else if (map.get(posTemp).white != this.white) {
                possibilities.add(posTemp);
                break;
            } else if (map.get(posTemp).white == this.white) {
                break;
            }
        }

        return super.possibleMoves(map, print);

    }

}
