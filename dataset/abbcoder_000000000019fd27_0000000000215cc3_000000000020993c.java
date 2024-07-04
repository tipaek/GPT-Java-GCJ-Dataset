import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[][]> cases = readLines();

        for (int c = 1; c <= cases.size(); c++) {
            int[][] lines = cases.get(c - 1);

            int N = lines[0][0];
            int[][] matrix = Arrays.copyOfRange(lines, 1, N + 1);

            int trace = 0;
            int rowRepeats = 0;
            int columnRepeats = 0;

            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            int[][] rowCounts = new int[N][N];
            int[][] columnCounts = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int e = matrix[i][j];
                    rowCounts[i][e - 1]++;
                    columnCounts[j][e - 1]++;
                }
            }

            for (int[] counts : rowCounts) {
                for (int count : counts) {
                    if (count != 1) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int[] counts : columnCounts) {
                for (int count : counts) {
                    if (count != 1) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            print(String.format("Case #%d: %d %d %d", c, trace, rowRepeats, columnRepeats));
        }
    }

    static ArrayList<int[][]> readLines() {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());
        ArrayList<int[][]> cases = new ArrayList<>(T);

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(in.nextLine());
            int[][] lines = new int[N + 1][];
            cases.add(lines);

            lines[0] = new int[]{N};
            for (int n = 0; n < N; n++) {
                lines[n + 1] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        in.close();
        return cases;
    }

    static void print(String line) {
        System.out.println(line);
    }

    static void print(int[] line) {
        System.out.println(Arrays.toString(line));
    }

    static void print(int[][] lines) {
        for (int[] line : lines) {
            print(line);
        }
    }
}
