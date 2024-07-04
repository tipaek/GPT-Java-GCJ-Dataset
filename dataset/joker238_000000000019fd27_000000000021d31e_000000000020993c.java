import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= t; ++test) {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            int sum=0;
            int r = 0,c=0;
            for(int i=0;i<n;i++) {
                HashSet<Integer> set = new HashSet<>();
                int f = 0;
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    if(!set.add(a[i][j])&&f==0) {
                        r++;
                        f=1;
                    }
                    if(i==j)
                        sum+=a[i][j];
                }
            }
            for(int i=0;i<n;i++) {
                HashSet<Integer> set = new HashSet<>();
                int f = 0;
                for(int j=0;j<n;j++) {
                    if(!set.add(a[j][i])&&f==0) {
                        c++;
                        f=1;
                    }
                }
            }
            System.out.println("Case #" + test + ": " + sum+" "+r+" "+c);
        }
    }
}