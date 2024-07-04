import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[]args){
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][]matrix = new int[n][n];
            int k = 0;
            int r = 0;
            int c = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    matrix[j][l] = sc.nextInt();
                }
            }
            for(int j = 0; j < n; j++){
                k+=matrix[j][j];
            }
            for(int j = 0; j < n; j++){
                HashSet<Integer>used = new HashSet<>();
                for(int l = 0; l < n; l++){
                    used.add(matrix[j][l]);
                }
                if(used.size() < n){
                    r++;
                }
            }
            for(int j = 0; j < n; j++){
                HashSet<Integer>used = new HashSet<>();
                for(int l = 0; l < n; l++){
                    used.add(matrix[l][j]);
                }
                if(used.size() < n){
                    c++;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + k + " " + r  + " " + c);
        }

    }
}
