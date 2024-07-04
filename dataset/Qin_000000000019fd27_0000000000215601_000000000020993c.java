import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // the size of matrix
            int row_total = 0;

            List<Set<Integer>> col_set_list = new ArrayList<>(new HashSet<>());
            int col_total = 0;

            int diagonal = 0;
            for(int j = 0; j < n; j++)
            {
                Set<Integer> row_set = new HashSet<>();
                for(int k = 0; k < n; k++) {
                    if (j == 0) {
                        col_set_list.add(k, new HashSet<>());
                    }
                    int temp = in.nextInt();
                    row_set.add(temp);
                    col_set_list.get(k).add(temp);
                    if (j==k){
                        diagonal += temp;
                    }
                }
                if (row_set.size() != n) {
                    row_total += 1;
                }
            }
            for(int j = 0; j < n; j++){
                if (col_set_list.get(j).size() != n) {
                    col_total += 1;
                }
            }
            System.out.println("Case #" + i + ": " + diagonal + " " + row_total+" "+col_total);
        }


    }
}
