import java.util.*;

class Pair {
    int start;
    int end;
    int index;

    Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        return Integer.compare(a.start, b.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            Pair[] pairsArray = new Pair[n];

            for (int i = 0; i < n; i++) {
                pairsArray[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(pairsArray, new PairComparator());
            String task = "J";
            String[] assignments = new String[n];
            Arrays.fill(assignments, "0");

            Pair lastJ = null;
            Pair lastC = null;
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                assignments[pairsArray[i].index] = task;

                if (i < n - 1 && pairsArray[i].end > pairsArray[i + 1].start) {
                    if (task.equals("J")) {
                        lastJ = pairsArray[i];
                        task = "C";
                        if (lastC != null && lastC.end > pairsArray[i + 1].start) {
                            impossible = true;
                            break;
                        }
                    } else {
                        lastC = pairsArray[i];
                        task = "J";
                        if (lastJ != null && lastJ.end > pairsArray[i + 1].start) {
                            impossible = true;
                            break;
                        }
                    }
                } else {
                    if (task.equals("J")) {
                        lastJ = pairsArray[i];
                    } else {
                        lastC = pairsArray[i];
                    }
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            caseNumber++;

            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
    }
}