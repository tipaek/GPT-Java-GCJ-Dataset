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
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = Integer.parseInt(scanner.nextLine());
            
            for (int i = 1; i <= testCases; i++) {
                String[] input = scanner.nextLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                
                int center = k / n;
                List<List<Integer>> matrix = new ArrayList<>(n);
                
                for (int row = 0; row < n; row++) {
                    List<Integer> currentRow = new ArrayList<>(n);
                    for (int col = 0; col < n; col++) {
                        int value = ((n - row + col) % n) + center;
                        if (value > n) {
                            value -= n;
                        }
                        currentRow.add(value);
                    }
                    matrix.add(currentRow);
                }
                
                int trace = IntStream.range(0, n).map(idx -> matrix.get(idx).get(idx)).sum();
                
                if (trace == k) {
                    System.out.println("Case #" + i + ": " + POSSIBLE);
                    for (List<Integer> row : matrix) {
                        System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                    }
                } else {
                    System.out.println("Case #" + i + ": " + IMPOSSIBLE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}