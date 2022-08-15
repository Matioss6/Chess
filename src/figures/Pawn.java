package figures;

import java.util.ArrayList;
import java.util.HashMap;

import board.ChessBoard;


public class Pawn extends Figure {

    public Pawn(boolean white, char y, char x) {
        super(white, y, x);

    }

    public void move(ArrayList<Character> list) {


        char y1 = this.position.get(0);
        char x1 = this.position.get(1);
        char y2 = list.get(0);
        char x2 = list.get(1);

        if (this.white) {
            if (y2 == y1 + 1 && x2 == x1 && !ChessBoard.chessBoardMap.containsKey(list)) {
                ChessBoard.move(list, this);
                position = list;
                System.out.println("pawn moved 1 up");
            } else if (y2 == y1 + 2 && y1 == '2' && x2 == x1 && !ChessBoard.chessBoardMap.containsKey(list)) {
                ChessBoard.move(list, this);
                position = list;
                System.out.println("pawn moved 2 up");
            } else if (y2 == y1 + 1 && (x2 == x1 + 1 || x2 == x1 - 1) && ChessBoard.chessBoardMap.containsKey(list) && !ChessBoard.chessBoardMap.get(list).white) {
                System.out.println("Kill to " + ChessBoard.chessBoardMap.get(list).getClass());
                ChessBoard.move(list, this);
                position = list;
            } else {
                System.out.println("wrong move - try different one");
            }
        } else {
            if (y2 == y1 - 1 && x2 == x1 && !ChessBoard.chessBoardMap.containsKey(list)) {
                ChessBoard.move(list, this);
                position = list;
                System.out.println("pawn moved 1 down");
            } else if (y2 == y1 - 2 && y1 == '7' && x2 == x1 && !ChessBoard.chessBoardMap.containsKey(list)) {
                ChessBoard.move(list, this);
                position = list;
                System.out.println("pawn moved 2 down");
            } else if (y2 == y1 - 1 && (x2 == x1 + 1 || x2 == x1 - 1) && ChessBoard.chessBoardMap.containsKey(list) && ChessBoard.chessBoardMap.get(list).white) {
                System.out.println("Kill to " + ChessBoard.chessBoardMap.get(list).getClass());
                ChessBoard.move(list, this);
                position = list;
            } else {
                System.out.println("wrong move - try different one");
            }
        }
    }

    public boolean possibleMoves(HashMap<ArrayList<Character>, Figure> map, boolean print) {

        possibilities.clear();
        char y1 = position.get(0);
        char x1 = position.get(1);


        if (this.white) {

            boolean present = true;
            ArrayList<Character> posTemp1 = new ArrayList<>();
            ArrayList<Character> posTemp2 = new ArrayList<>();
            ArrayList<Character> posTemp3 = new ArrayList<>();
            ArrayList<Character> posTemp4 = new ArrayList<>();

            posTemp1.add((char) (y1 + 1));
            posTemp1.add((char) (x1 + 1));
            if (map.containsKey(posTemp1) && !map.get(posTemp1).white) {
                possibilities.add(posTemp1);
            }

            posTemp2.add((char) (y1 + 1));
            posTemp2.add((char) (x1 - 1));
            if (map.containsKey(posTemp2) && !map.get(posTemp2).white) {
                possibilities.add(posTemp2);
            }

            posTemp3.add((char) (y1 + 1));
            posTemp3.add(x1);

            if (!map.containsKey(posTemp3)) {
                possibilities.add(posTemp3);
                present = false;
            }


            posTemp4.add((char) (y1 + 2));
            posTemp4.add(x1);
            if (!map.containsKey(posTemp4) && !present && y1 == '2') {
                possibilities.add(posTemp4);
            }

        }
        if (!this.white) {

            boolean present = true;
            ArrayList<Character> posTemp1 = new ArrayList<>();
            ArrayList<Character> posTemp2 = new ArrayList<>();
            ArrayList<Character> posTemp3 = new ArrayList<>();
            ArrayList<Character> posTemp4 = new ArrayList<>();

            posTemp1.add((char) (y1 - 1));
            posTemp1.add((char) (x1 + 1));
            if (map.containsKey(posTemp1) && map.get(posTemp1).white) {
                possibilities.add(posTemp1);
            }
            posTemp2.add((char) (y1 - 1));
            posTemp2.add((char) (x1 - 1));
            if (map.containsKey(posTemp2) && map.get(posTemp2).white) {
                possibilities.add(posTemp2);

            }
            posTemp3.add((char) (y1 - 1));
            posTemp3.add(x1);
            if (!map.containsKey(posTemp3)) {
                possibilities.add(posTemp3);
                present = false;
            }
            posTemp4.add((char) (y1 - 2));
            posTemp4.add(x1);
            if (!map.containsKey(posTemp4) && !present && y1 == '7') {
                possibilities.add(posTemp4);
            }

        }

        return super.possibleMoves(map, print);


    }
}
