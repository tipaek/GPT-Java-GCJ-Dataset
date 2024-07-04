import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = input.nextInt();
            int trace = input.nextInt();
            int assigned = size;
            boolean impossible = false;
            int averageTrace = trace / size;
            int[][] square = new int[size][size];
            List<List<Set<Integer>>> candidates = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                candidates.add(new ArrayList<>(Collections.nCopies(size, new HashSet<>())));
                square[i][i] = averageTrace;
            }

            int remainder = trace % size;
            if (remainder != 0) {
                if (remainder == 1 && averageTrace == 1) {
                    impossible = true;
                } else if (remainder == 1) {
                    square[0][0] += 2;
                    square[1][1]--;
                } else {
                    square[0][0] += remainder - 1;
                    square[1][1]++;
                }
            }

            generateCandidates(size, square, candidates);

            while (!impossible && assigned != size * size) {
                int[] minCell = findMinCell(size, square, candidates);
                int mr = minCell[0], mc = minCell[1];
                boolean done = true;

                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        if (updateSquare(size, square, candidates, r, c)) {
                            done = false;
                            assigned++;
                        }
                    }
                }

                if (done) {
                    assignValue(size, square, candidates, mr, mc);
                    assigned++;
                }
            }

            System.out.printf("Case #%d: ", t);
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println("POSSIBLE");
                printSquare(square);
            }
        }
    }

    private static void generateCandidates(int size, int[][] square, List<List<Set<Integer>>> candidates) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (r != c) {
                    Set<Integer> possible = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toSet());
                    Arrays.stream(square[r]).forEach(possible::remove);
                    int col = c;
                    IntStream.range(0, size).map(row -> square[row][col]).forEach(possible::remove);
                    candidates.get(r).set(c, possible);
                }
            }
        }
    }

    private static int[] findMinCell(int size, int[][] square, List<List<Set<Integer>>> candidates) {
        int mr = -1, mc = -1;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (square[r][c] == 0 && !candidates.get(r).get(c).isEmpty()) {
                    if (mr == -1 || candidates.get(r).get(c).size() < candidates.get(mr).get(mc).size()) {
                        mr = r;
                        mc = c;
                    }
                }
            }
        }
        return new int[]{mr, mc};
    }

    private static boolean updateSquare(int size, int[][] square, List<List<Set<Integer>>> candidates, int r, int c) {
        Set<Integer> possible = candidates.get(r).get(c);
        if (possible.isEmpty() && square[r][c] == 0) {
            return false;
        } else if (possible.size() == 1) {
            square[r][c] = possible.iterator().next();
            updateCandidates(size, square, candidates, r, c);
            return true;
        }

        Set<Integer> rowCopy = new HashSet<>(possible);
        IntStream.range(0, size).filter(i -> i != c).forEach(i -> rowCopy.removeAll(candidates.get(r).get(i)));
        if (rowCopy.size() == 1) {
            square[r][c] = rowCopy.iterator().next();
            updateCandidates(size, square, candidates, r, c);
            return true;
        }

        Set<Integer> colCopy = new HashSet<>(possible);
        IntStream.range(0, size).filter(i -> i != r).forEach(i -> colCopy.removeAll(candidates.get(i).get(c)));
        if (colCopy.size() == 1) {
            square[r][c] = colCopy.iterator().next();
            updateCandidates(size, square, candidates, r, c);
            return true;
        }

        return false;
    }

    private static void assignValue(int size, int[][] square, List<List<Set<Integer>>> candidates, int r, int c) {
        square[r][c] = candidates.get(r).get(c).iterator().next();
        updateCandidates(size, square, candidates, r, c);
    }

    private static void updateCandidates(int size, int[][] square, List<List<Set<Integer>>> candidates, int r, int c) {
        candidates.get(r).set(c, Collections.emptySet());
        IntStream.range(0, size).forEach(i -> {
            candidates.get(r).get(i).remove(square[r][c]);
            candidates.get(i).get(c).remove(square[r][c]);
        });
    }

    private static void printSquare(int[][] square) {
        Arrays.stream(square).map(
                r -> Arrays.stream(r).mapToObj(Integer::toString).collect(Collectors.joining(" "))
        ).forEach(System.out::println);
    }
}