import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] a){
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int trace = 0;
                int rc = 0;
                int cc = 0;
                int n = scanner.nextInt();
                int[][] mat = new int[n][n];
                for(int i=0; i<n; i++){
                    for(int j=0 ; j<n; j++){
                        mat[i][j] = scanner.nextInt();
                        if(i==j){
                            trace += mat[i][j];
                        }
                    }
                }
                for(int i=0; i<n; i++){
                    Set uniqueRow = new HashSet<Integer>();
                    for(int j=0; j<n; j++){
                        if(!uniqueRow.add(mat[i][j])){
                            rc++;
                            break;
                        }
                    }
                }
                for(int i=0; i<n; i++){
                    Set uniqueCol = new HashSet<Integer>();
                    for(int j=0; j<n; j++){
                        if(!uniqueCol.add(mat[j][i])){
                            cc++;
                            break;
                        }
                    }
                }
                System.out.println("Case #"+testNumber+": "+trace+" "+rc+" "+cc);
            }
        }
    }
}