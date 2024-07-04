import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int q = 0; q < t; q++) {
            String s = scanner.nextLine();
            LinkedList<String> list = new LinkedList<>();

            for (char c : s.toCharArray()) {
                list.add(String.valueOf(c));
            }

            int openBrackets = 0;

            if (list.size() == 1) {
                openBrackets = Integer.parseInt(list.get(0));
                addBrackets(list, openBrackets);
            } else {
                processList(list);
            }

            System.out.print("Case #" + (q + 1) + ": ");
            for (String str : list) {
                System.out.print(str);
            }
            System.out.println();
        }
    }

    private static void addBrackets(LinkedList<String> list, int openBrackets) {
        for (int i = 0; i < openBrackets; i++) {
            list.addFirst("(");
            list.addLast(")");
        }
    }

    private static void processList(LinkedList<String> list) {
        int openBrackets = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            if (isDigit(list.get(i)) && isDigit(list.get(i + 1))) {
                int current = Integer.parseInt(list.get(i));
                int next = Integer.parseInt(list.get(i + 1));

                if (i == 0) {
                    openBrackets = current;
                    balanceBrackets(list, i, openBrackets, next);
                } else {
                    adjustBrackets(list, i, openBrackets, current, next);
                }
            }

            if (i == list.size() - 2 && openBrackets > 0) {
                closeRemainingBrackets(list, openBrackets);
            }
        }
    }

    private static boolean isDigit(String str) {
        return !str.equals("(") && !str.equals(")");
    }

    private static void balanceBrackets(LinkedList<String> list, int i, int openBrackets, int next) {
        if (next < openBrackets) {
            int diff = openBrackets - next;
            addClosingBrackets(list, i, diff);
            addOpeningBrackets(list, openBrackets);
            openBrackets -= diff;
        } else if (next > openBrackets) {
            int diff = next - openBrackets;
            addOpeningBrackets(list, i, diff);
            addOpeningBrackets(list, openBrackets);
            openBrackets += diff;
        } else {
            addOpeningBrackets(list, openBrackets);
        }
    }

    private static void adjustBrackets(LinkedList<String> list, int i, int openBrackets, int current, int next) {
        if (next < current) {
            int diff = openBrackets - next;
            addClosingBrackets(list, i, diff);
            openBrackets -= diff;
        } else if (next > current) {
            int diff = next - openBrackets;
            addOpeningBrackets(list, i, diff);
            openBrackets += diff;
        }
    }

    private static void addOpeningBrackets(LinkedList<String> list, int count) {
        for (int k = 0; k < count; k++) {
            list.addFirst("(");
        }
    }

    private static void addOpeningBrackets(LinkedList<String> list, int index, int count) {
        for (int k = 0; k < count; k++) {
            list.add(index + 1, "(");
        }
    }

    private static void addClosingBrackets(LinkedList<String> list, int index, int count) {
        for (int k = 0; k < count; k++) {
            list.add(index + 1, ")");
        }
    }

    private static void closeRemainingBrackets(LinkedList<String> list, int openBrackets) {
        for (int k = 0; k < openBrackets; k++) {
            list.add(")");
        }
    }

    // Problem #3
    private static void problem3(Scanner scanner) {
        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            sorter(intervals);

            StringBuilder ans = new StringBuilder("C");
            int cIndex = 0, jIndex = -1;
            intervals[0][3] = 0;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[i - 1][1]) {
                    char curr = ans.charAt(i - 1);
                    ans.append(curr);
                    if (curr == 'C') {
                        cIndex = i;
                        intervals[i][3] = 0;
                    } else {
                        jIndex = i;
                        intervals[i][3] = 1;
                    }
                } else {
                    if (jIndex == -1) {
                        ans.append("J");
                        intervals[i][3] = 1;
                        jIndex = i;
                    } else {
                        if (intervals[i][0] >= intervals[jIndex][1]) {
                            ans.append("J");
                            intervals[i][3] = 1;
                            jIndex = i;
                        } else if (intervals[i][0] >= intervals[cIndex][1]) {
                            ans.append("C");
                            intervals[i][3] = 0;
                            cIndex = i;
                        } else {
                            ans = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }

            sorter2(intervals);

            if (ans.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (q + 1) + ": ");
                for (int[] interval : intervals) {
                    System.out.print(interval[3] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }

    private static void sorter(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
    }

    private static void sorter2(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[2]));
    }

    // Problem #1
    private static void problem1(Scanner scanner) {
        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() != n) {
                    rowCount++;
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colCount++;
                }
            }

            System.out.println("Case #" + (q + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}