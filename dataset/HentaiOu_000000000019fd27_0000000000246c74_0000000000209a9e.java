import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        int numberOfCases = Integer.parseInt(temp.split(" ")[0]);
        int length = Integer.parseInt(temp.split(" ")[1]);
        short[] ourArray = new short[length];

        // Loop for each testCase
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {

            // Setting complete array to -1
            for (int quNo = 0; quNo < length; quNo++) {
                ourArray[quNo] = -1;
            }

            // These are our references
            int valToSub = 0;
            int milf = (length / 2) - 1, mirt = length / 2;
            int LSymmetricIdx = milf, LNonSymmetricIdx = mirt;
            short oldValueAtSymmetricIdx = -1, oldValueAtNonSymmetricIdx = -1, newValueAtSymmetricIdx, newValueAtNonSymmetricIdx;
            boolean SIF = false, NSIF = false, completeSetBuilt = false;
            int CLAI = (milf - valToSub), CRAI = (mirt + valToSub);

            // Taking 150 Queries
            for (int quNo = 0; quNo < 15; quNo++) {
                short currentLeftBit, currentRightBit;

                if (!completeSetBuilt) {
                    if (quNo == 0) {
                        for (int j = 0; j < 5; j++) {
                            CLAI = milf - valToSub;
                            CRAI = mirt + valToSub;

                            // Next 2 inputs <--- Normal Inputs
                            System.out.println(CLAI + 1);
                            currentLeftBit = Short.parseShort(in.nextLine());
                            System.out.println(CRAI + 1);
                            currentRightBit = Short.parseShort(in.nextLine());
                            ourArray[CLAI] = currentLeftBit;
                            ourArray[CRAI] = currentRightBit;
                            valToSub++;

                            if (!SIF) {
                                if (currentLeftBit == currentRightBit) {
                                    LSymmetricIdx = CLAI;
                                    oldValueAtSymmetricIdx = currentLeftBit;
                                    SIF = true;
                                }
                            }

                            if (!NSIF) {
                                if (currentLeftBit != currentRightBit) {
                                    LNonSymmetricIdx = CLAI;
                                    oldValueAtNonSymmetricIdx = currentLeftBit;
                                    NSIF = true;
                                }
                            }
                        }
                    } else {
                        // First 2 inputs are our case checkers
                        System.out.println(LSymmetricIdx + 1);
                        newValueAtSymmetricIdx = Short.parseShort(in.nextLine());
                        System.out.println(LNonSymmetricIdx + 1);
                        newValueAtNonSymmetricIdx = Short.parseShort(in.nextLine());
                        if (!SIF) {

                            // SymmetricIdx not found and non-symmetricIdx found
                            // Right is mirror image of Left in Mid
                            if (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx) {
                                complementCurrentArray(ourArray, CLAI, CRAI);
                            }

                        } else if (!NSIF) {

                            // Non-symmetricIdx not found and symmetricIdx found
                            // Right is complement of mirror image of Left in Mid
                            if (newValueAtSymmetricIdx != oldValueAtSymmetricIdx) {
                                complementCurrentArray(ourArray, CLAI, CRAI);
                            }

                        } else {

                            // Both symmetric and non-symmetric indices found
                            if ((newValueAtSymmetricIdx == oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                                // Array Only Reversed
                                reverseCurrentArray(ourArray, CLAI, CRAI);
                            } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                                // Array Only Complemented
                                complementCurrentArray(ourArray, CLAI, CRAI);
                            } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx == oldValueAtNonSymmetricIdx)) {
                                // Array Reversed and Complemented
                                complementCurrentArray(ourArray, CLAI, CRAI);
                                reverseCurrentArray(ourArray, CLAI, CRAI);
                            } else {
                                // No Changes Needed
                                // Array not modified
                            }
                        }

                        oldValueAtSymmetricIdx = newValueAtSymmetricIdx;
                        oldValueAtNonSymmetricIdx = newValueAtNonSymmetricIdx;

                        for (int j = 0; j < 4; j++) {
                            CLAI = milf - valToSub;
                            CRAI = mirt + valToSub;

                            if (CLAI >= 0) {
                                // Next 2 inputs <--- Normal Inputs
                                System.out.println(CLAI + 1);
                                currentLeftBit = Short.parseShort(in.nextLine());
                                System.out.println(CRAI + 1);
                                currentRightBit = Short.parseShort(in.nextLine());
                                ourArray[CLAI] = currentLeftBit;
                                ourArray[CRAI] = currentRightBit;
                                valToSub++;

                                if (!SIF) {
                                    if (currentLeftBit == currentRightBit) {
                                        LSymmetricIdx = CLAI;
                                        oldValueAtSymmetricIdx = currentLeftBit;
                                        SIF = true;
                                    }
                                }

                                if (!NSIF) {
                                    if (currentLeftBit != currentRightBit) {
                                        LNonSymmetricIdx = CLAI;
                                        oldValueAtNonSymmetricIdx = currentLeftBit;
                                        NSIF = true;
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
                    CLAI = 0;
                    CRAI = ourArray.length - 1;
                    // First 2 inputs are our case checkers
                    System.out.println(LSymmetricIdx + 1);
                    newValueAtSymmetricIdx = Short.parseShort(in.nextLine());
                    System.out.println(LNonSymmetricIdx + 1);
                    newValueAtNonSymmetricIdx = Short.parseShort(in.nextLine());
                    if (!SIF) {

                        // SymmetricIdx not found and non-symmetricIdx found
                        // Right is mirror image of Left in Mid
                        if (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx) {
                            complementCurrentArray(ourArray, CLAI, CRAI);
                        }

                    } else if (!NSIF) {

                        // Non-symmetricIdx not found and symmetricIdx found
                        // Right is complement of mirror image of Left in Mid
                        if (newValueAtSymmetricIdx != oldValueAtSymmetricIdx) {
                            complementCurrentArray(ourArray, CLAI, CRAI);
                        }

                    } else {

                        // Both symmetric and non-symmetric indices found
                        if ((newValueAtSymmetricIdx == oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                            // Array Only Reversed
                            reverseCurrentArray(ourArray, CLAI, CRAI);
                        } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx != oldValueAtNonSymmetricIdx)) {
                            // Array Only Complemented
                            complementCurrentArray(ourArray, CLAI, CRAI);
                        } else if ((newValueAtSymmetricIdx != oldValueAtSymmetricIdx) && (newValueAtNonSymmetricIdx == oldValueAtNonSymmetricIdx)) {
                            // Array Reversed and Complemented
                            complementCurrentArray(ourArray, CLAI, CRAI);
                            reverseCurrentArray(ourArray, CLAI, CRAI);
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
            for(int quNo = 0; quNo < length; quNo++) {
                s += Short.toString(ourArray[quNo]);
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

    public static void reverseCurrentArray(short[] ourArray, int leftIndex, int rightIndex) {
        for(int quNo = 0; quNo <= (rightIndex-leftIndex)/2; quNo++) {
            short temp = ourArray[leftIndex + quNo];
            ourArray[leftIndex + quNo] = ourArray[(rightIndex - quNo)];
            ourArray[(rightIndex - quNo)] = temp;
        }
    }

    public static void complementCurrentArray(short[] ourArray, int leftIndex, int rightIndex) {
        for(int quNo = leftIndex; quNo <= rightIndex; quNo++) {
            if(ourArray[quNo] == 0) {
                ourArray[quNo] = 1;
            } else {
                ourArray[quNo] = 0;
            }
        }
    }
}