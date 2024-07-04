import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            Set<Integer> hr = new HashSet<Integer>();
            Set<Integer> hc = new HashSet<Integer>();
            int trace=0, row=0, col=0, temp;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    arr[j][k]=scan.nextInt();
                    if(j==k){
                        trace+=arr[j][k];
                    }
                }
            }
            for(int j=0;j<n;j++){
                temp=-1;
                for(int k=0;k<n;k++){
                    hr.add(arr[j][k]);
                    hc.add(arr[k][j]);
                }
                if(hr.size()<n)
                    row++;
                if(hc.size()<n)
                    col++;
                hr.clear();
                hc.clear();
            }
            System.out.println("Case #"+i+": "+trace+" "+row+" "+col);   
        }
    }
}