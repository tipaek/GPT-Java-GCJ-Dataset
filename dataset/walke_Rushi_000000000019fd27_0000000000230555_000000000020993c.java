import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int p = 1;
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int a[][] = new int[n][n];
            int trace = 0;
            for (int i = 0; i < n; i++) {
                String[] inp = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(inp[j]);
                    if (i == j) {
                        trace += a[i][i];
                    }
                }
            }
            int rownum = 0, colnum = 0;

            for (int i = 0; i < n; i++) {
                int k = 0, l = 0;
                ArrayList<Integer> listrow = new ArrayList<Integer>();
                ArrayList<Integer> listcol = new ArrayList<Integer>();
                for (int j = 0; j < n; j++) {

                    if (k == 0 && !listrow.isEmpty() && listrow.contains(a[i][j])) {
                        k = 1;
                        rownum++;
                    }
                    else{
                        listrow.add(a[i][j]);
                    }
                    if (l == 0 && !listcol.isEmpty() && listcol.contains(a[j][i])) {
                        l = 1;
                        colnum++;
                    }
                    else{
                        listcol.add(a[j][i]);
                    }

                }
            }
                System.out.println("Case #" + p + ": " + trace + " " + rownum + " " + colnum);
                p++;
            }
        }
    }
