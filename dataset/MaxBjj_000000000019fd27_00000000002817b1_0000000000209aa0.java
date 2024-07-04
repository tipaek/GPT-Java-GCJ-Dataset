import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int tests = Integer.parseInt(s.nextLine());
        //int tests = 1;

        for (int test = 1; test <= tests; test++) {
            String[] parts = s.nextLine().split(" ");
            //String[] parts = new String[]{"2", "3"};
            int n = Integer.parseInt(parts[0]);
            int desiredIndicium = Integer.parseInt(parts[1]);

            List<Integer> combinationToGetIndicium = findIndicium(n, desiredIndicium);
            if (combinationToGetIndicium.isEmpty()) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }

            int[][] m = new int[n][n];

            putIndicium(combinationToGetIndicium, m);

            if (!solveRest(m)) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }

            System.out.println("Case #" + test + ": POSSIBLE");
            printMatrix(m);
        }
    }

    private static void printMatrix(int[][] m) {
        for (int[] row : m) {
            StringJoiner sj = new StringJoiner(" ");
            for (int e : row) {
                sj.add(String.valueOf(e));
            }
            System.out.println(sj.toString());
        }
    }

    private static boolean solveRest(int[][] m) {
        HashSet<Integer>[] rows = new HashSet[m.length];

        for(int i = 0, j = 0; i < m.length; i++, j++) {
            rows[i] = new HashSet<>();
            rows[i].add(m[i][j]);
        }

        return backtrackFill(m, rows, 1, 0);
    }

    private static boolean backtrackFill(int[][] m, HashSet<Integer>[] rows, int d, int colIndex) {
        while (colIndex < m.length && m[colIndex][colIndex] == d) {
            // skip filled indicium's value
            colIndex++;
        }

        if (colIndex == m.length) {
            if (d == m.length) {
                return true;
            }
            return backtrackFill(m, rows, d + 1, 0);
        }

        for(int i = m.length - 1; i >= 0; i--) {
            if (!rows[i].contains(d) && m[i][colIndex] == 0) {
                rows[i].add(d);
                m[i][colIndex] = d;
                if (backtrackFill(m, rows, d, colIndex + 1)) {
                    return true;
                }
                rows[i].remove(d);
                m[i][colIndex] = 0;
            }
        }

        return false;
    }

    private static void putIndicium(List<Integer> combinationToGetIndicium, int[][] m) {
        int i = 0;
        int j = 0;

        for (Integer e : combinationToGetIndicium) {
            m[i][j] = e;
            i++;
            j++;
        }
    }

    private static List<Integer> findIndicium(int n, int desiredIndicium) {
        int[] numbers = new int[n];
        Arrays.fill(numbers, n);

        List<Integer> combination = findCombination(desiredIndicium, numbers, 0, new ArrayList<>());
        return combination;
    }

    private static List<Integer> findCombination(int remaining, int[] numbers, int index, ArrayList<Integer> current) {
        if (remaining < 0 || current.size() > numbers.length) {
            return Collections.emptyList();
        }

        if (remaining == 0) {
            if (current.size() == numbers.length) {
                Set<Integer> unique = new HashSet<>(current);
                if (unique.size() == 2 && current.size() > 2) {
                    int first = current.get(0);
                    int count = 0;
                    for (Integer e: current) {
                        if (e == first) {
                            count++;
                        }
                    }

                    if (count == current.size() - 1 || count == 1) {
                        return Collections.emptyList();
                    }
                }
                return current;
            }
            return Collections.emptyList();
        }

        for(int i = index; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                continue;
            }

            if (i + 1 > remaining) {
                break;
            }

            current.add(i + 1);
            numbers[i]--;

            List<Integer> result = findCombination(remaining - (i + 1), numbers, i, current);
            if (!result.isEmpty()) {
                return result;
            }

            numbers[i]++;
            current.remove(current.size() - 1);
        }

        return Collections.emptyList();
    }

    private static boolean isLatin(int[][] m) {
        HashSet<Integer>[] rows = new HashSet[m.length];
        HashSet<Integer>[] cols = new HashSet[m.length];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                int e = m[i][j];
                if (!rows[i].add(e) || !cols[j].add(e)) {
                    return false;
                }
            }
        }

        return true;
    }
}
