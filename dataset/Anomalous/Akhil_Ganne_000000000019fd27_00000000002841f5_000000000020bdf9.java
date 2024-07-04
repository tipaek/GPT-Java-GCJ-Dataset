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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            System.out.print("Case #" + caseNumber + ": ");
            int n = sc.nextInt();
            boolean isPossible = true;

            ArrayList<Pair> originalPairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                originalPairs.add(new Pair(start, end));
            }

            ArrayList<Pair> sortedPairs = new ArrayList<>(originalPairs);
            sortedPairs.sort(Comparator.comparingInt(p -> p.start));

            int endC = 0, endJ = 0;
            String[] assignments = new String[n];

            for (int i = 0; i < n; i++) {
                Pair currentPair = sortedPairs.get(i);
                if (currentPair.start >= endC) {
                    assignments[i] = "C";
                    endC = currentPair.end;
                } else if (currentPair.start >= endJ) {
                    assignments[i] = "J";
                    endJ = currentPair.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    Pair originalPair = originalPairs.get(i);
                    for (int j = 0; j < n; j++) {
                        Pair sortedPair = sortedPairs.get(j);
                        if (originalPair.start == sortedPair.start && originalPair.end == sortedPair.end && !assignments[j].equals("A")) {
                            System.out.print(assignments[j]);
                            assignments[j] = "A";
                            break;
                        }
                    }
                }
                System.out.println();
            }

            caseNumber++;
        }
    }
}