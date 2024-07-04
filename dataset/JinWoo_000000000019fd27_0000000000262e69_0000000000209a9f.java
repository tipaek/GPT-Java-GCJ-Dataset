import java.util.Scanner;

public class Solution {

    private static int addBraces(char[] a, int index, int amount, int state) {
        for (int i = 0; i < amount; i++) {
            if (state == 1) a[index + i] = '(';
            else a[index + i] = ')';
        }

        return index + amount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numCases; i++) {
            String input = in.nextLine();
            int sum = 0;
            int N = input.length();

            for (int j = 0; j < N; j++) {
                char c = input.charAt(j);
                int intC = Integer.parseInt(String.valueOf(c));
                sum += intC;
            }

            char[] output = new char[2 * sum + N];

            int j = 0;
            boolean start = true;
            boolean opening = true;
            int outIndex = 0;
            int outSize = 0;
            while (j < N) {
                if (start) {
                    char c = input.charAt(j);
                    int intC = Integer.parseInt(String.valueOf(c));
                    outIndex = addBraces(output, outIndex, intC, 1);
                    outSize += intC;
                    output[outIndex++] = input.charAt(j++);
                    outSize++;
                    start = false;
                }
                else {
                    char c = input.charAt(j);
                    char c_1 = input.charAt(j - 1);
                    int intC = Integer.parseInt(String.valueOf(c));
                    int intC_1 = Integer.parseInt(String.valueOf(c_1));
                    int diff = intC - intC_1;
                    if (diff > 0) {
                        if (opening) {
                            outIndex = addBraces(output, outIndex, diff, 1);
                        }
                        else {
                            outIndex = addBraces(output, outIndex, diff, 1);
                            opening = true;
                        }
                    }
                    else if (diff < 0) {
                        if (opening) {
                            outIndex = addBraces(output, outIndex, -diff, 0);
                            opening = false;
                        }
                        else {
                            outIndex = addBraces(output, outIndex, -diff, 0);
                        }
                    }
                    outSize += Math.abs(diff);
                    output[outIndex++] = input.charAt(j++);
                    outSize++;
                }
            }

            char c = input.charAt(--j);
            int intC = Integer.parseInt(String.valueOf(c));
            outIndex = addBraces(output, outIndex, intC, 0);
            outSize += intC;

            char[] newOut = new char[outSize];

            for (int k = 0; k < outSize; k++) newOut[k] = output[k];
            System.out.println("Case #" + (i + 1) + ": " + new String(newOut));
        }
    }
}