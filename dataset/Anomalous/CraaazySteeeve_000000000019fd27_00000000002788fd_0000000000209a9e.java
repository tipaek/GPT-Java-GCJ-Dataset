import java.util.Scanner;

public class Solution {

    private static int queriesMade = 0;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int tCount = input.nextInt();
        int bitCount = input.nextInt();
        for (int t = 0; t < tCount; t++) {
            String knownData = initKnownData(bitCount);
            boolean anchorPointsFound = false;
            int leftSideAnchorIndex = 1;
            int rightSideAnchorIndex = bitCount;

            int leftSideValue = makeQuery(input, leftSideAnchorIndex++);
            int rightSideValue = makeQuery(input, rightSideAnchorIndex--);
            int firstValue = leftSideValue;
            int nextLeftSideValue, nextRightSideValue;

            while (!anchorPointsFound && leftSideAnchorIndex < rightSideAnchorIndex) {
                nextLeftSideValue = makeQuery(input, leftSideAnchorIndex);
                nextRightSideValue = makeQuery(input, rightSideAnchorIndex);

                if (checkIfValidAnchors(leftSideValue + "" + nextLeftSideValue, nextRightSideValue + "" + rightSideValue)) {
                    knownData = updateKnownData(knownData, leftSideAnchorIndex - 1, String.valueOf(nextLeftSideValue));
                    knownData = updateKnownData(knownData, leftSideAnchorIndex - 2, String.valueOf(leftSideValue));
                    knownData = updateKnownData(knownData, rightSideAnchorIndex - 1, String.valueOf(nextRightSideValue));
                    knownData = updateKnownData(knownData, rightSideAnchorIndex, String.valueOf(rightSideValue));
                    anchorPointsFound = true;
                    break;
                }

                leftSideValue = nextLeftSideValue;
                rightSideValue = nextRightSideValue;

                if (queriesMade % 10 == 0) {
                    leftSideValue = makeQuery(input, leftSideAnchorIndex);
                    firstValue = makeQuery(input, 1);
                    firstValue = makeQuery(input, 1);
                    rightSideValue = makeQuery(input, rightSideAnchorIndex);
                }

                leftSideAnchorIndex++;
                rightSideAnchorIndex--;
            }

            String prevLeftAnchorValue = leftSideValue + "" + nextLeftSideValue;
            String prevRightAnchorValue = nextRightSideValue + "" + rightSideValue;

            while (knownData.contains("X")) {
                if (queriesMade % 10 == 0) {
                    if (anchorPointsFound) {
                        int leftSideFirstValue = makeQuery(input, leftSideAnchorIndex - 1);
                        int leftSideSecondValue = makeQuery(input, leftSideAnchorIndex);
                        int rightSideFirstValue = makeQuery(input, rightSideAnchorIndex);
                        int rightSideSecondValue = makeQuery(input, rightSideAnchorIndex + 1);

                        String newLeftAnchorValue = leftSideFirstValue + "" + leftSideSecondValue;
                        String newRightAnchorValue = rightSideFirstValue + "" + rightSideSecondValue;

                        ChangeType change = getChangeTypeOfData(prevLeftAnchorValue, prevRightAnchorValue, newLeftAnchorValue, newRightAnchorValue);
                        knownData = applyChange(knownData, change);

                        prevLeftAnchorValue = newLeftAnchorValue;
                        prevRightAnchorValue = newRightAnchorValue;
                    } else {
                        int newFirstValue = makeQuery(input, 1);
                        if (newFirstValue != firstValue) {
                            knownData = getComplement(knownData);
                            firstValue = newFirstValue;
                        }
                    }
                }

                int nextIndex = knownData.indexOf("X") + 1;
                int newValue = makeQuery(input, nextIndex);
                knownData = updateKnownData(knownData, nextIndex - 1, String.valueOf(newValue));
            }

            String status = submitAttempt(input, knownData);
            if (status.equals("N")) {
                return;
            }
            queriesMade = 0;
        }
    }

    private static String initKnownData(int bitCount) {
        return "X".repeat(bitCount);
    }

    private static String updateKnownData(String knownData, int index, String data) {
        return knownData.substring(0, index) + data + knownData.substring(index + 1);
    }

    private static String submitAttempt(Scanner input, String bitString) {
        System.out.println(bitString);
        input.nextLine();
        return input.nextLine();
    }

    private static int makeQuery(Scanner input, int queryIndex) {
        queriesMade++;
        System.out.println(queryIndex);
        return input.nextInt();
    }

    private static boolean checkIfValidAnchors(String anchor1, String anchor2) {
        return !anchor1.equals(anchor2) && !anchor1.equals(getReverse(anchor2)) && !anchor1.equals(getComplement(anchor2));
    }

    private static ChangeType getChangeTypeOfData(String anchor1, String anchor2, String newAnchor1, String newAnchor2) {
        if (anchor1.equals(newAnchor1) && anchor2.equals(newAnchor2)) {
            return ChangeType.S;
        }

        if (getReverse(anchor1).equals(newAnchor2) && getReverse(anchor2).equals(newAnchor1)) {
            return ChangeType.R;
        }

        if (getComplement(anchor1).equals(newAnchor1) && getComplement(anchor2).equals(newAnchor2)) {
            return ChangeType.C;
        }

        return ChangeType.RC;
    }

    private static String getComplement(String bits) {
        StringBuilder result = new StringBuilder();
        for (char bit : bits.toCharArray()) {
            result.append(bit == '0' ? '1' : '0');
        }
        return result.toString();
    }

    private static String getReverse(String bits) {
        return new StringBuilder(bits).reverse().toString();
    }

    private static String getReverseComplement(String bits) {
        return getReverse(getComplement(bits));
    }

    private static String applyChange(String knownData, ChangeType change) {
        switch (change) {
            case C:
                return getComplement(knownData);
            case R:
                return getReverse(knownData);
            case RC:
                return getReverseComplement(knownData);
            default:
                return knownData;
        }
    }

    private enum ChangeType {S, R, C, RC}
}