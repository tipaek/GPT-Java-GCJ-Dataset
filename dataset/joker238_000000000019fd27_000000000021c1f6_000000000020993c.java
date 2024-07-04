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
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    if(!set.add(a[i][j])&&r<=i)
                        r++;
                    if(i==j)
                        sum+=a[i][j];
                }
            }
            for(int i=0;i<n;i++) {
                HashSet<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++) {
                    if(!set.add(a[j][i])&&c<=i)
                        c++;
                }
            }
            System.out.println("Case #" + test + ": " + sum+" "+r+" "+c);
        }
    }
}