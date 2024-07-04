import java.util.Scanner;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);

    private static int total = 0;

    public static void main(String[] args) {
        String[] line = sc.nextLine().split(" ");
        int t = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);

        for (int tt = 0; tt < t; tt++) {

            boolean[] result = new boolean[b + 1];

            for (int i = 1; i <= 5; i++) {
                boolean res = ask(i);
                result[i] = res;
                boolean res2 = ask(b - i + 1);
                result[b - i + 1] = res2;
            }

            int nextQ = 6;

            outer:
            while (true) {
                int findFirstDiff = findFirst(result, nextQ, true);
                int findFirstSame = findFirst(result, nextQ, false);

                boolean rDiff = false;
                boolean rSame = false;
                if (findFirstDiff != -1) {
                    rDiff = ask(findFirstDiff);
                } else {
                    ask(findFirstSame);
                }
                if (findFirstSame != -1) {
                    rSame = ask(findFirstSame);
                } else {
                    ask(findFirstDiff);
                }

                if (findFirstDiff != -1 && findFirstSame == -1) {
                    // all differ
                    if (rDiff != result[findFirstDiff]) {
                        complement(result, nextQ);
                    }
                }

                if (findFirstDiff == -1 && findFirstSame != -1) {
                    // all same
                    if (rSame != result[findFirstSame]) {
                        complement(result, nextQ);
                    }
                }

                if (findFirstDiff != -1 && findFirstSame != -1) {
                    if (rSame == result[findFirstSame]) {
                        // reverse or nothing
                        if (rDiff == result[findFirstDiff]) {
                            // nothing
                        } else {
                            reverse(result, nextQ);
                        }
                    } else {
                        // complement or rev-comp
                        if (rDiff == result[findFirstDiff]) {
                            // rev-comp
                            reverse(result, nextQ);
                            complement(result, nextQ);
                        } else {
                            complement(result, nextQ);
                        }
                    }
                }

                if (nextQ > ((b+1) / 2)) {
                    break;
                }

                for (int a = 2; a < 10; a += 2) {
                    if (nextQ > (b+1) / 2) {
                        break outer;
                    }

                    boolean r = ask(nextQ);
                    result[nextQ] = r;
                    boolean r2 = ask(b - nextQ + 1);
                    result[b - nextQ + 1] = r2;
                    nextQ++;
                }
            }

            System.out.println(print(result));
            String s = sc.nextLine();
            if (s.equals("N")) {
                System.exit(0);
            }
        }
    }

    private static String print(boolean[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i] ? '1' : '0');
        }
        return sb.toString();
    }

    private static void complement(boolean[] result, int nextQ) {
        for (int i = 1; i < nextQ; i++) {
            result[i] = !result[i];
            result[result.length - i] = !result[result.length - i];
        }
    }

    private static void reverse(boolean[] result, int nextQ) {
        for (int i = 1; i < nextQ; i++) {
            boolean c = result[i];
            result[i] = result[result.length - i];
            result[result.length - i] = c;
        }
    }

    private static int findFirst(boolean[] result, int max, boolean findDiff) {
        for (int i = 1; i < max; i++) {
            int i2 = result.length - i;
            if (result[i] != result[i2] && findDiff) {
                return i;
            }
            if (result[i] == result[i2] && !findDiff) {
                return i;
            }
        }
        return -1;
    }

    private static boolean ask(int i) {
        System.out.println(i);
        //System.out.println(i + "     (" + ++total + ")");
        System.out.flush();
        String line = sc.nextLine();
        return line.charAt(0) == '1';
    }
}
