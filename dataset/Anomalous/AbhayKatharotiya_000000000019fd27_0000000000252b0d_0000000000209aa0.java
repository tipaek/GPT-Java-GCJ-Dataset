import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> results = new ArrayList<>();
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            String input = sc.nextLine();
            String[] inputs = input.split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            int remainder = k % n;

            if (remainder == 0) {
                List<List<Integer>> latinSquare = generateLatinSquare(n);
                List<List<Integer>> finalMatrix = new ArrayList<>();
                int quotient = k / n;

                for (int col = 0; col < n; col++) {
                    for (int row = 0; row < n; row++) {
                        if (latinSquare.get(row).get(col) == quotient) {
                            finalMatrix.add(latinSquare.get(row));
                            break;
                        }
                    }
                }

                results.add("Case #" + i + ": POSSIBLE");
                for (List<Integer> row : finalMatrix) {
                    StringBuilder rowString = new StringBuilder();
                    for (int val : row) {
                        rowString.append(val).append(" ");
                    }
                    results.add(rowString.toString().trim());
                }
            } else {
                results.add("Case #" + i + ": IMPOSSIBLE");
            }
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    static List<List<Integer>> generateLatinSquare(int n) {
        List<List<Integer>> matrix = new ArrayList<>();
        int start = n + 1;

        for (int i = 1; i <= n; i++) {
            List<Integer> row = new ArrayList<>();
            int temp = start;

            while (temp <= n) {
                row.add(temp);
                temp++;
            }

            for (int j = 1; j < start; j++) {
                row.add(j);
            }

            start--;
            matrix.add(row);
        }

        return matrix;
    }
}