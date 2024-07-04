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
                    System.out.println(q);
                    System.out.flush();

                    final String input = in.nextLine();
                    if (input.equals("N")) {
                        exit(1);
                    }
                    b[q] = (input.equals("0") ? '0' : '1');
                }

                System.out.println(String.valueOf(b).substring(1));
                System.out.flush();

                final String input = in.nextLine();
                if (!input.equals("Y")) {
                    exit(1);
                }
            }

        } else if (B == 20) {

            for (int x = 1; x <= T; ++x) {

                char[] b = new char[21];

                // 5 questions
                for (int q = 1; q <= 5; q++) {

                    System.out.println(q);
                    System.out.flush();

                    final String input = in.nextLine();
                    if (input.equals("N")) {
                        exit(1);
                    }
                    b[q] = (input.equals("0") ? '0' : '1');
                }

                // 5 questions
                for (int q = 1; q <= 5; q++) {
                    System.out.println(15 + q);
                    System.out.flush();

                    final String input = in.nextLine();
                    if (input.equals("N")) {
                        exit(1);
                    }
                    b[15 + q] = (input.equals("0") ? '0' : '1');
                }

                char[] p = null;    // p = op(b) for some operation op


                // 10 times x 10 questions == 100 more questions
                for (int times = 1; times <= 10; ++times) {

                    p = new char[21];

                    // 5 questions
                    for (int q = 1; q <= 5; q++) {

                        System.out.println(q);
                        System.out.flush();

                        final String input = in.nextLine();
                        if (input.equals("N")) {
                            exit(1);
                        }
                        p[q] = (input.equals("0") ? '0' : '1');
                    }

                    // 4 questions
                    for (int q = 1; q <= 4; q++) {
                        System.out.println(15 + q);
                        System.out.flush();

                        final String input = in.nextLine();
                        if (input.equals("N")) {
                            exit(1);
                        }
                        p[15 + q] = (input.equals("0") ? '0' : '1');
                    }

                    // P = op(B)
                    final Op op = calc(b, p);

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


                    // 1 question
                    System.out.println(positionToFill);
                    System.out.flush();

                    final String input = in.nextLine();
                    if (input.equals("N")) {
                        exit(1);
                    }
                    p[positionToFill] = (input.equals("0") ? '0' : '1');


                        b = Arrays.copyOf(p, p.length);
                }

                System.out.println(String.valueOf(p).substring(1));
                System.out.flush();

                final String input = in.nextLine();
                if (!input.equals("Y")) {
                    exit(1);
                }
            }
        }  else {
            exit(1);
        }
    }

    private static Op calc(final char[] b, final char[] p) {
        final Map<Op, String> map = new HashMap<>();
        Arrays.stream(Op.values())
                .filter(op -> op.matches(b, p))
                .forEach(op -> map.put(op, op.apply(b)));
        final Set<String> values = new HashSet<>();
        map.entrySet().forEach(e -> values.add(e.getValue()));
        if (values.size() != 1) {
            throw new IllegalStateException("Boo!");
        } else {
            return map.keySet().iterator().next();
        }
    }

    private static enum Op {
        Id {
            @Override
            public boolean matches(final char[] b, final char[] p) {
                if (b[1] != p[1] || b[2] != p[2] || b[3] != p[3] || b[4] != p[4] || b[5] != p[5] ||
                        b[16] != p[16] || b[17] != p[17] || b[18] != p[18] || b[19] != p[19]) {
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
                if (b[1] != flip(p[1]) || b[2] != flip(p[2]) || b[3] != flip(p[3]) || b[4] != flip(p[4]) || b[5] != flip(p[5]) ||
                        b[16] != flip(p[16]) || b[17] != flip(p[17]) || b[18] != flip(p[18]) || b[19] != flip(p[19])) {
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
                if (b[2] != p[19] || b[3] != p[18] || b[4] != p[17] || b[5] != p[16] ||
                        b[16] != p[5] || b[17] != p[4] || b[18] != p[3] || b[19] != p[2] || b[20] != p[1]) {
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
                if (b[2] != flip(p[19]) || b[3] != flip(p[18]) || b[4] != flip(p[17]) || b[5] != flip(p[16]) ||
                        b[16] != flip(p[5]) || b[17] != flip(p[4]) || b[18] != flip(p[3]) || b[19] != flip(p[2]) || b[20] != flip(p[1])) {
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
