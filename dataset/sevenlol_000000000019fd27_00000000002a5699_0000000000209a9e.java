import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        String s = sc.nextLine();
        String[] tokens = s.split("\\s+");
        int T = Integer.parseInt(tokens[0]);
        int B = Integer.parseInt(tokens[1]);


        for (int i = 1; i <= T; i++) {
            if (!solve(sc, T, B)) {
                // wrong ans
                break;
            }
        }
    }

    private static boolean solve(Scanner sc, int T, int B) {
        boolean[] arr = new boolean[B];

        boolean[] tested = new boolean[B / 2];
        LinkedHashSet<Integer> s1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> s2 = new LinkedHashSet<>();
        LinkedHashSet<Integer> d1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> d2 = new LinkedHashSet<>();
        int left = B / 2;

        for (int i = 0; i < 15; i++) {
            int j = 0;

            Boolean ress1 = null, resd1 = null;
            while (j < 9 && left > 0) {
                for (int k = 0; k < B / 2; k++) {
                    if (!tested[k]) {
                        j += 2;
                        boolean[] res = sendQueries(sc, k, B);
                        if (res[0] == res[1]) {
                            // same
                            if (s1.isEmpty()) {
                                s1.add(k);
                                ress1 = res[0];
                                tested[k] = true;
                                left--;
                            } else if (j <= 10 - (ress1 == null ? 1 : 0)) {
                                if (ress1 == null) {
                                    ress1 = query(sc, s1.iterator().next());
                                    j++;
                                }
                                if (ress1 == res[0]) {
                                    s1.add(k);
                                } else {
                                    s2.add(k);
                                }
                                tested[k] = true;
                                left--;
                            }
                        } else {
                            // diff
                            if (d1.isEmpty()) {
                                d1.add(k);
                                tested[k] = true;
                                left--;
                                resd1 = res[0];
                            } else if (j <= 10 - (resd1 == null ? 1 : 0)) {
                                if (resd1 == null) {
                                    resd1 = query(sc, d1.iterator().next());
                                    j++;
                                }
                                if (resd1 == res[0]) {
                                    d1.add(k);
                                } else {
                                    d2.add(k);
                                }
                                tested[k] = true;
                                left--;
                            }
                        }
                        break;
                    }
                }
            }

            int cnt = (s1.isEmpty() ? 0 : (ress1 == null ? 1 : 0)) + (d1.isEmpty() ? 0 : (resd1 == null ? 1 : 0));
            // System.err.println(j + ", s1=" + s1 + ", s2=" + s2 + ", d1=" + d1 + ", d2=" + d2);
            // System.err.println("left=" + left + ", tested=" + Arrays.toString(tested));
            // System.err.println("ress1=" + ress1 + ", resd1=" + resd1);
            if (left == 0 && j < 10 - cnt) {
                if (!s1.isEmpty()) {
                    if (ress1 == null) {
                        ress1 = query(sc, s1.iterator().next());
                    }
                    for (int k : s1) {
                        arr[k] = arr[B - k - 1] = ress1;
                    }
                    for (int k : s2) {
                        arr[k] = arr[B - k - 1] = !ress1;
                    }
                }
                if (!d1.isEmpty()) {
                    if (resd1 == null) {
                        resd1 = query(sc, d1.iterator().next());
                    }
                    for (int k : d1) {
                        arr[k] = resd1;
                        arr[B - k - 1] = !resd1;
                    }
                    for (int k : d2) {
                        arr[k] = !resd1;
                        arr[B - k - 1] = resd1;
                    }
                }
                break;
            } else {
                for (; j < 10; j++) {
                    sendQueries(sc, 0, B);
                }
            }
        }

        print(arr);
        String ans = sc.nextLine().trim();
        return ans.equals("Y");
    }

    private static boolean query(Scanner sc, int i) {
        System.out.println(i + 1);
        return read(sc);
    }

    private static boolean[] sendQueries(Scanner sc, int i, int B) {
        return new boolean[] { query(sc, i), query(sc, B - i - 1)};
    }

    private static boolean read(Scanner sc) {
        String s = sc.nextLine().trim();
        return s.equals("1");
    }

    private static void print(boolean[] arr) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : arr) {
            sb.append(b ? '1' : '0');
        }
        System.out.println(sb.toString());
    }
}