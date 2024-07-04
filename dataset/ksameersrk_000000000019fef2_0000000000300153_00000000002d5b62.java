//package round1b.q1;

import java.util.*;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            long x = in.nextLong();
            long y = in.nextLong();
            long sum = Math.abs(x) + Math.abs(y);
            StringBuilder stringBuilder = new StringBuilder();
            String binString = Long.toBinaryString(sum);
            int numZeros = 0;
            for(char c : binString.toCharArray()) {
                if(c == '0') numZeros++;
            }
            if(numZeros < 2) {
                if(numZeros == 0) {
                    char[] binStringX = Long.toBinaryString(Math.abs(x)).toCharArray();
                    char[] binStringY = Long.toBinaryString(Math.abs(y)).toCharArray();
                    boolean xPos = x >= 0;
                    boolean yPos = x >= 0;
                    int maxLen = Math.max(binStringX.length, binStringY.length);
                    int xLength = binStringX.length;
                    int yLength = binStringY.length;
                    for(int i=0; i<maxLen; i++) {
                        boolean isChanged = false;
                        if(i<xLength) {
                            if(binStringX[xLength-1-i] == '1') {
                                if(xPos) stringBuilder.append("E");
                                else stringBuilder.append("W");
                                isChanged = true;
                            }
                        }
                        if(i<yLength) {
                            if(binStringY[yLength-1-i] == '1') {
                                if(yPos) stringBuilder.append("N");
                                else stringBuilder.append("S");
                                isChanged = true;
                            }
                        }
                        if(!isChanged) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("IMPOSSIBLE");
                        }
                    }
                } else {
                    boolean labelChanged = false;
                    if(Math.abs(x) > Math.abs(y)) {
                        long tmp = x;
                        x = y;
                        y = tmp;
                        labelChanged = true;
                    }

                    char[] binStringX = Long.toBinaryString(Math.abs(x)).toCharArray();
                    char[] binStringY = Long.toBinaryString(Math.abs(y)).toCharArray();


                    long yAbs = Math.abs(y);
                    long yAbsMax = 1 << binStringY.length;
                    long yNew = 2* yAbsMax - yAbs;
                    binStringY = Long.toBinaryString(Math.abs(yNew)).toCharArray();

                    int isChanged = 0;
                    boolean xPos = x >= 0;
                    boolean yPos = x < 0;
                    int maxLen = Math.max(binStringX.length, binStringY.length);
                    int xLength = binStringX.length;
                    int yLength = binStringY.length;
                    for(int i=0; i<maxLen-1; i++) {
                        isChanged = 0;
                        if(i<xLength) {
                            if(binStringX[xLength-1-i] == '1') {
                                if(labelChanged) {
                                    if(yPos) stringBuilder.append("N");
                                    else stringBuilder.append("S");
                                } else {
                                    if(xPos) stringBuilder.append("E");
                                    else stringBuilder.append("W");
                                }
                                isChanged++;
                            }
                        }
                        if(i<yLength) {
                            if(binStringY[yLength-1-i] == '1') {
                                if(labelChanged) {
                                    if(xPos) stringBuilder.append("E");
                                    else stringBuilder.append("W");
                                } else {
                                    if(yPos) stringBuilder.append("N");
                                    else stringBuilder.append("S");
                                }
                                isChanged++;
                            }
                        }
                        if(isChanged != 1) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("IMPOSSIBLE");
                            break;
                        }
                    }
                    if(isChanged == 1) {
                        if(labelChanged) {
                            if(yPos) {
                                stringBuilder.append("W");
                            } else {
                                stringBuilder.append("E");
                            }
                        } else {
                            if(yPos) {
                                stringBuilder.append("S");
                            } else {
                                stringBuilder.append("N");
                            }
                        }
                    }

                }
            }
            else {
                stringBuilder.append("IMPOSSIBLE");
            }
            System.out.println(String.format("Case #%d: %s", t, stringBuilder.toString()));
        }
    }
}
