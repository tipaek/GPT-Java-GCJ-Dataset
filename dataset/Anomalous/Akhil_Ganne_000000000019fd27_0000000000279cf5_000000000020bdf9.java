import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            System.out.print("Case #" + caseNumber + ": ");
            int n = sc.nextInt();
            boolean[] cSchedule = new boolean[1500];
            boolean[] jSchedule = new boolean[1500];
            Arrays.fill(cSchedule, false);
            Arrays.fill(jSchedule, false);

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int k = 0; k < n; k++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean canAssignC = true;

                for (int i = start; i < end; i++) {
                    if (cSchedule[i]) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    result.append("C");
                    Arrays.fill(cSchedule, start, end, true);
                } else {
                    boolean canAssignJ = true;
                    for (int i = start; i < end; i++) {
                        if (jSchedule[i]) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        result.append("J");
                        Arrays.fill(jSchedule, start, end, true);
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

        bw.flush();
    }
}