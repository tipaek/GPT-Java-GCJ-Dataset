import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        PrintWriter out = new PrintWriter(System.out);
        for (int t1 = 1; t1 <= t; t1++) {
            char[] sequence = f.readLine().toCharArray();
            int[] digits = new int[sequence.length];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = sequence[i] - '0';
            }
            int[] originalDigits = Arrays.copyOf(digits, digits.length);

            int[] numOfOpenPar = new int[sequence.length];
            int[] numOfClosedPar = new int[sequence.length + 1];
            while (true) {
                int start = -1;
                int end = sequence.length;
                for (int i = 0; i < sequence.length; i++) {
                    if (start == -1 && digits[i] != 0) {
                        start = i;
                    }
                    if (start != -1 && digits[i] == 0) {
                        end = i;
                        break;
                    }
                }
                if (start == -1) {
                    break;
                }

                numOfOpenPar[start]++;
                numOfClosedPar[end]++;
                for (int i = start; i < end; i++) {
                    digits[i]--;
                }
            }

            out.print("Case #");
            out.print(t1);
            out.print(": ");
            for (int i = 0; i < sequence.length; i++) {
                for (int j = 0;  j< numOfClosedPar[i]; j++) {
                    out.print(")");
                }
                for (int j = 0; j < numOfOpenPar[i]; j++) {
                    out.print("(");
                }
                out.print(originalDigits[i]);
            }
            for (int j = 0; j < numOfClosedPar[sequence.length]; j++) {
                out.print(")");
            }

            out.println();
        }

        out.close();
    }
}
