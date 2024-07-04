import java.util.*;
import java.io.*;

public class Mtix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int z = sc.nextInt();
        
        for (int q = 1; q <= z; q++) {
            int no = sc.nextInt();
            int[][] arr = new int[no][no];
            
            for (int i = 0; i < no; i++) {
                for (int j = 0; j < no; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int add = calculateDiagonalSum(arr, no);
            int count = countDuplicateRows(arr, no);
            int ct = countDuplicateColumns(arr, no);
            
            System.out.println("Case #" + q + ": " + add + " " + count + " " + ct);
        }
    }

    private static int calculateDiagonalSum(int[][] arr, int no) {
        int sum = 0;
        for (int i = 0; i < no; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] arr, int no) {
        int count = 0;
        for (int i = 0; i < no; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < no; j++) {
                if (!seen.add(arr[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countDuplicateColumns(int[][] arr, int no) {
        int count = 0;
        for (int j = 0; j < no; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < no; i++) {
                if (!seen.add(arr[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}