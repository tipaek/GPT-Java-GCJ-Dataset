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
        
        // Generate the sequence string
        StringBuilder sequence = new StringBuilder();
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                sequence.append(j);
            }
        }

        int operations = 0;
        ArrayList<String> results = new ArrayList<>();
        int currentMax = x;
        int remainingCount = y;
        int sequenceLength = sequence.length() - 1;

        while (true) {
            if (sequence.charAt(sequenceLength) - '0' == currentMax && remainingCount == y) {
                remainingCount--;
                continue;
            }

            int end2 = findPosition(sequence, sequenceLength, currentMax, false);
            int end1 = findPosition(sequence, end2, currentMax, true);

            operations++;
            results.add((end1 + 1) + " " + (end2 - end1));
            
            // Rotate the sequence
            sequence = new StringBuilder(sequence.substring(end1 + 1, end2 + 1))
                        .append(sequence.substring(0, end1 + 1))
                        .append(sequence.substring(end2 + 1));

            remainingCount--;
            if (remainingCount == 0) {
                remainingCount = y;
                currentMax--;
                sequenceLength -= y;
            }

            if (currentMax == 1) {
                break;
            }
        }

        // Output the results
        System.out.println("Case #" + caseNumber + ": " + operations);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private int findPosition(StringBuilder sequence, int start, int target, boolean reverse) {
        for (int i = start; i >= 0; i--) {
            if (sequence.charAt(i) - '0' == target) {
                if (reverse) {
                    return i;
                }
            } else if (!reverse) {
                return i;
            }
        }
        return -1;
    }
}