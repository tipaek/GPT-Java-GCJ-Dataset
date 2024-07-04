import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] order = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = sc.nextInt();
                endTimes[j] = sc.nextInt();
                order[j] = j;
            }

            // Sort activities by end times
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n - 1; b++) {
                    if (endTimes[b] > endTimes[b + 1]) {
                        swap(endTimes, b, b + 1);
                        swap(startTimes, b, b + 1);
                        swap(order, b, b + 1);
                    }
                }
            }

            boolean impossible = false;
            ArrayList<Integer> bufferStart = new ArrayList<>();
            ArrayList<Integer> bufferEnd = new ArrayList<>();
            StringBuilder assignments = new StringBuilder();

            for (int k = 0; k < n; k++) {
                if (bufferStart.isEmpty()) {
                    bufferStart.add(startTimes[k]);
                    bufferEnd.add(endTimes[k]);
                    assignments.append("J");
                } else {
                    if (bufferEnd.size() == 2) {
                        if (bufferEnd.get(0) > startTimes[k] && bufferEnd.get(1) > startTimes[k]) {
                            impossible = true;
                            break;
                        }
                        if (bufferEnd.get(0) > startTimes[k]) {
                            bufferEnd.set(1, endTimes[k]);
                            bufferStart.set(1, startTimes[k]);
                            assignments.append("C");
                        } else {
                            bufferEnd.set(0, endTimes[k]);
                            bufferStart.set(0, startTimes[k]);
                            assignments.append("J");
                        }
                    } else {
                        if (bufferEnd.get(0) > startTimes[k]) {
                            bufferEnd.add(endTimes[k]);
                            bufferStart.add(startTimes[k]);
                            assignments.append("C");
                        } else {
                            bufferEnd.clear();
                            bufferStart.clear();
                            bufferEnd.add(endTimes[k]);
                            bufferStart.add(startTimes[k]);
                            assignments.append("J");
                        }
                    }
                }
            }

            char[] finalAssignments = new char[n];
            if (!impossible) {
                for (int l = 0; l < n; l++) {
                    finalAssignments[order[l]] = assignments.charAt(l);
                }
            }

            String result = impossible ? "IMPOSSIBLE" : new String(finalAssignments);
            System.out.println("Case " + (i + 1) + ": " + result);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}