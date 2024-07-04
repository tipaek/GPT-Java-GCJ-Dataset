import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCase = in.nextInt();
        String[] arr = new String[numOfCase];

        for (int i = 0; i < numOfCase; i++) {
            int n = in.nextInt();
            int[][] myArray = new int[n][n];

            for (int f = 0; f < n; f++) {
                for (int j = 0; j < n; j++) {
                    myArray[f][j] = in.nextInt();
                }
            }

            int nrows = 0;
            for (int q = 0; q < n; q++) {
                boolean rowHasDuplicate = false;
                for (int e = 0; e < n; e++) {
                    int x = myArray[q][e];
                    for (int r = e + 1; r < n; r++) {
                        if (myArray[q][r] == x) {
                            nrows++;
                            rowHasDuplicate = true;
                            break;
                        }
                    }
                    if (rowHasDuplicate) break;
                }
            }

            int ncol = 0;
            for (int q = 0; q < n; q++) {
                boolean colHasDuplicate = false;
                for (int e = 0; e < n; e++) {
                    int x = myArray[e][q];
                    for (int r = e + 1; r < n; r++) {
                        if (myArray[r][q] == x) {
                            ncol++;
                            colHasDuplicate = true;
                            break;
                        }
                    }
                    if (colHasDuplicate) break;
                }
            }

            int digSum = 0;
            for (int o = 0; o < n; o++) {
                digSum += myArray[o][o];
            }

            arr[i] = "Case #" + (i + 1) + ": " + digSum + " " + nrows + " " + ncol;
        }

        for (String result : arr) {
            System.out.println(result);
        }
    }
}