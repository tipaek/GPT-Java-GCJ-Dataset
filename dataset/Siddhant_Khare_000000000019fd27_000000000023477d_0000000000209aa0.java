import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution{

    public static void main(final String[] args) {
        final String possible = "POSSIBLE";
        final String impossible = "IMPOSSIBLE";
        final InputStream inputStream = new Solution().getClass().getClassLoader()
                .getResourceAsStream("Indicium_input_file.txt");
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        final int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            final List<Integer> numbers = Arrays.stream(in.nextLine().split(" ")).map(val -> Integer.parseInt(val))
                    .collect(Collectors.toList());

            final int n = numbers.get(0);
            final int k = numbers.get(1);// trace
            final int center = k / n;

            final List<List<Integer>> matrix = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                final List<Integer> row = new ArrayList<>(n);
                for (int m = 0; m < n; m++) {
                    final int p = n - j;
                    int val = ((p + m) % n) + center;
                    if (val > n) {
                        val = val - n;
                    }
                    row.add(val);

                }

                matrix.add(row);
            }
            final int trace = IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();
            if(trace == k){
                System.out.println("Case #"+i+": "+possible);
                matrix.stream()
                        .map(val -> val.stream()
                                .map(st -> st.toString())
                                .collect(Collectors.joining(" ")))
                        .forEach(System.out::println);
            }else {
                System.out.println("Case #"+i+": "+impossible);
            }

        }
    }

}
