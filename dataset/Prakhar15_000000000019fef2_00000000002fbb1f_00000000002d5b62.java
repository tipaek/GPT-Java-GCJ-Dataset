import java.util.*;
import java.io.*;

public class Solution {
    
    static int SIZE = 201; // 201
    static int CENTER = 100; // 100
    static String arr[][] = new String[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        populate(arr, 1, CENTER, CENTER, "");
        
        print(arr);
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            int x = CENTER - m;
            int y = CENTER + n;
            if (arr[x][y] == null || arr[x][y].equals("")) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + arr[x][y]);
            }
        }
    
    }
    
    static void populate(String arr[][], int k, int row, int col, String out) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return;
        }

        String temp1 = out + "W";
        String temp2 = out + "E";
        String temp3 = out + "N";
        String temp4 = out + "S";
        
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;

        // Populate array
        if (col - k >= 0 && (arr[row][col-k] == null || arr[row][col-k].equals(""))) {
            arr[row][col-k] = temp1;
            flag1 = true;
        }
        if (col + k < SIZE && (arr[row][col+k] == null || arr[row][col+k].equals(""))) {
            arr[row][col+k] = temp2;
            flag2 = true;
        }
        if (row - k >= 0 && (arr[row-k][col] == null || arr[row-k][col].equals(""))) {
            arr[row-k][col] = temp3;
            flag3 = true;
        }
        if (row + k < SIZE && (arr[row+k][col] == null || arr[row+k][col].equals(""))) {
            arr[row+k][col] = temp4;
            flag4 = true;
        }
        
        // Recursive call in all 4 directions
        if (flag1) {
            populate(arr, k*2, row, col - k, temp1);
        }
        if (flag2) {
            populate(arr, k*2, row, col + k, temp2);
        }
        if (flag3) {
            populate(arr, k*2, row - k, col, temp3);
        }
        if (flag4) {
            populate(arr, k*2, row + k, col, temp4);
        }
    }
    
    static void print(String arr[][]) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print (arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}