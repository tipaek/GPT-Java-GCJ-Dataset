import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for(int i = 1; i<=t; i++){
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int j = 0; j<n; j++){
                for(int k = 0; k<n; k++){
                    matrix[j][k] = in.nextInt();

                }
            }

            int col = 0;
            int row = 0;
            int trace = 0;
            for(int j = 0; j< n; j++){
                ArrayList<Integer> track = new ArrayList<Integer>();
                for(int k = 0; k<n; k++){
                    if(track.contains(matrix[k][j])){
                        row++;
                        break;
                    }
                    else track.add(matrix[k][j]);
                }
            }


            for(int j = 0; j<n; j++){
                for(int k = 0; k<n; k++){
                    if(j == k) trace += matrix[j][k];
                }
            }

            for(int j = 0; j< n; j++){
                ArrayList<Integer> track = new ArrayList<Integer>();
                for(int k = 0; k<n; k++){
                    if(track.contains(matrix[j][k])){
                        col++;
                        break;
                    }
                    else track.add(matrix[j][k]);
                }
            }

            System.out.println("Case #" + i +": " + trace + " " + col + " " + row);

        }

    }
}
