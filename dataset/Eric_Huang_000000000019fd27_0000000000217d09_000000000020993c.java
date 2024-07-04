

import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            int size = scan.nextInt();
            boolean[][] arrayRow = new boolean[size+1][size+1];
            boolean[][] arrayColumn = new boolean[size+1][size+1];
            int column = 0;
            int row = 0;
            boolean subtractRow = true;
            int trace = 0;
            boolean[] columnTrue = new boolean[size+1];
            for (int j = 0; j < size; j++) {
                subtractRow = true;
                for (int k = 0; k < size; k++) {
                    int next = scan.nextInt();

                    if (arrayRow[j][next] && subtractRow) {
                        subtractRow = false;
                        row++;
                    }
                    if(arrayColumn[k][next] && !columnTrue[k]){
                        columnTrue[k] = true;
                        column++;
                    }

                    arrayRow[j][next] = true;
                    arrayColumn[k][next] = true;

                    if(j == k){
                        trace += next;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i+1, trace, row, column);
        }


    }

}
