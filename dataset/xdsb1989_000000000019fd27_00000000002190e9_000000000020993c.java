import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] strs = new String[cases];
        for (int i = 1; i <= cases; ++i) {
            int size = in.nextInt();
            int [][]array = new int[size][];
            for (int row = 0; row < size; row++) {
                array[row] = new int[size];
                for (int col = 0; col < size; col++) {
                    array[row][col] = in.nextInt();
                }
            }
            int k = 0, r = 0, c = 0;
            for (int x=0; x < size; x++) {
                k = k + array[x][x];
            }
            HashSet<Integer> setA = new HashSet<>();

            for (int row=0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    setA.add(array[row][col]);
                }
                if (setA.size() < size) {
                    r++;
                }
                setA.clear();
            }

            for (int col=0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    setA.add(array[row][col]);
                }
                if (setA.size() < size) {
                    c++;
                }
                setA.clear();
            }
            strs[i-1] = "Case #" + i + ": " + k + " "+ r + " " + c;
        }
        for (int i = 0; i < cases; i++) {
            System.out.println(strs[i]);
        }
    }
}