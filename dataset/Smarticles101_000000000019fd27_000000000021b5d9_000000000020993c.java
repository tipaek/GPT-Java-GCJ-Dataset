import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        
        for (int cs = 1; cs <= cases; cs++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][];

            for (int i = 0; i < size; i++) {
                matrix[i] = new int[size];

                for (int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int k = 0, r = 0, c = 0;

            for (int i = 0; i < size; i++) {
                k += matrix[i][i];


                A: for (int j = 0; j < size; j++) {
                    for (int l = 0; l < j; l++) {
                        if (matrix[i][j] == matrix[i][l]) {
                            r++;
                            break A;
                        }
                    }
                }

                A: for (int j = 0; j < size; j++) {
                    for (int l = 0; l < j; l++) {
                        if (matrix[j][i] == matrix[l][i]) {
                            c++;
                            break A;
                        }
                    }
                }
            }

            System.out.println("Case #" + cs + ": " + k + " " + r + " " + c);
        }
    }
}