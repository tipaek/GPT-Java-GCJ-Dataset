import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
 public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int k=0,r,c,j;
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            for( j=0;j<n;j++){
                for(int m =0;m<n;m++){
                    arr[j][m] = in.nextInt();
                }
            }
            for(j=0;j<n;j++){
                k+=arr[j][j];
            }
            // repeated rows

            r =0 ;
            Set<Integer> integerSet = new HashSet<>();
            for( j=0;j<n;j++){
                for(int m =0;m<n;m++){
                    integerSet.add(arr[j][m]);
                }
                if(integerSet.size()<n){
                    r++;
                }
                integerSet.clear();
            }

            // repeated column

            c =0;
            Set<Integer> integerSet2 = new HashSet<>();
            for( j=0;j<n;j++){
                for(int m =0;m<n;m++){
                    integerSet2.add(arr[m][j]);
                }
                if(integerSet2.size()<n){
                    c++;
                }
                integerSet2.clear();
            }

            System.out.println("Case #" + i + ": " + k + " " + r+ " " + c);
        }
    }
}