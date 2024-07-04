import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int activities = in.nextInt();
            byte[] c = new byte[1441];
            byte[] j = new byte[1441];

            for (int j2 = 0; j2 < 1441; j2++) {
                c[j2] = 0;
                j[j2] = 0;
            }

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int ac = 0; ac < activities; ac++) {
                int activityStart = in.nextInt();
                int activityEnd = in.nextInt();
                boolean assigned = false;

                // Try to assign to C
                if (!assigned) {
                    boolean canAssignC = true;
                    for (int x = activityStart; x < activityEnd; x++) {
                        if (c[x] == 1) {
                            canAssignC = false;
                            break;
                        }
                    }
                    if (canAssignC) {
                        for (int x = activityStart; x < activityEnd; x++) {
                            c[x] = 1;
                        }
                        result.append("C");
                        assigned = true;
                    }
                }

                // Try to assign to J
                if (!assigned) {
                    boolean canAssignJ = true;
                    for (int x = activityStart; x < activityEnd; x++) {
                        if (j[x] == 1) {
                            canAssignJ = false;
                            break;
                        }
                    }
                    if (canAssignJ) {
                        for (int x = activityStart; x < activityEnd; x++) {
                            j[x] = 1;
                        }
                        result.append("J");
                        assigned = true;
                    }
                }

                // If neither C nor J can take the activity
                if (!assigned) {
                    result.append("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}