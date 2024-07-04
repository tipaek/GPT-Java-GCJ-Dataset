import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {

    final static int MAX_N = 100;
    static List<Integer> V = new ArrayList<>(MAX_N + 1);
    static List<Integer> S = new ArrayList<>(MAX_N + 1);
    static List<Integer> id = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t, n, x, y, i, j, l;
        t = sc.nextInt();
        n = sc.nextInt();

        for (i = 0; i <= MAX_N; i++) {
            V.add(0);
            S.add(0);
        }
        for (l = 1; l <= t; l++) {
            for (i = n / 2; i >= 1; i--) {
                j = n + 1 - i;
                pw.println(i);
                pw.flush();
                V.set(i, sc.nextInt());
                pw.println(j);
                pw.flush();
                V.set(j, sc.nextInt());
                if (V.get(i).equals(V.get(j))) {
                    S.set(i, 0);
                } else {
                    S.set(i, 1);
                }
            }

            int posIgual = 0, posDiferente = 0;
            for (i = 1; i <= n / 2; i++) {
                if (S.get(i) == 0) {
                    posIgual = i;
                    break;
                }
            }
            for (i = 1; i <= n / 2; i++) {
                if (S.get(i) == 1) {
                    posDiferente = i;
                    break;
                }
            }

            if (posIgual == 0 || posDiferente == 0) {
                pw.println(1);
                pw.flush();
                x = sc.nextInt();
                if (x != V.get(1)) {
                    for (i = 1; i <= n; i++) {
                        V.set(i, (V.get(i) + 1) % 2);
                    }
                }
            } else if (n > 10) {
                for (i = 1; i <= 5; i++) {
                    id.add(i);
                }

                if (posDiferente == 0 || posDiferente >= 6) {
                    for (i = 6; i <= n / 2; i++) {
                        if (S.get(i) == 1) {
                            id.add(i);
                        }
                    }
                    for (i = 6; i <= n / 2; i++) {
                        if (S.get(i) == 0) {
                            id.add(i);
                        }
                    }
                } else {
                    for (i = 6; i <= n / 2; i++) {
                        if (S.get(i) == 0) {
                            id.add(i);
                        }
                    }
                    for (i = 6; i <= n / 2; i++) {
                        if (S.get(i) == 1) {
                            id.add(i);
                        }
                    }
                }

                int pos = 0;
                for (i = 0; i <= 4; i++) {
                    if (!S.get(id.get(i)).equals(S.get(id.get(5)))) {
                        pos = i;
                        break;
                    }
                }
                for (i = 5; i < n / 2; i++) {
                    if (i % 9 == 5) {
                        if (S.get(id.get(i)).equals(S.get(id.get(pos)))) {
                            for (j = i - 1; j >= 0; j--) {
                                if (!S.get(id.get(i)).equals(S.get(id.get(j)))) {
                                    pos = j;
                                    break;
                                }
                            }
                        }

                        pw.println(id.get(i));
                        pw.flush();
                        x = sc.nextInt();
                        pw.println(id.get(pos));
                        pw.flush();
                        y = sc.nextInt();

                        if (x != V.get(id.get(i))) {
                            for (j = 0; j < i; j++) {
                                if (S.get(id.get(j)).equals(S.get(id.get(i)))) {
                                    V.set(id.get(j), (V.get(id.get(j)) + 1) % 2);
                                }
                            }
                        }
                        if (y != V.get(id.get(pos))) {
                            for (j = 0; j < i; j++) {
                                if (S.get(id.get(j)).equals(S.get(id.get(pos)))) {
                                    V.set(id.get(j), (V.get(id.get(j)) + 1) % 2);
                                }
                            }
                        }
                        V.set(id.get(i), x);
                        V.set(id.get(pos), y);
                    } else {
                        pw.println(id.get(i));
                        pw.flush();
                        V.set(id.get(i), sc.nextInt());
                    }
                }
            }

            for (i = 1; i <= n / 2; i++) {
                j = n + 1 - i;
                if (S.get(i) == 0) {
                    V.set(j, V.get(i));
                } else {
                    V.set(j, (V.get(i) + 1) % 2);
                }
            }

            for (i = 1; i <= n; i++) {
                pw.print((char) ('0' + V.get(i)));
            }
            pw.println();
            pw.flush();

            String code = sc.next();
            id = new ArrayList<>();

            if (code.equals("N")) {
                break;
            }
        }
    }
}