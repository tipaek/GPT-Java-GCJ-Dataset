import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));

        String tempBuffer;
        String result;
        tempBuffer = scanner.nextLine();
        byte testCases = Byte.parseByte(tempBuffer);

        String impossible = "IMPOSSIBLE";


        int dots[][] = new int [testCases][2];


        int caseIndex, index;


        for (caseIndex = 0; caseIndex < testCases; caseIndex++) {

            if (scanner.hasNext()) {
                dots[caseIndex][0] = scanner.nextInt();
                dots[caseIndex][1] = scanner.nextInt();
            }
        }
        for(caseIndex = 0; caseIndex< testCases; caseIndex++) {
            System.out.print("Case #"+(caseIndex+1)+": ");
            int distance = Math.abs(dots[caseIndex][0]) + Math.abs(dots[caseIndex][1]);
            if (distance % 2 == 0) {
                System.out.println(impossible);
                continue;
            }

            int curX = dots[caseIndex][0];
            int curY = dots[caseIndex][1];

            result = "";

            int qty = 0;
            int reverseStep = -1;
            int curValue;
            int nextValue;
            int testValue;
            while(distance > 0) {
                curValue = (qty == 0 ? 1 : 2*(qty));
                qty++;
                if (distance >= curValue) distance -= curValue;
                else {

                    boolean findFlag = false;
                    for(index = 0; index < qty-1; index++) {
                        testValue = (index == 0) ? 1 : 2*index;
                        if (distance + 2*testValue == curValue) {
                            reverseStep = index;
                            findFlag = true;
                            break;
                        }
                    }

                    if (!findFlag) {
                        qty = -1;
                    }
                    break;

                }

            }

            if (qty == -1) {
                System.out.println(impossible);
                continue;
            }


            for(index = 0; index< qty; index++) {
                curValue = (index == 0 ? 1 : 2*(index));

                nextValue = (index +1 == qty) ? 0 : curValue + 2;

                if (curValue == 1) {
                    if (Math.abs(curX) % 2 == 0 && curY != 0) {
                        if (curY > 0) {
                            if (reverseStep == index) { result += "S"; curY += 1; }
                            else {result += "N";curY -= 1; }
                        } else {
                            if (reverseStep == index) {result += "N"; curY -= 1; }
                            else { result += "S"; curY += 1; }
                        }
                    } else {
                        if (curX > 0) {
                            if (reverseStep == index) { result += "W"; curX += 1;}
                            else {result += "E";  curX -= 1;}
                        } else {
                            if (reverseStep == index) { result += "E";  curX -= 1;}
                            else { result += "W";  curX += 1;}
                        }
                    }
                } else {

                    if (curX == 0 || (Math.abs(curY) - curValue == 0)) {
                        if (curY > 0) {
                            if (reverseStep == index) {
                                curY += curValue;
                                result += "S";

                            } else{
                                curY -= curValue;
                                result += "N";
                            }

                        } else {
                            if (reverseStep == index) {
                                curY -= curValue;
                                result += "N";

                            }else {
                                curY += curValue;
                                result += "S";
                            }

                        }
                        continue;
                    }
                    if (curY == 0 || (Math.abs(curX) - curValue == 0)) {
                        if (curX > 0) {
                            if (reverseStep == index) {
                                curX += curValue;
                                result += "W";

                            }
                            else{
                                curX -= curValue;
                                result += "E";
                            }
                        } else {
                            if (reverseStep == index) {
                                curX -= curValue;
                                result += "E";
                            }else {
                                curX += curValue;
                                result += "W";
                            }
                        }
                        continue;
                    }

                    if ((Math.abs(curX) - curValue < nextValue) ) {

                        if (curY > 0) {
                            if (reverseStep == index) {
                                curY += curValue;
                                result += "S";

                            }else {
                                curY -= curValue;
                                result += "N";
                            }
                        } else {
                            if (reverseStep == index) {
                                curY -= curValue;
                                result += "N";

                            }else {
                                curY += curValue;
                                result += "S";
                            }
                        }

                    } else {
                        if (curX > 0) {
                            if (reverseStep == index) {
                                curX += curValue;
                                result += "W";
                            }else {
                                curX -= curValue;
                                result += "E";
                            }
                        } else {
                            if (reverseStep == index) {
                                curX -= curValue;
                                result += "E";
                            } else {
                                curX += curValue;
                                result += "W";
                            }
                        }
                    }
                }

            }
            System.out.println(result);

        }

    }
}