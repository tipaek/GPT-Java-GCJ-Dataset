import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static int count = 0;

    public static void main(String[] args) {
        // Scanner has functions to read ints, longs, strings, chars, etc.
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int caseNum = input.nextInt();
        int bitNum = input.nextInt();
        input.nextLine();

        for(int i = 1; i <= caseNum; i ++) {
            solve(bitNum, input);
        }
    }

    private static void solve(int bitNum, Scanner input) {
        count = 0;
        int[] sameMirror = new int[2];
        int[] diffMirror = new int[2];
        int left = 1;
        int right = bitNum;
        int result = 0;
        while(left <= right) {
            printCount(String.valueOf(left));
            int leftV = input.nextInt();
            input.nextLine();
            printCount(String.valueOf(right));
            int rightV = input.nextInt();
            input.nextLine();

            result |= leftV << (bitNum - left);
            result |= rightV << (bitNum - right);
            if(sameMirror[0] == 0 && leftV == rightV) {
                sameMirror[0] = left;
                sameMirror[1] = leftV;
            }
            if(diffMirror[0] == 0 && leftV != rightV) {
                diffMirror[0] = left;
                diffMirror[1] = leftV;
            }

            // update existing bits when the bits change
            if(count % 10 == 0) {
                boolean isSameMirrorUpdate = false;
                boolean isDiffMirrorUpdate = false;
                boolean hasSameMirror = false;
                boolean hasDiffMirror = false;
                if(sameMirror[0] != 0) {
                    hasSameMirror = true;
                    printCount(String.valueOf(sameMirror[0]));
                    int curSameMirrorV = input.nextInt();
                    input.nextLine();
                    isSameMirrorUpdate = curSameMirrorV != sameMirror[1];
                } else {
                    printCount("1");
                    input.nextLine();
                }
                if(diffMirror[0] != 0) {
                    hasDiffMirror = true;
                    printCount(String.valueOf(diffMirror[0]));
                    int curDiffMirrorV = input.nextInt();
                    input.nextLine();
                    isDiffMirrorUpdate = curDiffMirrorV != diffMirror[1];
                } else {
                    printCount("1");
                    input.nextLine();
                }
                if(!hasSameMirror && hasDiffMirror &&  isDiffMirrorUpdate
                || !hasDiffMirror && hasSameMirror && isSameMirrorUpdate) {
                    xor(result, bitNum);
                } else if(hasDiffMirror && hasSameMirror && isSameMirrorUpdate && isDiffMirrorUpdate) {
                    xor(result, bitNum);
                } else if(hasDiffMirror && hasSameMirror && isSameMirrorUpdate && !isDiffMirrorUpdate) {
                    xor(result, bitNum);
                    reverse(result, bitNum);
                } else if(hasDiffMirror && hasSameMirror && !isSameMirrorUpdate && isDiffMirrorUpdate) {
                    reverse(result, bitNum);
                }
            }
            left ++;
            right --;

        }

        printCount(String.valueOf(result));
        input.nextLine();
    }

    private static void printCount(String p) {
        out.println(p);
        count ++;
    }

    private static void xor(int result, int bitNum) {
        for(int i = 0; i < bitNum; i ++) {
            result ^= 1 << i;
        }
    }

    private static void reverse(int result, int bitNum) {
        int left = 0;
        int right = bitNum - 1;
        while(left < right) {
            if((result & (1 << left)) != (result & (1 << right))) {
                result ^= 1 << left;
                result ^= 1 << right;
            }
            left ++;
            right --;
        }
    }
}