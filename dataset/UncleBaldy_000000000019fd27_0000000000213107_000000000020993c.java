import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        
        for (int x = 0; x++ < T;) {
            int N = Integer.parseInt(in.readLine());
            int sum = 0;
            int sqrSum = 0;
            int[] sumRow = new int[N];
            int[] sqrSumRow = new int[N];
            int[] sumCol = new int[N];
            int[] sqrSumCol = new int[N];
            int k = 0;
            int r = 0;
            int c = 0;
            for (int i = 0; i < N; i++) {
                sum += i+1;
                sqrSum += (i+1) * (i+1);
                String[] line = in.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    int v = Integer.parseInt(line[j]);
                    sumRow[i] += v;
                    sumCol[j] += v;
                    sqrSumRow[i] += v * v;
                    sqrSumCol[j] += v * v;
                    if (i == j) {
                        k += v;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (sumRow[i] != sum || sqrSumRow[i] != sqrSum) {
                    r++;
                }
                if (sumCol[i] != sum || sqrSumCol[i] != sqrSum) {
                    c++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", x, k, r, c);
        }
    }
}