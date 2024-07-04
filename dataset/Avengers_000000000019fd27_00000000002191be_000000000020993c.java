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
        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(in.readLine());
            List<List<Integer>> matrix = new ArrayList<>(n);

            int repRow = 0;
            int repCol = 0;
            for (int j = 0; j < n; j++) {
                List<Integer> row = Arrays.stream(in.readLine().split(" ")).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
                if (n != row.stream().distinct().count()) {
                    repRow++;
                }
                matrix.add(row);
            }
            int trace = IntStream.range(0, n).map(k -> matrix.get(k).get(k)).sum();

            for (int z = 0; z < n; z++) {
                List<Integer> col = new ArrayList<>();
                for (List<Integer> row : matrix) {
                    col.add(row.get(z));
                }
                if (n != col.stream().distinct().count()) {
                    repCol++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + repRow + " " + repCol);
        }
    }
}
