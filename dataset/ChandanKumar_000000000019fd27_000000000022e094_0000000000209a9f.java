
import java.util.*;
import java.io.*;

public class Solution {

    private static StringBuilder sbFinal;

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        String[] finalArray = new String[T];

        for (int i = 1; i <= T; ++i) {

            StringBuilder sbOriginal = new StringBuilder(in.next());
            sbFinal = new StringBuilder();

            int openCount = 0;

            for (int j = 0; j < sbOriginal.length();) {

                int element = getRequiredInteger(sbOriginal.charAt(j));

                int openRequired = element - openCount;

                for (int k = 1; k <= openRequired; k++) {
                    sbFinal.append('(');
                }

                sbFinal.append(element);

                int nextIndex = getNextDifferent(sbOriginal, j + 1, element);
                int closeRequired;

                if (nextIndex >= sbOriginal.length()) {

                    closeRequired = openCount + openRequired;

                    for (int k = 1; k <= closeRequired; k++) {
                        sbFinal.append(')');
                    }
                } else {

                    int nextElement = getRequiredInteger(sbOriginal.charAt(nextIndex));

                    if (nextElement < element) {

                        closeRequired = element - nextElement;

                        for (int k = 0; k < closeRequired; k++) {
                            sbFinal.append(')');
                        }
                    } else {
                        closeRequired = 0;
                    }
                }

                openCount = openCount + openRequired - closeRequired;
                j = nextIndex;
            }

            finalArray[i - 1] = sbFinal.toString();
        }

        for (int i = 0; i < finalArray.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, finalArray[i]));
        }
    }

    private static int getRequiredInteger(char character) {
        return character - 48;
    }

    private static int getNextDifferent(StringBuilder sb, int index, int element) {

        if (index >= sb.length()) {
            return index;
        }

        int i;

        for (i = index; i < sb.length(); i++) {

            if (getRequiredInteger(sb.charAt(i)) != element) {
                return i;
            } else {
                sbFinal.append(sb.charAt(i));
            }
        }

        return i;
    }
}
