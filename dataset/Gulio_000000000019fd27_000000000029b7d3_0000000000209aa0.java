import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int K = in.nextInt();
            if (N > 3) {
                if (K == N + 1 || K == N * N - 1) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    continue;
                }
                int[] arr = createDiagonal(N, K);
                generate(arr, N, t);
            } else {
                if (N == 2) {
                    if (K == 2) {
                        System.out.println("Case #" + t + ": POSSIBLE");
                        System.out.println("1 2 ");
                        System.out.println("2 1 ");
                    } else if (K == 4) {
                        System.out.println("Case #" + t + ": POSSIBLE");
                        System.out.println("2 1 ");
                        System.out.println("1 2 ");
                    } else {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                    }
                } else if (N == 3) {
                    if (K == 3) {
                        System.out.println("Case #" + t + ": POSSIBLE");
                        System.out.println("1 2 3 ");
                        System.out.println("3 1 2 ");
                        System.out.println("2 3 1 ");
                    } else if (K == 6) {
                        System.out.println("Case #" + t + ": POSSIBLE");
                        System.out.println("1 2 3 ");
                        System.out.println("2 3 1 ");
                        System.out.println("3 1 2 ");
                    } else if (K == 9) {
                        System.out.println("Case #" + t + ": POSSIBLE");
                        System.out.println("3 1 2 ");
                        System.out.println("2 3 1 ");
                        System.out.println("1 2 3 ");
                    } else {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    private static int[] createDiagonal(int N, int K) {
        K -= N;
        int[] arr = new int[N];
        Arrays.fill(arr, 1);

        int currentUp = 1;
        while (K > 0) {
            if (currentUp == 1) {
                if (arr[0] == arr[1]) {
                    ++arr[0];
                    --K;
                } else {
                    ++arr[1];
                    --K;
                    if (arr[1] == N) {
                        ++currentUp;
                    }
                }
            } else if (currentUp == N - 2) {
                if (arr[N - 2] == arr[N - 1]) {
                    ++arr[N - 2];
                    --K;
                } else {
                    ++arr[N - 1];
                    --K;
                }
            } else {
                if (K >= N - 1) {
                    arr[currentUp] += N - 1;
                    K -= N - 1;
                } else {
                    arr[currentUp] += K;
                    K = 0;
                }
                ++currentUp;
            }
        }
        return arr;
    }

    private static void generate(int[] sumParts, int n, int t) {

        ArrayList<ArrayList<Set<Integer>>> latinSquare = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            latinSquare.add(new ArrayList<>(n));
            for (int j = 0; j < n; ++j) {
                latinSquare.get(i).add(new HashSet<>());
                for (int k = 1; k <= n; ++k) {
                    latinSquare.get(i).get(j).add(k);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            latinSquare.get(i).get(i).clear();
            latinSquare.get(i).get(i).add(sumParts[i]);
            for (int j = 0; j < n; ++j) {
                if (j != i) {
                    latinSquare.get(i).get(j).remove(sumParts[i]);
                    latinSquare.get(j).get(i).remove(sumParts[i]);
                }
            }
        }

        fill(latinSquare, n, 0, 0);

        System.out.println("Case #" + t + ": POSSIBLE");
        printLatinSquare(latinSquare);
    }

    private static void printLatinSquare(ArrayList<ArrayList<Set<Integer>>> latinSquare) {
        for (ArrayList<Set<Integer>> row : latinSquare) {
            for (Set<Integer> value : row) {
                System.out.print(value.iterator().next() + " ");
            }
            System.out.println();
        }
    }

    private static boolean fill(ArrayList<ArrayList<Set<Integer>>> latinSquare, int n, int row, int column) {
        //System.out.println(row + " " + column);
        Set<Integer> set = new HashSet<>(latinSquare.get(row).get(column));
        //ArrayList<Integer> arrayList = new ArrayList<>(set);
        //Collections.shuffle(arrayList);
        int nextRow = row;
        int nextColumn = column;
        ++nextColumn;
        if (nextColumn == n) {
            nextColumn = 0;
            ++nextRow;
        }
        for (Integer i : set) {
            latinSquare.get(row).get(column).clear();
            latinSquare.get(row).get(column).add(i);

            if (nextRow == n) {
                return true;
            }

            ArrayList<Integer> removedFromRow = new ArrayList<>();
            ArrayList<Integer> removedFromColumn = new ArrayList<>();

            boolean timeToBackEarly = false;

            for (int j = 0; j < n; ++j) {
                if (j != column) {
                    boolean removeFromRow = latinSquare.get(row).get(j).remove(i);
                    if (removeFromRow) {
                        removedFromRow.add(j);
                    }
                    if (latinSquare.get(row).get(j).isEmpty()) {
                        timeToBackEarly = true;
                        break;
                    }
                }
                if (j != row) {
                    boolean removeFromColumn = latinSquare.get(j).get(column).remove(i);
                    if (removeFromColumn) {
                        removedFromColumn.add(j);
                    }
                    if (latinSquare.get(j).get(column).isEmpty()) {
                        timeToBackEarly = true;
                        break;
                    }
                }
            }

            if (!timeToBackEarly) {
                boolean success = fill(latinSquare, n, nextRow, nextColumn);
                if (success) {
                    return success;
                }
            }

            for (Integer j : removedFromRow) {
                latinSquare.get(row).get(j).add(i);
            }
            for (Integer j : removedFromColumn) {
                latinSquare.get(j).get(column).add(i);
            }
        }
        latinSquare.get(row).get(column).clear();
        latinSquare.get(row).get(column).addAll(set);
        return false;
    }
}
