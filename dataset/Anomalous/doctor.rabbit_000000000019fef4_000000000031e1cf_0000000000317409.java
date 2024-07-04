import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfCases = in.nextInt();
        for (int currentCase = 1; currentCase <= numOfCases; currentCase++) {
            int xEast = in.nextInt();
            int yNorth = in.nextInt();
            String purrMoveString = in.next();

            int maxTurn = purrMoveString.length();
            int currentTurn = 0;
            List<PurrCat> purrCatMovementList = new ArrayList<>();
            String[] purrMoveArray = purrMoveString.split("");

            PurrCat initialPurrCatPosition = new PurrCat(xEast, yNorth, currentTurn);
            purrCatMovementList.add(initialPurrCatPosition);

            int currentPosX = initialPurrCatPosition.x;
            int currentPosY = initialPurrCatPosition.y;

            for (String move : purrMoveArray) {
                switch (move) {
                    case "N":
                        currentPosY++;
                        break;
                    case "E":
                        currentPosX++;
                        break;
                    case "W":
                        currentPosX--;
                        break;
                    case "S":
                        currentPosY--;
                        break;
                }
                currentTurn++;
                PurrCat nextPurrCatPosition = new PurrCat(currentPosX, currentPosY, currentTurn);
                purrCatMovementList.add(nextPurrCatPosition);
            }

            boolean isPossible = false;
            int turnsNeeded = Integer.MAX_VALUE;
            for (PurrCat p : purrCatMovementList) {
                int manhattanDistance = Math.abs(p.x) + Math.abs(p.y);
                if (manhattanDistance <= maxTurn && manhattanDistance <= p.turn && turnsNeeded > p.turn) {
                    turnsNeeded = p.turn;
                    isPossible = true;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + currentCase + ": " + turnsNeeded);
            } else {
                System.out.println("Case #" + currentCase + ": IMPOSSIBLE");
            }
        }
    }
}

class PurrCat {
    int x;
    int y;
    int turn;

    public PurrCat(int x, int y, int turn) {
        this.x = x;
        this.y = y;
        this.turn = turn;
    }
}