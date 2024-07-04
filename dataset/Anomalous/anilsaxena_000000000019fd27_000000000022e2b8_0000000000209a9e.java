import java.io.*;
import java.util.*;

public class Solution {
    private static boolean debug = false;
    private static FileWriter fileWriter;
    private static int B, queryCount;

    public static void main(String[] args) {
        solveProblem(System.in);
    }

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int t = sc.nextInt();
        B = sc.nextInt();
        for (int i = 1; i <= t; ++i) {
            if (B == 10) {
                solveTestCaseB10(sc);
            } else if (B == 20) {
                solveTestCaseB20(sc);
            } else {
                solveTestCaseB100(sc);
            }
        }
    }

    private static void solveTestCaseB10(Scanner sc) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            printOut(String.valueOf(i + 1));
            result.append(sc.nextInt());
        }
        printOut(result.toString());
        checkResult(sc);
    }

    private static void solveTestCaseB20(Scanner sc) {
        boolean[] same = new boolean[B / 2];
        findSameness(sc, 0, same);
        findSameness(sc, 5, same);
        int[] answer = new int[B];
        findAnswers(sc, 0, answer);
        for (int i = 0; i < B / 2; i++) {
            answer[B - i - 1] = same[i] ? answer[i] : 1 - answer[i];
        }
        printResult(sc, answer);
    }

    private static void solveTestCaseB100(Scanner sc) {
        int[] batchNumbers = new int[B / 2];
        Arrays.fill(batchNumbers, -1);
        int[] batchIndexes = new int[4];
        Arrays.fill(batchIndexes, -1);

        for (int i = 0; i < 12; i++) {
            writeOutput("Queries: " + queryCount);
            int sameIndexDigit = getBatchDigit(sc, batchIndexes, 0, 1);
            int diffIndexDigit = getBatchDigit(sc, batchIndexes, 2, 3);
            if (sameIndexDigit == -1) getResult(sc, 1);
            if (diffIndexDigit == -1) getResult(sc, 1);

            int startIndex = 5 + (i * 4);
            findBatchNumber(sc, startIndex, 4, batchNumbers);
            adjustBatchNumbers(batchNumbers, startIndex, sameIndexDigit, diffIndexDigit);
            findBatchIndexes(batchNumbers, batchIndexes);
        }

        writeOutput("Queries: " + queryCount);
        int[] batchDigits = getBatchDigits(sc, batchIndexes);
        int[] answer = computeFinalAnswer(batchNumbers, batchDigits);
        printResult(sc, answer);
    }

    private static int getBatchDigit(Scanner sc, int[] batchIndexes, int idx1, int idx2) {
        if (batchIndexes[idx1] != -1) {
            return getResult(sc, batchIndexes[idx1] + 1);
        } else if (batchIndexes[idx2] != -1) {
            return 1 - getResult(sc, batchIndexes[idx2] + 1);
        }
        return -1;
    }

    private static void adjustBatchNumbers(int[] batchNumbers, int startIndex, int sameIndexDigit, int diffIndexDigit) {
        if (sameIndexDigit == 0) {
            for (int j = startIndex; j < startIndex + 4 && j < batchNumbers.length; j++) {
                if (batchNumbers[j] < 2) batchNumbers[j] = 1 - batchNumbers[j];
            }
        }
        if (diffIndexDigit == 0) {
            for (int j = startIndex; j < startIndex + 4 && j < batchNumbers.length; j++) {
                if (batchNumbers[j] >= 2) batchNumbers[j] = 5 - batchNumbers[j];
            }
        }
    }

    private static int[] getBatchDigits(Scanner sc, int[] batchIndexes) {
        int[] batchDigits = new int[4];
        for (int i = 0; i < batchIndexes.length; i++) {
            if (batchIndexes[i] != -1) {
                batchDigits[i] = getResult(sc, batchIndexes[i] + 1);
            }
        }
        return batchDigits;
    }

    private static int[] computeFinalAnswer(int[] batchNumbers, int[] batchDigits) {
        int[] answer = new int[B];
        for (int i = 0; i < batchNumbers.length; i++) {
            int batchNum = batchNumbers[i];
            answer[i] = batchDigits[batchNum];
            if (batchNum < 2) {
                answer[B - i - 1] = answer[i];
            } else {
                answer[B - i - 1] = 1 - answer[i];
            }
        }
        return answer;
    }

    private static void findSameness(Scanner sc, int startIndex, boolean[] same) {
        for (int i = startIndex; i < startIndex + 5; i++) {
            printOut(String.valueOf(i + 1));
            int left = sc.nextInt();
            printOut(String.valueOf(B - i));
            int right = sc.nextInt();
            same[i] = (left == right);
        }
    }

    private static void findAnswers(Scanner sc, int startIndex, int[] answers) {
        for (int i = startIndex; i < startIndex + 10; i++) {
            printOut(String.valueOf(i + 1));
            answers[i] = sc.nextInt();
        }
    }

    private static void findBatchIndexes(int[] batchNumbers, int[] batchIndexes) {
        Arrays.fill(batchIndexes, -1);
        for (int i = 0; i < batchNumbers.length; i++) {
            if (batchNumbers[i] != -1 && batchIndexes[batchNumbers[i]] == -1) {
                batchIndexes[batchNumbers[i]] = i;
            }
        }
    }

    private static void findBatchNumber(Scanner sc, int startIndex, int count, int[] batchNumbers) {
        for (int i = startIndex; i < startIndex + count; i++) {
            if (i < B / 2) {
                int left = getResult(sc, i + 1);
                int right = getResult(sc, B - i);
                batchNumbers[i] = (left << 1) | right;
            } else {
                getResult(sc, 1);
                getResult(sc, 1);
            }
        }
    }

    private static int getResult(Scanner sc, int index) {
        printOut(String.valueOf(index));
        return sc.nextInt();
    }

    private static void printOut(String out) {
        queryCount++;
        System.out.println(out);
    }

    private static void printResult(Scanner sc, int[] answer) {
        StringBuilder result = new StringBuilder();
        for (int value : answer) {
            result.append(value);
        }
        printOut(result.toString());
        checkResult(sc);
    }

    private static void checkResult(Scanner sc) {
        String resultResponse = sc.next();
        if (!"Y".equals(resultResponse)) {
            throw new AssertionError("Failed " + resultResponse);
        }
    }

    private static void writeOutput(String text) {
        if (!debug) {
            return;
        }
        try {
            if (fileWriter == null) {
                fileWriter = new FileWriter("input.out");
            }
            fileWriter.write(text);
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}