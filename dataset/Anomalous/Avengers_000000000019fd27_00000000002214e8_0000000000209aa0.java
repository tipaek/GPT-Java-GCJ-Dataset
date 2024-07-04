import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            List<Integer> input = Arrays.stream(reader.readLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
            int n = input.get(0);
            int k = input.get(1);

            if (k % n != 0 || k % n > n || k < 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");

                List<Integer> permutation = IntStream.rangeClosed(1, n)
                                                      .boxed()
                                                      .collect(Collectors.toList());
                Collections.rotate(permutation, -((k / n) - 1));

                for (int j = 0; j < n; j++) {
                    System.out.println(permutation.stream()
                                                  .map(String::valueOf)
                                                  .collect(Collectors.joining(" ")));
                    Collections.rotate(permutation, 1);
                }
            }
        }
    }

    static int findSum(int n) {
        if (n % 2 == 0) {
            return (n / 2) * (n + 1);
        } else {
            return ((n + 1) / 2) * n;
        }
    }
}