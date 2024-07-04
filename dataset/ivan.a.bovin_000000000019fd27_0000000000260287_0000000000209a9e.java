import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int T = input.nextInt();
        final int B = input.nextInt();
        // System.out.println(); // debug
        for (int t = 1; t <= T; ++t) {
            final Boolean[] b = new Boolean[B];
            int X = -1;
            int indexOfSame = -1;
            int indexOfDifferent = -1;
            for (int i = 0; i < 150; ++i) {
                final int ii = i % 10;
                if (i < 10 || ii > 1) {
                    if (i % 2 == 0) {
                        ++X;
                        if (X >= B / 2) {
                            break;
                        }
                        System.out.println(X + 1);
                        b[X] = input.nextInt() == 1;
                    } else {
                        System.out.println(B - X);
                        b[B - X - 1] = input.nextInt() == 1;
                        if (b[X] == b[B - X - 1]) {
                            if (indexOfSame < 0) {
                                indexOfSame = X;
                            }
                        } else {
                            if (indexOfDifferent < 0) {
                                indexOfDifferent = X;
                            }
                        }
                    }
                } else if (ii == 0) {
                    if (indexOfSame < 0) {
                        System.out.println(1);
                        input.nextInt();
                    } else {
                        System.out.println(indexOfSame + 1);
                        boolean bi = input.nextInt() == 1;
                        if (bi != b[indexOfSame]) {
                            for (int x = 0; x <= X; ++x) {
                                if (b[x] == b[B - x - 1]) {
                                    b[x] = !b[x];
                                    b[B - x - 1] = !b[B - x - 1];
                                }
                            }
                        }
                    }
                } else if (ii == 1) {
                    if (indexOfDifferent < 0) {
                        System.out.println(1);
                        input.nextInt();
                    } else {
                        System.out.println(indexOfDifferent + 1);
                        boolean bi = input.nextInt() == 1;
                        if (bi != b[indexOfDifferent]) {
                            for (int x = 0; x <= X; ++x) {
                                if (b[x] != b[B - x - 1]) {
                                    b[x] = !b[x];
                                    b[B - x - 1] = !b[B - x - 1];
                                }
                            }
                        }
                    }
                }
                // String ss = joinBytesToString(b); // debug
                // System.out.format("%d %s\n\n", i, ss); // debug
            }
            // System.out.println("DONE"); // debug
            System.out.println(joinBytesToString(b));
        }
    }

    private static String joinBytesToString(Boolean[] b) {
        return Arrays.stream(b).map(bb -> bb == null ? "." : bb ? "1" : "0")
                .collect(Collectors.joining(""));
    }
}
