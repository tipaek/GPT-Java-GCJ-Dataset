import java.io.*;
import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t1 = 1;
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int arr[][] = new int[n][n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }
            int r = 0, c = 0;
            for (int i = 0; i < arr.length; i++) {
                int freq1[] = new int[100];
                for (int j = 0; j < arr.length; j++) {
                    freq1[arr[i][j]]++;
                }
                for (int k = 0; k < freq1.length; k++) {
                    if(freq1[k] > 1){
                        r++;
                        break;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                int freq1[] = new int[100];
                for (int j = 0; j < arr.length; j++) {
                    freq1[arr[j][i]]++;
                }
                for (int k = 0; k < freq1.length; k++) {
                    if(freq1[k] > 1){
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + t1 + ": " + sum + " " + r + " " + c);
            t1++;
        }
    }
}