import java.util.*;
    import java.io.*;
    public class Solution {
     public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = in.nextInt();
            for (int t = 1; t <= testCases; ++t) {
                int n = in.nextInt();
                int k = in.nextInt();

                int[][] m = new int[n][n];
                splitTrace(n, m, k);
                boolean notImpossible = true;

                int i = 0;
                while (notImpossible && i < n) {
                    List<Integer> rowValues = getRowValues(n);
                    rowValues.remove(Integer.valueOf(m[i][i]));
                    int j = 0;
                    while (notImpossible && j < n) {
                        if (i != j) {
                            Integer newValueIndex = findNotUsedValueIndex(m, i, j, rowValues);
                            if (newValueIndex == null) {
                                notImpossible = false;
                            } else {
                                m[i][j] = rowValues.get(newValueIndex);
                                rowValues.remove(newValueIndex.intValue());
                            }
                        }
                        ++j;
                    }
                    ++i;
                }


                if (notImpossible) {
                    System.out.println("Case #" + t + ": POSSIBLE");
                    for (i = 0; i < n; ++i) {
                        for (int j = 0; j < n - 1; ++j) {
                            System.out.print(m[i][j]);
                            System.out.print(" ");
                        }
                        System.out.println(m[i][n - 1]);
                    }
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static Integer findNotUsedValueIndex(int[][] m, int i, int j, List<Integer> rowValues) {
        boolean notFound = true;
        if (i < j) {
            int k = 0;
            while (notFound && k < rowValues.size()) {
                int actual = rowValues.get(k);
                boolean notAlreadyUsed = true;
                int l = i - 1;
                while (notAlreadyUsed && -1 < l) {
                    if (m[l][j] == actual) {
                        notAlreadyUsed = false;
                    }
                    --l;
                }
                if (notAlreadyUsed) {
                    notFound = false;
                } else {
                    ++k;
                }
            }
            if (notFound) {
                return null;
            }
            return k;
        } else {
            int k = rowValues.size() - 1;
            while (notFound && -1 < k) {
                int actual = rowValues.get(k);
                boolean notAlreadyUsed = true;
                int l = i - 1;
                while (notAlreadyUsed && -1 < l) {
                    if (m[l][j] == actual) {
                        notAlreadyUsed = false;
                    }
                    --l;
                }
                if (notAlreadyUsed) {
                    notFound = false;
                } else {
                    --k;
                }
            }
            if (notFound) {
                return null;
            }
            return k;
        }
    }

    private static List<Integer> getRowValues(int n) {
        List<Integer> rowValues = new ArrayList<>(n);
        for (int i = 1; i <= n; ++i) {
            rowValues.add(i);
        }
        return rowValues;
    }

    private static void splitTrace(int n, int[][] m, int k) {
        int mod = k % n;
        int div = k / n;
        for (int i = 0; i < n; ++i) {
            m[i][i] = div;
        }
        if (mod != 0) {
            for (int i = 0; i < mod; ++i) {
                m[i][i] += 1;
            }
        }
    }
    }