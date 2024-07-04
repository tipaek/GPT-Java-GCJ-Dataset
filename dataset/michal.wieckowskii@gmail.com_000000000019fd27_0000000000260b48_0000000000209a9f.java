import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solveCase(in, i);
        }
    }

    public static void solveCase(Scanner in, int caseNb) {
        //Split into array
        String[] strArray = in.nextLine().split("");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        //Find where monothonicy is changing
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        final LinkedList<Integer> indexesOfPeaks = new LinkedList<>();

        for (int i = 1; i < intArray.length - 1; i++) {
            int currentValue = intArray[i];
            int previousValue = intArray[i - 1];
            int nextValue = intArray[i + 1];

            if (previousValue > currentValue && nextValue > currentValue) {
                indexesOfPeaks.add(i);
                isDecreasing = false;
            } else if (previousValue < currentValue && nextValue < currentValue) {
                indexesOfPeaks.add(i);
                isIncreasing = false;
            } else if (previousValue < currentValue && nextValue > currentValue) {
                continue;
            } else if (previousValue > currentValue && nextValue < currentValue) {
                continue;
            } else if (previousValue > currentValue && nextValue == currentValue) {
                isDecreasing = true;
                continue;
            } else if (previousValue < currentValue && nextValue == currentValue) {
                isIncreasing = true;
                continue;
            } else if ((isIncreasing || isDecreasing) && nextValue == currentValue) {
                continue;
            } else if (isIncreasing && nextValue > currentValue) {
                continue;
            } else if (isDecreasing && nextValue < currentValue) {
                continue;
            } else if (isIncreasing && nextValue < currentValue) {
                indexesOfPeaks.add(i);
                isIncreasing = false;
            } else if (isDecreasing && nextValue > currentValue) {
                indexesOfPeaks.add(i);
                isDecreasing = false;
            }
        }
        if (isIncreasing || isDecreasing || indexesOfPeaks.isEmpty()) {
            indexesOfPeaks.add(intArray.length - 1);
        } else {
            indexesOfPeaks.add(intArray.length);
        }


        //Combine string
        String answer = "";
        int p, n;
        int indexOfPeak = indexesOfPeaks.removeFirst();
        answer = Integer.toString(intArray[indexOfPeak]);

        //moving back
        if (indexOfPeak - 1 >= 0) {
            p = indexOfPeak;
        } else {
            answer = addParenthesis(answer, false, intArray[indexOfPeak], true);
            p = -1;
        }
        while (p > 0) {
            if (intArray[p] == intArray[p - 1]) {
                answer = intArray[p - 1] + answer;
            } else {
                answer = intArray[p - 1] + addParenthesis(answer, false, Math.abs(intArray[p] - intArray[p - 1]), intArray[p] > intArray[p - 1]);
            }
            p--;
        }

//        answer = intArray[p] + answer;
        if (p!=-1 && intArray[p] != 0) {
            answer = addParenthesis(answer, false, intArray[p], true);
        }

        //moving next

        if (indexOfPeak + 1 <= intArray.length - 1) {
            n = indexOfPeak;
        } else {
            answer = addParenthesis(answer, true, intArray[indexOfPeak], false);
            n = -1;
        }
        int nextPeak = -1;
        while (!indexesOfPeaks.isEmpty()) {
            nextPeak = indexesOfPeaks.removeFirst();
            while (n <= nextPeak && n+1 < intArray.length) {
                if (intArray[n] == intArray[n + 1]) {
                    answer = answer + intArray[n];
                } else {
                    answer = addParenthesis(answer, true, Math.abs(intArray[n] - intArray[n + 1]), intArray[n] < intArray[n + 1]) + intArray[n+1];
                }
                n++;
            }
            if (n+1 == intArray.length && intArray[n] != 0) {
                answer = addParenthesis(answer, true, intArray[n], false);
                n++;
            }
        }
//        if (nextPeak == -1) {
//            answer = addParenthesis(answer, true, intArray[indexOfPeak], false);
//        }

        System.out.println("Case #" + caseNb + ": " + answer);
//        if (indexOfPeak - 1 >= 0) {
//            p = indexOfPeak - 1;
//        } else {
//            answer = addParenthesis(answer, false, intArray[indexOfPeak], false);
//            p = -1;
//        }
//        while (p - 1 >= 0) {
//            if (intArray[p] == intArray[p - 1]) {
//                answer = intArray[p] + answer;
//            } else {
//                answer = addParenthesis(answer, false, Math.abs(intArray[p] - intArray[p - 1]), intArray[p] > intArray[p - 1]);
//            }
//        }
//        if (intArray[p] != 0) {
//            answer = addParenthesis(answer, false, intArray[p], false);
//        }
//
//        if (indexOfPeak + 1 < intArray.length) {
//            n = indexOfPeak + 1;
//        } else {
//            answer = addParenthesis(answer, true, intArray[indexOfPeak], true);
//            n = -1;
//        }
//
//        if (intArray[indexOfPeak] == intArray[p]) {
//
//        }


    }

    public static String addParenthesis(String base, boolean inFront, int nb, boolean fronParenth) {
        final String parenth = fronParenth ? "(" : ")";

        if (!inFront) {
            for (int i = 0; i < nb; i++) {
                base = parenth + base;
            }
        } else {
            for (int i = 0; i < nb; i++) {
                base = base + parenth;
            }
        }
        return base;
    }
}
