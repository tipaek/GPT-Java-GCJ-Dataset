import java.util.*;
class Vestigium {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        for(int t = 1; t <= testCases; t++) {
            int n = s.nextInt();
            int trace = 0;
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = s.nextInt();
                    if (i == j) {
                        trace = trace + a[i][j];
                    }
                }
            }
            int rowDuplicate = 0;
            int columnDuplicate = 0;
            for (int i = 0; i < n; i++) {
                if (isDuplicateExist(a, i, n)) {
                    rowDuplicate++;
                }
                if (isColumnDuplicateExist(a, i, n)) {
                    columnDuplicate++;
                }
            }
            System.out.println("Case #" + t + ":" + trace + " " + rowDuplicate + " " + columnDuplicate);
        }
        
    }
    
    static boolean isColumnDuplicateExist(int[][] arr, int columnIndex, int n) {
        boolean isDuplicateExist = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][columnIndex] == arr[j][columnIndex]) {
                    isDuplicateExist = true;
                    break;
                }
            }
            if (isDuplicateExist) {
                break;
            }
        }
        return isDuplicateExist;
    }

    static boolean isDuplicateExist(int[][] arr, int rowIndex, int length) {
        boolean isDuplicateExist = false;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[rowIndex][i] == arr[rowIndex][j]) {
                    isDuplicateExist = true;
                    break;
                }
            }
            if (isDuplicateExist) {
                break;
            }
        }
        return isDuplicateExist;
    }
}