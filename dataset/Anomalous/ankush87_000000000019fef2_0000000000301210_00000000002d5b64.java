import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        int[] answers = new int[numberOfTestCases];
        int[][][] moves = new int[numberOfTestCases][10000][2];

        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
            answers[testCaseIndex] = 0;
            String[] deckSize = bufferedReader.readLine().split(" ");
            int rank = Integer.parseInt(deckSize[0]);
            int suit = Integer.parseInt(deckSize[1]);
            int currentMoveIndex = 0;

            while (rank > 1) {
                int rankCopy = rank;
                int suitCopy = suit;
                int flag = 0;

                while (suitCopy > 1) {
                    moves[testCaseIndex][currentMoveIndex][0] = rankCopy * (suitCopy - 1);
                    if (flag > 0 && currentMoveIndex > 0) {
                        moves[testCaseIndex][currentMoveIndex][0] += moves[testCaseIndex][currentMoveIndex - 1][1];
                    }
                    moves[testCaseIndex][currentMoveIndex][1] = rankCopy - 1;
                    currentMoveIndex++;
                    suitCopy--;
                    flag++;
                }
                rank--;
            }
            answers[testCaseIndex] = currentMoveIndex;
        }

        for (int i = 0; i < numberOfTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
            for (int j = 0; j < answers[i]; j++) {
                System.out.println(moves[i][j][0] + " " + moves[i][j][1]);
            }
        }
    }
}