import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    
    public static class ListComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
            for (int i = 0; i < l1.size(); ++i) {
                int comparison = l1.get(i).compareTo(l2.get(i));
                if (comparison != 0) {
                    return comparison;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            List<List<Integer>> intervals = new ArrayList<>(N);

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                List<Integer> interval = new ArrayList<>();
                interval.add(Integer.parseInt(tokenizer.nextToken()));
                interval.add(Integer.parseInt(tokenizer.nextToken()));
                intervals.add(interval);
            }

            List<List<Integer>> sortedIntervals = new ArrayList<>(intervals);
            sortedIntervals.sort(new ListComparator());

            int C = 0, J = 0;
            boolean isPossible = true;
            List<String> assignments = new ArrayList<>(N);

            for (List<Integer> interval : sortedIntervals) {
                int start = interval.get(0);
                int end = interval.get(1);

                if (C <= start) {
                    C = end;
                    assignments.add("C");
                } else if (J <= start) {
                    J = end;
                    assignments.add("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                writer.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                String[] schedule = new String[N];
                for (int i = 0; i < N; i++) {
                    List<Integer> originalInterval = intervals.get(i);
                    for (int j = 0; j < N; j++) {
                        if (sortedIntervals.get(j).equals(originalInterval) && schedule[i] == null) {
                            schedule[i] = assignments.get(j);
                            sortedIntervals.get(j).set(0, -1);
                            sortedIntervals.get(j).set(1, -1);
                            break;
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                for (String s : schedule) {
                    result.append(s);
                }
                writer.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
        writer.close();
    }
}