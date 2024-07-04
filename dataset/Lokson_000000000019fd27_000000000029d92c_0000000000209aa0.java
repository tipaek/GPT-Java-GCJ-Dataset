import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int size = in.nextInt();
            int trace = in.nextInt();
            Integer startingNumber = startingNumber(size, trace);
            if(startingNumber != null) {
                System.out.println(String.format("Case #%s: POSSIBLE", caseNumber));
                printResult(size, startingNumber);
            } else {
                System.out.println(String.format("Case #%s: IMPOSSIBLE", caseNumber));
            }
        }
    }

    private static void printResult(int size, int startingNumber) {
        String[] dummyTab = new String[size];
        for(int i = 0; i < size; i++) {
            int value = (i + startingNumber - 1) % size;
            dummyTab[i] = String.valueOf(value + 1);
        }
        for(int row = 1; row <= size; row++) {
            System.out.println(String.join(" ", dummyTab));

            String last = dummyTab[dummyTab.length-1];
            System.arraycopy(dummyTab, 0, dummyTab, 1, dummyTab.length-1 );
            dummyTab[0] = last;
        }
    }

    private static Integer startingNumber(int size, int trace) {
        if(trace >= size && trace <= (size*size)) {
            if(trace%size == 0) {
                return trace/size;
            }
        }
        return null;
    }

}