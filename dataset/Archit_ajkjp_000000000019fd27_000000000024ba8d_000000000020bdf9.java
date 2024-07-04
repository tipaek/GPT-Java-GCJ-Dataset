package Codejam2020_AA;

import java.util.Scanner;

public class CodeJam2020_ParentingPartneringReturns {
    public static void main(String[] args) {
        int testCases;
        int activities;
        Scanner sc = new Scanner(System.in);
        testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            activities = sc.nextInt();
            int[] array = new int[2];
            boolean impossiblePrinted = false;
            boolean changed = false;
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < activities; j++) {
                // Starts S mins after midnight.
                // End E mins after midnight.
                int S, E;
                S = sc.nextInt();
                E = sc.nextInt();
                if (j == 0) {
                    result.append('C');
                    array[0] = S;
                    array[1] = E;
                } else if (S > array[0] && S < array[1] && E > array[0] && E < array[1]) {
                    impossiblePrinted = true;
                    result.append('J');
                    array[0] = S;
                    array[1] = E;
                    changed = true;
                } else {
                    if (S > array[0] && S < array[1] || E > array[0] && E < array[1]) {
                        result.append('J');
                    } else {
                        if (changed) {
                            result.append('J');
                        } else {
                            result.append('C');
                        }
                        impossiblePrinted = false;
                    }
                }
            }
            if (!impossiblePrinted) {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}
