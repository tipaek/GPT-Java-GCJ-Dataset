import java.util.HashSet;
import java.util.Scanner;
class Programming {
    public static void main(String[] args) {
        int t;
        int caseNumber = 1;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (caseNumber <= t) {
            int n;
            n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int rowAns = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet();
                for (int j = 0; j < n; j++) {
                    if(set.contains(matrix[i][j])) {
                        rowAns++;
                        break;
                    }
                    else set.add(matrix[i][j]);
                }
            }

            int colAns = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet();
                for (int j = 0; j < n; j++) {
                    if(set.contains(matrix[j][i])) {
                        colAns++;
                        break;
                    }
                    else set.add(matrix[j][i]);
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " "  + rowAns + " " + colAns);

            caseNumber++;
        }
    }
}
