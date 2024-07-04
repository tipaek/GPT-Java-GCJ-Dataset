import java.io.*;
import java.util.*;

public class Solution {
    private static boolean debug = false;

    private static int B;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int t = sc.nextInt();
        B = sc.nextInt();
        for (int i = 1; i <= t; ++i) {
            solveTestCase(sc);
        }
    }

    private static void solveTestCase(Scanner sc) {
        List<int[]> answers = new ArrayList<>();
        
        for(int loop = 0; loop < 4; loop++) {
            int[] answer = new int[B];
            answers.add(answer);
            for (int i = 0; i < 10; i++) {
                printOut(String.valueOf(i + 1));
                answer[i] = sc.nextInt();
            }
        }
        String result = "";
        for(int num: answers.get(3)){
            result += num;
        }
        printOut(String.valueOf(result));
        String resultResponse = sc.next();
        if (!resultResponse.equals("Y")) {
            throw new AssertionError("Failed " + resultResponse);
        }
    }

    private static void printOut(String out) {
        System.out.println(out);
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println(str);
        }

    }

    private static String getTokenSeparatedString(Collection<?> listValues, String token) {
        StringBuilder strValue = new StringBuilder("");
        if (listValues != null) {
            int i = 0;
            for (Object v : listValues) {
                String value = v.toString();
                if (i == 0) {
                    strValue.append(value);
                } else {
                    strValue.append(token);
                    strValue.append(value);
                }
                i++;
            }
        }
        return strValue.toString();
    }

    public static void main(String[] args) {
        solveProblem(System.in);
    }
}
