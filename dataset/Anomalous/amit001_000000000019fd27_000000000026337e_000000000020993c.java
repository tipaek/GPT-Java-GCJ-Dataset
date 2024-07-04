import java.util.Scanner;

class A {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[][] arr = new int[n][n];
                int diagonalSum = 0, rowDuplicates = 0, colDuplicates = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = sc.nextInt();
                        if (i == j) {
                            diagonalSum += arr[i][j];
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    boolean rowHasDuplicate = false;
                    for (int j = 0; j < n - 1; j++) {
                        for (int k = j + 1; k < n; k++) {
                            if (arr[i][j] == arr[i][k]) {
                                rowDuplicates++;
                                rowHasDuplicate = true;
                                break;
                            }
                        }
                        if (rowHasDuplicate) break;
                    }
                }

                for (int i = 0; i < n; i++) {
                    boolean colHasDuplicate = false;
                    for (int j = 0; j < n - 1; j++) {
                        for (int k = j + 1; k < n; k++) {
                            if (arr[j][i] == arr[k][i]) {
                                colDuplicates++;
                                colHasDuplicate = true;
                                break;
                            }
                        }
                        if (colHasDuplicate) break;
                    }
                }

                System.out.println(diagonalSum + " " + rowDuplicates + " " + colDuplicates);
                t--;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}