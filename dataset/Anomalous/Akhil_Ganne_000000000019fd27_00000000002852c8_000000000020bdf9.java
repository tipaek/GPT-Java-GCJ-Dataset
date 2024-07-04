import java.io.*;
import java.util.*;

class Pair {
    int start, end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            System.out.print("Case #" + caseNumber + ": ");
            int n = sc.nextInt();
            boolean isPossible = true;
            List<Pair> originalPairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                originalPairs.add(new Pair(start, end));
            }

            List<Pair> sortedPairs = new ArrayList<>(originalPairs);
            sortedPairs.sort(Comparator.comparingInt(p -> p.start));

            int cEnd = 0, jEnd = 0;
            String[] assignments = new String[n];
            for (int i = 0; i < n; i++) {
                Pair currentPair = sortedPairs.get(i);
                if (currentPair.start >= cEnd) {
                    assignments[i] = "C";
                    cEnd = currentPair.end;
                } else if (currentPair.start >= jEnd) {
                    assignments[i] = "J";
                    jEnd = currentPair.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Pair originalPair : originalPairs) {
                    for (int j = 0; j < n; j++) {
                        Pair sortedPair = sortedPairs.get(j);
                        if (sortedPair.start == originalPair.start && sortedPair.end == originalPair.end && !"A".equals(assignments[j])) {
                            result.append(assignments[j]);
                            assignments[j] = "A";
                            break;
                        }
                    }
                }
                System.out.println(result.toString());
            }
            caseNumber++;
        }
        sc.close();
    }
}