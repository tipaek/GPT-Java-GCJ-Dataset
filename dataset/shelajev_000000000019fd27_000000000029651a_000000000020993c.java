

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = sc.nextInt();

            int k = 0;
            int[][] m = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int e = sc.nextInt();
                    if (i == j) {
                        k += e;
                    }
                    m[i][j] = e;
                }
            }
            int rows = 0;

            for(int i = 0; i < n; i++) {
                Set<Integer> numbers = new HashSet<>();
                for(int j = 0; j < n; j++) {
                    numbers.add(m[i][j]);
                }
                if(numbers.size() < n) {
                    rows++;
                }
            }

            int cols = 0;
            for(int i = 0; i < n; i++) {
                Set<Integer> numbers = new HashSet<>();
                for(int j = 0; j < n; j++) {
                    numbers.add(m[j][i]);
                }
                if(numbers.size() < n) {
                    cols++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + k + " " + rows + " " + cols);
        }
    }


}
