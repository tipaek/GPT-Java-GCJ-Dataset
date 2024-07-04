import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int T = 0;

        System.out.print("Enter number of test cases >> ");
        Scanner scanner = new Scanner(System.in);

        try {
            T = scanner.nextInt();
            if (T <= 1 || T >= 100) {
                System.out.println("Number of test cases should be more than 1 and less than 100");
            }
        } catch (Exception e) {
            System.out.println("Number of test cases is not a valid integer");
        }

        int[] k = new int[T], r = new int[T], c = new int[T];

        // input
        for (int t = 0; t < T; t++) {
            System.out.println("========= Matrix " + (t + 1) + " =========");
            System.out.print("Enter size of the matrix >> ");

            try {
                int N = scanner.nextInt();
                if (N <= 2 || N >= 100) {
                    System.out.println("Size of array should be more than 2 and less than 100");
                } else {
                    int[][] M = new int[N][N];
                    // enter matrix
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print("Enter size of the M[" + (i + 1) + "," + (j + 1) + "]= ");
                            M[i][j] = scanner.nextInt();
                        }
                    }

                    // print matrix
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(M[i][j] + " ");
                        }
                        System.out.println();
                    }

                    // sum of values on the main diagonal
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (i == j)
                                k[t] += M[i][j];
                        }
                    }

                    // row
                    a:
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            for (int counter = j + 1; counter < N; counter++) {
                                if (M[i][j] == (M[i][counter])) {
                                    r[t]++;
                                    continue a;
                                }
                            }
                        }
                        System.out.println();
                    }

                    //column
                    b:
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {

                            for (int counter = j + 1; counter < N; counter++) {

                                if (M[j][i] == (M[counter][i])) {
                                    c[t]++;
                                    continue b;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Size of array is not a valid integer");
            }
        }

        // output
        System.out.println("Output");
        for (int t = 0; t < T; t++) {
            System.out.println("Case #" + (t + 1) + ": " + k[t] + " " + r[t] + " " + c[t]);
        }
    }
}

