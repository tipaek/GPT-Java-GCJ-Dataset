import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {

            // Read size of the square
            int n = in.nextInt();


            // Trace of the Matrix
            int k = 0;
            // Number of row with duplicate elements
            int r = 0;
            // Number of column with duplicate elements
            int c = 0;

            Set<Integer>[] currentColumnValue = new HashSet[n];
            for(int currentColumn = 0; currentColumn < n; currentColumn++) {
                currentColumnValue[currentColumn] = new HashSet<>();
            }


            for(int currentRow = 0; currentRow < n; currentRow++) {

                Set<Integer> currentRowValue = new HashSet<>();
                for(int currentColumn = 0; currentColumn < n; currentColumn++) {

                    int currentValue = in.nextInt();

                    currentRowValue.add(currentValue);
                    currentColumnValue[currentColumn].add(currentValue);

                    if(currentColumn == currentRow) {
                        k = k + currentValue;
                    }


                }

                if(currentRowValue.size() != n) {
                    r++;
                }
            }

            for(int currentColumn = 0; currentColumn < n; currentColumn++) {
                if(currentColumnValue[currentColumn].size() != n )
                    c++;
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
  