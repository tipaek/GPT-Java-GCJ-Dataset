
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    static String solve(int[][] arr) {
        StringBuilder ans = new StringBuilder();
        int ce = -1;
        int je = -1;

        for (int i = 0; i < arr.length; i++) {
            int from = arr[i][0];
            int to = arr[i][1];

            //check C
            if (from >=ce) {
                ans.append("C");
                ce = to;
                continue;
            }
            //check J
            if (from >=je) {
                ans.append("J");
                je = to;
                continue;
            }

            return "IMPOSSIBLE";
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int cs = 1; cs <= cases; cs++) {
            int n = in.nextInt();
            in.nextLine();

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] line = in.nextLine().split(" ");
                int from = Integer.parseInt(line[0]);
                int to = Integer.parseInt(line[1]);
                arr[i] = new int[]{from, to};
            }
            Arrays.sort(arr,(o1, o2) -> o1[0]-o2[0]);
            System.out.println("Case #" + cs + ": "+solve(arr));
        }
    }
}
