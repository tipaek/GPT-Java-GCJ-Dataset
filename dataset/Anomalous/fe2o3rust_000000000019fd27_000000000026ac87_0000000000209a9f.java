import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numCases; i++) {
            CaseInputs inputs = readCase(reader);
            CaseOutputs outputs = processCase(inputs);
            printOutput(i + 1, outputs);
        }
    }

    private static CaseOutputs processCase(CaseInputs inputs) {
        CaseOutputs outputs = new CaseOutputs();
        StringBuilder sb = new StringBuilder();
        int prevDigit = 0;

        for (int digit : inputs.digits) {
            int diff = prevDigit - digit;
            sb.append(")".repeat(Math.max(0, diff)));
            sb.append("(".repeat(Math.max(0, -diff)));
            sb.append(digit);
            prevDigit = digit;
        }

        sb.append(")".repeat(prevDigit));
        outputs.result = sb.toString();
        return outputs;
    }

    private static CaseInputs readCase(BufferedReader reader) throws IOException {
        CaseInputs inputs = new CaseInputs();
        String digitString = reader.readLine();
        int[] arr = new int[digitString.length()];

        for (int i = 0; i < digitString.length(); i++) {
            arr[i] = Character.digit(digitString.charAt(i), 10);
        }

        inputs.digits = arr;
        return inputs;
    }

    private static void printOutput(int caseNum, CaseOutputs outputs) {
        System.out.println("Case #" + caseNum + ": " + outputs.result);
    }

    public static class CaseInputs {
        public int[] digits;
    }

    public static class CaseOutputs {
        public String result;
    }
}