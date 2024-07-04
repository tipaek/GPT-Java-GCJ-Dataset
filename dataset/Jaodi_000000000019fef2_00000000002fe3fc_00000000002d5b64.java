import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int s = in.nextInt();
            int currR = r;
            ArrayList<ArrayList<Integer>> moves = new ArrayList();
            while (currR > 2) {
                int a = currR * (s - 1);
                int b = currR - 1;
                for (int j = 0; j < s - 1; j++) {
                    ArrayList<Integer> move = new ArrayList();
                    move.add(a);
                    move.add(b);
                    moves.add(move);
                    a-=1;
                }
                currR--;
            }
            for (int j = 0; j < s - 1; j++) {
                int a = 2 * s - 2 - j;
                int b = 1;
                ArrayList<Integer> move = new ArrayList();
                move.add(a);
                move.add(b);
                moves.add(move);
            }
            System.out.println("Case #" + i + ": " + moves.size());
            for (ArrayList<Integer> move : moves) {
                System.out.println(move.get(0) + " " + move.get(1));
            }
        }
        in.close();
    }
}