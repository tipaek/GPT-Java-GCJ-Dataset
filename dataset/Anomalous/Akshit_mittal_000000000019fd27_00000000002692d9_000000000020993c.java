import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Arrays;

class Solution {

    public static void solveMatrix(String[][] s, int t) {
        int n = s.length;
        int trace = 0, row = 0, column = 0;
        Hashtable<String, Integer>[] hc = new Hashtable[n];
        int[] a = new int[n];
        Arrays.fill(a, 0);

        for (int i = 0; i < n; i++) {
            Hashtable<String, Integer> hr = new Hashtable<>();
            int rowFlag = 0;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    hc[j] = new Hashtable<>();
                }

                if (i == j) {
                    trace += Integer.parseInt(s[i][j]);
                }

                if (!hr.containsKey(s[i][j])) {
                    hr.put(s[i][j], 1);
                } else {
                    rowFlag = 1;
                }

                if (!hc[j].containsKey(s[i][j])) {
                    hc[j].put(s[i][j], 1);
                } else {
                    a[j] = 1;
                }
            }
            if (rowFlag == 1) {
                row++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                column++;
            }
        }

        System.out.println("Case #" + t + ": " + trace + " " + row + " " + column);
    }

    static int r = 0;

    public static String addParentheses(String s) {
        return "(" + s + ")";
    }

    public static String solveString(String s, int d, int limit) {
        if (s.isEmpty()) {
            return "";
        }

        int a = -1, f = 0;
        StringBuilder st = new StringBuilder();
        int sm = 10;
        int y = Character.getNumericValue(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            y = Character.getNumericValue(s.charAt(i));
            if (y < sm) {
                sm = y;
            }
            if (y > d && f == 0) {
                a = i;
                f = 1;
            } else if (y == d) {
                if (a != -1 && f == 1) {
                    st.append(solveString(s.substring(a, i), d + 1, d)).append(s.charAt(i));
                    f = 0;
                    a = -1;
                } else {
                    st.append(s.charAt(i));
                }
            }

            if (i == s.length() - 1 && y > d) {
                if (a != -1 && f == 1) {
                    st.append(solveString(s.substring(a, i + 1), d + 1, d));
                }
            }
        }

        int j = d - limit;
        while (j > 0) {
            st.insert(0, addParentheses(st.toString()));
            j--;
            r++;
        }
        return st.toString();
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int t = 1; t <= T; t++) {
                String s = br.readLine();
                String result = solveString(s, 0, 0);
                System.out.println("Case #" + t + ": " + result);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}