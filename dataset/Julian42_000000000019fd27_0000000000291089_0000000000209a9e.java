import java.util.Scanner;

public class Solution {
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
                        // If first diff are different froSm expected flip diff
                        System.out.println(firstDiff + 1);
                        boolean res = scanner.nextInt() == 1;

                        if (res != leftVals[firstDiff]) {
                            System.out.println("Flip diff");
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
                        boolean res = scanner.nextInt() == 1;

                        if (res != leftVals[firstSame]) {
                            System.out.println("Flip same");
                            flipSame(leftVals, isSame);
                        }
                    } else {
                        System.out.println(1);
                        scanner.nextInt();
                    }
                } else {
                    // Query to opposites
                    System.out.println(pos+1);
                    boolean leftVal = scanner.nextInt() == 1;
                    System.out.println(numBits-pos);
                    boolean rightVal = scanner.nextInt() == 1;

                    if (leftVal == rightVal) {
                        if (firstSame == -1) {
                            firstSame = pos;
                        }
                        isSame[pos] = true;
                    } else {
                        if (firstDiff == -1) {
                            firstDiff = pos;
                        }
                        isSame[pos] = false;
                    }
                    leftVals[pos] = leftVal;
                    pos++;
                }
                if (pos == leftVals.length) {
                    break;
                }
                numQueries += 2;
            }
            
            // Create result
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
                // End Program
                return;
            }
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
