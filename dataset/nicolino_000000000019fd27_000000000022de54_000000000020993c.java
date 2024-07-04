import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 0; c < t; c++) {
            int N = in.nextInt();
            in.nextLine();

            int[][] matrix = new int[N][N];
            int rowCounter = 0;

            for (int i = 0; i < N; i++) {
                String[] line = in.nextLine().split("\\s+");
                HashSet<Integer> rowChecker = new HashSet<Integer>();
                int counter = 0;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if(rowChecker.contains(matrix[i][j])){
                        counter++;
                    } else {
                        rowChecker.add(matrix[i][j]);
                    }
                    // System.err.print(matrix[i][j] + " ");
                }
                if(counter > 0){
                    rowCounter++;
                }
               //  System.err.println();
            }

            int[] sol = vestigium(matrix, N);

            System.out.println("Case #" + (c + 1) + ": " + sol[0] + " " + rowCounter + " " + sol[1]);

        }
    }

    public static int[] vestigium(int[][] matrix, int N) {
        int[] res = new int[2];

        for(int i = 0; i< N; i++){
            HashSet<Integer> colChecker = new HashSet<Integer>();
            int counter = 0;
            for(int j = 0; j < N; j++){
                if(i==j){
                    res[0]+=matrix[i][j];
                }
                if(colChecker.contains(matrix[j][i])){
                    counter++;
                } else {
                    colChecker.add(matrix[j][i]);
                }
            }
            if(counter > 0){
                res[1]++;
            }
        }

        return res;
    }
}
