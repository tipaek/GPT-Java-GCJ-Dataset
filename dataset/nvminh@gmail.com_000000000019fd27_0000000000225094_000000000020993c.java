import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = getScanner();
        int caseNum = readLineToInt(sc);
        for(int caseIndex = 1; caseIndex <= caseNum; caseIndex ++) {
            int n = readLineToInt(sc);
            int[][] matrix = new int[n][];
            for(int r = 0; r < n; r++) {
                matrix[r] = readLineToInts(sc);
                //System.out.println(Arrays.toString(matrix[r]));
            }
            System.out.println(String.format("Case #%s: %s", caseIndex, solve(n, matrix)));
        }
    }

    private static String solve(int n, int[][] matrix) {
        int k = 0;
        int r = 0;
        int c = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            k+=matrix[i][i];
            set.clear();
            for(int ri = 0; ri < n; ri++) {
                set.add(matrix[ri][i]);
            }
            if(set.size() < n) {
                c++;
            }

            set.clear();
            for(int ci = 0; ci < n; ci++) {
                set.add(matrix[i][ci]);
            }
            if(set.size() < n) {
                r++;
            }
        }
        return String.format("%s %s %s", k, r, c);
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
        // try {
        //     return new Scanner(new FileInputStream("input.txt"));
        // } catch (Exception x) {
        //     return null;
        // }
    }

    private static int readLineToInt(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    private static int[] readLineToInts(Scanner sc) {
        String line = sc.nextLine();
        return Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}