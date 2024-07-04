import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private void solve(Scanner scan) {
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(array[i][j]);
            }
            if (set.size() != n) {
                rowDuplicates++;
            }
        }
        int colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(array[j][i]);
            }
            if (set.size() != n) {
                colDuplicates++;
            }
        }
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += array[i][i];
        }
        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
