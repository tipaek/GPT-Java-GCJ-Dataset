import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            int k = input.get(1);

            if (k % n != 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");

                List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
                int rotation = k / n;
                int factor = (rotation == n) ? rotation - 1 : rotation;

                for (int j = 1; j <= n; j++) {
                    int start = rotation;
                    List<Integer> rotatedList = new ArrayList<>();
                    for (int l = 0; l < n; l++) {
                        rotatedList.add(start);
                        start = (start % n) + 1;
                    }
                    System.out.println(rotatedList.stream().map(String::valueOf).collect(Collectors.joining(" ")));

                    rotation--;
                    if (rotation == 0) {
                        rotation = n;
                    }
                }
            }
        }
    }
}