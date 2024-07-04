import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final PrintWriter out = new PrintWriter(System.out);

    public static void main(final String[] args) throws IOException {
        int t = in.nextInt();
        int test = 1;
        while (t > 0) {
            out.print("Case #" + test + ": ");
            extractedSolution(t);
            --t;
            test++;
        }
        out.flush();
        out.close();
        in.close();
    }

    private static void extractedSolution(int t) throws IOException {
        char[] charArray = in.next().toCharArray();
        int openingBracket = 0;
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] - '0') > openingBracket) {
                for (int j = openingBracket; j < (charArray[i] - '0'); j++) {
                    out.print('(');
                }
                openingBracket = (charArray[i] - '0');

            } else if ((charArray[i] - '0') < openingBracket) {

                for     (int j = openingBracket; j > (charArray[i] - '0'); --j) {
                    out.print(')');
                }
                openingBracket =     (charArray[i] - '0');
            }
            out.print(charArray[i]);
        }
        while (openingBracket > 0) {
            out.print(')');

            --openingBracket;
        }
        out.println();
    }
}