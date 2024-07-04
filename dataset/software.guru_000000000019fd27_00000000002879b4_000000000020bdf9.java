import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        for (int tc = 1; tc <= numberOfTestCases; tc++) {
            block:
            {
                int n = scanner.nextInt();
                int[][] tasks = new int[n][3];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 2; j++) {
                        tasks[i][j] = scanner.nextInt();
                    }
                    tasks[i][2] = i;
                }
                char[] letters = new char[tasks.length];
                Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
                int cameronPointer = 0, jamiePointer = 0;
                for (int[] task : tasks) {
                    if (task[0] >= cameronPointer) {
                        letters[task[2]] = 'C';
                        cameronPointer = task[1];
                    } else if (task[0] >= jamiePointer) {
                        letters[task[2]] = 'J';
                        jamiePointer = task[1];
                    } else {
                        System.out.println("Case #" + tc + ": IMPOSSIBLE");
                        break block;
                    }
                }
                System.out.println("Case #" + tc + ": " + new String(letters));
            }
        }
    }
}