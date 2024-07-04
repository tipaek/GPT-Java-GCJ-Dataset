import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        for (int t = 1; t <= T; t++) {
            byte[] bs = new byte[B];
            int oddPair = -1, evenPair = -1;
            byte oddPairL = -1, evenPairL = -1, inv = 0;
            boolean reversed = false;
            int asks = 0;
            for (int i = 0; i < B >> 1; i++) {
                if (asks > 0 && asks % 10 == 0) {
                    if (evenPair != -1) {
                        ++asks;
                        inv = (byte) (evenPairL ^ ask(in, evenPair, reversed, 0, B));
                        if (oddPair != -1) {
                            ++asks;
                            reversed = oddPairL != ask(in, oddPair, false, inv, B);
                        }
                    } else {
                        ++asks;
                        inv = (byte) (oddPairL ^ ask(in, oddPair, reversed, 0, B));
                    }
                }

                ++asks;
                byte l = ask(in, i, reversed, inv, B);

                if (asks % 10 == 0) {
                    if (evenPair != -1) {
                        ++asks;
                        inv = (byte) (evenPairL ^ ask(in, evenPair, reversed, 0, B));
                        if (oddPair != -1) {
                            ++asks;
                            reversed = oddPairL != ask(in, oddPair, false, inv, B);
                        }
                    } else {
                        ++asks;
                        inv = (byte) (oddPairL ^ ask(in, oddPair, reversed, 0, B));
                    }
                }

                ++asks;
                byte r = ask(in, i, !reversed, inv, B);

                if (l != r) {
                    oddPair = i;
                    oddPairL = l;
                } else {
                    evenPair = i;
                    evenPairL = l;
                }

                bs[i] = l;
                bs[B - 1 - i] = r;
            }

            if (asks % 10 == 0) {
                if (evenPair != -1) {
                    ++asks;
                    inv = (byte) (evenPairL ^ ask(in, evenPair, reversed, 0, B));
                    if (oddPair != -1) {
                        ++asks;
                        reversed = oddPairL != ask(in, oddPair, false, inv, B);
                    }
                } else {
                    ++asks;
                    inv = (byte) (oddPairL ^ ask(in, oddPair, reversed, 0, B));
                }
            }
            for (int i = 0; i < B; i++) {
                System.out.print(bs[reversed ? B - 1 - i : i] ^ inv);
            }
            out("");
        }
    }

    private static byte ask(Scanner in, int n, boolean reversed, int inv, int b) {
        out(reversed ? b - n : n + 1);
        return (byte) (in.nextByte() ^ inv);
    }

    private static void out(Object s) {
        System.out.println(s);
        System.out.flush();
    }
}
