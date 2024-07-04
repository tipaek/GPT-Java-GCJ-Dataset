import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader rdr  = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(rdr);
        
        int num_cases = Integer.parseInt(in.readLine());
        for (int u = 0; u < num_cases; u++) {
            int m_size = Integer.parseInt(in.readLine());
            int[][] case_arr = new int[m_size][m_size];
            int k = 0;
            int r = 0;
            int c = 0;
            
            for (int i = 0; i < m_size; i++) {
                String[] line = in.readLine().split(" ");
                for (int j = 0; j < m_size; j++) {
                    case_arr[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            // k
            for (int i = 0; i < m_size; i++) {
                k += case_arr[i][i];
            }
            
            // r
            for (int i = 0; i < m_size; i++) {
                Set<Integer> row = new HashSet<>();
                for (int j = 0; j < m_size; j++) {
                    row.add(case_arr[i][j]);
                }
                r += m_size == row.size() ? 0 : 1;
            }
            
            // c
            for (int i = 0; i < m_size; i++) {
                Set<Integer> col = new HashSet<>();
                for (int j = 0; j < m_size; j++) {
                    col.add(case_arr[j][i]);
                }
                c += m_size == col.size() ? 0 : 1;
            }
            
            System.out.println("Case #" + (u+1) + ": " + k + " " + r + " " + c);
        }
    }
}
