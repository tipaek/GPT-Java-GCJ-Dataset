import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // check possibility of trace value
            List<Integer> possibleTraces = new ArrayList<>();
            int sum = 0;
            for (int n = 1; n <= N; n++) {
                sum += n;
                possibleTraces.add(n * N); // multiple
            }
            if (N > 2) {
                possibleTraces.add(sum);
            }

            if (possibleTraces.contains(K)) {
                String line = "Case #" + test_case + ": POSSIBLE"  + "\n";
                System.out.print(line);

                if (K == sum) {
                    for (int i = 0; i < N; i++) {
                        for (int j = 1; j <= N; j++) {
                            int num = (i + j) % N;
                            num = num == 0 ? N : num;
                            if (j < N -1) {
                                System.out.print(num + " ");
                            } else {
                                System.out.print(num);
                            }
                        }
                        System.out.println();
                    }
                }
                else {
                    int start = K / N;
                    for (int i = 0; i < N; i++) {
                        int rowStart = (i == 0) ? start : start + (N - i);
                        rowStart = rowStart == 0 ? N : rowStart;
                        for (int j = 0; j < N; j++) {
                            int num = (rowStart + j) % N;
                            num = num == 0 ? N : num;
                            if (j < N -1) {
                                System.out.print(num + " ");
                            } else {
                                System.out.print(num);
                            }
                        }
                        System.out.println();
                    }
                }
            }
            else {
                String line = "Case #" + test_case + ": IMPOSSIBLE"  + "\n";
                System.out.print(line);
            }
        }
    }
}
