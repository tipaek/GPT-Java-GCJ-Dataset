import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main (String Args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        int casesDone = 1;
        while (casesDone <= cases) {
            String[] split = in.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int trace = Integer.parseInt(split[1]);
            int posTrace = 0;
            HashSet<Integer> possTrace = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                posTrace += i;
                possTrace.add(i*N);
            }
            if (N > 2) {
                possTrace.add(posTrace);
            }
            if (possTrace.contains(trace)) {
                System.out.println("Case #" + casesDone + ": POSSIBLE");
                if (trace % N == 0) {
                    int mid = trace / N;
                    int k = mid;
                    for (int i = 1; i <= N; i++) {
                        int temp = k;
                        while (temp <= N) {
                            System.out.print(temp + " ");
                            temp++;
                        }
                        for (int j = 1; j < k; j++) {
                            System.out.print(j + " ");
                        }
                        k--;
                        if (k <= 0) {
                            k = N;
                        }
                        System.out.println();
                    }
                } else {
                    int[][] arr = new int[N][N];
                    for (int i = 0; i < N; i++){
                        arr[0][i] = i + 1;
                    }
                    for (int i = 1; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            arr[i][j] = arr[0][(j + i)%N];
                        }
                    }
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Case #" + casesDone + ": IMPOSSIBLE");
            }
            casesDone++;
        }
    }
}
