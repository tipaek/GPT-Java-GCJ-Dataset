
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for(int h=1;h<=t;h++) {
            str.append("Case #" + h + ": ");
            String in[] = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            boolean allSame = false;
            boolean allDiff = false;
            if (k % n == 0) {
                allSame = true;
            }
            int arr[][] = new int[n + 1][n + 1];
            if (!allSame && !allDiff) {
                str.append("IMPOSSIBLE\n");
            } else {
                str.append("POSSIBLE\n");
                if (allSame) {
                    for (int i = 1; i <= n; i++) {
                        int count = 1;
                        int j = i;
                        int cellValue = k / n;
                        while (count <= n) {
                            arr[i][j] = cellValue;
                            cellValue++;
                            if (cellValue == n + 1) {
                                cellValue = 1;
                            }
                            j++;
                            if (j == n + 1) {
                                j = 1;
                            }
                            count++;
                        }
                    }

                }
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        str.append(arr[i][j] + " ");
                    }
                    str.append("\n");
                }
            }
        }
        out.print(str);
        out.flush();
        br.close();
    }
}





