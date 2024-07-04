
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        String possible = "POSSIBLE";
        String impossible = "IMPOSSIBLE";
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t ; i++) {
            List<Integer> numbers = Arrays.stream(in.nextLine().split(" "))
                    .map(val -> Integer.parseInt(val)).collect(Collectors.toList());

            int n = numbers.get(0);
            int k = numbers.get(1);// trace

            if (n >= 2 && n <= 50) {
                List<List<Integer>> matrix = new ArrayList<>(n);
                boolean repRow = false;
                for (int j = 1; j <= n; j++) {
                    List<Integer> row = new ArrayList<>(n);

                    for (int m = 1; m <= n; m++) {
                        int p = (((j + 1) + m) % n);
                        if(p == 0){
                            p = n;
                        }
                        row.add(p);

                    }
                    if(n!= row.stream().distinct().count()){
                        repRow = true;
                        break;
                    }
                    matrix.add(row);
                }

                boolean repCol = false;
                if (!repRow){
                    for (int z = 0; z < n; z++) {
                        List<Integer> col = new ArrayList<>();
                        for (List<Integer> row: matrix) {
                            col.add(row.get(z));
                        }
                        if (n != col.stream().distinct().count()){
                            repCol = true;
                            break;
                        }
                    }
                }

                int trace = IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();
                if (!repRow && !repCol && trace == k ) {
                    System.out.println("Case #" + i + ": " + possible);
                    printMatrix(matrix);
                } else {
                    System.out.println("Case #" + i + ": " + impossible);

                }
            }else {
                System.out.println("Case #" + i + ": " + impossible);
            }

        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        matrix.stream()
                .map(val -> val.stream()
                        .map(st -> st.toString())
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }


}
