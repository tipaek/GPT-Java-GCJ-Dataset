import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            new Solution().solve(i, br);
        }
    }

    private void solve(int caseNumber, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        StringBuilder sequence = new StringBuilder();
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                sequence.append(j);
            }
        }

        int operations = 0;
        ArrayList<String> results = new ArrayList<>();
        int currentNumber = x;
        int remainingSwaps = y - 1;
        int sequenceLength = sequence.length() - 1;

        while (currentNumber > 1) {
            int end2 = 0;
            int end1 = 0;

            for (int j = sequenceLength; j >= 0; j--) {
                if (currentNumber == Character.getNumericValue(sequence.charAt(j))) {
                    continue;
                } else {
                    end2 = j;
                    break;
                }
            }

            for (int j = end2; j >= 0; j--) {
                if (currentNumber == Character.getNumericValue(sequence.charAt(j))) {
                    end1 = j;
                    break;
                }
            }

            operations++;
            int r1 = end1 + 1;
            int r2 = end2 - end1;
            results.add(r1 + " " + r2);

            String temp = sequence.substring(end1 + 1, end2 + 1) + sequence.substring(0, end1 + 1) + sequence.substring(end2 + 1);
            sequence = new StringBuilder(temp);

            remainingSwaps--;
            if (remainingSwaps == 0) {
                remainingSwaps = y - 1;
                currentNumber--;
                sequenceLength -= y;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + operations);
        for (String result : results) {
            System.out.println(result);
        }
    }
}