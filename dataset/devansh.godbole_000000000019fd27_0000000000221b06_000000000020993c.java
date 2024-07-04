import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String []args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int trace = 0, r = 0, c = 0;
            HashSet<Integer> set = new HashSet<>();
            boolean flag = true;
            
            int mat[][] = new int[n][n];
            
            for(int a = 0; a < n; a++) {
                set.clear();
                flag = true;
                for(int b = 0; b < n; b++) {
                    mat[a][b] = sc.nextInt();
                    if(a == b)
                        trace += mat[a][b];
                    if(!set.add(mat[a][b]) && flag) {
                        flag = false;
                        r++;
                    }
                }
            }
            for(int a = 0; a < n; a++) {
                set.clear();
                for(int b = 0; b < n; b++) {
                    if(!set.add(mat[b][a])) {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}