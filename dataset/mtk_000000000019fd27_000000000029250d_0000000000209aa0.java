import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Indicium
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader ir = new InputReader();
        int testCases = ir.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = ir.nextInt();
            int trace = ir.nextInt();
            // System.err.println(n + " " + trace);

            int possibleStartOfFirstRow = 0;

            if ((n == 4 && trace >= 6 && trace <= 14)) {
                possibleStartOfFirstRow = 1;
            }

            if (trace >= n && trace <= n*n) {
                for (int i = 1; i <= n; i++) {
                    if (i * n == trace) {
                        possibleStartOfFirstRow = i;
                        break;
                    }
                }
            }


            if (possibleStartOfFirstRow == 0 && n == 5) {
                // is sum k possible with n values 1...n (1 is missing and 1 is double)
                if(trace == 7) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    System.out.println("2 1 4 3 5");
                    System.out.println("1 2 5 4 3");
                    System.out.println("3 5 1 2 4");
                    System.out.println("5 4 3 1 2");
                    System.out.println("4 3 2 5 1");

                } else if(trace == 8) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    System.out.println("3 1 5 4 2");
                    System.out.println("1 2 4 5 3");
                    System.out.println("4 3 1 2 5");
                    System.out.println("2 5 3 1 4");
                    System.out.println("5 4 2 3 1");
                } else if(trace == 9) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    System.out.println("4 1 5 3 2");
                    System.out.println("1 2 3 5 4");
                    System.out.println("3 4 1 2 5");
                    System.out.println("2 5 4 1 3");
                    System.out.println("5 3 2 4 1");
                } else if(trace == 21) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    System.out.println("5 3 1 2 4");
                    System.out.println("4 5 2 3 1");
                    System.out.println("3 1 4 5 2");
                    System.out.println("1 2 3 4 5");
                    System.out.println("2 4 5 1 3");
                } else if(trace == 22) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    System.out.println("4 5 1 2 3");
                    System.out.println("5 3 2 1 4");
                    System.out.println("2 4 5 3 1");
                    System.out.println("3 1 4 5 2");
                    System.out.println("1 2 3 4 5");
                } else if(trace == 23) {
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    System.out.println("4 5 1 3 2");
                    System.out.println("5 4 2 1 3");
                    System.out.println("3 2 5 4 1");
                    System.out.println("2 1 3 5 4");
                    System.out.println("1 3 4 2 5");
                } else {
                    Combo sumKPossible = isSumPossible(trace, n);
//                System.err.println("possible? " + sumKPossible.possible);
                    if (sumKPossible.possible) {
                        System.out.println("Case #" + testCase + ": POSSIBLE");
                        print5by5(sumKPossible);
                    } else {
                        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    }
                }
            } else if (possibleStartOfFirstRow > 0) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                if (n == 4 && trace == 6) {
                    System.out.println("1 4 3 2");
                    System.out.println("4 2 1 3");
                    System.out.println("3 1 2 4");
                    System.out.println("2 3 4 1");
                } else if (n == 4 && trace == 7) {
                    System.out.println("3 1 2 4");
                    System.out.println("1 2 4 3");
                    System.out.println("4 3 1 2");
                    System.out.println("2 4 3 1");
                } else if (n == 4 && trace == 9) {
                    System.out.println("3 1 4 2");
                    System.out.println("1 4 2 3");
                    System.out.println("2 3 1 4");
                    System.out.println("4 2 3 1");
                } else if (n == 4 && trace == 10) {
                    System.out.println("1 3 2 4");
                    System.out.println("2 4 1 3");
                    System.out.println("3 1 4 2");
                    System.out.println("4 2 3 1");
                } else if (n == 4 && trace == 11) {
                    System.out.println("4 3 1 2");
                    System.out.println("3 1 2 4");
                    System.out.println("2 4 3 1");
                    System.out.println("1 2 4 3");
                } else if (n == 4 && trace == 13) {
                    System.out.println("2 4 3 1");
                    System.out.println("4 3 1 2");
                    System.out.println("1 2 4 3");
                    System.out.println("3 1 2 4");
                } else if(n == 4 && trace == 14) {
                    System.out.println("3 2 1 4");
                    System.out.println("2 4 3 1");
                    System.out.println("1 3 4 2");
                    System.out.println("4 1 2 3");
                } else {
                    List<Integer> previousRow = getRowStartingWith(possibleStartOfFirstRow, n);
                    System.out.println(getStringRepresentation(previousRow));
                    for (int i = 2; i <= n; i++) {
                        List<Integer> nextRow = getRotatedByOne(previousRow);
                        System.out.println(getStringRepresentation(nextRow));
                        previousRow = nextRow;
                    }
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void print5by5(Combo combo) {
//        System.err.println(combo);
        int[][] mat = new int[5][5];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                mat[i][j] = 0;
            }
        }
        mat[0][0] = mat[4][4] = combo.included;
        int fill = 1;
        for (int i=1; i<4; ) {
            if (fill == combo.included || fill == combo.excluded) {
                fill++;
                continue;
            }
            mat[i][i] = fill;
            fill++;
            i++;
        }

        /*
        for(int i=1; i<5; i++) {
            int next = (mat[0][i-1]+1)%5;
            if (next == 0) next = 5;
            mat[0][i] = next;
        }
        for(int i=1; i<5; i++) {
            int next = (mat[i-1][0]+1)%5;
            if (next == 0) next = 5;
            mat[i][0] = next;
        }*/

        mat[0][4] = combo.excluded;
        mat[4][0] = combo.excluded;
        mat[1][2] = combo.excluded;
        mat[2][3] = combo.excluded;
        mat[3][1] = combo.excluded;

        int middle = mat[2][2];
        mat[0][1] = middle;
        mat[1][0] = middle;
        mat[3][4] = middle;
        mat[4][3] = middle;

