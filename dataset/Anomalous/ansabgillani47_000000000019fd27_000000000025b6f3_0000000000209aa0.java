import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Indicium {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";
        
        InputStream inputStream = Indicium.class.getClassLoader().getResourceAsStream("Indicium_input_file.txt");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String[] input = in.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int center = k / n;

            List<List<Integer>> matrix = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                List<Integer> row = new ArrayList<>(n);
                for (int m = 0; m < n; m++) {
                    int p = n - j;
                    int val = ((p + m) % n) + center;
                    if (val > n) {
                        val -= n;
                    }
                    row.add(val);
                }
                matrix.add(row);
            }

            int trace = IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();
            if (trace == k) {
                System.out.println("Case #" + i + ": " + POSSIBLE);
                matrix.forEach(row -> System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
            } else {
                System.out.println("Case #" + i + ": " + IMPOSSIBLE);
            }
        }
    }
}