

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Solution {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = sc.nextInt();

            int k = 0;
            long sum = 0;
            long product = 1;
            long[] rSum = new long[n];
            long[] rPro = new long[n];
            Arrays.fill(rPro, 1);
            long[] cSum = new long[n];
            long[] cPro = new long[n];
            Arrays.fill(cPro, 1);

            for (int i = 0; i < n; i++) {
                sum += (i + 1);
                product *= (i + 1);
                for (int j = 0; j < n; j++) {
                    int e = sc.nextInt();
                    if (i == j) {
                        k += e;
                    }

                    rSum[i] += e;
                    rPro[i] *= e;

                    cSum[j] += e;
                    cPro[j] *= e;
                }
            }

            int rows = 0;
            int cols = 0;
            for (int i = 0; i < n; i++) {
                if (rSum[i] != sum || rPro[i] != product) {
                    rows++;
                }
                if (cSum[i] != sum || cPro[i] != product) {
                    cols++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + k + " " + rows + " " + cols);
        }
    
    }


}
