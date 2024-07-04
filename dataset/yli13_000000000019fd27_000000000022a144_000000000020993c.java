import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        for (int i = 1; i <= testCase; i++) {
            solve(input, i);
        }
    }

    private static String solve(Scanner scanner, int c) {
        int n = scanner.nextInt();
        int[][] m = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            String[] splited = s.split("\\s+");
            for (int j = 0; j < s.length(); j++) {
                m[i][j] = Integer.parseInt(splited[j]);
            }
        }
        long trace = getTrace(m, n);
        int row = check(m, n, true);
        int col = check(m, n, false);
        System.out.println("Case #" + c +": " + trace + " " + row + " " + col);
    }

    private static int check(int[][] m, int n, boolean isRow) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int cur = 0;
                if (isRow) {
                    cur = m[i][j];    
                } else {
                    cur = m[j][i];
                }
                if (s.contains(cur)) {
                    res++;
                    break;
                } else {
                    s.add(cur);
                }
            }
        }   
        return res;
    }
    
    private static long getTrace(int[][] m, int n) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += m[i][i];
        }
        return res;
    }
}
