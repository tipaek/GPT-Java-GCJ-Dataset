
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Pamathi Gunaratne
 */
class VestigiumApp {

    /**
     * @param args the command line arguments
     *
     */
    private int T;
    private int N;
    private int[][] matrix;

    VestigiumApp(int cases) {
        T = cases;

    }

    void input() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        for (int i = 1; i <= T; i++) {
            System.out.println("Please enter the size of matrix");
            N = sc.nextInt();
            int x;
            if (N >= 2 && N <= 100) {
                matrix = new int[N][N];
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        x = sc.nextInt();
                        if (x >= 1 && x <= N) {
                            matrix[r][c] = x;
                        }
                    }

                }
                System.out.println("case #" + i + " :" + trace(matrix, N) + " " + reprow(matrix, N) + " " + repcol(matrix, N));

            }
        }
    }

    int reprow(int matrix[][], int size) {
        int count = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size - 1; c++) {
                if (matrix[r][c] == matrix[r][c + 1]) {
                    count++;
                    break;
                }
            }

        }
        return count;

    }

    int repcol(int matrix[][], int size) {
        int count = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size - 1; c++) {
                if (matrix[c][r] == matrix[c + 1][r]) {
                    count++;
                    break;
                }
            }

        }
        return count;

    }

    int trace(int matrix[][], int size) {
        int sum = 0;
        for (int r = 0; r < size; r++) {
            sum = sum + matrix[r][r];
        }
        return sum;

    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        System.out.println("Please enter the no of test cases");
        int T = sc.nextInt();

        if (T >= 1 && T <= 100) {
            VestigiumApp object = new VestigiumApp(T);
            object.input();
            System.exit(0); 
        }
    }
    
    
}
