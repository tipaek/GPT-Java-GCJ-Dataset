import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
    private StringBuilder buffer = new StringBuilder(16384);

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; ++t) {
            buffer.append("Case #").append(t + 1).append(": ");
            int rows = reader.nextInt();
            int cols = reader.nextInt();

            List<Dancer> aliveDancers = new ArrayList<>();
            Dancer[][] floor = new Dancer[rows][cols];
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c) {
                    floor[r][c] = new Dancer(reader.nextLong());
                    aliveDancers.add(floor[r][c]);
                }
            }

            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c) {
                    Dancer current = floor[r][c];
                    current.above = getNeighbor(r - 1, c, floor);
                    current.right = getNeighbor(r, c + 1, floor);
                    current.below = getNeighbor(r + 1, c, floor);
                    current.left = getNeighbor(r, c - 1, floor);
                }
            }

            performDance(aliveDancers);
        }

        System.out.print(buffer);
    }

    private void performDance(List<Dancer> aliveDancers) {
        boolean hasChanges = true;
        long totalSkill = 0;

        while (hasChanges) {
            hasChanges = false;
            totalSkill += aliveDancers.stream().mapToLong(d -> d.skill).sum();

            for (Dancer dancer : aliveDancers) {
                dancer.checkElimination();
            }

            updateNeighbors(aliveDancers);
            List<Dancer> remainingDancers = aliveDancers.stream()
                    .filter(d -> !d.eliminated)
                    .collect(Collectors.toList());
            hasChanges = aliveDancers.size() != remainingDancers.size();
            aliveDancers = remainingDancers;
        }

        buffer.append(totalSkill).append('\n');
    }

    private void updateNeighbors(List<Dancer> remainingDancers) {
        for (Dancer dancer : remainingDancers) {
            while (dancer.above != null && dancer.above.eliminated) {
                dancer.above = dancer.above.above;
            }
            while (dancer.right != null && dancer.right.eliminated) {
                dancer.right = dancer.right.right;
            }
            while (dancer.below != null && dancer.below.eliminated) {
                dancer.below = dancer.below.below;
            }
            while (dancer.left != null && dancer.left.eliminated) {
                dancer.left = dancer.left.left;
            }
        }
    }

    private Dancer getNeighbor(int r, int c, Dancer[][] floor) {
        if (r >= 0 && r < floor.length && c >= 0 && c < floor[0].length) {
            return floor[r][c];
        }
        return null;
    }

    private static class Dancer {
        private long skill;
        private boolean eliminated;
        private Dancer above;
        private Dancer right;
        private Dancer below;
        private Dancer left;

        public Dancer(long skill) {
            this.skill = skill;
        }

        public void checkElimination() {
            long neighborCount = 0;
            long totalSkill = 0;

            if (above != null) {
                totalSkill += above.skill;
                neighborCount++;
            }
            if (right != null) {
                totalSkill += right.skill;
                neighborCount++;
            }
            if (below != null) {
                totalSkill += below.skill;
                neighborCount++;
            }
            if (left != null) {
                totalSkill += left.skill;
                neighborCount++;
            }

            eliminated = neighborCount * skill < totalSkill;
        }
    }

    class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}