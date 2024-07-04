import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] ti = new int[t][3];
        
        for (int h = 0; h < t; h++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            boolean validInput = true;
            for (int i = 0; i < n && validInput; i++) {
                for (int k = 0; k < n && validInput; k++) {
                    int j = sc.nextInt();
                    if (j > n || j <= 0) {
                        validInput = false;
                    } else {
                        arr[i][k] = j;
                    }
                }
            }
            
            if (!validInput) {
                break;
            }
            
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == arr[i][j + 1]) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            ti[h][1] = rowDuplicates;
            
            int colDuplicates = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i][j] == arr[i + 1][j]) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            ti[h][2] = colDuplicates;
            
            int diagonalSum = 0;
            for (int k = 0; k < n; k++) {
                diagonalSum += arr[k][k];
            }
            ti[h][0] = diagonalSum;
        }
    }
}