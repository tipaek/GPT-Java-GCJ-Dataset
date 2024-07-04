import java.util.Scanner;

public class Main {
    public static boolean check(int[][] arr, int i, int j) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        // Check upwards
        for (int i1 = i - 1; i1 >= 0; i1--) {
            if (arr[i1][j] == -1) continue;
            if (arr[i1][j] > arr[i][j]) return false;
            break;
        }
        
        // Check downwards
        for (int i1 = i + 1; i1 < rows; i1++) {
            if (arr[i1][j] == -1) continue;
            if (arr[i1][j] > arr[i][j]) return false;
            break;
        }
        
        // Check leftwards
        for (int j1 = j - 1; j1 >= 0; j1--) {
            if (arr[i][j1] == -1) continue;
            if (arr[i][j1] > arr[i][j]) return false;
            break;
        }
        
        // Check rightwards
        for (int j1 = j + 1; j1 < cols; j1++) {
            if (arr[i][j1] == -1) continue;
            if (arr[i][j1] > arr[i][j]) return false;
            break;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] arr = new int[r][c];
            int skill = 0;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = sc.nextInt();
                    skill += arr[i][j];
                }
            }

            int remainingCells = r * c;
            int prevRemainingCells;

            do {
                prevRemainingCells = remainingCells;
                remainingCells = 0;
                int[][] toBeRemoved = new int[r * c][2];
                int k = 0;
                int sum = 0;

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (arr[i][j] == -1) continue;

                        if (check(arr, i, j)) {
                            skill += arr[i][j];
                            sum += arr[i][j];
                            remainingCells++;
                        } else {
                            toBeRemoved[k][0] = i;
                            toBeRemoved[k][1] = j;
                            k++;
                        }
                    }
                }

                for (int i = 0; i < k; i++) {
                    arr[toBeRemoved[i][0]][toBeRemoved[i][1]] = -1;
                }

                if (remainingCells == prevRemainingCells) {
                    skill -= sum;
                    break;
                }
            } while (remainingCells > 1);

            System.out.println("Case #" + caseNumber + ": " + skill);
            caseNumber++;
        }

        sc.close();
    }
}