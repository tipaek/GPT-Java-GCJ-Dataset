//package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class Solution {

    public static void main(String[] args) {

        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        final int T = in.nextInt();
        final int B = in.nextInt();
        in.nextLine();

        if (B == 10) {

            for (int x = 1; x <= T; ++x) {
                final char[] b = new char[11];
                for (int q = 1; q <= 10; q++) {
                    b[q] = askQuestion(q, in);
                }
                offerAnswer(String.valueOf(b).substring(1), in);
            }

        } else if (B == 20) {

            for (int x = 1; x <= T; ++x) {

                char[] b = new char[21];

                // 5 questions
                for (int q = 1; q <= 5; q++) {
                    b[q] = askQuestion(q, in);
                }

                // 5 questions
                for (int q = 1; q <= 5; q++) {
                    b[15 + q] = askQuestion(15 + q, in);
                }

                char[] p = null;    // p = op(b) for some operation op


                // 10 times x 10 questions == 100 more questions
                for (int times = 1; times <= 10; ++times) {

                    p = new char[21];

                    // 5 questions
                    for (int q = 1; q <= 5; q++) {
                        p[q] = askQuestion(q, in);
                    }

                    // 4 questions
                    for (int q = 1; q <= 4; q++) {
                        p[15 + q] = askQuestion(15 + q, in);
                    }

                    // P = op(B)
                    final Op op = calc(b, p);

                    final Set<Integer> unknown = getIntermediatePositions();

                    if (op == Op.Id) {
                        p[20] = b[20];
                        for (int position = 6; position <= 15; ++position) {
                            if (b[position] != '\0') {
                                p[position] = b[position];
                                unknown.remove(position);
                            }
                        }
                    }

                    if (op == Op.Comp) {
                        p[20] = flip(b[20]);
                        for (int position = 6; position <= 15; ++position) {
                            if (b[position] != '\0') {
                                p[position] = flip(b[position]);
                                unknown.remove(position);
                            }
                        }
                    }

                    if (op == Op.Rev) {
                        p[20] = b[1];
                        for (int position = 6; position <= 15; ++position) {
                            if (b[position] != '\0') {
                                p[21 - position] = b[position];
                                unknown.remove(21 - position);
                            }
                        }
                    }

                    if (op == Op.RevComp) {
                        p[20] = flip(b[1]);
                        for (int position = 6; position <= 15; ++position) {
                            if (b[position] != '\0') {
                                p[21 - position] = flip(b[position]);
                                unknown.remove(21 - position);
                            }
                        }
                    }

                    final int positionToFill = unknown.iterator().next();
                    p[positionToFill] = askQuestion(positionToFill, in);
                    b = Arrays.copyOf(p, p.length);
                }

                offerAnswer(String.valueOf(b).substring(1), in);
            }
        }  else {
            exit(1);
        }
    }

    private static Set<Integer> getIntermediatePositions() {
        final Set<Integer> unknown = new HashSet<>();
        unknown.add(6);
        unknown.add(7);
        unknown.add(8);
        unknown.add(9);
        unknown.add(10);
        unknown.add(11);
        unknown.add(12);
        unknown.add(13);
        unknown.add(14);
        unknown.add(15);
        return unknown;
    }

    private static char askQuestion(final int position, final Scanner in) {
        System.out.println(position);
        System.out.flush();

        final String input = in.nextLine();
        if (input.equals("N")) {
            exit(1);
        }
        return (input.equals("0") ? '0' : '1');
    }

    private static void offerAnswer(final String answer, final Scanner in) {
        System.out.println(answer);
        System.out.flush();

        final String input = in.nextLine();
        if (!input.equals("Y")) {
            exit(1);
        }
    }

    private static Op calc(final char[] b, final char[] p) {
        final Set<Op> ops = new HashSet<>();
        Arrays.stream(Op.values())
                .filter(op -> op.matches(b, p))
                .forEach(op -> ops.add(op));
        return ops.iterator().next();
    }

    private static enum Op {
        Id {
            @Override
            public boolean matches(final char[] b, final char[] p) {
                if (b[1] != p[1] || b[2] != p[2] || b[3] != p[3] || b[4] != p[4] || b[5] != p[5] ||
                        b[16] != p[16] || b[17] != p[17] || b[18] != p[18] || b[19] != p[19]) {
                    return false;
                }
                if (b[6] != '\0' && p[6] != '\0' && b[6] != p[6]) {
                    return false;
                }
                if (b[7] != '\0' && p[7] != '\0' && b[7] != p[7]) {
                    return false;
                }
                if (b[8] != '\0' && p[8] != '\0' && b[8] != p[8]) {
                    return false;
                }
                if (b[9] != '\0' && p[9] != '\0' && b[9] != p[9]) {
                    return false;
                }
                if (b[10] != '\0' && p[10] != '\0' && b[10] != p[10]) {
                    return false;
                }
                if (b[11] != '\0' && p[11] != '\0' && b[11] != p[11]) {
                    return false;
                }
                if (b[12] != '\0' && p[12] != '\0' && b[12] != p[12]) {
                    return false;
                }
                if (b[13] != '\0' && p[13] != '\0' && b[13] != p[13]) {
                    return false;
                }
                if (b[14] != '\0' && p[14] != '\0' && b[14] != p[14]) {
                    return false;
                }
                if (b[15] != '\0' && p[15] != '\0' && b[15] != p[15]) {
                    return false;
                }
                return true;
            }

            @Override
            public String apply(final char[] b) {
                return "" + b[1] + b[2] + b[3] + b[4] + b[5] + b[16] + b[17] + b[18] + b[19] + b[20];
            }
        },
        Comp {
            @Override
            public boolean matches(final char[] b, final char[] p) {
                if (flip(b[1]) != p[1] || flip(b[2]) != p[2] || flip(b[3]) != p[3] || flip(b[4]) != p[4] || flip(b[5]) != p[5] ||
                        flip(b[16]) != p[16] || flip(b[17]) != p[17] || flip(b[18]) != p[18] || flip(b[19]) != p[19]) {
                    return false;
                }if (b[6] != '\0' && p[6] != '\0' && flip(b[6]) != p[6]) {
                    return false;
                }
                if (b[7] != '\0' && p[7] != '\0' && flip(b[7]) != p[7]) {
                    return false;
                }
                if (b[8] != '\0' && p[8] != '\0' && flip(b[8]) != p[8]) {
                    return false;
                }
                if (b[9] != '\0' && p[9] != '\0' && flip(b[9]) != p[9]) {
                    return false;
                }
                if (b[10] != '\0' && p[10] != '\0' && flip(b[10]) != p[10]) {
                    return false;
                }
                if (b[11] != '\0' && p[11] != '\0' && flip(b[11]) != p[11]) {
                    return false;
                }
                if (b[12] != '\0' && p[12] != '\0' && flip(b[12]) != p[12]) {
                    return false;
                }
                if (b[13] != '\0' && p[13] != '\0' && flip(b[13]) != p[13]) {
                    return false;
                }
                if (b[14] != '\0' && p[14] != '\0' && flip(b[14]) != p[14]) {
                    return false;
                }
                if (b[15] != '\0' && p[15] != '\0' && flip(b[15]) != p[15]) {
                    return false;
                }
                return true;
            }

            @Override
            public String apply(final char[] b) {
                return "" + flip(b[1]) + flip(b[2]) + flip(b[3]) + flip(b[4]) + flip(b[5]) +
                        flip(b[16]) + flip(b[17]) + flip(b[18]) + flip(b[19]) + flip(b[20]);
            }
        },
        Rev {
            @Override
            public boolean matches(final char[] b, final char[] p) {
                if (b[20] != p[1] || b[19] != p[2] || b[18] != p[3] || b[17] != p[4] || b[16] != p[5] ||
                        b[5] != p[16] || b[4] != p[17] || b[3] != p[18] || b[2] != p[19]) {
                    return false;
                }
                if (b[6] != '\0' && p[15] != '\0' && b[6] != p[15]) {
                    return false;
                }
                if (b[7] != '\0' && p[14] != '\0' && b[7] != p[14]) {
                    return false;
                }
                if (b[8] != '\0' && p[13] != '\0' && b[8] != p[13]) {
                    return false;
                }
                if (b[9] != '\0' && p[12] != '\0' && b[9] != p[12]) {
                    return false;
                }
                if (b[10] != '\0' && p[11] != '\0' && b[10] != p[11]) {
                    return false;
                }
                if (b[11] != '\0' && p[10] != '\0' && b[11] != p[10]) {
                    return false;
                }
                if (b[12] != '\0' && p[9] != '\0' && b[12] != p[9]) {
                    return false;
                }
                if (b[13] != '\0' && p[8] != '\0' && b[13] != p[8]) {
                    return false;
                }
                if (b[14] != '\0' && p[7] != '\0' && b[14] != p[7]) {
                    return false;
                }
                if (b[15] != '\0' && p[6] != '\0' && b[15] != p[6]) {
                    return false;
                }
                return true;
            }

            @Override
            public String apply(final char[] b) {
                return "" + b[20] + b[19] + b[18] + b[17] + b[16] + b[5] + b[4] + b[3] + b[2] + b[1];
            }
        },
        RevComp {
            @Override
            public boolean matches(final char[] b, final char[] p) {
                if (flip(b[20]) != p[1] || flip(b[19]) != p[2] || flip(b[18]) != p[3] || flip(b[17]) != p[4] || flip(b[16]) != p[5] ||
                        flip(b[5]) != p[16] || flip(b[4]) != p[17] || flip(b[3]) != p[18] || flip(b[2]) != p[19]) {
                    return false;
                }
                if (b[6] != '\0' && p[15] != '\0' && flip(b[6]) != p[15]) {
                    return false;
                }
                if (b[7] != '\0' && p[14] != '\0' && flip(b[7]) != p[14]) {
                    return false;
                }
                if (b[8] != '\0' && p[13] != '\0' && flip(b[8]) != p[13]) {
                    return false;
                }
                if (b[9] != '\0' && p[12] != '\0' && flip(b[9]) != p[12]) {
                    return false;
                }
                if (b[10] != '\0' && p[11] != '\0' && flip(b[10]) != p[11]) {
                    return false;
                }
                if (b[11] != '\0' && p[10] != '\0' && flip(b[11]) != p[10]) {
                    return false;
                }
                if (b[12] != '\0' && p[9] != '\0' && flip(b[12]) != p[9]) {
                    return false;
                }
                if (b[13] != '\0' && p[8] != '\0' && flip(b[13]) != p[8]) {
                    return false;
                }
                if (b[14] != '\0' && p[7] != '\0' && flip(b[14]) != p[7]) {
                    return false;
                }
                if (b[15] != '\0' && p[6] != '\0' && flip(b[15]) != p[6]) {
                    return false;
                }
                return true;
            }

            @Override
            public String apply(final char[] b) {
                return "" + flip(b[20]) + flip(b[19]) + flip(b[18]) + flip(b[17]) + flip(b[16]) +
                        flip(b[5]) + flip(b[4]) + flip(b[3]) + flip(b[2]) + flip(b[1]);
            }
        };

        public abstract boolean matches(final char[] b, final char[] p);
        public abstract String apply(final char[] b);
    }
    
    private static char flip(final char arg) {
        if (arg == '0') {
            return '1';
        } else if (arg == '1') {
            return '0';
        } else {
            throw new IllegalArgumentException("Bad arg: " + arg);
        }
    }
}
