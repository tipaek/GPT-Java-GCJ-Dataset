
import java.util.*;
import java.io.*;

public class Solution {

    private static void runTest(int x, int y, String moves){

        for (int move = 0; move <= moves.length(); move++){

            // System.out.println("X: " + x + ", Y: " + y + ", Move: " + move);

            if (Math.abs(x) + Math.abs(y) <= move){
                System.out.println(move);
                return;
            }
            else if (move == moves.length()){
                System.out.println("IMPOSSIBLE");
                return;
            }

            if (moves.charAt(move) == 'N'){
                y = y + 1;
            }
            else if (moves.charAt(move) == 'S'){
                y =  y - 1;
            }
            else if (moves.charAt(move) == 'E'){
                x = x + 1;
            }
            else{
                x = x - 1;
            }

        }

    }

    public static void main(String[] args){
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();

            System.out.print("Case #" + i + ": ");

            runTest(x, y, s);

        }

    in.close();
        
    }

}