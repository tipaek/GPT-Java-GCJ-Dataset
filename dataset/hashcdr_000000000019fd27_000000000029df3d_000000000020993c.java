import java.io.*;
import java.util.*;

public class Solution {

    static String[] calculate(int[][] square, int n) throws IOException {

        String[] result = new String[3];
        int k = 0, c = 0, r = 0;

        //noinspection DuplicatedCode
        for(int i = 0; i < n; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int j = 0; j < n; j++) {
                if(map.containsKey(square[i][j])) {
                    r++;
                    break;
                } else {
                    map.put(square[i][j], 1);
                }
            }
        }

        //noinspection DuplicatedCode
        for(int i = 0; i < n; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int j = 0; j < n; j++) {
                if(map.containsKey(square[j][i])) {
                    c++;
                    break;
                } else {
                    map.put(square[j][i], 1);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            k += square[i][i];
        }

        result[0] = String.valueOf(k);
        result[1] = String.valueOf(r);
        result[2] = String.valueOf(c);

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /*
          The first line of the input gives the number of test cases, T.
          T test cases follow. Each starts with a line containing a single integer N: the size of the matrix to explore.
          Then, N lines follow.
          The i-th of these lines contains N integers Mi,1, Mi,2 ..., Mi,N.
          Mi,j is the integer in the i-th row and j-th column of the matrix.
         */

        int t = Integer.parseInt(br.readLine());

        int T = t;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[][] square = new int[n][n];

            for(int i = 0; i < n; i++) {
                String[] ithString = br.readLine().split(" ");

                for (int j = 0; j < n; j++) {
                    square[i][j] = Integer.parseInt(ithString[j]);
                }
            }

            String[] result = calculate(square, n);

            /*
            For each test case, output one line containing Case #x: k r c,
            where x is the test case number (starting from 1), k is the trace of the matrix,
            r is the number of rows of the matrix that contain repeated elements,
            and c is the number of columns of the matrix that contain repeated elements.
             */

            System.out.println("Case #" + (T-t) + ": " + result[0] + " " + result[1] + " " + result[2]);
        }

        br.close();
    }
}
