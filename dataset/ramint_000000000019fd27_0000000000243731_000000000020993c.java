import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String [] args ) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int tt=0;tt<t;tt++) {
            int n = scanner.nextInt();
            int [][] m = new int[n+1][n+1];
            for(int i=0;i<n;i++) {
                for(int j =0; j<n; j++) {
                    m[i][j] = scanner.nextInt();
                }
            }

            int r = 0; 
            int c = 0;
            int trace = 0;
            for(int i=0;i<n;i++) {
                HashSet<Integer> set = new HashSet<>();
                HashSet<Integer> set2 = new HashSet<>();
                for(int j=0;j<n;j++) {
                    if(i==j) {
                        trace+=m[i][j];
                    }
                    set.add(m[i][j]);
                    set2.add(m[j][i]);
                }
                if (set.size()!=n) {
                    r++;
                }
                if (set2.size()!=n) {
                    c++;
                }
                
            }

            System.out.println("Case #" + (tt+1) + ": " + trace + " " + r+ " " + c );
        }
    }
    
}