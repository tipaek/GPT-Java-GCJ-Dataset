
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        String inFile = "sample.in";
        //Scanner sc = new Scanner(Template.class.getResource(inFile).openStream());
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println("Case #" + test + ": " + doit(n, matrix));
        }
    }

    private static String doit(int n, int[][] matrix) {
        int k = 0, r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            k += matrix[i][i];
        }
        for (int i = 0; i < n; i ++) {
            boolean[] found = new boolean[n];
            for (int j = 0; j < n; j++) {
                int elm = matrix[i][j];
                if (found[elm-1]) {
                    r++;
                    break;
                }
                found[elm-1] = true;
            }
        }
        for (int j = 0; j < n; j ++) {
            boolean[] found = new boolean[n];
            for (int i = 0; i < n; i++) {
                int elm = matrix[i][j];
                if (found[elm-1]) {
                    c++;
                    break;
                }
                found[elm-1] = true;
            }
        }
        return String.format("%d %d %d", k, r, c);
    }
}
