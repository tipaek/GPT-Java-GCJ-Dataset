

import java.util.*;
import java.io.*;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int dimension = in.nextInt();
            int[][] square = new int[dimension][dimension];
            int rowDuplicateCount = 0;
            int columnDuplicateCount = 0;
            int trace = 0;
            for(int r = 0; r < dimension; r++){
                boolean foundDuplicate = false;
                Set<Integer> entrySet = new HashSet<>();
                for(int c = 0; c < dimension; c++){
                    int element = in.nextInt();
                    if (entrySet.contains(element) && !foundDuplicate){
                        rowDuplicateCount++;
                        foundDuplicate = true;
                    }
                    entrySet.add(element);
                    square[c][r] = element;
                    if (r == c)
                        trace += element;
                }
            }
            for(int c = 0; c < dimension; c++){
                if (Arrays.stream(square[c]).boxed().distinct().count() != square[c].length)
                    columnDuplicateCount++;
            }

            System.out.println("Case #" + i + ": " + (trace) + " " +
                    (rowDuplicateCount) + " " + (columnDuplicateCount));
        }
    }
}

