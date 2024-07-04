import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        String space = in.nextLine();

        // Solve each test case
        for (int i=1; i<cases+1; i++) {
            solve(i, in);
        }
    }

    public static void solve(int i, Scanner in) {
        int rank = in.nextInt(), suit = in.nextInt(), product = rank * suit;

        if (rank * suit % 2 == 0) {
            System.out.println("Case #" + i + ": " + (product / 2 - 1));
        } else {
            System.out.println("Case #" + i + ": " + ((product - 1) / 2));
        }

        int inital_suit = (product - 1) % rank;
        int initial_rank = product - inital_suit - 1;
        
        for (int j=0; j<rank-1; j++) {
            for (int k=0; k<suit-1; k++) {
                System.out.println(initial_rank + " " + inital_suit);
                initial_rank--;
            }
            inital_suit--;
        }
    }
}