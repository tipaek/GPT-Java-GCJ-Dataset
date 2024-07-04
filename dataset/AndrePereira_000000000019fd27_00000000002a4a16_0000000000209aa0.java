import java.util.*;

public class Solution {

    private static void indicium(int cs, int n, int t) {

        boolean possible = false;
        if (t % n == 0) {
            possible = true;
        }
        System.out.println(String.format("Case #%d: %s", cs, possible ? "POSSIBLE" : "IMPOSSIBLE"));
        if (possible) {
            int k = t / n;
            int[] nums = new int[n];
            int numIndex = 1;
            nums[0] = k;
            for (int i=1; i<= n; i++)
                if (i != k)
                    nums[numIndex++] = i;
            numIndex = 0;
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (i == j)
                        System.out.print(k + " ");
                    else
                        System.out.print(nums[numIndex] + " ");
                    if (j < n)
                        numIndex = (numIndex + 1) % n;
                    else
                        System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int k = 0; k<t; k++ ) {
            String line = scanner.nextLine();
            String[] sline = line.split(" ");
            int n = Integer.parseInt(sline[0]);
            int trace = Integer.parseInt(sline[1]);
            indicium(k+1, n, trace);
        }

    }
}
