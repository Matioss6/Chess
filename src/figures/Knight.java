package figures;

import board.ChessBoard;

import java.util.ArrayList;
import java.util.HashMap;

public class Knight extends Figure {


    public Knight(boolean white, char x, char y) {
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

        char x1 = (char) (x + 2);
        char y1 = (char) (y + 1);
        char x2 = (char) (x + 2);
        char y2 = (char) (y - 1);
        char x3 = (char) (x - 2);
        char y3 = (char) (y + 1);
        char x4 = (char) (x - 2);
        char y4 = (char) (y - 1);
        char x5 = (char) (x + 1);
        char y5 = (char) (y + 2);
        char x6 = (char) (x - 1);
        char y6 = (char) (y + 2);
        char x7 = (char) (x + 1);
        char y7 = (char) (y - 2);
        char x8 = (char) (x - 1);
        char y8 = (char) (y - 2);
        addMove(x1, y1);
        addMove(x2, y2);
        addMove(x3, y3);
        addMove(x4, y4);
        addMove(x5, y5);
        addMove(x6, y6);
        addMove(x7, y7);
        addMove(x8, y8);

        return super.possibleMoves(map, print);

    }

    private void addMove(char x, char y) {


        if (x <= 'h' && x >= 'a' && y <= '8' && y >= '1') {
            ArrayList<Character> posTemp1 = new ArrayList<>();
            posTemp1.add(y);
            posTemp1.add(x);
            if (!ChessBoard.chessBoardMap.containsKey(posTemp1)) {
                possibilities.add(posTemp1);

            } else if (ChessBoard.chessBoardMap.get(posTemp1).white != this.white) {
                possibilities.add(posTemp1);
            }
        }

    }

}
