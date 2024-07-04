import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    arr[i][k] = sc.nextInt();
                    if (i == k) {
                        trace += arr[i][k];
                    }
                }
            }
            
            int row = 0;
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                for (int k = 0; k < n && !hasDuplicate; k++) {
                    for (int y = k + 1; y < n; y++) {
                        if (arr[i][k] == arr[i][y]) {
                            row++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                }
            }
            
            int column = 0;
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                for (int k = 0; k < n && !hasDuplicate; k++) {
                    for (int y = k + 1; y < n; y++) {
                        if (arr[k][i] == arr[y][i]) {
                            column++;
                            hasDuplicate = true;
                            break;
                        }
                    }
                }
            }
            
            System.out.println("Case #" + (j + 1) + ": " + trace + " " + row + " " + column);
        }
        
        sc.close();
    }
}