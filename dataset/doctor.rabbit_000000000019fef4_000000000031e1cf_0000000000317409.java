import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Solution {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numOfCases = in.nextInt();
        int current_c = 1;

        while(in.hasNextInt()) {
            int X_EAST = in.nextInt();
            int Y_NORTH = in.nextInt();
            String purrMove_String = in.next();

            int MAX_TURN = purrMove_String.length();
            int CURRENT_TURN = 0;
            List<PurrCat> purrCatMovementList_arrayList = new ArrayList<PurrCat>();
            String[] purrMove_array;
            // Convert movement to String
            purrMove_array = purrMove_String.split("");

            //Initial position
            PurrCat initialPurrCatPosition = new PurrCat(0+X_EAST , 0+Y_NORTH, CURRENT_TURN);
            purrCatMovementList_arrayList.add(initialPurrCatPosition);

            int current_pos_x = initialPurrCatPosition.x;
            int current_pos_y = initialPurrCatPosition.y;

            //Check What are the movements, put them into movement List
            for (int i=0; i < purrMove_array.length; i++) {
                if ( purrMove_array[i].equals("N") ){
                    current_pos_y +=1;
                    CURRENT_TURN+=1;
                    PurrCat nextPurrCatPosition = new PurrCat(current_pos_x , current_pos_y,CURRENT_TURN);
                    purrCatMovementList_arrayList.add(nextPurrCatPosition);
                }
                else if ( purrMove_array[i].equals("E")) {
                    current_pos_x +=1;
                    CURRENT_TURN+=1;
                    PurrCat nextPurrCatPosition = new PurrCat(current_pos_x , current_pos_y,CURRENT_TURN);
                    purrCatMovementList_arrayList.add(nextPurrCatPosition);
                }
                else if ( purrMove_array[i].equals("W")) {
                    current_pos_x -=1;
                    CURRENT_TURN+=1;
                    PurrCat nextPurrCatPosition = new PurrCat(current_pos_x , current_pos_y,CURRENT_TURN);
                    purrCatMovementList_arrayList.add(nextPurrCatPosition);
                }
                else if ( purrMove_array[i].equals("S")) {
                    current_pos_y -=1;
                    CURRENT_TURN+=1;
                    PurrCat nextPurrCatPosition = new PurrCat(current_pos_x , current_pos_y,CURRENT_TURN);
                    purrCatMovementList_arrayList.add(nextPurrCatPosition);
                }
            }

            //impossible check
            boolean isPossible = false;
            int turnsNeeded = Integer.MAX_VALUE;
            for (PurrCat p : purrCatMovementList_arrayList) {
                if ( Math.abs(p.x) + Math.abs(p.y) > MAX_TURN )
                    continue;
                else if ( Math.abs(p.x) + Math.abs(p.y) > p.turn)
                    continue;
                else {
                    if ( turnsNeeded > p.turn ) {
                        turnsNeeded = p.turn;
                        isPossible = true;
                    }
                }
            }
            //if possible,
            if (isPossible) {
                System.out.println("Case #" + current_c + ": " + turnsNeeded);
            }
            else {
                System.out.println("Case #" + current_c + ": IMPOSSIBLE");
            }
            //tracking how many moves do we need
            current_c++;
        }
    }
}

// PurrCat Location
class PurrCat {
    int x;
    int y;
    int turn;
    public PurrCat(int x, int y, int turn) {
        this.x=x;
        this.y=y;
        this.turn=turn;
    }
}