import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
            int[] answers = new int[numberOfTestCases];
            int[][][] moves = new int[numberOfTestCases][10000][2];

            for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
                answers[testCaseIndex] = 0;
                String[] deckSize = bufferedReader.readLine().split(" ");
                int rank = Integer.parseInt(deckSize[0]);
                int suit = Integer.parseInt(deckSize[1]);

                int currentInstance = 0;
                while (rank > 1) {
                    int rankCopy = rank;
                    int suitCopy = suit;
                    int flag = 0;
                    int maxInstance = currentInstance;

                    while (suitCopy > 1) {
                        moves[testCaseIndex][currentInstance][0] = rankCopy * (suitCopy - 1);
                        int newInstance = currentInstance;

                        while (flag > 0 && newInstance > maxInstance) {
                            moves[testCaseIndex][currentInstance][0] += moves[testCaseIndex][newInstance - 1][1];
                            newInstance--;
                        }

                        moves[testCaseIndex][currentInstance][1] = rankCopy - 1;
                        currentInstance++;
                        suitCopy--;
                        flag++;
                    }
                    rank--;
                }
                answers[testCaseIndex] = currentInstance;
            }

            for (int j = 0; j < numberOfTestCases; j++) {
                System.out.println("Case #" + (j + 1) + ": " + answers[j]);
                for (int k = 0; k < answers[j]; k++) {
                    System.out.println(moves[j][k][0] + " " + moves[j][k][1]);
                }
            }
        }
    }
}