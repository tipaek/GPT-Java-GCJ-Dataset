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
            int leftIndex = 1;
            int rightIndex = bitCount;
            int leftValue = makeQuery(input, leftIndex++);
            int rightValue = makeQuery(input, rightIndex--);
            int firstValue = leftValue;
            int nextLeftValue, nextRightValue;
            
            while (!anchorPointsFound && leftIndex < rightIndex) {
                nextLeftValue = makeQuery(input, leftIndex);
                nextRightValue = makeQuery(input, rightIndex);
                
                if (areValidAnchors(leftValue + "" + nextLeftValue, nextRightValue + "" + rightValue)) {
                    knownData = updateKnownData(knownData, leftIndex - 1, String.valueOf(nextLeftValue));
                    knownData = updateKnownData(knownData, leftIndex - 2, String.valueOf(leftValue));
                    knownData = updateKnownData(knownData, rightIndex - 1, String.valueOf(nextRightValue));
                    knownData = updateKnownData(knownData, rightIndex, String.valueOf(rightValue));
                    anchorPointsFound = true;
                    break;
                }
                
                leftValue = nextLeftValue;
                rightValue = nextRightValue;
                
                if (queriesMade % 10 == 0) {
                    leftValue = makeQuery(input, leftIndex);
                    firstValue = makeQuery(input, 1);
                    makeQuery(input, 1); // To keep queries even.
                    rightValue = makeQuery(input, rightIndex);
                }
                
                leftIndex++;
                rightIndex--;
            }
            
            String prevLeftAnchor = leftValue + "" + nextLeftValue;
            String prevRightAnchor = nextRightValue + "" + rightValue;
            
            while (knownData.contains("X")) {
                if (queriesMade % 10 == 0) {
                    if (anchorPointsFound) {
                        int leftFirstValue = makeQuery(input, leftIndex - 1);
                        int leftSecondValue = makeQuery(input, leftIndex);
                        int rightFirstValue = makeQuery(input, rightIndex);
                        int rightSecondValue = makeQuery(input, rightIndex + 1);
                        String newLeftAnchor = leftFirstValue + "" + leftSecondValue;
                        String newRightAnchor = rightFirstValue + "" + rightSecondValue;
                        
                        ChangeType change = detectChangeType(prevLeftAnchor, prevRightAnchor, newLeftAnchor, newRightAnchor);
                        knownData = applyChange(change, knownData);
                        
                        prevLeftAnchor = newLeftAnchor;
                        prevRightAnchor = newRightAnchor;
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
            
            if (submitAttempt(input, knownData).equals("N")) {
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
    
    private static boolean areValidAnchors(String anchor1, String anchor2) {
        return !anchor1.equals(anchor2) && !anchor1.equals(getReverse(anchor2)) && !anchor1.equals(getComplement(anchor2));
    }
    
    private static ChangeType detectChangeType(String anchor1, String anchor2, String newAnchor1, String newAnchor2) {
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
    
    private static String applyChange(ChangeType change, String knownData) {
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
    
    private static String getComplement(String bits) {
        StringBuilder result = new StringBuilder();
        for (char bit : bits.toCharArray()) {
            result.append(bit == '0' ? '1' : bit == '1' ? '0' : bit);
        }
        return result.toString();
    }
    
    private static String getReverse(String bits) {
        return new StringBuilder(bits).reverse().toString();
    }
    
    private static String getReverseComplement(String bits) {
        return getReverse(getComplement(bits));
    }
    
    private enum ChangeType {S, R, C, RC}
}