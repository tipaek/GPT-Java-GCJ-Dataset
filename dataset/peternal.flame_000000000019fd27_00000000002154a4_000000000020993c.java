import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            HashSet<Integer>[] rows = new HashSet[n];
            HashSet<Integer>[] columns = new HashSet[n];
            for(int j = 0; j<n; j++){
                rows[j] = new HashSet<>();
                columns[j] = new HashSet<>();
            }
            int trace = 0;
            for(int r = 0; r<n; r++){
                for(int c = 0; c<n; c++){
                    m[r][c] = in.nextInt();
                    if(r==c){
                        trace += m[r][c];
                    }
                    rows[r].add(m[r][c]);
                    columns[c].add(m[r][c]);
                }
            }
            int rowsAmount = 0, columnsAmount = 0;
            for(int j = 0; j<n; j++){
                if(rows[j].size()!=n){
                    rowsAmount++;
                }
                if(columns[j].size()!=n){
                    columnsAmount++;
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + rowsAmount + " " + columnsAmount);
        }
    }
}

