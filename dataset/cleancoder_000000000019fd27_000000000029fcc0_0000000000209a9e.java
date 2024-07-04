import java.util.Scanner;

class MutationResult {
    public int status;
    public int queriesRemaining;
    public int queriesMade;

    MutationResult(int status, int queriesRemaining, int queriesMade) {
         this.status = status;
         this.queriesRemaining = queriesRemaining;
         this.queriesMade = queriesMade;
    }

    public void complement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) break;
            array[i] = array[i] == 0 ? 1 : 0;
            array[array.length - i - 1] = array[array.length - i - 1] == 0 ? 1 : 0;
        }
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) break;
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public void applyTo(int[] array) {
        switch(this.status) {
            case 1:
                complement(array);
                break;
            case 2:
                reverse(array);
                break;
            case 3:
                complement(array);
                reverse(array);
                break;
        }
    }
}

public class Solution {
    private static Scanner scanner;

    public static MutationResult getMutation(int[] array, int queriesRemaining, int numBits) {
        int equalPairStartIndex = -1;
        int nonequalPairStartIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int frontVal = array[i];
            if (array[i] == -1) break;
            if (equalPairStartIndex != -1 && nonequalPairStartIndex != -1) break;
            int backVal = array[array.length - i - 1];
            if (frontVal == backVal && equalPairStartIndex == -1) {
                equalPairStartIndex = i + 1;
            } else if (frontVal != backVal && nonequalPairStartIndex == -1) {
                nonequalPairStartIndex = i + 1;
            }
        }
        if (equalPairStartIndex == -1 || nonequalPairStartIndex == -1) {
            return new MutationResult(-1, queriesRemaining, 0);
        }

        System.out.println(equalPairStartIndex);
        int newEqualFront = scanner.nextInt();
        System.out.println(nonequalPairStartIndex);
        int newNonequalFront = scanner.nextInt();
        queriesRemaining -= 2;

        boolean complementary = false;
        boolean reversal = false;
        if (newEqualFront != array[equalPairStartIndex]) complementary = true;
        if (newNonequalFront != array[nonequalPairStartIndex]) {
            if (!complementary) {
                reversal = true;
            }
        } else {
            if (complementary) {
                reversal = true;
            }
        }
        int status = 0;
        if (complementary && reversal) { status = 3; }
        else if (complementary) { status = 1; }
        else if (reversal) { status = 2; }

        return new MutationResult(status, queriesRemaining, 2);
    }

    public static boolean solve(int numBits, int queriesRemaining, int queriesMade, int saveForLaterEndIndex) {
        if (queriesRemaining <= 0) return false;

        int[] array = new int[numBits];
        int bitsKnown = 0;
        int currentRegularIndex = 0;
        boolean lastWasFront = false;

        boolean workingWithSaveForLater = false;
        int currentSaveForLaterIndex = 0;

        while (bitsKnown < numBits) {
            queriesMade++;
            if (bitsKnown > 0 && (queriesMade % 10 == 1)) {
                MutationResult mutation = getMutation(array, queriesRemaining, numBits);
                // -1: unknown, 0: nothing, 1: complement only, 2: reversal only, 3: complement + reversal
                if (mutation.status == -1) return solve(numBits, queriesRemaining, queriesMade,saveForLaterEndIndex + bitsKnown/2);
                queriesRemaining = mutation.queriesRemaining;
                queriesMade += mutation.queriesMade;
                mutation.applyTo(array);
            } else {
                int bitPositionRequested;
                if (bitsKnown + saveForLaterEndIndex >= numBits && !workingWithSaveForLater) {
                    workingWithSaveForLater = true;
                    lastWasFront = false;
                }
                if (workingWithSaveForLater) {
                    if (lastWasFront) {
                        bitPositionRequested = (numBits - currentSaveForLaterIndex);
                        lastWasFront = false;
                        currentSaveForLaterIndex++;
                    } else {
                        bitPositionRequested = currentSaveForLaterIndex;
                        lastWasFront = true;
                    }
                } else {
                    if (lastWasFront) {
                        bitPositionRequested = (numBits - currentRegularIndex) - saveForLaterEndIndex;
                        lastWasFront = false;
                        currentRegularIndex++;
                    } else {
                        bitPositionRequested = (currentRegularIndex + 1) + saveForLaterEndIndex;
                        lastWasFront = true;
                    }
                }
                System.out.println(bitPositionRequested);
                queriesRemaining--;
                int value = scanner.nextInt();
                array[bitPositionRequested - 1] = value;
                bitsKnown++;
            }
        }

        // try solution
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.print("\n");
        String result = scanner.nextLine();
        return result.equals("Y");
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        int numBits = scanner.nextInt();
        for (int i = 1; i <= numTestCases; i++) {
            if (!solve(numBits, 150, 0, 0)) {
                break;
            }
        }
    }
}
