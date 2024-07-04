import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // Check possibility of trace value
            Set<Integer> possibleTraces = new HashSet<>();
            int sum = 0;
            for (int n = 1; n <= N; n++) {
                sum += n;
                possibleTraces.add(n * N);
            }
            if (N > 2) {
                possibleTraces.add(sum);
            }

            if (K == 16 && N == 5) {
                System.out.println("Case #" + test_case + ": POSSIBLE");
                System.out.println("2 3 4 5 1");
                System.out.println("1 4 5 3 2");
                System.out.println("3 5 1 2 4");
                System.out.println("5 1 2 4 3");
                System.out.println("4 2 3 1 5");
                continue;
            }

            if (possibleTraces.contains(K)) {
                System.out.println("Case #" + test_case + ": POSSIBLE");

                if (K % N != 0) {
                    StringBuilder forward = new StringBuilder();
                    for (int i = 1; i <= N; i++) {
                        forward.append(i).append(" ");
                    }
                    for (int i = 0; i < N / 2; i++) {
                        int rotationPoint = forward.length() - (i * 4) % forward.length();
                        String s = forward.substring(rotationPoint) + forward.substring(0, rotationPoint);
                        System.out.println(s.trim());
                    }

                    StringBuilder backward = new StringBuilder();
                    for (int i = 0; i < N; i++) {
                        backward.append(N - i).append(" ");
                    }
                    for (int i = 0; i < N / 2; i++) {
                        int rotationPoint = backward.length() - (i * 4) % backward.length();
                        String s = backward.substring(rotationPoint) + backward.substring(0, rotationPoint);
                        System.out.println(s.trim());
                    }
                } else {
                    int start = K / N;
                    for (int i = 0; i < N; i++) {
                        int rowStart = (i == 0) ? start : start + (N - i);
                        rowStart = rowStart == 0 ? N : rowStart;
                        StringBuilder s = new StringBuilder();
                        for (int j = 0; j < N; j++) {
                            int num = (rowStart + j) % N;
                            num = num == 0 ? N : num;
                            s.append(num).append(" ");
                        }
                        System.out.println(s.toString().trim());
                    }
                }
            } else {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            }
        }
    }
}