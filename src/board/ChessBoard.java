package board;

import figures.*;

import java.io.Serializable;
import java.util.*;


/**
 * Doku
 * Hello
 * Lets
 * Check
 * This
 * Out
 */

/*
  Not the same - yet similar ;)
   */
public class ChessBoard implements Serializable {

    static public HashMap<ArrayList<Character>, Figure> chessBoardMap = new HashMap<>();     
    static public HashMap<ArrayList<Character>, Figure> chessBoardMapCheck = new HashMap<>();
    public HashMap<ArrayList<Character>, Figure> saveChessBoardMap = new HashMap<>();
    static public King blackKing = new King(false, '8', 'e');
    static public King whiteKing = new King(true, '1', 'e');



    public void create() {

        for (char i = 'a'; i <= 'h'; i++) {

            addFigure(new Pawn(true, '2', i));
            addFigure(new Pawn(false, '7', i));
        }

        addFigure(new Queen(true, '1', 'd'));
        addFigure(new Queen(false, '8', 'd'));
        addFigure(whiteKing);
        addFigure(blackKing);
        addFigure(new Rook(true, '1', 'a'));
        addFigure(new Rook(false, '8', 'a'));
        addFigure(new Rook(true, '1', 'h'));
        addFigure(new Rook(false, '8', 'h'));
        addFigure(new Knight(true, '1', 'b'));
        addFigure(new Knight(false, '8', 'b'));
        addFigure(new Knight(true, '1', 'g'));
        addFigure(new Knight(false, '8', 'g'));
        addFigure(new Bishop(true, '1', 'c'));
        addFigure(new Bishop(false, '8', 'c'));
        addFigure(new Bishop(true, '1', 'f'));
        addFigure(new Bishop(false, '8', 'f'));


    }

    public void addFigure(Figure figure) {
        chessBoardMap.put(figure.getPosition(), figure);

    }

    public static void move(ArrayList<Character> position, Figure figure) {

        chessBoardMap.remove(figure.getPosition());
        chessBoardMap.put(position, figure);


    }

    public static void checkMoveWithMate(ArrayList<Character> position, Figure figure) {

        chessBoardMapCheck.clear();
        chessBoardMapCheck.putAll(chessBoardMap);
        chessBoardMapCheck.remove(figure.getPosition());
        chessBoardMapCheck.put(position, figure);


    }


}
