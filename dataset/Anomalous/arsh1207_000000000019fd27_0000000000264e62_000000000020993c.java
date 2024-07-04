import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeJam1 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 0; t < testCases; t++) {
                int N = Integer.parseInt(br.readLine());
                int[][] matrix = new int[N][N];
                
                for (int i = 0; i < N; i++) {
                    String[] lineArray = br.readLine().split(" ");
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = Integer.parseInt(lineArray[j]);
                    }
                }

                int trace = 0;
                for (int i = 0; i < N; i++) {
                    trace += matrix[i][i];
                }

                int rowCounter = 0;
                int columnCounter = 0;

                for (int i = 0; i < N; i++) {
                    Integer[] rowArray = new Integer[N];
                    Integer[] colArray = new Integer[N];
                    for (int j = 0; j < N; j++) {
                        rowArray[j] = matrix[i][j];
                        colArray[j] = matrix[j][i];
                    }

                    if (hasDuplicates(rowArray)) {
                        rowCounter++;
                    }

                    if (hasDuplicates(colArray)) {
                        columnCounter++;
                    }
                }

                System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowCounter + " " + columnCounter);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean hasDuplicates(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return true;
            }
        }
        return false;
    }
}