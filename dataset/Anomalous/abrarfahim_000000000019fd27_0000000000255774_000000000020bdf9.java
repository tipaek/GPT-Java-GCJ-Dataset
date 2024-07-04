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

            // Sorting based on end times
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n - 1; b++) {
                    if (endTimes[b] > endTimes[b + 1]) {
                        // Swap end times
                        int temp = endTimes[b];
                        endTimes[b] = endTimes[b + 1];
                        endTimes[b + 1] = temp;

                        // Swap start times
                        temp = startTimes[b];
                        startTimes[b] = startTimes[b + 1];
                        startTimes[b + 1] = temp;

                        // Swap order
                        temp = order[b];
                        order[b] = order[b + 1];
                        order[b + 1] = temp;
                    }
                }
            }

            StringBuilder assignments = new StringBuilder();
            boolean impossible = false;
            ArrayList<Integer> bufferStart = new ArrayList<>();
            ArrayList<Integer> bufferEnd = new ArrayList<>();

            int k = 0;
            while (k < n) {
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
                k++;
            }

            char[] finalAssignments = new char[n];
            if (!impossible) {
                for (int l = 0; l < n; l++) {
                    finalAssignments[order[l]] = assignments.charAt(l);
                }
            }

            String output = impossible ? "IMPOSSIBLE" : new String(finalAssignments);
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}