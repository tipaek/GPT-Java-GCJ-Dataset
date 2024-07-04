import java.util.*;
import java.io.*;
public class Solution {
    private static char DONE = '_';
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ti = 1; ti <= t; ++ti) {
            char[] input = in.next().toCharArray();
            char[] wip = zeroToDone(input);
            int tmp = 0;
            while (isDone(wip)) {
                if (tmp++ == 10) return;
                int start = 0;
                int end = 0;
                boolean digitChecked = false;
                for (int i=0; i<wip.length; i++) {
                    if ( digitChecked ) {
                        if ( Character.isDigit(wip[i]) ) {
                            end = i;
                        } else {
                            wip = setParenthes(wip, start, end);
                            digitChecked = false;
                            break;
                        }
                    }
                    if ( !digitChecked && Character.isDigit(wip[i]) ) {
                        digitChecked = true;
                        start = i;
                        end = start;
                    }
                }
                if (digitChecked) {
                    wip = setParenthes(wip, start, end);
                }
//                System.out.println("wip = " + String.valueOf(wip));
            }

            int changed = 0;
            for(int i=0; i<wip.length; i++) {
                if(wip[i] == DONE) {
                    wip[i] = input[changed++];
                }
            }
            System.out.println("Case #" + ti + ": " + String.valueOf(wip));
        }
    }
    private static char[] zeroToDone(char[] input) {
        return String.valueOf(input).replace('0', DONE).toCharArray();
    }

    private static boolean isDone(char[] input) {
        return String.valueOf(input).matches(".*\\d.*");
    }
    private static char[] setParenthes(char[] wip, int start, int end) {
//        System.out.println("wip = " + String.valueOf(wip) + ", start = " + start + ", end = " + end);
        char[] parenthesAdded = new char[wip.length + 2];
        int pindex = 0;
        for (int i=0; i<wip.length; i++) {
            if (i == start) {
                parenthesAdded[pindex++] = '(';
            }
            if (i >= start && i <= end) {
                if (wip[i] == '1') {
                    parenthesAdded[pindex++] = DONE;
                } else {
                    parenthesAdded[pindex++] = Character.forDigit(
                            (Character.getNumericValue(wip[i]) - 1), 10
                    );
                }
            } else {
                parenthesAdded[pindex++] = wip[i];
            }
            if (i == end) {
                parenthesAdded[pindex++] = ')';
            }

        }
        return parenthesAdded;
    }
}