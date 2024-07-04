import java.util.*;
import java.io.*;

public class Solution {
    
    private static int T;
    private static List<int[][]> squares;

    public static void main(String[] args) {
        readInput('W');

        for (int i = 0; i < T; i++) {
            int[][] square = squares.get(i);
            int N = square.length;
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate trace
            for (int j = 0; j < N; j++) {
                trace += square[j][j];
            }

            // Check row duplicates
            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(square[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check column duplicates
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!colSet.add(square[k][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static void readInput(char mode) {
        BufferedReader in = null;
        try {
            if (mode == 'E') {
                in = new BufferedReader(new FileReader("input.txt"));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
            }

            T = Integer.parseInt(in.readLine());
            squares = new ArrayList<>();

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(in.readLine());
                int[][] square = new int[N][N];
                for (int j = 0; j < N; j++) {
                    String[] row = in.readLine().split(" ");
                    for (int k = 0; k < N; k++) {
                        square[j][k] = Integer.parseInt(row[k]);
                    }
                }
                squares.add(square);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}