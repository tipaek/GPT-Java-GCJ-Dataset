import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String getSolution(final Scanner scanner) {
        final int rowCount = scanner.nextInt();
        final int colCount = scanner.nextInt();

        List<List<Competitor>> rows = new ArrayList<>();
        List<List<Competitor>> cols = new ArrayList<>();

        long interest = 0;
        boolean first = true;
        for (int row = 0; row < rowCount; row++) {
            rows.add(new ArrayList<>());
            for (int col = 0; col < colCount; col++) {
                if (first) {
                    cols.add(new ArrayList<>());
                }
                final long value = scanner.nextLong();
                interest += value;
                final Competitor competitor = new Competitor(value, row, col);
                rows.get(row).add(competitor);
                cols.get(col).add(competitor);

                if (col > 0) {
                    final Competitor left = rows.get(row).get(col - 1);
                    competitor.left = left;
                    left.right = competitor;
                }

                if (row > 0) {
                    final Competitor up = cols.get(col).get(row - 1);
                    competitor.up = up;
                    up.down = competitor;
                }
            }
            first = false;
        }

        long totalInterest = interest;
        boolean change;
        do {
            change = false;
            List<Competitor> toEliminate = new ArrayList<>();
            for (final List<Competitor> row : rows) {
                for (final Competitor competitor : row) {
                    if (shouldEliminate(competitor)) {
                        toEliminate.add(competitor);
                        competitor.toBeEliminated = true;
                        change = true;
                    }
                }
            }
            for (final Competitor competitor : toEliminate) {
                interest -= competitor.value;
                eliminateCompetitor(rows, cols, competitor);
            }
            if (change) {
                totalInterest += interest;
            }
        } while (change);
        return String.valueOf(totalInterest);
    }

    private static boolean shouldEliminate(final Competitor competitor) {
        if (!competitor.present) {
            return false;
        }
        long sum = 0;
        long count = 0;
        if (competitor.left != null) {
            count++;
            sum += competitor.left.value;
        }
        if (competitor.right != null) {
            count++;
            sum += competitor.right.value;
        }
        if (competitor.up != null) {
            count++;
            sum += competitor.up.value;
        }
        if (competitor.down != null) {
            count++;
            sum += competitor.down.value;
        }
        return ((double) competitor.value) < ((double) sum / count);
    }

    private static void eliminateCompetitor(List<List<Competitor>> rows, List<List<Competitor>> cols, final Competitor competitor) {
        competitor.present = false;

        updateNeighbor(rows, cols, competitor.left);
        updateNeighbor(rows, cols, competitor.right);
        updateNeighbor(rows, cols, competitor.up);
        updateNeighbor(rows, cols, competitor.down);
    }

    private static void updateNeighbor(List<List<Competitor>> rows, List<List<Competitor>> cols, final Competitor neighbor) {
        if (neighbor == null || !neighbor.toBeEliminated) {
            return;
        }
        neighbor.toBeEliminated = false;
        findNewNeighbors(rows, cols, neighbor);
    }

    private static void findNewNeighbors(List<List<Competitor>> rows, List<List<Competitor>> cols, final Competitor competitor) {
        final List<Competitor> compRow = rows.get(competitor.row);
        final List<Competitor> compCol = cols.get(competitor.col);

        competitor.left = findNeighbor(compRow, competitor.col, -1);
        competitor.right = findNeighbor(compRow, competitor.col, 1);
        competitor.up = findNeighbor(compCol, competitor.row, -1);
        competitor.down = findNeighbor(compCol, competitor.row, 1);
    }

    private static Competitor findNeighbor(List<Competitor> competitors, int start, int direction) {
        for (int i = start + direction; i >= 0 && i < competitors.size(); i += direction) {
            Competitor other = competitors.get(i);
            if (other.present && !other.toBeEliminated) {
                return other;
            }
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
        final int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }

    public static class Competitor {
        long value;
        Competitor left, right, up, down;
        boolean present;
        boolean toBeEliminated;
        int row;
        int col;

        public Competitor(long value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
            this.present = true;
            this.toBeEliminated = false;
        }
    }
}