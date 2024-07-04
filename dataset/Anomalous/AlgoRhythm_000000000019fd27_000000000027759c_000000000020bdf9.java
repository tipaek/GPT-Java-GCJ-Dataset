import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int[] jamie = new int[1440];
            int[] cameron = new int[1440];
            Arrays.fill(jamie, 0);
            Arrays.fill(cameron, 0);

            StringBuilder str = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();

                if (!possible) continue;

                boolean canAssignToJamie = true;
                for (int j = s; j < e; j++) {
                    if (jamie[j] == 1) {
                        canAssignToJamie = false;
                        break;
                    }
                }

                if (canAssignToJamie) {
                    Arrays.fill(jamie, s, e, 1);
                    str.append("J");
                } else {
                    boolean canAssignToCameron = true;
                    for (int j = s; j < e; j++) {
                        if (cameron[j] == 1) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        Arrays.fill(cameron, s, e, 1);
                        str.append("C");
                    } else {
                        str.setLength(0);
                        str.append("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }

            System.out.print("Case #" + (l + 1) + ": " + str);
            if (l != t - 1) {
                System.out.println();
            }
        }
    }
}