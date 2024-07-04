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
            HashSet<Integer> possTrace = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                possTrace.add(i*N);
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

                }
            } else {
                System.out.println("Case #" + casesDone + ": IMPOSSIBLE");
            }
            casesDone++;
        }
    }
}
