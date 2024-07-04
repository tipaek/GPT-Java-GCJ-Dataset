import java.util.*;
import java.util.stream.Stream;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(in, b);
        }
    }

    public static void solve(Scanner in, int b) {
        boolean[] known = new boolean[b + 1];
        boolean[] tab = new boolean[b + 1];
        int i = 1;
        int c = 1;
        boolean pair_found = false;
        boolean diff_found = false;
        int pairlow = -1;
        int difflow = -1;
        while (!pair_found) {
            System.out.println(i);
            System.out.flush();
            c++;
            known[i] = true;
            tab[i] = in.nextInt() == 1;
            System.out.println(b-i+1);
            System.out.flush();
            c++;
            known[b - i + 1] = true;
            tab[b-i+1] = in.nextInt() == 1;
            if (allknown(known)) {
                printit(tab, in);
                return;
            }
            if (tab[i] == tab[b - i + 1]) {
                pair_found = true;
                pairlow = i;
                i++;
                break;
            } else {
                diff_found = true;
                difflow = i;
                i++;
            }
            if (c % 10 == 1) {
                System.out.println(1);
                System.out.flush();
                c++;
                in.nextInt();
                System.out.println(1);
                System.out.flush();
                c++;
                boolean newval = in.nextInt() == 1;
                if (tab[1] != newval) {
                    for (int j = 1; j < i; j++) {
                        tab[j] = !tab[j];
                        tab[b - j + 1] = !tab[b - j + 1];
                    }
                }
            }
        }
        while (!diff_found) {
            if (c % 10 == 1) {
                System.out.println(1);
                System.out.flush();
                c++;
                in.nextInt();
                System.out.println(1);
                System.out.flush();
                c++;
                boolean newval = in.nextInt() == 1;
                if (tab[1] != newval) {
                    for (int j = 1; j < i; j++) {
                        tab[j] = !tab[j];
                        tab[b - j + 1] = !tab[b - j + 1];
                    }
                }
            }
            System.out.println(i);
            System.out.flush();
            c++;
            known[i] = true;
            tab[i] = in.nextInt() == 1;
            System.out.println(b - i + 1);
            System.out.flush();
            c++;
            known[b - i + 1] = true;
            tab[b - i + 1] = in.nextInt() == 1;
            if (allknown(known)) {
                printit(tab, in);
                return;
            }
            if (tab[i] != tab[b - i + 1]) {
                diff_found = true;
                difflow = i;
                i++;
                break;
            } else {
                i++;
            }
        }
        while (i <= (b / 2)) {
            if (c % 10 == 1) {
                System.out.println(pairlow);
                System.out.flush();
                c++;
                boolean newpairval = in.nextInt() == 1;
                System.out.println(difflow);
                System.out.flush();
                c++;
                boolean newdiffval = in.nextInt() == 1;
                if (tab[pairlow] != newpairval) {
                    for (int j = 1; j < i; j++) {
                        if (tab[j] == tab[b - j + 1]) {
                            tab[j] = !tab[j];
                            tab[b - j + 1] = !tab[b - j + 1];
                        }
                    }
                }
                if (tab[difflow] != newdiffval) {
                    for (int j = 1; j < i; j++) {
                        if (tab[j] != tab[b - j + 1]) {
                            tab[j] = !tab[j];
                            tab[b - j + 1] = !tab[b - j + 1];
                        }
                    }
                }
            }
            System.out.println(i);
            System.out.flush();
            c++;
            known[i] = true;
            tab[i] = in.nextInt() == 1;
            System.out.println(b - i + 1);
            System.out.flush();
            c++;
            known[b - i + 1] = true;
            tab[b - i + 1] = in.nextInt() == 1;
            if (allknown(known)) {
                printit(tab, in);
                return;
            }
            i++;
        }
        throw new RuntimeException("Should not happen");
    }

    public static void printit(boolean[] tab, Scanner in) {
        for (int i = 1; i < tab.length; i++) {
            System.out.print(tab[i] ? '1' : '0');
        }
        System.out.println();
        System.out.flush();
        in.nextLine();
        if ("N".equals(in.nextLine())) {
            throw new RuntimeException("wrong answer should not happen");
        }
    }

    public static boolean allknown(boolean[] known) {
        for (int i = 1; i < known.length; i++) {
            if (!known[i])
                return false;
        }
        return true;
    }
}
