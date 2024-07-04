import java.util.*;

public class Solution {
    static class Pair {
        final int start;
        final int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return start == pair.start &&
                    end == pair.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
    private final int T ;
    private final ArrayList<Pair> activities;

    public Solution(int T, ArrayList<Pair> activities) {
        this.T = T;
        this.activities = activities;
    }

    public void solve() {
        System.out.printf("Case #%s: ", T);

        final ArrayList<Pair> originalOrder = (ArrayList<Pair>) activities.clone();

        activities.sort(Comparator.comparingInt(a -> a.getStart()));

        Map<Pair, LinkedList<String>> solution = new HashMap<>();

        int J = -1;
        int C = -1;

        boolean failed = false;

        for (int i = 0; i < activities.size(); i++) {
            final Pair time = activities.get(i);

            final LinkedList<String> parents = solution.getOrDefault(time, new LinkedList<>());

            if(time.start >= J) {
                parents.add("J");
                J = time.end;
            } else if(time.start >= C) {
                parents.add("C");
                C = time.end;
            } else {
                failed = true;
                break;
            }

            solution.put(time, parents);
        }

        StringBuilder sb = new StringBuilder();

        if(failed)
            sb = new StringBuilder("IMPOSSIBLE");
        else {
            for (Pair pair : originalOrder) {
                final LinkedList<String> parents = solution.get(pair);

                sb.append(parents.pollFirst());
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            ArrayList<Pair> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                final int S = in.nextInt();
                final int E = in.nextInt();

                activities.add(new Pair(S,E));
            }

            final Solution solution = new Solution(t + 1, activities);

            solution.solve();
        }
    }
}
