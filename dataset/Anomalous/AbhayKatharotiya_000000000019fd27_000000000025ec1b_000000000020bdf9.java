import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> results = new ArrayList<>();
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            int n = sc.nextInt();
            sc.nextLine();
            List<List<Integer>> intervals = new ArrayList<>();
            List<List<Integer>> originalIntervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String[] parts = sc.nextLine().split(" ");
                List<Integer> interval = new ArrayList<>();
                for (String part : parts) {
                    interval.add(Integer.parseInt(part));
                }
                intervals.add(interval);
                originalIntervals.add(new ArrayList<>(interval));
            }

            intervals.sort(Comparator.comparingInt(a -> a.get(0)));
            List<String> assigned = new ArrayList<>();
            boolean cAvailable = true, jAvailable = true, isImpossible = false;

            for (int k = 0; k < intervals.size(); k++) {
                cAvailable = true;
                jAvailable = true;

                for (int a = k - 1; a >= 0; a--) {
                    if (assigned.get(a).equals("C") && cAvailable) {
                        if (intervals.get(k).get(0) < intervals.get(a).get(1)) {
                            cAvailable = false;
                        }
                    } else if (assigned.get(a).equals("J") && jAvailable) {
                        if (intervals.get(k).get(0) < intervals.get(a).get(1)) {
                            jAvailable = false;
                        }
                    }
                    if (!cAvailable && !jAvailable) {
                        break;
                    }
                }

                if (cAvailable) {
                    assigned.add("C");
                } else if (jAvailable) {
                    assigned.add("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                results.add("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder finalAssignment = new StringBuilder();
                for (List<Integer> original : originalIntervals) {
                    for (int a = 0; a < intervals.size(); a++) {
                        if (original.equals(intervals.get(a))) {
                            finalAssignment.append(assigned.get(a));
                            break;
                        }
                    }
                }
                results.add("Case #" + i + ": " + finalAssignment.toString());
            }
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static List<List<Integer>> getSortedList(List<List<Integer>> inputs) {
        inputs.sort(Comparator.comparingInt(a -> a.get(0)));
        return inputs;
    }
}