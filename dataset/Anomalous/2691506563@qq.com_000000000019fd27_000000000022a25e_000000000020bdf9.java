import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            ArrayList<Integer> cList = new ArrayList<>();
            ArrayList<Integer> jList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (!jList.contains(i)) {
                    cList.add(i);
                    for (int k = i + 1; k < n; k++) {
                        if (!jList.contains(k)) {
                            if (!(intervals[i][0] >= intervals[k][1] || intervals[i][1] <= intervals[k][0])) {
                                jList.add(k);
                            }
                        }
                    }
                }
            }

            boolean isImpossible = false;
            for (int i = 0; i < jList.size() - 1 && !isImpossible; i++) {
                for (int k = i + 1; k < jList.size(); k++) {
                    if (!(intervals[jList.get(i)][0] >= intervals[jList.get(k)][1] || intervals[jList.get(i)][1] <= intervals[jList.get(k)][0])) {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int i = 0; i < n; i++) {
                    if (cList.contains(i)) {
                        System.out.print("C");
                    } else {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
        }
    }
}