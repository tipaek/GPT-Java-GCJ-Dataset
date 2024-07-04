import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++)
        {
            // size of the matrix
            int n = in.nextInt();

            HashMap<String, HashSet<Integer>> input_mat = new HashMap<String, HashSet<Integer>>();
            int trace = 0;
            int num_cols = 0;
            int num_rows = 0;
            HashSet<String> detected_keys = new HashSet<String>();
            for (int j=0;j<n;j++) {
                for (int k = 0; k < n; k++) {
                    int value = in.nextInt();
                    String row_key = 'r' + String.valueOf(j);
                    String col_key = 'c' + String.valueOf(k);
                    if (j==k)
                        trace += value;
                    if (input_mat.containsKey(row_key))
                    {
                        HashSet<Integer> thelist = input_mat.get(row_key);
                        if (thelist.contains(value))
                        {
                            if (detected_keys.contains(row_key))
                            {
                                // Do nothing
                            }
                            else
                            {
                                detected_keys.add(row_key);
                                num_rows++;
                            }
                        }
                        else
                            thelist.add(value);
                        input_mat.put(row_key, thelist);
                    }
                    else {
                        HashSet<Integer> thelist = new HashSet<Integer>();
                        thelist.add(value);
                        input_mat.put(row_key, thelist);
                    }

                    if (input_mat.containsKey(col_key))
                    {
                        HashSet<Integer> thelist = input_mat.get(col_key);
                        if (thelist.contains(value))
                        {
                            if (detected_keys.contains(col_key))
                            {
                                // Do nothing
                            }
                            else
                            {
                                detected_keys.add(col_key);
                                num_cols++;
                            }
                        }
                        else
                            thelist.add(value);
                        input_mat.put(col_key, thelist);
                    }
                    else
                    {
                        HashSet<Integer> thelist = new HashSet<Integer>();
                        thelist.add(value);
                        input_mat.put(col_key, thelist);
                    }

                }
            }
            // calculate rows/cols here

            System.out.println("Case #" + i + ": " + trace + " " + num_rows + " " + num_cols);
        }
    }

}
