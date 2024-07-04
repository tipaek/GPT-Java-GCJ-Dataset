import java.io.*;
import java.util.*;

public class Solution {
    private static boolean debug = false;
    private static FileWriter fileWriter;

    private static int B, queryCount;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int t = sc.nextInt();
        B = sc.nextInt();
        for (int i = 1; i <= t; ++i) {
            if(B == 10) {
                solveTestCaseB100(sc);
            }else if(B == 20){
                solveTestCaseB20(sc);
            }else{
                solveTestCaseB100(sc);
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

            throw new AssertionError("Failed " + resultResponse );
        }
    }

    private static void solveTestCaseB100(Scanner sc) {
        int[] batchNumbers = new int[B / 2];
        Arrays.fill(batchNumbers, -1);
        int[] batchIndexes = new int[4];
        Arrays.fill(batchIndexes, -1);

        findBatchNumber(sc, 0, 5, batchNumbers);
        findBatchIndexes(batchNumbers, batchIndexes);
        for(int i = 0; i < 12; i++){
            writeOutput("Queries: " + queryCount);
            int sameIndexDigit = -1;
            int diffIndexDigit = -1;
            if(batchIndexes[0] != -1){
                sameIndexDigit = getResult(sc, batchIndexes[0] + 1);
            }else if(batchIndexes[1] != -1){
                sameIndexDigit = getResult(sc, batchIndexes[1] + 1);
                sameIndexDigit = sameIndexDigit == 1 ? 0 : 1;
            }
            if(batchIndexes[2] != -1){
                diffIndexDigit = getResult(sc, batchIndexes[2] + 1);
            }else if(batchIndexes[3] != -1){
                diffIndexDigit = getResult(sc, batchIndexes[3] + 1);
                diffIndexDigit = diffIndexDigit == 1 ? 0 : 1;
            }
            if(sameIndexDigit == -1){
                //waste it
                getResult(sc, 1);
            }
            if(diffIndexDigit == -1){
                getResult(sc, 1);
            }
            int startIndex = 5 + (i * 4);
            findBatchNumber(sc, startIndex, 4, batchNumbers);
            if(sameIndexDigit == 0){
                for(int j  = startIndex; j < startIndex + 4 && j < batchNumbers.length; j++) {
                    if (batchNumbers[j] < 2) {
                        batchNumbers[j] = batchNumbers[j] == 0 ? 1 : 0;
                    }
                }
            }
            if(diffIndexDigit == 0){
                for(int j  = startIndex; j < startIndex + 4 && j < batchNumbers.length; j++) {
                    if (batchNumbers[j] >= 2) {
                        batchNumbers[j] = batchNumbers[j] == 2 ? 3 : 2;
                    }
                }
            }
            findBatchIndexes(batchNumbers, batchIndexes);
        }


      //  writeOutput(printArr(batchNumbers));
        writeOutput("Queries: " + queryCount);
        int[] batchDigits = new int[4];
        for(int i = 0; i < batchIndexes.length; i++){
            if(batchIndexes[i] != -1) {
                batchDigits[i] = getResult(sc, batchIndexes[i] + 1);
            }
        }
        writeOutput(printArr(batchNumbers));
        writeOutput(printArr(batchIndexes));
        writeOutput(printArr(batchDigits));
        int[] answer = new int[B];
        for(int i = 0; i < batchNumbers.length; i++){
            int batchNum = batchNumbers[i];
            answer[i] = batchDigits[batchNum];
            if(batchNum < 2){
                answer[B-i-1] = answer[i];
            }else{
                answer[B-i-1] = answer[i] == 1 ? 0 : 1;
            }
        }
        String result = "";
        for(int i = 0; i < B; i++){
            result += answer[i];
        }
        printOut(String.valueOf(result));
        String resultResponse = sc.next();
        if (!resultResponse.equals("Y")) {
            throw new AssertionError("Failed " + resultResponse );
        }
    }

    private static int getResult(Scanner sc, int index){
        printOut(String.valueOf(index));
        return sc.nextInt();
    }

    private static void findBatchIndexes(int[] batchNumbers, int[] batchIndexes){
        Arrays.fill(batchIndexes, -1);
        for(int i = 0; i < batchNumbers.length; i++){
            if(batchNumbers[i] != -1 && batchIndexes[batchNumbers[i]] == -1){
                batchIndexes[batchNumbers[i]] = i;
            }
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

    private static void findBatchNumber(Scanner sc, int startIndex, int count, int[] batchNumbers){
        for(int i = startIndex; i < startIndex + count; i++){
            if(i < B/2) {
                int left = getResult(sc, i + 1);
                int right = getResult(sc, B - i);
                if (left == 1 && right == 1) {
                    batchNumbers[i] = 0;
                } else if (left == 0 && right == 0) {
                    batchNumbers[i] = 1;
                } else if (left == 1 && right == 0) {
                    batchNumbers[i] = 2;
                } else if (left == 0 && right == 1) {
                    batchNumbers[i] = 3;
                }
            }else{
                getResult(sc, 1);
                getResult(sc, 1);
            }
        }
    }

    private static void printOut(String out) {
        queryCount++;
        System.out.println(out);
    }

    public static String printArr(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int in : arr) {
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

    private static void writeOutput(String text){
        if(!debug){
            return;
        }
        try {
            if(fileWriter == null){
                fileWriter =  new FileWriter("input.out");
            }
            fileWriter.write(text);
            fileWriter.write("\n");
            fileWriter.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        solveProblem(System.in);
    }
}
