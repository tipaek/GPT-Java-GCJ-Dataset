import java.util.Scanner;

public class Solution {
    static int checks = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int[] out = new int[b];
            int eq = -1;
            int eqVal = 0;
            int neq = -1;
            int neqVal = 0;

            int[] mod = new int[b];
            checks = 0;

            for (int i1 = 0; i1 < (b + 1) / 2; i1++) {

                if (checks > 0 && (checks % 10) == 0) {
                    if (eq >= 0) {
                        int a = read(sc, eq);
                        if (a != eqVal) {
                            mod[i1 - 1] += 1;
                            eqVal = a;
                            neqVal = 1 - neqVal;
                        }
                    }
                    if (neq >= 0) {
                        int a = read(sc, neq);
                        if (a != neqVal) {
                            mod[i1 - 1] += 2;
                            neqVal = a;
                        }
                    }
                    if (checks % 2 == 1) {
                        read(sc, 0);
                    }
                }

                int x = read(sc, i1);
                int y = read(sc, b - 1 - i1);

                out[i1] = x;
                out[b - 1 - i1] = y;

                if (eq == -1 && x == y) {
                    eq = i1;
                    eqVal = x;
                }
                if (neq == -1 && x != y) {
                    neq = i1;
                    neqVal = x;
                }
            }

            char[] str = new char[b];
            boolean neg = false;
            boolean sw = false;
            for (int i1 = (b + 1) / 2 - 1; i1 >= 0; i1--) {
                if ((mod[i1] & 1) == 1) {
                    neg = !neg;
                }
                if ((mod[i1] & 2) == 2) {
                    sw = !sw;
                }
                str[i1] = (char)('0' + neg(sw ? out[b - 1 - i1] : out[i1], neg));
                str[b - 1 - i1] = (char)('0' + neg(sw ? out[i1] : out[b - 1 - i1], neg));
            }

            System.out.println(new String(str));
            String answer = sc.next();
            if (!answer.equals("Y")) {
                System.err.println("WRONG");
                return;
            }
            System.err.println("CORRECT");
        }
    }

    private static int read(Scanner sc, int eq) {
        System.out.println(eq + 1);
        int a = sc.next().charAt(0) - '0';
        checks++;
        if (a != 0 && a != 1) {
            System.err.println("Unknown char: " + a);
            System.exit(4);
        }
        return a;
    }

    static int neg(int i, boolean n) {
        return n ? 1 - i : i;
    }
}
