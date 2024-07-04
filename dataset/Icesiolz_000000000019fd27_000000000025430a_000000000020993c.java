import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        
        for(int i = 1; i <= T; i++) {
            int r = 0;
            int c = 0;
            int k = 0;
            
            int N = sc.nextInt();
            int matrix[][] = new int[N][N];
            for(int j = 0; j < N; j++) {
                for(int l = 0; l < N; l++) {
                    matrix[j][l] = sc.nextInt();
                    if(j == l) {
                        k += matrix[j][l];
                    }
                }
            }
            
            boolean checkRow[] = new boolean[N];
            boolean checkCol[] = new boolean[N];
            for(int j = 0; j < N; j++) {
                checkRow[j] = false;
                checkCol[j] = false;
            }
            
            for(int j = 0; j < N; j++) {
                HashSet<Integer> row = new HashSet<>();
                HashSet<Integer> col = new HashSet<>();
                for(int l = 0; l < N; l++) {
                    int value = matrix[j][l];
                    if(!checkRow[j]) {
                        if(row.contains(value)) {
                            checkRow[j] = true;
                            if(r == 0) {
                                r = 1;
                            }
                            r++;
                        } else {
                            row.add(value);
                        }
                        value = matrix[l][j];
                        if(col.contains(value)) {
                            checkCol[j] = true;
                            if (c == 0) {
                                c = 1;
                            }
                            c++;
                        } else {
                            col.add(value);
                        }
                    }
                }
            }
            if (r > N) {
                r = N;
            }
            if (c > N) {
                c = N;
            }
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}