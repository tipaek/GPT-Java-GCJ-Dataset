import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= t; i++) {
            List<Integer> input = Arrays.stream(reader.readLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
            int n = input.get(0);
            int m = input.get(1);

            if (m % n != 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");

                List<Integer> list = IntStream.range(1, n + 1)
                                              .boxed()
                                              .collect(Collectors.toList());
                Collections.rotate(list, m / n);

                for (int j = 0; j < n; j++) {
                    System.out.println(list.stream()
                                           .map(Object::toString)
                                           .collect(Collectors.joining(" ")));
                    Collections.rotate(list, 1);
                }
            }
        }
    }
}