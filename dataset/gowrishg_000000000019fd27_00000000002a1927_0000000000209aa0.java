import java.util.*;
import java.io.*;

class Solution {

        public static void main(String[] args) throws Exception {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//            Scanner in = new Scanner(text);
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int k = in.nextInt();
                String ans = solve(n, k);
                System.out.println("Case #" + i + ": " + ans);
            }
        }

        public static String solve(int n, int k) {
            int[][] ans = fillDiag(n, k);
            boolean possible = fillRestV2(ans, n);
            return possible ? "POSSIBLE" + printAns(ans) : "IMPOSSIBLE";// + printAns(ans);
        }

        public static String printAns(int[][] ans) {
            StringBuffer out = new StringBuffer();
            out.append("\n");
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    out.append(ans[i][j]);
                    if (j < ans[i].length - 1) out.append(" ");
                }
                if (i < ans.length - 1) out.append("\n");
            }
            return out.toString();
        }

        public static boolean fillRestV2(int[][] ans, final int n) {
            Hashtable<String, Integer> cache = new Hashtable();
            Hashtable<Integer, Integer> ht = new Hashtable();
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                ht.putIfAbsent(ans[i][i], 0);
                int count = ht.get(ans[i][i]) + 1;
                ht.put(ans[i][i], count);
            }
            Set<Integer> nums = ht.keySet();
            for(Integer num: nums) {
                if(ht.get(num) == n - 1) {
                    possible = false;
                    break;
                }
            }
            return possible ? fillRest(cache, ans, 0, 1, n) : false;
        }


        public static boolean fillRest(Hashtable<String, Integer> cache, int[][] ans, int row, int col, final int n) {
            if (row == n) return true;
            else if (row == -1) return false;
            else if (row == 0 && col == 0) return false;

            //printAns(ans);

            cache.putIfAbsent(row + "" + col, 1);

            final int possibleValue;
            if (col == row) possibleValue = ans[row][col];
            else possibleValue = cache.get(row + "" + col);
            boolean isPossible = isPossible(ans, possibleValue, row, col, n);
//            System.out.println("Row: " + row + ", Col: " + col + ", isPossible: " + isPossible + ", possibleValue: " + possibleValue);
            if (isPossible) {
                ans[row][col] = possibleValue;
                col++;
                if (col == n) {
                    row++;
                    col = 0;
                }
                return fillRest(cache, ans, row, col, n);
            } else {
//                System.out.println(printAns(ans));
                ans[row][col] = 0;
                if (possibleValue < n) {
                    cache.put(row + "" + col, possibleValue + 1);
                } else {
                    cache.remove(row + "" + col);
                    col--;
                    if (col == -1) {
                        row--;
                        col = n - 1;
                    }
                    if (row == col) {
                        col--;
                    }
                    if (col == -1) {
                        row--;
                        col = n - 1;
                    }
                }
                return fillRest(cache, ans, row, col, n);
            }
        }

        public static boolean isPossible(final int[][] ans, int checkNum, final int row, final int col, final int n) {
            if (row == col) return true;
            if (checkNum > n) return false;
            for (int x = 0; x < n; x++) {
                if (ans[row][x] == checkNum || ans[x][col] == checkNum) {
                    return false;
                }
            }
            return true;
        }

        public static int[][] fillDiag(int n, int k) {
            int[][] ans = new int[n][n];
            int reminder = k;
            for (int i = 0; i < n; i++) {
                int diag = reminder % (n - i);
                if (diag == 0) {
                    diag = reminder / (n - i);
                }
                reminder -= diag;
                ans[i][i] = diag;
            }
            return ans;
        }
    }