

import java.util.*;
import java.io.*;

/**
 *
 * @author EliteBook
 */
public class Solution {

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= t; i++) {
            

            int n = Integer.parseInt(br.readLine().trim());
            int[][] ar = new int[n][n];
            int rc = 0;
            int cc = 0;
            int trace = 0;
            for (int j = 0; j < n; j++) {
                String[] ip = br.readLine().trim().split(" ");

                for (int k = 0; k < n; k++) {
                    int d = Integer.parseInt(ip[k]);
                    ar[j][k] = d;
                     if (j == k) {
                        trace += d;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                Set<Integer> setR = new HashSet<>();
                Set<Integer> setC = new HashSet<>();
                for (int k = 0; k < n; k++) {
                  
                    if (!setR.add(ar[j][k])) {
                        rc++;
                        break;

                    }

                }
            }
            for (int j = 0; j < n; j++) {

                Set<Integer> setC = new HashSet<>();
                for (int k = 0; k < n; k++) {
                 
                    if (!setC.add(ar[k][j])) {
                        cc++;
                        break;

                    }

                }
            }
            System.out.println("Case #"+i+": "+trace+" "+rc+" "+cc);

        }

    }
}
