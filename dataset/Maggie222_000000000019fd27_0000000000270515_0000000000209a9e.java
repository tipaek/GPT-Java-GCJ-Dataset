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
        int[] result = new int[bitNum];
        while(left <= right) {
            printCount(String.valueOf(left));
            int leftV = input.nextInt();
            input.nextLine();
            printCount(String.valueOf(right));
            int rightV = input.nextInt();
            input.nextLine();
            result[left - 1] = leftV;
            result[right - 1] = rightV;
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
                }
                if(diffMirror[0] != 0) {
                    hasDiffMirror = true;
                    printCount(String.valueOf(diffMirror[0]));
                    int curDiffMirrorV = input.nextInt();
                    input.nextLine();
                    isDiffMirrorUpdate = curDiffMirrorV != diffMirror[1];
                } else {
                    printCount("1");
                }
                if(!hasSameMirror && hasDiffMirror &&  isDiffMirrorUpdate
                || !hasDiffMirror && hasSameMirror && isSameMirrorUpdate) {
                    xor(result);
                } else if(hasDiffMirror && hasSameMirror && isSameMirrorUpdate && isDiffMirrorUpdate) {
                    xor(result);
                } else if(hasDiffMirror && hasSameMirror && isSameMirrorUpdate && !isDiffMirrorUpdate) {
                    xor(result);
                    reverse(result);
                } else if(hasDiffMirror && hasSameMirror && !isSameMirrorUpdate && isDiffMirrorUpdate) {
                    reverse(result);
                }
            }
            left ++;
            right --;

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bitNum; i ++) {
            sb.append(result[i]);
        }
        printCount(sb.toString());
        input.nextLine();
    }

    private static void printCount(String p) {
        out.println(p);
        out.flush();
        count ++;
    }

    private static void xor(int[] bits) {
        for(int i = 0; i < bits.length; i ++) {
            bits[i] = bits[i] == 1 ? 0 : 1;
        }
    }

    private static void reverse(int[] bits) {
        int left = 0;
        int right = bits.length - 1;
        while(left < right) {
            int temp = bits[left];
            bits[left] = bits[right];
            bits[right] = temp;
            left ++;
            right --;
        }
    }
}
