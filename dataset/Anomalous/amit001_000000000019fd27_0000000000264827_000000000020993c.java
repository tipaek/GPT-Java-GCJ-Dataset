import java.util.Scanner;

public class Code {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int caseNumber = 1;
            int t = sc.nextInt();
            
            while (t > 0) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0, rowDuplicates = 0, colDuplicates = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = sc.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!rowSet.add(matrix[i][j])) {
                            rowDuplicates++;
                            break;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!colSet.add(matrix[j][i])) {
                            colDuplicates++;
                            break;
                        }
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
                t--;
                caseNumber++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}