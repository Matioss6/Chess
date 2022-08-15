import board.ChessBoard;
import figures.Figure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Chess {

    ChessBoard chessBoard = new ChessBoard();
    boolean noWinner = true;
    boolean moveWhite = true;


    public static void main(String[] args) {
        new Chess().go();

    }

    public void go() {

        boolean loaded = load();
        if (!loaded) chessBoard.create();

        while (noWinner) {
            boolean validMove = false;
            boolean wrongMove;

            while (!validMove) {
                Figure figure = whatToMove();
                validMove = figure.possibleMoves(ChessBoard.chessBoardMap, true);
                if (validMove) {
                    ArrayList<Character> move = whereToMove();

                    if (checkMate(ChessBoard.chessBoardMap)) {
                        ChessBoard.checkMoveWithMate(move, figure);
                        wrongMove = checkMate(ChessBoard.chessBoardMapCheck);
                        if (wrongMove) {
                            System.out.println("Wrong move - You have to protect the KING");
                            break;
                        }

                    }
                    moveWhite = !moveWhite;
                    figure.move(move);
                    checkMate(ChessBoard.chessBoardMap);


                }
            }
        }
    }

    public Figure whatToMove() {

        ArrayList<Character> whatToMove = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        while (!ChessBoard.chessBoardMap.containsKey(whatToMove) || moveWhite != ChessBoard.chessBoardMap.get(whatToMove).white) {

            String myInput = "null";

            while (myInput.length() != 2 && !myInput.equals("save")) {
                System.out.println("Which Figure do You want to go now? Type (1-8, a-h) eg. 5d or save to save");
                myInput = keyboard.next();
            }
            if (myInput.equals("save")) {
                save();
            }
            whatToMove.clear();
            whatToMove.add(0, myInput.charAt(0));
            whatToMove.add(1, myInput.charAt(1));
            if (ChessBoard.chessBoardMap.containsKey(whatToMove) && moveWhite != ChessBoard.chessBoardMap.get(whatToMove).white) {
                System.out.println("Now its time for different Colour");
            } else if (!ChessBoard.chessBoardMap.containsKey(whatToMove)) {
                System.out.println("No figure at this coordinates");
            }
        }
        return ChessBoard.chessBoardMap.get(whatToMove);

    }

    public ArrayList<Character> whereToMove() {

        ArrayList<Character> whereToMove = new ArrayList<>();
        String myInput = "letsGo";
        Scanner keyboard = new Scanner(System.in);


        System.out.println("Where do You want to move ? Type (1-8, a-h) eg. 5d");
        try {
            while (myInput.length() != 2 || myInput.charAt(0) < '1' || myInput.charAt(0) > '8' || myInput.charAt(1) > 'h' || myInput.charAt(1) < 'a') {
                myInput = keyboard.next();
                if (myInput.length() != 2 || myInput.charAt(0) < '1' || myInput.charAt(0) > '8' || myInput.charAt(1) > 'h' || myInput.charAt(1) < 'a')
                    System.out.println("Type correct value");

            }
        } catch (Exception ex) {
            System.out.println("Type correct value");
        }
        whereToMove.clear();

        whereToMove.add(0, myInput.charAt(0));
        whereToMove.add(1, myInput.charAt(1));

        return whereToMove;

    }

    public boolean checkMate(HashMap<ArrayList<Character>, Figure> map) {

        ArrayList<ArrayList<Character>> checkMate = new ArrayList<>();
        boolean mate = false;


        for (Figure figure : map.values()) {
            figure.possibleMoves(map, false);
            checkMate.addAll(figure.getPossibilities());

            for (ArrayList<Character> characters : checkMate) {
                if (characters.equals(ChessBoard.whiteKing.getPosition()) || characters.equals(ChessBoard.blackKing.getPosition())) {
                    mate = true;
                }

            }

        }
        if (mate) {
            System.out.println("Check");
        }

        return mate;
    }

    public void save() {


        try {
            FileOutputStream save = new FileOutputStream("saveGry.ser");
            ObjectOutputStream saveOb = new ObjectOutputStream(save);
            chessBoard.saveChessBoardMap = ChessBoard.chessBoardMap;
            saveOb.writeObject(chessBoard);
            saveOb.writeObject(moveWhite);
            saveOb.close();
            System.exit(0);
        } catch (Exception os) {
            System.out.println("Something Went Wrong while saving");
        }
    }

    public boolean load() {
        int myInput = 0;

        while (myInput != 1 && myInput != 2) {
            System.out.println("Write 1 to load a game, write 2 start new one\n");
            Scanner keyboard = new Scanner(System.in);
            try {
                myInput = keyboard.nextInt();
                if (myInput != 1 && myInput != 2)
                    System.out.println("1 or 2 - it's not that hard");

            } catch (Exception ex) {
                System.out.println("1 or 2 - it's not that hard");
            }
        }
        if (myInput == 1) {
            try {
                FileInputStream load = new FileInputStream("saveGry.ser");
                ObjectInputStream Ob = new ObjectInputStream(load);
                chessBoard = (ChessBoard) Ob.readObject();
                moveWhite = (boolean) Ob.readObject();
                ChessBoard.chessBoardMap = chessBoard.saveChessBoardMap;
                Ob.close();
                System.out.print(ChessBoard.chessBoardMap);
                return true;
            } catch (Exception os) {
                System.out.println("No save available - starting new one");
            }
        }
        return false;


    }


}