//        for(int i=0; i<5; i++)
//            System.out.println(getStringRepresentation(mat[i]));
//        System.out.println();

        boolean ret = fillRest(mat);
//        System.out.println("final ret " + ret);

//        System.out.println("Final print");
        for(int i=0; i<5; i++)
            System.out.println(getStringRepresentation(mat[i]));
//            System.err.println(Arrays.toString(mat[i]));
    }

    private static boolean fillRest(int[][] mat) {
//        mat[2][3]=34;

        if(AllFilled(mat))
            return true;

        for(int i=0; i<5; i++) {
//            int[] rowCandidates = getRowCandidates(mat[i]) ;
//            System.out.println("rowCandidates " + i + " " + Arrays.toString(rowCandidates));
            for(int j=0; j<5; j++) {
                if(mat[i][j] == 0) {
                   for(int x = 1; x < 6; x++) {
//                       if(rowCandidates[x] != 0 && isSafe(mat, i, j, x)) {
                       if(isSafe(mat, i, j, x)) {
//                           System.out.println("setting mat["+i +"]["+j+"] = " + rowCandidates[x]);
                           mat[i][j] = x;
                           if(fillRest(mat)) {
//                               System.out.println("Returning true...");
                               return true;
                           }
                           mat[i][j] = 0;
                       }
                   }
                }
            }
        }
        return false;
    }

    private static boolean AllFilled(int[][] mat) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if (mat[i][j] == 0) {
                    return false;
                }
            }
        }
//        System.out.println("returning true;");
//        for(int i=0; i<5; i++)
//            System.err.println(Arrays.toString(mat[i]));
        return true;
    }

    private static boolean isSafe(int[][] mat, int i, int j, int x) {
        return !usedInRow(mat, i, x) && !usedInCol(mat, j, x);
    }

    private static boolean usedInCol(int[][] grid, int col, int x) {

        for (int row = 0; row < 5; row++)
            if (grid[row][col] == x)
                return true;
        return false;
    }

    private static boolean usedInRow(int[][] grid, int row, int x) {
        for (int col = 0; col < 5; col++) {
            if (grid[row][col] == x)
                return true;
        }
        return false;
    }

    private static int[] getRowCandidates(int[] orig) {
        int[] arr = new int[6];
        for(int i=1; i<6; i++) {
            arr[i] = i;
        }
        for(int i=0; i<5; i++) {
            if(orig[i] != 0) {
                arr[orig[i]] = 0;
            }
        }
        return arr;
    }

    private static Combo isSumPossible(int trace, int n) {
        int curSum = 0;
        int totalSum = n*(n+1)/2;
        int[] res = new int[n+1];

        for (int i = 1; i <= n; i++) {
            res[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            res[i] = i;
            // remove ith and add jth
            // i.e. exclude 1 and double the other
            curSum = totalSum;
            curSum -= i;
            for (int j = 1; j <= n; j++) {
                curSum += j;
                if (i != j) {
                    if (trace == curSum) {
//                        System.err.println("Excluding " + i + " double including " + j);
                        res[i] = j;
                        Combo c = new Combo();
                        c.possible = true;
                        c.nn = res;
                        c.included = j;
                        c.excluded = i;
                        return c;
                    }
                }
                curSum -= j;
            }
        }
        return new Combo();
    }
    static class Combo {
        boolean possible;
        int[] nn;
        int excluded;
        int included;

        @Override
        public String toString() {
            return "Combo{" +
                    "possible=" + possible +
                    ", nn=" + Arrays.toString(nn) +
                    ", excluded=" + excluded +
                    ", included=" + included +
                    '}';
        }
    }

    private static String getStringRepresentation(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        return getStringRepresentation(list);
    }

    private static String getStringRepresentation(List<Integer> row) {
        return row.stream().map(Objects::toString).collect(Collectors.joining(" "));
    }

    private static List<Integer> getRotatedByOne(List<Integer> row) {
        int len = row.size();
        int last = row.get(len-1);
        List<Integer> nums = new ArrayList<>(len);
        nums.add(last);
        for (int i = 1; i < len; i++) {
            nums.add(row.get(i-1));
        }
        return nums;
    }

    private static List<Integer> getRowStartingWith(int start, int n) {
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int next = start%n;
            nums.add((next == 0) ? n : next);
//            System.err.println("nums[" + i + "] = " + nums[i] + ", next was " + next);
            start++;
        }
        return nums;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer st;

        public InputReader() throws FileNotFoundException {
            reader = new BufferedReader(new InputStreamReader(System.in));
            //  reader = new BufferedReader(new InputStreamReader(new FileInputStream("Indicium.in")));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(nextLine()); }
            return st.nextToken();
        }

        public String nextLine() {
            try { return reader.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
    }
}
