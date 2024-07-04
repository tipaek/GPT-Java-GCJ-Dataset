import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static int parseStringToInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int testCases = parseStringToInt(tokenizer.nextToken());
        int bitLength = parseStringToInt(tokenizer.nextToken());
        int attemptCounter = 1;

        if (bitLength == 10) {
            for (int testCaseIndex = 1; testCaseIndex <= testCases; testCaseIndex++) {
                StringBuilder resultBuilder = new StringBuilder();
                while (attemptCounter <= 10) {
                    bufferedWriter.write("1\n");
                    bufferedWriter.flush();
                    bufferedReader.readLine();
                    attemptCounter++;
                }
                for (int bitPosition = 1; bitPosition <= 10; bitPosition++) {
                    bufferedWriter.write(bitPosition + "\n");
                    bufferedWriter.flush();
                    resultBuilder.append(parseStringToInt(bufferedReader.readLine()));
                }
                resultBuilder.append("\n");
                bufferedWriter.write(resultBuilder.toString());
                bufferedWriter.flush();
                attemptCounter = 1;

                if (bufferedReader.readLine().equals("N")) {
                    break;
                }
            }
        } else {
            for (int testCaseIndex = 1; testCaseIndex <= testCases; testCaseIndex++) {
                StringBuilder resultBuilder = new StringBuilder();
                while (attemptCounter <= 150) {
                    bufferedWriter.write("1\n");
                    bufferedWriter.flush();
                    bufferedReader.readLine();
                    attemptCounter++;
                }
                for (int bitPosition = 1; bitPosition <= bitLength; bitPosition++) {
                    resultBuilder.append(0);
                }
                bufferedWriter.write(resultBuilder.toString());
                bufferedWriter.flush();
                attemptCounter = 1;

                if (bufferedReader.readLine().equals("N")) {
                    break;
                }
            }
        }

        bufferedWriter.close();
    }
}