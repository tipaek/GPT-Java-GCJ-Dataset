

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static void print(BufferedOutputStream bufferedOutputStream, byte[] bytes) throws IOException {
        bufferedOutputStream.write(bytes);
    }


    private static boolean isValid(int[][] ltm, int n) {
        int sum = 0;
        for(int i = 0; i < n; i++) sum += ltm[i][i];
        return sum == k;
    }

    private static boolean search(int[][] ltm, boolean[][] colMap, boolean[][] rowMap, int n, int i, int j) {
        if(i == n) {
            return isValid(ltm, n);
        }
        else if(j == n && i < n) return search(ltm, colMap, rowMap, n, i + 1, 0);

        if(ltm[i][j] > 0) return search(ltm, colMap, rowMap, n, i, j+1);

        for(int m = 1; m <= n; m++) {
            if(!(colMap[j][m] || rowMap[i][m])) {
                ltm[i][j] = m;
                colMap[j][m] = rowMap[i][m] = true;

                if(search(ltm, colMap, rowMap, n, i, j+1)) { return true; }

                ltm[i][j] = 0;
                colMap[j][m] = rowMap[i][m] = false;
            }
        }
        return ltm[i][j] > 0;
    }

    private static int k = -1;
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
                k = Integer.parseInt(str[1]);

                String ans = "POSSIBLE";
                boolean isPossible = true;
//                int div = k/n, rem = k%n;
                int[][] ltm = new int[n][n];
                boolean[][] colMap = new boolean[n][n+1];
                boolean[][] rowMap = new boolean[n][n+1];
//                for(int i = 0 ; i < n; i++) {
//                    if(div + rem > n) {ltm[i][i] = div + 1; rem--;}
//                    else ltm[i][i] = i == n-1 ? div + rem: div;
//                    colMap[i][ltm[i][i]] = rowMap[i][ltm[i][i]] = true;
//                }

                if(!search(ltm, colMap, rowMap, n, 0, 0)) {
                    ans = "IMPOSSIBLE"; isPossible = false;
                }

                print(bufferedOutputStream, testCaseStrBytes);
                print(bufferedOutputStream, Integer.toString(t).getBytes());
                print(bufferedOutputStream, colSpace);
                print(bufferedOutputStream, ans.getBytes());
                if(isPossible) {
                    print(bufferedOutputStream, eolb);
                    for(int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            print(bufferedOutputStream, Integer.toString(ltm[i][j]).getBytes());
                            print(bufferedOutputStream, space);
                        }
                        print(bufferedOutputStream, eolb);
                    }
                } else print(bufferedOutputStream, eolb);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
