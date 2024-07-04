import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static ArrayList<String> output = new ArrayList<>();
    private static int pos = 0;
    private static void ReadInput(Scanner sc){
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        OperateMatrix(matrix, size);
    }

    private static void OperateMatrix(int[][] matrix, int size) {
        int k = 0, r = 0, c = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int saveR = matrix[i][j];
                int saveC = matrix[j][i];
                for (int l = j + 1; l < size; l++) {
                    if (saveC == matrix[l][i]){
                        c++;
                        saveC = -1;
                        j = size;
                    }
                    if (saveR == matrix[i][l]) {
                        r++;
                        saveR = -1;
                        j = size;
                    }
                }
            }
            k += matrix[i][i];
        }
        String out = String.format("Case #%d: %d %d %d", pos + 1, k, r, c);
        output.add(out);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (pos = 0; pos < n; pos++) {
            ReadInput(sc);
        }
        for (String out:
             output) {
            System.out.println(out);
        }
    }
}
