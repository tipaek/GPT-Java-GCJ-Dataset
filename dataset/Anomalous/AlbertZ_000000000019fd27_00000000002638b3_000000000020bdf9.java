import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintWriter OUTPUT = new PrintWriter(System.out);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = SCANNER.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            OUTPUT.print(String.format("Case #%d: ", i));
            solution.solve();
        }
        
        OUTPUT.flush();
        System.exit(0);
    }

    private void solve() throws IOException {
        int n = SCANNER.nextInt();
        int[][] tasks = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            tasks[i][0] = SCANNER.nextInt();
            tasks[i][1] = SCANNER.nextInt();
            tasks[i][2] = i;
        }
        
        Arrays.sort(tasks, (task1, task2) -> 
            task1[0] != task2[0] ? Integer.compare(task1[0], task2[0]) : Integer.compare(task1[1], task2[1])
        );
        
        int cameronEnd = 0, jamieEnd = 0;
        char[] result = new char[n];
        
        for (int[] task : tasks) {
            if (task[0] >= cameronEnd) {
                result[task[2]] = 'C';
                cameronEnd = task[1];
            } else if (task[0] >= jamieEnd) {
                result[task[2]] = 'J';
                jamieEnd = task[1];
            } else {
                OUTPUT.println("IMPOSSIBLE");
                return;
            }
        }
        
        OUTPUT.println(new String(result));
    }
}