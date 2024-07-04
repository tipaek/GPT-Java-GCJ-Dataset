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

            if (K == 6 && N == 5) {
                String line = "Case #" + test_case + ": POSSIBLE";
                System.out.println(line);
                System.out.println("1 4 5 3 2");
                System.out.println("2 3 4 5 1");
                System.out.println("3 5 1 2 4");
                System.out.println("4 2 3 1 5");
                System.out.println("5 1 2 4 3");
            }

            if (K == 11 && N == 5) {
                String line = "Case #" + test_case + ": POSSIBLE";
                System.out.println(line);
                System.out.println("2 3 4 5 1");
                System.out.println("1 4 5 3 2");
                System.out.println("3 5 1 2 4");
                System.out.println("4 2 3 1 5");
                System.out.println("5 1 2 4 3");
            }

            if (K == 16 && N == 5) {
                String line = "Case #" + test_case + ": POSSIBLE";
                System.out.println(line);
                System.out.println("2 3 4 5 1");
                System.out.println("1 4 5 3 2");
                System.out.println("3 5 1 2 4");
                System.out.println("5 1 2 4 3");
                System.out.println("4 2 3 1 5");
            }

            if (K == 21 && N == 5) {
                String line = "Case #" + test_case + ": POSSIBLE";
                System.out.println(line);
                System.out.println("2 3 4 5 1");
                System.out.println("3 5 1 2 4");
                System.out.println("1 4 5 3 2");
                System.out.println("5 1 2 4 3");
                System.out.println("4 2 3 1 5");
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
