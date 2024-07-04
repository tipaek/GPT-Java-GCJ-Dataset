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
        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<Integer> inputs = Arrays.stream(reader.readLine().split(" "))
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());
            int n = inputs.get(0);
            int k = inputs.get(1);

            if (k % n != 0 || k / n > n || k < 0) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": POSSIBLE");

                List<Integer> permutation = IntStream.rangeClosed(1, n)
                                                      .boxed()
                                                      .collect(Collectors.toList());
                Collections.rotate(permutation, -((k / n) - 1));

                for (int j = 0; j < n; j++) {
                    String result = permutation.stream()
                                               .map(String::valueOf)
                                               .collect(Collectors.joining(" "));
                    System.out.println(result);
                    Collections.rotate(permutation, 1);
                }
            }
        }
    }
}