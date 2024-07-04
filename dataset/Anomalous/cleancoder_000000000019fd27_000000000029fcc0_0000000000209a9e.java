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
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] == -1) break;
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public void applyTo(int[] array) {
        if (status == 1) {
            complement(array);
        } else if (status == 2) {
            reverse(array);
        } else if (status == 3) {
            complement(array);
            reverse(array);
        }
    }
}

public class Solution {
    private static Scanner scanner;

    public static MutationResult getMutation(int[] array, int queriesRemaining, int numBits) {
        int equalPairStartIndex = -1;
        int nonequalPairStartIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) break;
            if (equalPairStartIndex != -1 && nonequalPairStartIndex != -1) break;
            int backVal = array[array.length - i - 1];
            if (array[i] == backVal && equalPairStartIndex == -1) {
                equalPairStartIndex = i + 1;
            } else if (array[i] != backVal && nonequalPairStartIndex == -1) {
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

        boolean complementary = newEqualFront != array[equalPairStartIndex];
        boolean reversal = newNonequalFront != array[nonequalPairStartIndex] != complementary;

        int status = (complementary ? 1 : 0) + (reversal ? 2 : 0);
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
                if (mutation.status == -1) return solve(numBits, queriesRemaining, queriesMade, saveForLaterEndIndex + bitsKnown / 2);
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
                array[bitPositionRequested - 1] = scanner.nextInt();
                bitsKnown++;
            }
        }

        for (int bit : array) {
            System.out.print(bit);
        }
        System.out.print("\n");
        return scanner.nextLine().equals("Y");
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