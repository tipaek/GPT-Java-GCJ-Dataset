import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        for (int x = 0; x < cases; x++) {

            int size = Integer.parseInt(br.readLine());
            int[][] square = new int[size][size];
            int trace = 0;
            int repRows = 0;
            int repCols = 0;

            for (int r = 0; r < size; r++) {
                String[] line = br.readLine().split(" ");
                Set<Integer> uniqR = new HashSet<>();

                for (int c = 0; c < size; c++) {
                    int value = Integer.parseInt(line[c]);
                    square[r][c] = value;

                    if (r == c) {
                        trace += value;
                    }

                    if (!uniqR.add(value)) {
                        repRows++;
                        break;
                    }
                }
            }

            for (int c = 0; c < size; c++) {
                Set<Integer> uniqC = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!uniqC.add(square[r][c])) {
                        repCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + trace + " " + repRows + " " + repCols);
        }
    }
}