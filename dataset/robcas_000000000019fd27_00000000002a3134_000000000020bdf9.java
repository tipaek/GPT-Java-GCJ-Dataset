import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
           int tasks = scanner.nextInt();
           int[][] schedule = new int[tasks][2];
           for (int j = 0; j < tasks; j++) {
               int[] interval = new int[2];
               interval[0] = scanner.nextInt();
               interval[1] = scanner.nextInt();
               schedule[j] = interval;
           }
           sortbyColumn(schedule, 0);
           String res = "";
           //C = 0, J = 1;
           boolean[] C = new boolean[1441];
           boolean[] J = new boolean[1441];
           Arrays.fill(C, true);
           Arrays.fill(J, true);
           for (int j = 0; j < schedule.length; j++) {
               if (res.equals("IMPOSSIBLE"))
                   break;
               if (C[schedule[j][0]]) {
                   for (int k = schedule[j][0]; k < schedule[j][1]; k++)
                       C[k] = false;
                   res += "C";
                   continue;
               }
               if (J[schedule[j][0]]) {
                   for (int k = schedule[j][0]; k < schedule[j][1]; k++)
                       J[k] = false;
                   res += "J";
                   continue;
               }
               res = "IMPOSSIBLE";
           }
           System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
}
