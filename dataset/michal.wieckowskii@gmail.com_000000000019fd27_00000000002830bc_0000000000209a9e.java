import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] values = in.nextLine().split(" ");
        int t = Integer.parseInt(values[0]);  // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = Integer.parseInt(values[1]);  // Scanner has functions to read ints, longs, strings, chars, etc.

        if (b == 10) {
            for (int i = 1; i <= t; ++i) {
                if (!solveCase10(in, b)) {
                    break;
                }
            }
        } else {
            for (int i = 1; i <= t; ++i) {
                processTestCaseBig(in, b);
            }
        }


    }

    private static void processTestCaseBig(Scanner in, int b) {
        int[] answer = new int[b];
        for (int i = 0; i < b; i++) {
            answer[i] = -1;
        }

        int[] values = get10(in, b);
        for (int i = 0; i < 5; i++) {
            answer[i] = values[i];
            answer[b - 1 - i] = values[9 - i];
        }

        int[] newOldValuesArray = new int[6];
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1);
            newOldValuesArray[i] = Integer.parseInt(in.nextLine());
            System.out.println(b - i);
            newOldValuesArray[5 - i] = Integer.parseInt(in.nextLine());
        }
        for (int q = 0; q < 3; q++) {
            //1.
            boolean complemented = true;
            int[] complementedValues = complement(values);
            for (int i = 0; i < 3; i++) {
                if (complementedValues[i] == newOldValuesArray[i] && complementedValues[5 - i] == newOldValuesArray[5 - i])
                    continue;
                else complemented = false;
            }

            //2.
            boolean swapped = true;
            int[] swappedValues = swap(values);
            for (int i = 0; i < 3; i++) {
                if (swappedValues[i] == newOldValuesArray[i] && swappedValues[5 - i] == newOldValuesArray[5 - i])
                    continue;
                else swapped = false;
            }

            //3.
            boolean swappedAndComplemented = true;
            int[] swappedAndComplementedValues = swap(values);
            for (int i = 0; i < 3; i++) {
                if (swappedAndComplementedValues[i] == newOldValuesArray[i] && swappedAndComplementedValues[5 - i] == newOldValuesArray[5 - i])
                    continue;
                else swappedAndComplemented = false;
            }

            if (swapped) {
                values = swap(values);
            } else if (complemented) {
                values = complement(values);
            } else {
                values = swapAndComplement(values);
            }
            int start = q*4+6;
            for(int i=start;i<start+4;i++) {
                System.out.println(i);
                values[i-1] = Integer.parseInt(in.nextLine());
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<values.length;i++){
            sb.append(values[i]);
        }
    }


    private static int[] complement(int[] array) {
        int newLength = array.length;
        int[] copiedArray = Arrays.copyOf(array, newLength);
        for (int i = 0; i < newLength; i++) {
            if (copiedArray[i] == -1) continue;
            copiedArray[i] = copiedArray[i] == 0 ? 1 : 0;
        }
        return copiedArray;
    }

    private static int[] swap(int[] array) {
        int newLength = array.length;
        int[] copiedArray = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            copiedArray[i] = array[newLength - 1 - i];
        }
        return copiedArray;
    }

    private static int[] swapAndComplement(int[] array) {
        int[] swaped = swap(array);
        return complement(swaped);
    }


    private static int[] get10(Scanner in, int b) {
        int[] answer = new int[10];
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1);
            int value = Integer.parseInt(in.nextLine());
            answer[i] = value;
        }
        for (int i = b - 1; i > b - 6; i--) {
            System.out.println(i);
            int value = Integer.parseInt(in.nextLine());
            answer[10 - (b - i)] = value;
        }
        return answer;
    }

    private static boolean solveCase10(Scanner in, int b) {
        int[] answer = new int[b];
        for (int i = 0; i < b; i++) {
            System.out.println(i + 1);
            int value = Integer.parseInt(in.nextLine());
            answer[i] = value;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]);
        }

        System.out.println(sb.toString());
        String judgeAnswer = in.nextLine();
        return judgeAnswer.equalsIgnoreCase("Y");
    }

}
