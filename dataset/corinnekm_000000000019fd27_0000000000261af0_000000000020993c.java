import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("resources/input1.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line;
        /****************************************************************************/
        int T = Integer.parseInt(sc.nextLine());
        int i = 0;
        int N = Integer.parseInt(sc.nextLine());

        int[][] square = new int[N][N];
        for (int t = 0; t < T; t++) {
            int trace = 0;
            int nbRepeatedRows = 0;
            while (sc.hasNextLine() && i < N) {
                String allNumbers = sc.nextLine();
                HashMap<Integer, Integer> hRow = new HashMap<Integer, Integer>();
                String[] numbers = allNumbers.split(" ");
                for (int j = 0; j < N; j++) {
                    int current = Integer.parseInt(numbers[j]);
                    if (i == j) {
                        trace = trace + current;
                    }
                    hRow.put(current, i);
                    square[i][j] = current;
                }
                if (hRow.keySet().size() < N) {
                    nbRepeatedRows = nbRepeatedRows + 1;
                }
                i++;
            }
            System.out.printf("Case #%d: %d %d %d", t + 1, trace, nbRepeatedRows, getNbRepeatedColumns(N, square));
            System.out.println("");
            i = 0;
            if (sc.hasNextLine()) {
                N = Integer.parseInt(sc.nextLine());
            }
        }
    }

    private static int getNbRepeatedColumns(int n, int[][] square) {
        int nbRepeatedColumns = 0;
        for (int c = 0; c < n; c++) {
            HashMap<Integer, Integer> hColumns = new HashMap<Integer, Integer>();
            for (int r = 0; r < n; r++) {
                int current = square[r][c];
                hColumns.put(current, c);
            }
            if (hColumns.keySet().size() < n) {
                nbRepeatedColumns = nbRepeatedColumns + 1;
            }
        }
        return nbRepeatedColumns;
    }
}