import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String M = in.next();
            System.out.println("Case #" + i + ": " + solve(X, Y, M));
        }
        // write your code here
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String solve(int X, int Y, String M) {
        String res = "";
        int[][] coords = new int[M.length() + 1][3];
        coords[0][0] = X;
        coords[0][1] = Y;
        for (int i = 0; i < M.length(); i++){
            char move = M.charAt(i);
            int x = coords[i][0];
            int y = coords[i][1];

            if (move == 'N'){
                y++;
            }

            if (move == 'S'){
                y--;
            }

            if (move == 'E'){
                x++;
            }

            if (move == 'W'){
                x--;
            }

            coords[i+1][0] = x;
            coords[i+1][1] = y;
        }
        

        int minMovesCountToReachable = 0;
        int[] closestCoordReachable = null;

        for (int i = 0; i < coords.length; i++){
            int distance = Math.abs(coords[i][0]) + Math.abs(coords[i][1]);
            if (distance <= i){
                if (closestCoordReachable == null || i < minMovesCountToReachable) {
                    closestCoordReachable = coords[i];
                    minMovesCountToReachable = i;

                }
            }
        }


        return closestCoordReachable == null ? IMPOSSIBLE : String.valueOf(minMovesCountToReachable);
    }

}
