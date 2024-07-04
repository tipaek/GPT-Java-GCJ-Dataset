import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    static String calculate(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        int s = matrix.length;
        HashMap<Integer, Integer>[] rows = new HashMap[s];
        HashMap<Integer, Integer>[] columns = new HashMap[s];

        HashSet<Integer> rr = new HashSet();
        HashSet<Integer> rc = new HashSet();
        for (int i = 0; i < s; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
           
          }
      

        
        int trace = 0;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                int n = matrix[i][j];


                rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);

                if (rows[i].get(n) > 1 ) rr.add(i);
                if(columns[j].get(n) > 1) rc.add(j);
    

                
                if (i == j) trace+= matrix[i][i];
            }
        }

        for(int i = 0; i < s; i++){
            
          
        }
        result.append(trace+" "+rr.size()+ " "+rc.size());
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] m = new int[n][n];


            for (int k = 0; k < n; k++) {

                for (int j = 0; j < n; j++) {
                    int x = in.nextInt();

                   
                    m[k][j] = x;
                }
            }

      

            String result = Solution.calculate(m);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}