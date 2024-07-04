import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int numCases = 1; numCases <= tc; numCases++) {
            int n = Integer.parseInt(br.readLine());
            int[] times = new int[1441];

            boolean valid = true;
            List<List<Integer>> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);

                for (int j = start; j < end; j++) {
                    times[j]++;
                }

                intervals.add(Arrays.asList(start, end, i));
            }

            for (int count : times) {
                if (count > 2) {
                    valid = false;
                    break;
                }
            }

            intervals.sort(Comparator.comparingInt(l -> l.get(0)));

            int[] assignments = new int[n];
            for (int i = 0; i < n; i++) {
                int person = 0;
                int start1 = intervals.get(i).get(0);
                int end1 = intervals.get(i).get(1);
                int index1 = intervals.get(i).get(2);

                for (int j = i - 1; j >= 0; j--) {
                    int start2 = intervals.get(j).get(0);
                    int end2 = intervals.get(j).get(1);
                    int index2 = intervals.get(j).get(2);

                    if (!(start1 >= end2 || start2 >= end1)) {
                        if (assignments[index2] == 0) {
                            person = 1;
                        } else {
                            person = 0;
                        }
                    }
                }
                assignments[index1] = person;
            }

            if (!valid) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", numCases);
            } else {
                StringBuilder result = new StringBuilder();
                for (int assignment : assignments) {
                    result.append(assignment == 0 ? "C" : "J");
                }
                System.out.printf("Case #%d: %s\n", numCases, result);
            }
        }

        br.close();
    }
}