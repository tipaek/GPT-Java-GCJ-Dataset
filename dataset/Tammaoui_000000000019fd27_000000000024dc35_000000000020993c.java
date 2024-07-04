package jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int testCases;

    public static void main(String[] args) throws IOException {
        testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rows = 0;
            int cols = 0;

            for (int j = 0; j < n; j++) {
                HashSet<Integer> rowset = new HashSet<Integer>();
                String s[] = br.readLine().split(" ");
                for (int k = 0; k < s.length; k++) {
                    matrix[j][k] = Integer.parseInt(s[k]);
                    rowset.add(Integer.parseInt(s[k]));
                }
                if (rowset.size() < n){
                    rows++;
                }
                trace += matrix[j][j];
            }

            for (int j = 0; j < matrix.length; j++) {
                Integer[] column = new Integer[n];
                for (int k = 0; k < n; k++) {
                    column[k] = matrix[k][j];
                }
                if(dupes(column)){
                    cols++;
                }
            }
            sb.append("Case #" + i+1 + ": " + trace + " " + rows + " " + cols + "\n");
        }
        System.out.println(sb);
    }

    public static boolean dupes(Integer[] arr){
        Set<Integer> intSet = new HashSet<Integer>();
        Collections.addAll(intSet, arr);
        return intSet.size() != arr.length;
    }
}
