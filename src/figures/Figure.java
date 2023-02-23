package figures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Figure implements Serializable {

    ArrayList<Character> position = new ArrayList<>();
    ArrayList<ArrayList<Character>> possibilities = new ArrayList<>();
    public final boolean white;

    Figure(boolean whiteIsTrue, char a, char b) {
        white = whiteIsTrue;
        position.add(a);
        position.add(b);

    }


    public ArrayList<Character> getPosition() {
        return position;

    }

    public ArrayList<ArrayList<Character>> getPossibilities() {
        return possibilities;

    }

    abstract public void move(ArrayList<Character> list);

    public boolean possibleMoves(HashMap<ArrayList<Character>, Figure> map, boolean print) {

        if (!possibilities.isEmpty()) {
            if (print) System.out.println(possibilities);
            return true;
        } else if (print) System.out.println("You can't move this figure");

        return false;
    }


}
