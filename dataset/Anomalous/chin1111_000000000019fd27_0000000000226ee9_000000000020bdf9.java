import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= numberOfTestCases; i++) {
            int numberOfEntries = Integer.parseInt(br.readLine().trim());
            Parenting[] parents = new Parenting[numberOfEntries];
            int[][] input = new int[numberOfEntries][2];

            for (int j = 0; j < numberOfEntries; j++) {
                String[] entry = br.readLine().split(" ");
                int start = Integer.parseInt(entry[0]);
                int end = Integer.parseInt(entry[1]);

                input[j][0] = start;
                input[j][1] = end;

                parents[j] = new Parenting(start, end);
            }

            Arrays.sort(parents);

            StringBuilder output = new StringBuilder();
            int firstEnd = 0;
            int secondEnd = 0;

            for (Parenting parent : parents) {
                if (parent.start >= firstEnd) {
                    output.append("C");
                    firstEnd = parent.end;
                } else if (parent.start >= secondEnd) {
                    output.append("J");
                    secondEnd = parent.end;
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!output.toString().equals("IMPOSSIBLE")) {
                StringBuilder actualOutput = new StringBuilder();
                HashSet<Integer> coveredIndexes = new HashSet<>();
                for (int j = 0; j < numberOfEntries; j++) {
                    for (int k = 0; k < numberOfEntries; k++) {
                        if (!coveredIndexes.contains(k) && input[j][0] == parents[k].start && input[j][1] == parents[k].end) {
                            actualOutput.append(output.charAt(k));
                            coveredIndexes.add(k);
                            break;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + actualOutput);
            } else {
                System.out.println("Case #" + i + ": " + output);
            }
        }
    }

    static class Parenting implements Comparable<Parenting> {
        int start, end;

        public Parenting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Parenting other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}