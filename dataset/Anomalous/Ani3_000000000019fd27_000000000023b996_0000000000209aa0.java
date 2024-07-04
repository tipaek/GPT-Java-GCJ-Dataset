import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Indicium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        
        for (int t = 1; t <= testCases; t++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int baseValue = k / n;
            List<List<Integer>> matrix = new ArrayList<>(n);
            
            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    int value = ((n - i + j) % n) + baseValue;
                    if (value > n) {
                        value -= n;
                    }
                    row.add(value);
                }
                matrix.add(row);
            }
            
            int trace = IntStream.range(0, n).map(idx -> matrix.get(idx).get(idx)).sum();
            if (trace == k) {
                System.out.println("Case #" + t + ": POSSIBLE");
                matrix.forEach(row -> System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}