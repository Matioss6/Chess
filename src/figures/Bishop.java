package figures;

import board.ChessBoard;

import java.util.ArrayList;
import java.util.HashMap;

public class Bishop extends Figure {

    public Bishop(boolean white, char x, char y) {
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

        for (char i = (char) (y + 1), b = (char) (x + 1); i <= '8' && b <= 'h'; i++, b++) {


            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(i);
            posTemp.add(b);

            if (!map.containsKey(posTemp)) {
                possibilities.add(posTemp);

            } else if (map.get(posTemp).white != this.white) {
                possibilities.add(posTemp);
                break;
            } else if (map.get(posTemp).white == this.white) {
                break;
            }

        }
        for (char i = (char) (y + 1), b = (char) (x - 1); i <= '8' && b >= 'a'; i++, b--) {


            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(i);
            posTemp.add(b);

            if (!map.containsKey(posTemp)) {
                possibilities.add(posTemp);

            } else if (map.get(posTemp).white != this.white) {
                possibilities.add(posTemp);
                break;
            } else if (map.get(posTemp).white == this.white) {
                break;
            }

        }
        for (char i = (char) (y - 1), b = (char) (x - 1); i >= '1' && b >= 'a'; i--, b--) {


            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(i);
            posTemp.add(b);


            if (!map.containsKey(posTemp)) {
                possibilities.add(posTemp);

            } else if (map.get(posTemp).white != this.white) {
                possibilities.add(posTemp);
                break;
            } else if (map.get(posTemp).white == this.white) {
                break;
            }

        }
        for (char i = (char) (y - 1), b = (char) (x + 1); i >= '1' && b <= 'h'; i--, b++) {


            ArrayList<Character> posTemp = new ArrayList<>();

            posTemp.add(i);
            posTemp.add(b);


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
