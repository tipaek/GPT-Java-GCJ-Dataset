

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static void print(BufferedOutputStream bufferedOutputStream, byte[] bytes) throws IOException {
        bufferedOutputStream.write(bytes);
    }

    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);
            String eol = System.getProperty("line.separator");
            byte[] eolb = eol.getBytes();
            String str[] = bufferedReader.readLine().split(" ");
            int testCases = Integer.parseInt(str[0]);
            byte[] testCaseStrBytes = "Case #".getBytes();
            byte[] colSpace = ": ".getBytes();
            byte[] space = " ".getBytes();
            for (int t = 1; t<=testCases; t++) {
                str = bufferedReader.readLine().split(" ");
                int n = Integer.parseInt(str[0]);
                int[][] a = new int[n][n];
                int[][] colMap = new int[n+1][n+1];
                for(int i = 0; i < n; i++) {
                    str = bufferedReader.readLine().split(" ");
                    for(int j = 0; j < n; j++) {
                        a[i][j] = Integer.parseInt(str[j]);
                        colMap[j][a[i][j]] += 1;
                    }
                }

                int k = 0, r = 0, c = 0;
                for(int i = 0; i < n; i++) {
                    boolean done_for_row = false;
                    boolean row[] = new boolean[n+1];
                    for(int j = 0; j < n; j++) {
                        if(i == j) k += a[i][j];
                        if(colMap[j] != null && colMap[j][a[i][j]] > 1) {
                            colMap[j] = null;
                            c++;
                        }
                        if(!done_for_row && row[a[i][j]]) {
                            done_for_row = true; r++;
                        }
                        row[a[i][j]] = true;
                    }
                }

                print(bufferedOutputStream, testCaseStrBytes);
                print(bufferedOutputStream, Integer.toString(t).getBytes());
                print(bufferedOutputStream, colSpace);
                print(bufferedOutputStream, Integer.toString(k).getBytes());
                print(bufferedOutputStream, space);
                print(bufferedOutputStream, Integer.toString(r).getBytes());
                print(bufferedOutputStream, space);
                print(bufferedOutputStream, Integer.toString(c).getBytes());
                bufferedOutputStream.write(eolb);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
