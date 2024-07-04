import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bohdan
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (n == 2) {
                if (k == 2) {
                    System.out.println("Case #" + t + ": " + "POSSIBLE");
                    System.out.println("1 2");
                    System.out.println("2 1");
                } else if (k == 4) {
                    System.out.println("Case #" + t + ": " + "POSSIBLE");
                    System.out.println("2 1");
                    System.out.println("1 2");
                } else {
                    System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                }
            } else {
                int d = k / n;
                int r = k - d * (n - 1);

                int[] mask = new int[n];
                for (int i = 0; i < n; i++) {
                    mask[i] = i + 1;
                }
                int[][] result = new int[n][n];
                int ind;
                if (r == d) {
                    System.out.println("Case #" + t + ": " + "POSSIBLE");
                    mask[d - 1] = 1;
                    mask[0] = d;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            ind = (n + i - j) % n;
                            result[i][j] = mask[ind];
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n - 1; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println(result[i][n - 1]);
                    }

                } else {
                    if ((r > n)||((r == n) && (d!=1))) {
                        d = d + 1;
                    }
                    r = k - d * (n - 1);
                    int a = -1;
                    int b = -1;
                    if (r < d) {
                        a = r - 1;
                        b = d + 1;
                        if ((d == n) && (r < n - 1)) {
                            b = n - 1;
                            a = r + 1;
                        }
                    }
                    if (r > d) {
                        a = d - 1;
                        b = r + 1;
                        if ((d == 1) && (r > 2)) {
                            b = r - 1;
                            a = 2;
                        }
                    }
                    if (((a < 1) || (b > n)) || ((a == b) && (n==3))) {
                        System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                    } else {

                        System.out.println("Case #" + t + ": " + "POSSIBLE");
                        mask[0] = d;
                        mask[d - 1] = 1;
                        if (a != b) {
                            //System.out.println("a = "+a+"b = "+b+"r = "+r+"d = "+d);
                            if (a!=1){
                                mask[a - 1] = mask[1];
                            }
                            else{
                                mask[d-1] = mask[1];
                            }
                            mask[1] = a;
                            if (b!= 1){
                                mask[b - 1] = mask[n-1];
                            }
                            else{
                                mask[d-1] = mask[n-1];
                            }
                            mask[n - 1] = b;
                            
                            //System.out.println(mask[0]+" "+mask[1]+" "+mask[2]+" "+mask[3]+" ");
                            for (int i = 0; i < n; i++) {
                                for (int j = 2; j < n; j++) {
                                    ind = (n + j - i) % n;
                                    result[i][j] = mask[ind];
                                }
                                result[i][0] = mask[((n + 1 - i) % n)];
                                result[i][1] = mask[((n - i) % n)];
                            }
                        }
                        else{
                            if (a!=1){
                                mask[a-1] = mask[1];
                            }
                            else{
                                mask[d-1] = mask[1];                            
                            }                        
                            mask[1] = a;
                            for (int i = 0; i < n; i++) {
                                for (int j = 3; j < n; j++) {
                                    ind = (n + j - i) % n;
                                    result[i][j] = mask[ind];
                                }
                            }
                            result[0][2] = mask[2];
                            result[0][1] = mask[0];
                            result[0][0] = mask[1];
                            result[1][0] = mask[0];
                            result[1][1] = mask[1];
                            result[1][2] = mask[n-1];
                            result[n-1][2] = mask[1];
                            result[2][2] = mask[0];
                            result[n-1][0] = mask[3];
                            result[n-1][1] = mask[2];
                            result[2][0+(n%2)] = mask[n-2];
                            result[2][1-(n%2)] = mask[n-1];
                            for (int j = 3; j<n-1; j++){
                                result[j][2] = mask[n-j+1];
                                
                            }
                            int j = 0;
                            int val = 2;
                            for (int p = 0; p<n-4; p++){
                                result[n-2-p][j] = mask[val];
                                j = 1-j;
                                val++;
                            }
                            j = 1;
                            val = 4;
                            for (int p = 0; p<n-4; p++){
                                result[n-2-p][j] = mask[val];
                                val++;
                                j = 1-j;
                            }
                            
                            
                        }
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n - 1; j++) {
                                System.out.print(result[i][j] + " ");
                            }
                            System.out.println(result[i][n - 1]);
                        }
                    }
                }
            }

        }
    }

}
