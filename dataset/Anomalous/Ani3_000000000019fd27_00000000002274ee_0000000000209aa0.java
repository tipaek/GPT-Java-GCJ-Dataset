import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Indicium {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";
        
        InputStream inputStream = Indicium.class.getClassLoader().getResourceAsStream("Indicium_input_file.txt");
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
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
                matrix.stream()
                      .map(row -> row.stream()
                                     .map(String::valueOf)
                                     .collect(Collectors.joining(" ")))
                      .forEach(System.out::println);
            } else {
                System.out.println("Case #" + i + ": " + IMPOSSIBLE);
            }
        }
        scanner.close();
    }
}