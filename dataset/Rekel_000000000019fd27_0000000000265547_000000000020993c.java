import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testen = sc.nextInt();

        for (int test = 1; test <= testen; test++) {
            test(test);
        }
    }

    private static void test(int test) {
        int grootte = sc.nextInt();
        int rij = 0;
        int kolom = 0;
        int trace = 0;

        int[][] matrix = new int[grootte][grootte];
        boolean[] gehad = new boolean[grootte];

        for (int i = 0; i < grootte; i++) {
            for (int j = 0; j < grootte; j++) {
                int getal = sc.nextInt();
                matrix[i][j] = getal;
                if (i == j)
                    trace += getal;
            }
        }
        // Rijen:
        for (int r = 0; r < grootte; r++) {
            Arrays.fill(gehad, false);
            for (int k = 0; k < grootte; k++) {
                int getal = matrix[r][k];
                if (gehad[getal-1]) {
                    rij++;
                    break;
                } else {
                    gehad[getal-1] = true;
                }
            }
        }
        // Kolommen:
        for (int k = 0; k < grootte; k++) {
            Arrays.fill(gehad, false);
            for (int r = 0; r < grootte; r++) {
                int getal = matrix[r][k];
                if (gehad[getal-1]) {
                    kolom++;
                    break;
                } else {
                    gehad[getal-1] = true;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d\n", test, trace, rij, kolom);
    }
}