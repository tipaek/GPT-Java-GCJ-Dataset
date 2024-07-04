import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            System.out.print("Case #" + caseNumber + ": ");
            int n = sc.nextInt();
            boolean[] cSchedule = new boolean[1441];
            boolean[] jSchedule = new boolean[1441];
            Arrays.fill(cSchedule, false);
            Arrays.fill(jSchedule, false);

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int k = 0; k < n; k++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean canAssignToC = true;

                for (int i = start; i < end; i++) {
                    if (cSchedule[i]) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    result.append("C");
                    for (int i = start; i < end; i++) {
                        cSchedule[i] = true;
                    }
                } else {
                    boolean canAssignToJ = true;
                    for (int i = start; i < end; i++) {
                        if (jSchedule[i]) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        result.append("J");
                        for (int i = start; i < end; i++) {
                            jSchedule[i] = true;
                        }
                    } else {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                System.out.println(result.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
            caseNumber++;
        }
    }
}