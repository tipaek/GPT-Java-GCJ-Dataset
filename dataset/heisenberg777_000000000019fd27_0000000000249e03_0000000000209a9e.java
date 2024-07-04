import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        int numberOfCases = Integer.parseInt(temp.split(" ")[0]);
        int length = Integer.parseInt(temp.split(" ")[1]);
        short[] upBuildedArray = new short[length];

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {

            for (int iii = 0; iii < length; iii++) {
                upBuildedArray[iii] = -1;
            }

            int valToSub = 0;
            int miiLeft = (length / 2) - 1, miiRight = length / 2;
            int LSymmetricIdx = miiLeft, LNonSymmetricIdx = miiRight;
            short ovasIdx = -1, ovansIdx = -1, nvasIdx, nvansIdx;
            boolean SIF = false, NSIF = false, completeSetBuilt = false;
            int leftIndex = (miiLeft - valToSub), rightIndex = (miiRight + valToSub);

         
            for (int iii = 0; iii < 15; iii++) {
                short currentLeftBit, currentRightBit;

                if (!completeSetBuilt) {
                    if (iii == 0) {
                        for (int j = 0; j < 5; j++) {
                            leftIndex = miiLeft - valToSub;
                            rightIndex = miiRight + valToSub;

                            System.out.println(leftIndex + 1);
                            currentLeftBit = Short.parseShort(in.nextLine());
                            System.out.println(rightIndex + 1);
                            currentRightBit = Short.parseShort(in.nextLine());
                            upBuildedArray[leftIndex] = currentLeftBit;
                            upBuildedArray[rightIndex] = currentRightBit;
                            valToSub++;

                            if (!SIF) {
                                if (currentLeftBit == currentRightBit) {
                                    LSymmetricIdx = leftIndex;
                                    ovasIdx = currentLeftBit;
                                    SIF = true;
                                }
                            }

                            if (!NSIF) {
                                if (currentLeftBit != currentRightBit) {
                                    LNonSymmetricIdx = leftIndex;
                                    ovansIdx = currentLeftBit;
                                    NSIF = true;
                                }
                            }
                        }
                    } else {
    
                        System.out.println(LSymmetricIdx + 1);
                        nvasIdx = Short.parseShort(in.nextLine());
                        System.out.println(LNonSymmetricIdx + 1);
                        nvansIdx = Short.parseShort(in.nextLine());
                        if (!SIF) {

              
                            if (nvansIdx != ovansIdx) {
                                complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                            }

                        } else if (!NSIF) {

          
                            if (nvasIdx != ovasIdx) {
                                complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                            }

                        } else {

                      
                            if ((nvasIdx == ovasIdx) && (nvansIdx != ovansIdx)) {
                    
                                reverseCurrentArray(upBuildedArray, leftIndex, rightIndex);
                            } else if ((nvasIdx != ovasIdx) && (nvansIdx != ovansIdx)) {
                           
                                complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                            } else if ((nvasIdx != ovasIdx) && (nvansIdx == ovansIdx)) {
                               
                                complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                                reverseCurrentArray(upBuildedArray, leftIndex, rightIndex);
                            } else {
                            }
                        }

                        ovasIdx = nvasIdx;
                        ovansIdx = nvansIdx;

                        for (int j = 0; j < 4; j++) {
                            leftIndex = miiLeft - valToSub;
                            rightIndex = miiRight + valToSub;

                            if (leftIndex >= 0) {
                                System.out.println(leftIndex + 1);
                                currentLeftBit = Short.parseShort(in.nextLine());
                                System.out.println(rightIndex + 1);
                                currentRightBit = Short.parseShort(in.nextLine());
                                upBuildedArray[leftIndex] = currentLeftBit;
                                upBuildedArray[rightIndex] = currentRightBit;
                                valToSub++;

                                if (!SIF) {
                                    if (currentLeftBit == currentRightBit) {
                                        LSymmetricIdx = leftIndex;
                                        ovasIdx = currentLeftBit;
                                        SIF = true;
                                    }
                                }

                                if (!NSIF) {
                                    if (currentLeftBit != currentRightBit) {
                                        LNonSymmetricIdx = leftIndex;
                                        ovansIdx = currentLeftBit;
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
                    leftIndex = 0;
                    rightIndex = upBuildedArray.length - 1;
                    System.out.println(LSymmetricIdx + 1);
                    nvasIdx = Short.parseShort(in.nextLine());
                    System.out.println(LNonSymmetricIdx + 1);
                    nvansIdx = Short.parseShort(in.nextLine());
                    if (!SIF) {
                        
                        if (nvansIdx != ovansIdx) {
                            complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                        }

                    } else if (!NSIF) {

                        
                        if (nvasIdx != ovasIdx) {
                            complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                        }

                    } else {

                        
                        if ((nvasIdx == ovasIdx) && (nvansIdx != ovansIdx)) {
                            reverseCurrentArray(upBuildedArray, leftIndex, rightIndex);
                        } else if ((nvasIdx != ovasIdx) && (nvansIdx != ovansIdx)) {
                            complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                        } else if ((nvasIdx != ovasIdx) && (nvansIdx == ovansIdx)) {
                            complementCurrentArray(upBuildedArray, leftIndex, rightIndex);
                            reverseCurrentArray(upBuildedArray, leftIndex, rightIndex);
                        } else {
                        }
                    }

                    ovasIdx = nvasIdx;
                    ovansIdx = nvansIdx;

                    for (int j = 0; j < 4; j++) {
                        System.out.println(1);
                        in.nextLine();
                        System.out.println(1);
                        in.nextLine();
                    }
                }
            }

            String s = "";
            for(int iii = 0; iii < length; iii++) {
                s += Short.toString(upBuildedArray[iii]);
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

    public static void reverseCurrentArray(short[] upBuildedArray, int leftIndex, int rightIndex) {
        for(int iii = 0; iii <= (rightIndex-leftIndex)/2; iii++) {
            short temp = upBuildedArray[leftIndex + iii];
            upBuildedArray[leftIndex + iii] = upBuildedArray[(rightIndex - iii)];
            upBuildedArray[(rightIndex - iii)] = temp;
        }
    }

    public static void complementCurrentArray(short[] upBuildedArray, int leftIndex, int rightIndex) {
        for(int iii = leftIndex; iii <= rightIndex; iii++) {
            if(upBuildedArray[iii] == 0) {
                upBuildedArray[iii] = 1;
            } else {
                upBuildedArray[iii] = 0;
            }
        }
    }
}