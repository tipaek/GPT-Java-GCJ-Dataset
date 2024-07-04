import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int k = 1; k <= t; ++k) {
                int n = Integer.parseInt(br.readLine());
                int[][] arr = new int[n][n];
                int count_row = 0;
                int count_col = 0;
                int trace = 0;
                ArrayList<HashSet<Integer>> list_col_hash = new ArrayList<HashSet<Integer>>();
                for (int i = 0; i < n; i++)
                    list_col_hash.add(new HashSet<Integer>());
                int[] col_dups = new int[n];
                for (int i = 0; i < n; i++) {
                    String[] row = br.readLine().split(" ");
                    HashSet<Integer> row_hash = new HashSet<Integer>();
                    int row_flag = 0;
                    for (int j = 0; j < n; j++) {
                        int val = Integer.parseInt(row[j]);
                        if (i == j)
                            trace +=val;
                        if (row_hash.contains(val))
                            row_flag = 1;
                        row_hash.add(val);
                        if (list_col_hash.get(j).contains(val))
                            col_dups[j] += 1;
                        list_col_hash.get(j).add(val);
                    }
                    if (row_flag == 1)
                        count_row += 1;
                }
                for (int a : col_dups)
                    if (a > 0)
                        count_col += 1;


                System.out.println("Case #" + k + ": " + trace + " " + count_row + " " + count_col);
            }


    }
}