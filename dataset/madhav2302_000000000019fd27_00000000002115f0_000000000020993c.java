import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();


        for (int testNumber = 1; testNumber <= T; testNumber++) {
            int N = scanner.nextInt();

            boolean[][] rowValue = new boolean[N][N + 1];
            boolean[][] columnValue = new boolean[N][N + 1];

            int trace = 0;
            Set<Integer> rows = new HashSet<>();
            Set<Integer> columns = new HashSet<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt();

                    if (rowValue[i][value]) rows.add(i);
                    if (columnValue[j][value]) columns.add(j);

                    rowValue[i][value] = true;
                    columnValue[j][value] = true;

                    if (i == j) trace += value;
                }
            }

            System.out.println("Case #" + testNumber + " " + trace + " " + rows.size() + " " + columns.size());
        }
    }
}
