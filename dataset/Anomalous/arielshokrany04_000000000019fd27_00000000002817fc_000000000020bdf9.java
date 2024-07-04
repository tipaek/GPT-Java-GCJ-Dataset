import java.util.Scanner;
import java.io.*;

class Solution {
    public static int[] start;
    public static int[] end;
    static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(input.nextLine());
        StringBuilder output = new StringBuilder();
        
        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(input.nextLine());
            start = new int[N];
            end = new int[N];
            
            for (int j = 0; j < N; j++) {
                addTime(input.nextLine(), j);
            }
            
            output.append(solve(i, N)).append("\n");
        }
        
        System.out.print(output.toString());
    }

    public static void addTime(String time, int index) {
        String[] times = time.split(" ");
        start[index] = Integer.parseInt(times[0]);
        end[index] = Integer.parseInt(times[1]);
    }

    public static String solve(int caseNumber, int count) {
        for (int i = 0; i < end.length; i++) {
            for (int j = 1; j < end.length; j++) {
                if (start[j] > start[i] && start[j - 1] > start[i] && start[j] < end[i] && start[j - 1] < end[i]) {
                    return "Case #" + caseNumber + ": IMPOSSIBLE";
                }
            }
        }

        StringBuilder result = new StringBuilder("C");
        char lastAssigned = 'C';

        for (int j = 1; j < count; j++) {
            if (start[j] <= end[j - 1] && end[j] >= start[j - 1]) {
                lastAssigned = 'J';
            } else {
                lastAssigned = 'C';
            }
            result.append(lastAssigned);
        }

        return "Case #" + caseNumber + ": " + result.toString();
    }
}