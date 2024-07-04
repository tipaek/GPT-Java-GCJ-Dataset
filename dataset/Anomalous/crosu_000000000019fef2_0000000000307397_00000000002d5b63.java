import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static boolean debug = false;
    public static boolean fromFile = false;
    public static String inputFile = "testC.in";

    public static PrintWriter writer;
    public static Scanner scanner;

    public static void debugPrintln(String s) {
        if (debug) {
            writer.println(s);
        }
    }

    public static void debugPrint(String s) {
        if (debug) {
            writer.print(s);
        }
    }

    public static long now() {
        return System.nanoTime();
    }

    public static double round(double d, int sigDigits) {
        double q = Math.pow(10, sigDigits);
        return Math.round(d * q) / q;
    }

    public static void printTime(long start, long stop) {
        long elapsed = stop - start;
        double msPerNs = Math.pow(10, -6);
        debugPrintln("Ms elapsed: " + round(elapsed * msPerNs, 4) + " (" + round(start * msPerNs, 4) + ", " + round(stop * msPerNs, 4) + ")");
    }

    public static class Card {
        int suite;
        int rank;

        public Card(int suite, int rank) {
            this.suite = suite;
            this.rank = rank;
        }
    }

    public static void nextCase(int caseNum, int a, int b) {
        int rankNum = scanner.nextInt();
        int suiteNum = scanner.nextInt();
        int cardNum = rankNum * suiteNum;
        int stepsRequired = (rankNum - 1) * (suiteNum - 1);
        Card[] order = new Card[cardNum];
        Card[] prevOrder = new Card[cardNum];

        int index = 0;
        for (int s = 0; s < suiteNum; s++) {
            for (int r = 0; r < rankNum; r++) {
                order[index++] = new Card(s, r);
            }
        }

        writer.print("Case #" + caseNum + ": " + stepsRequired);

        for (int r = 0; r < rankNum - 1; r++) {
            for (int s = 1; s < suiteNum; s++) {
                int firstCut = -1;
                int secondCut = -1;

                for (int x = 0; x < cardNum; x++) {
                    if (order[x].rank > r) {
                        firstCut = x;
                        break;
                    }
                }

                for (int x = firstCut + 1; x < cardNum; x++) {
                    if (order[x].rank == r) {
                        secondCut = x;
                        break;
                    }
                }

                int a = cardNum - secondCut;
                int b = secondCut - firstCut;
                writer.print("\n" + a + " " + b);

                System.arraycopy(order, firstCut, prevOrder, firstCut, cardNum - firstCut);

                int offset = cardNum - secondCut;
                System.arraycopy(prevOrder, firstCut, order, firstCut + offset, secondCut - firstCut);

                offset = firstCut - secondCut;
                System.arraycopy(prevOrder, secondCut, order, secondCut + offset, cardNum - secondCut);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            nextCase(i + 1, a, b);
            if (i < t - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}