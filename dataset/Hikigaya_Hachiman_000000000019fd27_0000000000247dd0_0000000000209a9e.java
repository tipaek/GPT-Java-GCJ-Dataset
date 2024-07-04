import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        int numberOfCases = Integer.parseInt(temp.split(" ")[0]);
        int lengthOfBitsArray = Integer.parseInt(temp.split(" ")[1]);
        short[] bottomUpBitArray = new short[lengthOfBitsArray];
        for (int caseId = 1; caseId <= numberOfCases; caseId++) {
            for (int i = 0; i < lengthOfBitsArray; i++) {
                bottomUpBitArray[i] = -1;
            }
            int distanceFromMid = 0;
            int midLeft = (lengthOfBitsArray / 2) - 1, midRight = lengthOfBitsArray / 2;
            int LSymmetricIdx = midLeft, LNonSymmetricIdx = midRight;
            short oldValueAtSymmetricIdx = -1, oldValueAtNonSymmetricIdx = -1, newValueAtSymmetricIdx, newValueAtNonSymmetricIdx;
            boolean symmetricIdxFound = false, nonSymmetricIdxFound = false, completeSetBuilt = false;
            int currentLeftArrayIndex = (midLeft - distanceFromMid), currentRightArrayIndex = (midRight + distanceFromMid);
            for (int i = 0; i < 15; i++) {
                short currentLeftBit, currentRightBit;

                if (!completeSetBuilt) {
                    if (i == 0) {
                        for (int j = 0; j < 5; j++) {
                            currentLeftArrayIndex = midLeft - distanceFromMid;
                            currentRightArrayIndex = midRight + distanceFromMid;
                            System.out.println(currentLeftArrayIndex + 1);
                            currentLeftBit = Short.parseShort(in.nextLine());
                            System.out.println(currentRightArrayIndex + 1);
                            currentRightBit = Short.parseShort(in.nextLine());
                            bottomUpBitArray[currentLeftArrayIndex] = currentLeftBit;
                            bottomUpBitArray[currentRightArrayIndex] = currentRightBit;
                            distanceFromMid++;

                            if (!symmetricIdxFound) {
                                if (currentLeftBit == currentRightBit) {
                                    LSymmetricIdx = currentLeftArrayIndex;
                                    oldValueAtSymmetricIdx = currentLeftBit;
                                    symmetricIdxFound = true;
                                }
                            }

                            if (!nonSymmetricIdxFound) {
                                if (currentLeftBit != currentRightBit) {
                                    LNonSymmetricIdx = currentLeftArrayIndex;
                                    oldValueAtNonSymmetricIdx = currentLeftBit;
                                    nonSymmetricIdxFound = true;
                                }
                            }
                        }
                    } else {
                        // First 2 inputs are our case checkers
                        System.out.println(LSymmetricIdx + 1);
                        newValueAtSymmetricIdx = Short.parseShort(in.nextLine());
                        System.out.println(LNonSymmetricIdx + 1);
                        newValueAtNonSymmetricIdx = Short.parseShort(in.nextLine());
                        if (!symmetricIdxFound) {

                            // SymmetricIdx not found and non-symmetricIdx found
                            // Right is mirror image of Left in Mid
                            if (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx) {
                                complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                            }

                        } else if (!nonSymmetricIdxFound) {

                            // Non-symmetricIdx not found and symmetricIdx found
                            // Right is complement of mirror image of Left in Mid
                            if (newValueAtSymmetricIdx != oldValueAtSymmetricIdx) {
                                complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                            }

                        } else {

                            // Both symmetric and non-symmetric indices found
                            if ((newValueAtSymmetricIdx == oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                                // Array Only Reversed
                                reverseCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                            } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                                // Array Only Complemented
                                complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                            } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx == oldValueAtNonSymmetricIdx)) {
                                // Array Reversed and Complemented
                                complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                                reverseCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                            } else {
                                // No Changes Needed
                                // Array not modified
                            }
                        }

                        oldValueAtSymmetricIdx = newValueAtSymmetricIdx;
                        oldValueAtNonSymmetricIdx = newValueAtNonSymmetricIdx;

                        for (int j = 0; j < 4; j++) {
                            currentLeftArrayIndex = midLeft - distanceFromMid;
                            currentRightArrayIndex = midRight + distanceFromMid;

                            if (currentLeftArrayIndex >= 0) {
                                // Next 2 inputs <--- Normal Inputs
                                System.out.println(currentLeftArrayIndex + 1);
                                currentLeftBit = Short.parseShort(in.nextLine());
                                System.out.println(currentRightArrayIndex + 1);
                                currentRightBit = Short.parseShort(in.nextLine());
                                bottomUpBitArray[currentLeftArrayIndex] = currentLeftBit;
                                bottomUpBitArray[currentRightArrayIndex] = currentRightBit;
                                distanceFromMid++;

                                if (!symmetricIdxFound) {
                                    if (currentLeftBit == currentRightBit) {
                                        LSymmetricIdx = currentLeftArrayIndex;
                                        oldValueAtSymmetricIdx = currentLeftBit;
                                        symmetricIdxFound = true;
                                    }
                                }

                                if (!nonSymmetricIdxFound) {
                                    if (currentLeftBit != currentRightBit) {
                                        LNonSymmetricIdx = currentLeftArrayIndex;
                                        oldValueAtNonSymmetricIdx = currentLeftBit;
                                        nonSymmetricIdxFound = true;
                                    }
                                }
                            } else {
                                completeSetBuilt = true;
                                System.out.println(1);
                                in.nextLine();
                                System.out.println(1);
                                in.nextLine();
                            }
                        }
                    }
                } else {
                    currentLeftArrayIndex = 0;
                    currentRightArrayIndex = bottomUpBitArray.length - 1;
                    // First 2 inputs are our case checkers
                    System.out.println(LSymmetricIdx + 1);
                    newValueAtSymmetricIdx = Short.parseShort(in.nextLine());
                    System.out.println(LNonSymmetricIdx + 1);
                    newValueAtNonSymmetricIdx = Short.parseShort(in.nextLine());
                    if (!symmetricIdxFound) {

                        // SymmetricIdx not found and non-symmetricIdx found
                        // Right is mirror image of Left in Mid
                        if (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx) {
                            complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                        }

                    } else if (!nonSymmetricIdxFound) {

                        // Non-symmetricIdx not found and symmetricIdx found
                        // Right is complement of mirror image of Left in Mid
                        if (newValueAtSymmetricIdx != oldValueAtSymmetricIdx) {
                            complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                        }

                    } else {

                        // Both symmetric and non-symmetric indices found
                        if ((newValueAtSymmetricIdx == oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                            // Array Only Reversed
                            reverseCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                        } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                            // Array Only Complemented
                            complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                        } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx == oldValueAtNonSymmetricIdx)) {
                            // Array Reversed and Complemented
                            complementCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                            reverseCurrentArray(bottomUpBitArray, currentLeftArrayIndex, currentRightArrayIndex);
                        } else {
                            // No Changes Needed
                            // Array not modified
                        }
                    }

                    oldValueAtSymmetricIdx = newValueAtSymmetricIdx;
                    oldValueAtNonSymmetricIdx = newValueAtNonSymmetricIdx;

                    for (int j = 0; j < 4; j++) {
                        System.out.println(1);
                        in.nextLine();
                        System.out.println(1);
                        in.nextLine();
                    }
                }
            }

            String s = "";
            for(int i = 0; i < lengthOfBitsArray; i++) {
                s += Short.toString(bottomUpBitArray[i]);
            }
            System.out.println(s);

            s = in.nextLine();
            if(s.equalsIgnoreCase("Y")) {
                continue;
            } else {
                System.out.println("Exiting");
                break;
            }
        }
    }

    public static void reverseCurrentArray(short[] bottomUpBitArray, int leftIndex, int rightIndex) {
        for(int i = 0; i <= (rightIndex-leftIndex)/2; i++) {
            short temp = bottomUpBitArray[leftIndex + i];
            bottomUpBitArray[leftIndex + i] = bottomUpBitArray[(rightIndex - i)];
            bottomUpBitArray[(rightIndex - i)] = temp;
        }
    }

    public static void complementCurrentArray(short[] bottomUpBitArray, int leftIndex, int rightIndex) {
        for(int i = leftIndex; i <= rightIndex; i++) {
            if(bottomUpBitArray[i] == 0) {
                bottomUpBitArray[i] = 1;
            } else {
                bottomUpBitArray[i] = 0;
            }
        }
    }
}