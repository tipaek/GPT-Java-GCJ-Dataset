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
                String line = "Case #" + test_case + ": POSSIBLE";
                System.out.println(line);

                if (K % N != 0) {
                    // forwards
                    String forward = "";
                    for (int i = 1; i <= N; i++) {
                        forward += i + " ";
                    }
                    for (int i = 0; i < N/2; i++) {
                        int rotationPoint = forward.length() - (i * 4) % forward.length();
                        String s = forward.substring(rotationPoint) + forward.substring(0, rotationPoint);
                        System.out.println(s);
                    }

                    // backwards
                    String backwards = "";
                    for (int i = 0; i < N; i++) {
                        backwards += (N - i) + " ";
                    }
                    for (int i = 0; i < N/2; i++) {
                        int rotationPoint = backwards.length() - (i * 4) % backwards.length();
                        String s = backwards.substring(rotationPoint) + backwards.substring(0, rotationPoint);
                        System.out.println(s);
                    }
                }
                else {
                    int start = K / N;
                    for (int i = 0; i < N; i++) {
                        int rowStart = (i == 0) ? start : start + (N - i);
                        rowStart = rowStart == 0 ? N : rowStart;
                        String s = "";
                        for (int j = 0; j < N; j++) {
                            int num = (rowStart + j) % N;
                            num = num == 0 ? N : num;
                            s += num + " ";
                        }
                        System.out.println(s.trim());
                    }
                }
            }
            else {
                String line = "Case #" + test_case + ": IMPOSSIBLE";
                System.out.println(line);
            }
        }
    }
}
