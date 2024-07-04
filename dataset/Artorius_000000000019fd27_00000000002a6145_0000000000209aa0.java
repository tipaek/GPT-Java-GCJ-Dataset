import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            final int size = input.nextInt();
            final int trace = input.nextInt();
            int assigned = size;

            boolean impossible = false;
            int averageTrace = trace / size;
            int[][] square = new int[size][];
            List<List<Set<Integer>>> candidates = new ArrayList<>(size);

            for(int i = 0; i < size; ++i) {
                candidates.add(new ArrayList<>(size));
                square[i] = new int[size];
                square[i][i] = averageTrace;
            }

            int remainder = trace % size;
            if(remainder != 0) {
                if(remainder == 1 && averageTrace == 1) {
                    impossible = true;
                }
                else if(remainder == 1) {
                    square[0][0] += 2;
                    --square[1][1];
                }
                else {
                    square[0][0] += remainder - 1;
                    square[1][1] += 1;
                }
            }

            //Generate the candidates
            for(int r = 0; r < size; ++r) {
                for(int c = 0; c < size; ++c) {
                    if(r == c) {
                        candidates.get(r).add(new HashSet<>());
                        continue;
                    }

                    final Set<Integer> possible = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toSet());

                    Arrays.stream(square[r]).forEach(possible::remove);
                    final int col = c;
                    IntStream.range(0, size).map(row -> square[row][col]).forEach(possible::remove);

                    candidates.get(r).add(possible);
                }
            }

            while(!impossible && assigned != size * size) {
                int mr = -1;
                int mc = -1;
                boolean done = true;
                for(int r = 0; r < size; ++r) {
                    for(int c = 0; c < size; ++c) {
                        Set<Integer> possible = candidates.get(r).get(c);
                        final int row = r;
                        final int col = c;

                        if(possible.isEmpty() && square[r][c] == 0) {
                            impossible = true;
                            break;
                        }
                        else if(possible.isEmpty()) {
                            continue;
                        }
                        else if(possible.size() == 1) {
                            square[r][c] = possible.iterator().next();
                            candidates.get(r).get(c).retainAll(Collections.emptySet());
                            IntStream.range(0, size).forEach(i -> {
                                candidates.get(row).get(i).remove(square[row][col]);
                                candidates.get(i).get(col).remove(square[row][col]);
                            });
                            done = false;
                            ++assigned;
                            continue;
                        }

                        //Are we the only square that can take a value?
                        final Set<Integer> rowCopy = new HashSet<>(possible);
                        IntStream.range(0, size)
                                .filter(i -> i != col)
                                .forEach(i -> rowCopy.removeAll(candidates.get(row).get(i)));

                        if(rowCopy.size() == 1) {
                            square[r][c] = rowCopy.iterator().next();
                            candidates.get(r).get(c).retainAll(Collections.emptySet());
                            IntStream.range(0, size).forEach(i -> {
                                candidates.get(row).get(i).remove(square[row][col]);
                                candidates.get(i).get(col).remove(square[row][col]);
                            });
                            done = false;
                            ++assigned;
                            continue;
                        }

                        final Set<Integer> colCopy = new HashSet<>(possible);
                        IntStream.range(0, size)
                                .filter(i -> i != row)
                                .forEach(i -> colCopy.removeAll(candidates.get(i).get(col)));

                        if(colCopy.size() == 1) {
                            square[r][c] = colCopy.iterator().next();
                            candidates.get(r).get(c).retainAll(Collections.emptySet());
                            IntStream.range(0, size).forEach(i -> {
                                candidates.get(row).get(i).remove(square[row][col]);
                                candidates.get(i).get(col).remove(square[row][col]);
                            });
                            done = false;
                            ++assigned;
                            continue;
                        }


                        if(mr == -1 || possible.size() < candidates.get(mr).get(mc).size()) {
                            mr = r;
                            mc = c;
                        }
                    }
                }

                if(done) {
                    //Just pick one
                    square[mr][mc] = candidates.get(mr).get(mc).iterator().next();
                    candidates.get(mr).get(mc).retainAll(Collections.emptySet());
                    final int row = mr;
                    final int col = mc;
                    IntStream.range(0, size).forEach(i -> {
                        candidates.get(row).get(i).remove(square[row][col]);
                        candidates.get(i).get(col).remove(square[row][col]);
                    });
                    ++assigned;
                }
            }

            System.out.println(String.format("Case #%d: ", t));
            if(impossible)
                System.out.println("IMPOSSIBLE");
            else {
                System.out.println("POSSIBLE");
                printSquare(square);
            }
        }
    }

    private static void printSquare(final int[][] square) {
        Arrays.stream(square).map(
                r -> Arrays.stream(r).mapToObj(Integer::toString).collect(Collectors.joining(" "))
        ).forEach(System.out::println);
    }
}
