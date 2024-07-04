import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int input = 1; input <= t; ++input) {

            // Read size of data
            int S = in.nextInt();
            int R = in.nextInt();

            int nbMove = (R - 1)*(S - 1);

            System.out.println("Case #" + input + ": " + nbMove);
            int deckSizeToLeave = S-1;
            int toMove = R * S - S;

            for(int i = 0; i < S-1; i++) {

                for(int j = 0; j < R - 1 ; j++) {
                    System.out.println(toMove + " " + deckSizeToLeave);
                    toMove--;
                }
                deckSizeToLeave--;
            }

        }
    }


}
  