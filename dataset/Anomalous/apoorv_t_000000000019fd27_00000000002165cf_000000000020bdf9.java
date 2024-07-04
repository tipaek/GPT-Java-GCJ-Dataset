import java.util.*;

class Solution {

    static class Pair implements Comparable<Pair> {
        public final int index;
        public final int value;
        public char c;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int testCase = 0;

        while (t-- > 0) {
            int n = in.nextInt();
            int[][] activities = new int[n][2];
            Pair[] pairs = new Pair[n];

            for (int i = 0; i < n; i++) {
                activities[i][0] = in.nextInt();
                activities[i][1] = in.nextInt();
                pairs[i] = new Pair(i, activities[i][0]);
            }

            Arrays.sort(pairs);
            int endC = 0, endJ = 0;
            boolean possible = true;

            for (Pair pair : pairs) {
                if (endC <= pair.value) {
                    endC = activities[pair.index][1];
                    pair.c = 'C';
                } else if (endJ <= pair.value) {
                    endJ = activities[pair.index][1];
                    pair.c = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (possible) {
                Arrays.sort(pairs, Comparator.comparingInt(p -> p.index));
                for (Pair pair : pairs) {
                    result.append(pair.c);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (++testCase) + ": " + result.toString());
        }

        in.close();
    }
}