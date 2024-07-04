import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    private static boolean debug = false;
    private static boolean fromFile = false;
    private static String inputFile = "testC.in";
    
    private static PrintWriter writer;
    private static Scanner scanner;

    private static void debugPrintln(String message) {
        if (debug) {
            writer.println(message);
        }
    }

    private static void debugPrint(String message) {
        if (debug) {
            writer.print(message);
        }
    }

    private static long currentTime() {
        return System.nanoTime();
    }

    private static double roundToSignificantFigures(double value, int significantFigures) {
        double scale = Math.pow(10, significantFigures);
        return Math.round(value * scale) / scale;
    }

    private static void printElapsedTime(long startTime, long endTime) {
        long elapsedTime = endTime - startTime;
        double millisecondsPerNanosecond = 1e-6;
        debugPrintln("Milliseconds elapsed: " + roundToSignificantFigures(elapsedTime * millisecondsPerNanosecond, 4) + 
                     " (" + roundToSignificantFigures(startTime * millisecondsPerNanosecond, 4) + ", " + 
                     roundToSignificantFigures(endTime * millisecondsPerNanosecond, 4) + ")");
    }

    private static class Card {
        int suite;
        int rank;

        Card(int suite, int rank) {
            this.suite = suite;
            this.rank = rank;
        }
    }

    private static void processCase(int caseNumber) {
        int rankCount = scanner.nextInt();
        int suiteCount = scanner.nextInt();
        int cardCount = rankCount * suiteCount;
        int requiredSteps = (rankCount - 1) * (suiteCount - 1);
        Card[] cards = new Card[cardCount];
        Card[] previousOrder = new Card[cardCount];
        int index = 0;

        for (int suite = 0; suite < suiteCount; suite++) {
            for (int rank = 0; rank < rankCount; rank++) {
                cards[index++] = new Card(suite, rank);
            }
        }

        writer.print("Case #" + caseNumber + ": " + requiredSteps);

        for (int rank = 0; rank < rankCount - 1; rank++) {
            for (int suite = 1; suite < suiteCount; suite++) {
                int firstCut = -1;
                int secondCut = -1;

                for (int i = 0; i < cardCount; i++) {
                    if (cards[i].rank > rank) {
                        firstCut = i;
                        break;
                    }
                }

                for (int i = firstCut + 1; i < cardCount; i++) {
                    if (cards[i].rank == rank) {
                        secondCut = i;
                        break;
                    }
                }

                int a = cardCount - secondCut;
                int b = secondCut - firstCut;
                writer.print("\n" + a + " " + b);

                System.arraycopy(cards, firstCut, previousOrder, firstCut, cardCount - firstCut);

                int offset = cardCount - secondCut;
                System.arraycopy(previousOrder, firstCut, cards, firstCut + offset, secondCut - firstCut);

                offset = firstCut - secondCut;
                System.arraycopy(previousOrder, secondCut, cards, secondCut + offset, cardCount - secondCut);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        scanner = fromFile ? new Scanner(new File(inputFile)) : new Scanner(System.in);
        writer = new PrintWriter(System.out);

        int testCaseCount = scanner.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            processCase(i + 1);
            if (i < testCaseCount - 1) {
                writer.println();
            }
        }

        writer.close();
        scanner.close();
    }
}