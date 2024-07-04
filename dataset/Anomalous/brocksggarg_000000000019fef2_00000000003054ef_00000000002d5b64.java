import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Solution solution = new Solution();
        for (int i = 1; i <= t; i++) {
            solution.solve(i, br);
        }
    }

    private void solve(int t, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        StringBuilder sequence = new StringBuilder();
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                sequence.append(j);
            }
        }

        int resultCount = 0;
        ArrayList<String> results = new ArrayList<>();
        int currentNumber = x;
        int remainingCount = y;
        int sequenceLength = sequence.length() - 1;

        while (true) {
            if (sequence.charAt(sequenceLength) - '0' == currentNumber && remainingCount == y) {
                --remainingCount;
                continue;
            }

            int end2 = findEnd(sequence, sequenceLength, currentNumber);
            int end1 = findEnd(sequence, end2 - 1, currentNumber);

            resultCount++;
            int r1 = end1 + 1;
            int r2 = end2 - end1;
            results.add(r1 + " " + r2);

            String temp = sequence.substring(end1 + 1, end2 + 1) + sequence.substring(0, end1 + 1) + sequence.substring(end2 + 1);
            sequence = new StringBuilder(temp);

            --remainingCount;
            if (remainingCount == 0) {
                remainingCount = y;
                --currentNumber;
                sequenceLength -= y;
            }

            if (currentNumber == 1) {
                break;
            }
        }

        System.out.println("Case #" + t + ": " + resultCount);
        for (String res : results) {
            System.out.println(res);
        }
    }

    private int findEnd(StringBuilder sequence, int start, int currentNumber) {
        for (int i = start; i >= 0; i--) {
            if (currentNumber != sequence.charAt(i) - '0') {
                return i;
            }
        }
        return -1;
    }
}