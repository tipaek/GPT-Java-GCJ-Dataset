import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG?new Scanner(new FileInputStream("test.in")):new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Integer[][] matrix = new Integer[n][];
            for(int j = 0; j < n; ++j) {
                Integer[] row = new Integer[n];
                for(int k = 0; k < n; ++k) {
                    // append a string into StringBuilder input1
                    row[k] = in.nextInt();
                }
                matrix[j] = row;
            }
            System.out.println("Case #" + i + ": " + vestigium(matrix)[0]+ " " + vestigium(matrix)[1]+ " " + vestigium(matrix)[2]);
        }
    }

    static int[] vestigium(Integer[][] matrix) {
        int trace = 0;
        int row = 0;
        int column = 0;
        for(int i = 0; i < matrix.length; ++i) {
            trace += matrix[i][i];
        }
        for(int i = 0; i < matrix.length; ++i) {
            HashMap<Integer, Integer> exist = new HashMap<>();
            for (int j = 0; j < matrix.length; ++j) {
                if(exist.containsKey(matrix[i][j])) {
                    row++;
                    break;
                } else {
                    exist.put(matrix[i][j], 0);
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            HashMap<Integer, Integer> exist = new HashMap<>();
            for (int j = 0; j < matrix.length; ++j) {
                if(exist.containsKey(matrix[j][i])) {
                    column++;
                    break;
                } else {
                    exist.put(matrix[j][i], 0);
                }
            }
        }
        return new int[]{trace, row, column};
    }
}