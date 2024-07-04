import java.util.Scanner;

public class ESAbATAd {
    public static void main(String[] args) {
        // Read two ints T and B containing num testcases and num bits
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        int numBits = scanner.nextInt();

        for (int x = 1; x <= numTestCases; x++) {
            boolean[] leftVals = new boolean[numBits/2];
            boolean[] isSame = new boolean[numBits/2];
            int pos = 0;
            int firstSame = -1;
            int firstDiff = -1;

            int numQueries = 0;

            // Can make up to 150 queries, but system should never allow that many without having an answer
            while (true) {
                if (numQueries % 10 == 0 && numQueries != 0) {
                    if (firstDiff != -1) {
                        // If first diff are different from expected flip diff
                        System.out.println(firstDiff + 1);
                        numQueries++;
                        boolean res = scanner.nextInt() == 1;

                        if (res != leftVals[firstDiff]) {
                            flipDiff(leftVals, isSame);
                        }
                    } else {
                        // Always want to be on a multiple of two
                        System.out.println(1);
                        scanner.nextInt();
                    }
                    if (firstSame != -1) {
                        // If first same are different from expected flip same
                        System.out.println(firstSame + 1);
                        numQueries++;
                        boolean res = scanner.nextInt() == 1;

                        if (res != leftVals[firstSame]) {
                            flipSame(leftVals, isSame);
                        }
                    } else {
                        System.out.println(1);
                        scanner.nextInt();
                    }
                } else {
                    // Query to opposites
                    System.out.println(pos+1);
                    numQueries++;
                    boolean leftVal = scanner.nextInt() == 1;
                    System.out.println(numBits-pos);
                    numQueries++;
                    boolean rightVal = scanner.nextInt() == 1;

                    if (leftVal == rightVal) {
                        isSame[pos] = true;
                    } else {
                        isSame[pos] = false;
                    }
                    leftVals[pos] = leftVal;
                    pos++;
                }
                if (pos == leftVals.length) {
                    break;
                }
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < leftVals.length; i++) {
                if (leftVals[i])
                    res.append('1');
                else
                    res.append('0');
            }
            for (int i = leftVals.length-1; i >= 0; i--) {
                if (isSame[i]) {
                    if (leftVals[i])
                        res.append('1');
                    else
                        res.append('0');
                } else {
                    if (leftVals[i])
                        res.append('0');
                    else
                        res.append('1');
                }
            }
            System.out.println(res);
            String correct = scanner.nextLine();
            while (!correct.equals("Y") && !correct.equals("N")) {
                correct = scanner.nextLine();
            }
            if (correct.equals("N")) {
                System.exit(5);
            }
            // Can make upto 150 queries

            // Query structure
            // 1. single line containing an integer between 1 and B indicating which position in the array you wish to look at

            // Once sent if the number of queries sent so far ends in a 1, one of the four situtaions will occur with equal probability

            // judge responds with single line containing single character 0 or 1

            // once done making queries
            // 1. output line contaniing a string of B chars each of which is 0 or 1 representing the bits currently stored in the
            // 2. judge responds with one line containing a single letter
            //      'Y' if the answer was correct
            //      'N' if the answer was incorrect
        }
    }

    static void flipSame(boolean[] leftVals, boolean[] isSame) {
        for (int i = 0; i < leftVals.length; i++) {
            if (isSame[i]) {
                leftVals[i] = !leftVals[i];
            }
        }
    }

    static void flipDiff(boolean[] leftVals, boolean[] isSame) {
        for (int i = 0; i < leftVals.length; i++) {
            if (!isSame[i]) {
                leftVals[i] = !leftVals[i];
            }
        }
    }
}
