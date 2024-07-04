import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {
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
            List<List<Set<Integer>>> candidates = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                candidates.add(new ArrayList<>(size));
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

            // Generate the candidates
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (r == c) {
                        candidates.get(r).add(new HashSet<>());
                        continue;
                    }

                    Set<Integer> possible = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toSet());

                    Arrays.stream(square[r]).forEach(possible::remove);
                    int col = c;
                    IntStream.range(0, size).map(row -> square[row][col]).forEach(possible::remove);

                    candidates.get(r).add(possible);
                }
            }

            while (!impossible && assigned != size * size) {
                int mr = -1;
                int mc = -1;
                boolean done = true;
                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        Set<Integer> possible = candidates.get(r).get(c);

                        if (possible.isEmpty() && square[r][c] == 0) {
                            impossible = true;
                            break;
                        } else if (possible.isEmpty()) {
                            continue;
                        } else if (possible.size() == 1) {
                            int value = possible.iterator().next();
                            square[r][c] = value;
                            updateCandidates(candidates, square, r, c, value);
                            done = false;
                            assigned++;
                            continue;
                        }

                        Set<Integer> rowCopy = new HashSet<>(possible);
                        IntStream.range(0, size).filter(i -> i != c).forEach(i -> rowCopy.removeAll(candidates.get(r).get(i)));

                        if (rowCopy.size() == 1) {
                            int value = rowCopy.iterator().next();
                            square[r][c] = value;
                            updateCandidates(candidates, square, r, c, value);
                            done = false;
                            assigned++;
                            continue;
                        }

                        Set<Integer> colCopy = new HashSet<>(possible);
                        IntStream.range(0, size).filter(i -> i != r).forEach(i -> colCopy.removeAll(candidates.get(i).get(c)));

                        if (colCopy.size() == 1) {
                            int value = colCopy.iterator().next();
                            square[r][c] = value;
                            updateCandidates(candidates, square, r, c, value);
                            done = false;
                            assigned++;
                            continue;
                        }

                        if (mr == -1 || possible.size() < candidates.get(mr).get(mc).size()) {
                            mr = r;
                            mc = c;
                        }
                    }
                }

                if (done) {
                    int value = candidates.get(mr).get(mc).iterator().next();
                    square[mr][mc] = value;
                    updateCandidates(candidates, square, mr, mc, value);
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

    private static void updateCandidates(List<List<Set<Integer>>> candidates, int[][] square, int row, int col, int value) {
        candidates.get(row).get(col).clear();
        IntStream.range(0, square.length).forEach(i -> {
            candidates.get(row).get(i).remove(value);
            candidates.get(i).get(col).remove(value);
        });
    }

    private static void printSquare(int[][] square) {
        Arrays.stream(square)
              .map(row -> Arrays.stream(row).mapToObj(Integer::toString).collect(Collectors.joining(" ")))
              .forEach(System.out::println);
    }
}