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
            List<Competitor> toElim = new ArrayList<>();
            for (final List<Competitor> row : rows) {
                for (final Competitor competitor : row) {
                    if (mustEliminate(competitor)) {
                        toElim.add(competitor);
                        competitor.toBeElim = true;
                        change = true;
                    }
                }
            }
            for (final Competitor competitor : toElim) {
                interest -= competitor.value;
                eliminate(rows, cols, competitor);
            }
            if(change) {
                totalInterest += interest;
            }
        } while (change);
        return String.valueOf(totalInterest);
    }

    public static boolean mustEliminate(final Competitor competitor) {
        if(!competitor.present) {
            return false;
        }
        long sum = 0;
        long count = 0;
        if(competitor.left != null) {
            count++;
            sum += competitor.left.value;
        }
        if(competitor.right != null) {
            count++;
            sum += competitor.right.value;
        }
        if(competitor.up != null) {
            count++;
            sum += competitor.up.value;
        }
        if(competitor.down != null) {
            count++;
            sum += competitor.down.value;
        }
        return ((double)competitor.value) < ((double) sum / (double)count);
    }

    public static void eliminate(List<List<Competitor>> rows, List<List<Competitor>> cols, final Competitor competitor) {
        competitor.present = false;

        Competitor left = competitor.left;
        while(left != null && left.toBeElim) {
            left = left.left;
        }
        if(left != null) {
            findNewNeighour(rows, cols, competitor.left);
        }

        Competitor right = competitor.right;
        while(right != null && right.toBeElim) {
            right = right.right;
        }
        if(right != null) {
            findNewNeighour(rows, cols, competitor.right);
        }

        Competitor up = competitor.up;
        while(up != null && up.toBeElim) {
            up = up.up;
        }
        if(up != null) {
            findNewNeighour(rows, cols, competitor.up);
        }

        Competitor down = competitor.down;
        while(down != null && down.toBeElim) {
            down = down.down;
        }
        if(down != null) {
            findNewNeighour(rows, cols, competitor.down);
        }
    }

    public static void findNewNeighour(List<List<Competitor>> rows, List<List<Competitor>> cols, final Competitor competitor) {
        final List<Competitor> compRow = rows.get(competitor.row);
        final List<Competitor> compCol = cols.get(competitor.col);

        Competitor newother = null;
        for(int i = competitor.col - 1; i >= 0; i--) {
            final Competitor other = compRow.get(i);
            if(other.present && !other.toBeElim) {
                newother = other;
                break;
            }
        }
        competitor.left = newother;

        newother = null;
        for(int i = competitor.col + 1; i < compRow.size(); i++) {
            final Competitor other = compRow.get(i);
            if(other.present && !other.toBeElim) {
                newother = other;
                break;
            }
        }
        competitor.right = newother;

        newother = null;
        for(int i = competitor.row - 1; i >= 0; i--) {
            final Competitor other = compCol.get(i);
            if(other.present && !other.toBeElim) {
                newother = other;
                break;
            }
        }
        competitor.up = newother;

        newother = null;
        for(int i = competitor.row + 1; i < compCol.size(); i++) {
            final Competitor other = compCol.get(i);
            if(other.present && !other.toBeElim) {
                newother = other;
                break;
            }
        }
        competitor.down = newother;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("C.in"));

        final int testCases = scanner.nextInt();
        for(int i = 1; i<= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }

    public static class Competitor {
        long value;
        Competitor left, right, up, down;
        boolean present;
        boolean toBeElim;
        int row;
        int col;

        public Competitor(long value, int row, int col) {
            this.value = value;
            present = true;
            this.row =row;
            this.col=col;
            toBeElim = false;
        }
    }
}
