import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {
    int a;
    int b;
    int c;

    public Result() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Result> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[][] matrix = new int[m][m];
            boolean[] col = new boolean[m];
            Result r = new Result();

            for (int j = 0; j < m; j++) {
                boolean row = false;
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) r.a += matrix[j][k];

                    if (k > 0 && !row) {
                        for (int l = 0; l < k; l++) {
                            if (matrix[j][l] == matrix[j][k]) {
                                row = true;
                                r.b++;
                                break;
                            }
                        }
                    }

                    if (j > 0 && !col[k]) {
                        for (int l = 0; l < j; l++) {
                            if (matrix[l][k] == matrix[j][k]) {
                                col[k] = true;
                                r.c++;
                                break;
                            }
                        }
                    }
                }
            }

            results.add(r);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i).a + " " + results.get(i).b + " " + results.get(i).c);
        }

        scanner.close();
    }
}