import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            StringBuilder result = new StringBuilder();
            int lastJ = 0, lastC = 0;
            boolean isImpossible = false;

            if (intervals[1][0] >= intervals[0][1]) {
                result.append("JJ");
                lastJ = 1;
                lastC = -1;
            } else {
                result.append("JC");
                lastJ = 0;
                lastC = 1;
            }

            for (int k = 2; k < n; k++) {
                if (intervals[k - 1][1] > intervals[k][0]) { // finish > start
                    if (result.charAt(result.length() - 1) == 'C') {
                        if (intervals[lastJ][1] <= intervals[k][0]) {
                            result.append("J");
                            lastJ = k;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        if (lastC != -1) {
                            if (intervals[lastC][1] <= intervals[k][0]) {
                                result.append("C");
                                lastC = k;
                            } else {
                                isImpossible = true;
                                break;
                            }
                        } else {
                            result.append("C");
                            lastC = k;
                        }
                    }
                } else { // finish <= start
                    if (result.charAt(result.length() - 1) == 'C') {
                        if (intervals[lastJ][1] <= intervals[k][0]) {
                            result.append("J");
                            lastJ = k;
                        } else {
                            result.append("C");
                            lastC = k;
                        }
                    } else {
                        if (lastC != -1) {
                            if (intervals[lastC][1] <= intervals[k][0]) {
                                result.append("C");
                                lastC = k;
                            } else {
                                result.append("J");
                                lastJ = k;
                            }
                        } else {
                            result.append("C");
                            lastC = k;
                        }
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }
    }
}