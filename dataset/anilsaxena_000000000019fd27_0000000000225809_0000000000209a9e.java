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
            if(B == 10) {
                solveTestCaseB10(sc);
            }else if(B == 20){
                solveTestCaseB20(sc);
            }else{
                // solveTestCase(sc);
            }
        }
    }

    private static void solveTestCaseB10(Scanner sc) {
        String result = "";
        for (int i = 0; i < 10; i++) {
            printOut(String.valueOf(i + 1));
            result += sc.nextInt();
        }

        printOut(String.valueOf(result));
        String resultResponse = sc.next();
        if (!resultResponse.equals("Y")) {
            throw new AssertionError("Failed " + resultResponse);
        }
    }

    private static void solveTestCaseB20(Scanner sc) {
        boolean[] same = new boolean[B / 2];
        findSameness(sc, 0, same);
        findSameness(sc, 5, same);
        int[] answer = new int[B];
        findAnswers(sc, 0, answer);
        for(int i = 0; i < B/2; i++){
            if(same[i]){
                answer[B - i - 1] = answer[i];
            }else{
                answer[B - i - 1] = answer[i] == 1 ? 0 : 1;
            }
        }
        String result = "";
        for(int i = 0; i < B; i++){
            result += answer[i];
        }
        printOut(String.valueOf(result));
        String resultResponse = sc.next();
        if (!resultResponse.equals("Y")) {

            throw new AssertionError("Failed " + resultResponse + "\n" + printArr(same));
        }
    }

    private static void findAnswers(Scanner sc, int startIndex, int[] answers) {
        for (int i = startIndex; i < startIndex + 10; i++) {
            printOut(String.valueOf(i + 1));
            answers[i] = sc.nextInt();
        }
    }

    private static void findSameness(Scanner sc, int startIndex, boolean[] same){
        for(int i = startIndex; i < startIndex + 5; i++){
            printOut(String.valueOf(i + 1));
            int left = sc.nextInt();
            printOut(String.valueOf(B - i));
            int right = sc.nextInt();
            if(left == right){
                same[i] = true;
            }
        }
    }

    private static void printOut(String out) {
        System.out.println(out);
    }

    public static String printArr(boolean[] arr) {
        StringBuilder builder = new StringBuilder();
        for (boolean in : arr) {
            builder.append(in + " ");
        }
       return builder.toString();
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
