import java.util.*;

class Solution {
    static class Pair {
        int first;
        int second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numPairs = Integer.parseInt(scanner.nextLine());
            Pair[] pairs = new Pair[numPairs];

            for (int i = 0; i < numPairs; i++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                pairs[i] = new Pair();
                pairs[i].first = start;
                pairs[i].second = end;
            }

            Arrays.sort(pairs, Comparator.comparingInt(p -> p.first));

            int endC = 0, endJ = 0;
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (Pair pair : pairs) {
                if (endC <= pair.first) {
                    endC = pair.second;
                    result.append("C");
                } else if (endJ <= pair.first) {
                    endJ = pair.second;
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNum + ": " + result);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}