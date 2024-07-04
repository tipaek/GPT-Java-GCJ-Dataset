import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            List<Integer> inputs = Arrays.stream(reader.readLine().split(" "))
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());
            int n = inputs.get(0);
            int m = inputs.get(1);

            if (m % n != 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");

                List<Integer> sequence = IntStream.rangeClosed(1, n)
                                                   .boxed()
                                                   .collect(Collectors.toList());
                Collections.rotate(sequence, m / n);

                for (int j = 0; j < n; j++) {
                    System.out.println(sequence.stream()
                                               .map(String::valueOf)
                                               .collect(Collectors.joining(" ")));
                    Collections.rotate(sequence, 1);
                }
            }
        }
    }
}