import java.util.*;
import java.io.*;

public class Solution {
    public static int calculateMaxValue(int p, int n, int[][] a, int[][] dp) {
        if (p == 0 || n < 0) return 0;
        if (dp[p][n] > 0) return dp[p][n];

        int maxVal = 0;
        maxVal = Math.max(calculateMaxValue(p, n - 1, a, dp), maxVal);

        for (int i = 0; i < a[n].length; i++) {
            if (p - i - 1 >= 0) {
                maxVal = Math.max(a[n][i] + calculateMaxValue(p - i - 1, n - 1, a, dp), maxVal);
            } else {
                break;
            }
        }
        return dp[p][n] = maxVal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0, colRepeats = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() != n) {
                    rowRepeats++;
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    public static Comparator<Pair> getPairComparator() {
        return new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int result = o2.value.compareTo(o1.value);
                if (result == 0) {
                    return o2.index.compareTo(o1.index);
                }
                return result;
            }
        };
    }
}

class Pair {
    Integer value;
    Integer index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class SegmentTree {
    int[] segmentTree;
    int size;

    SegmentTree(int[] array) {
        size = array.length;
        int height = (int) Math.ceil(Math.log(size) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        segmentTree = new int[maxSize];
        buildSegmentTree(array, 0, 0, size - 1);
    }

    int buildSegmentTree(int[] array, int root, int start, int end) {
        if (start == end) {
            segmentTree[root] = array[start];
        } else {
            int mid = (start + end) / 2;
            segmentTree[root] = Math.min(
                buildSegmentTree(array, 2 * root + 1, start, mid),
                buildSegmentTree(array, 2 * root + 2, mid + 1, end)
            );
        }
        return segmentTree[root];
    }

    int getMinValue(int queryStart, int queryEnd) {
        return getMinValueUtil(0, 0, size - 1, queryStart, queryEnd);
    }

    int getMinValueUtil(int root, int start, int end, int queryStart, int queryEnd) {
        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[root];
        }
        if (end < queryStart || start > queryEnd) {
            return Integer.MAX_VALUE;
        }

        int mid = (start + end) / 2;
        return Math.min(
            getMinValueUtil(2 * root + 1, start, mid, queryStart, queryEnd),
            getMinValueUtil(2 * root + 2, mid + 1, end, queryStart, queryEnd)
        );
    }

    void updateValue(int index, int newValue) {
        updateValueUtil(0, 0, size - 1, index, newValue);
    }

    int updateValueUtil(int root, int start, int end, int index, int newValue) {
        if (start == end) {
            return segmentTree[root] = newValue;
        }

        int mid = (start + end) / 2;
        if (index <= mid) {
            segmentTree[root] = Math.min(updateValueUtil(2 * root + 1, start, mid, index, newValue), segmentTree[2 * root + 2]);
        } else {
            segmentTree[root] = Math.min(segmentTree[2 * root + 1], updateValueUtil(2 * root + 2, mid + 1, end, index, newValue));
        }
        return segmentTree[root];
    }
}