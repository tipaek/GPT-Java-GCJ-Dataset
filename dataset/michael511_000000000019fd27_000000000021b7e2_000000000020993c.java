import java.util.*;
import java.io.*;

public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int c = in.nextInt();
            int k = 0;
            int [][]array = new int [c][c];
            int counterCol = 0;
            int counterRow = 0;
            
            ArrayList<Integer> list;
            
            for (int row = 0; row < c; row++) {
                for (int col = 0; col < c; col++) {
                    array[row][col] = in.nextInt();
                }
                k+= array[row][row];
            }
            
            for (int row = 0; row < c; row++) {
                list = new ArrayList<Integer>();
                for (int col = 0; col < c; col++) {
                    if (list.contains(array[row][col])) {
                        counterCol++;
                        break;
                    } else {
                        list.add(array[row][col]);
                    }
                }
            }
            
            
            for (int col = 0; col < c; col++) {
                list = new ArrayList<Integer>();
                for (int row = 0; row < c; row++) {
                    if (list.contains(array[row][col])) {
                        counterRow++;
                        break;
                    } else {
                        list.add(array[row][col]);
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + k + " "+ counterCol + " " + counterRow);
        }
    }
}