import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LatinSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] square = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                for (int j = 0; j < size; j++) {
                    square[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int columnRepeats = 0;

            for (int i = 0; i < size; i++) {
                int[] rowCheck = new int[size + 1];
                int[] columnCheck = new int[size + 1];

                for (int j = 0; j < size; j++) {
                    rowCheck[square[i][j]]++;
                    columnCheck[square[j][i]]++;

                    if (rowCheck[square[i][j]] > 1) {
                        rowRepeats++;
                        break;
                    }

                    if (columnCheck[square[j][i]] > 1) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                trace += square[i][i];
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }
    }
}