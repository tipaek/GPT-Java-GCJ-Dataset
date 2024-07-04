import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        int[] answers = new int[numberOfTestCases];
        int[][][] moves = new int[numberOfTestCases][1000][2];

        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
            answers[testCaseIndex] = 0;
            String[] deckSize = bufferedReader.readLine().split(" ");
            int rank = Integer.parseInt(deckSize[0]);
            int suit = Integer.parseInt(deckSize[1]);

            int currentMoveIndex = 0;
            while (rank > 1) {
                int suitCopy = suit;
                while (suitCopy > 1) {
                    moves[testCaseIndex][currentMoveIndex][0] = rank * (suitCopy - 1);
                    moves[testCaseIndex][currentMoveIndex][1] = rank - 1;
                    currentMoveIndex++;
                    suitCopy--;
                }
                rank--;
            }
            answers[testCaseIndex] = currentMoveIndex;
        }

        for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
            System.out.println("Case #" + (testCaseIndex + 1) + ": " + answers[testCaseIndex]);
            for (int moveIndex = 0; moveIndex < answers[testCaseIndex]; moveIndex++) {
                System.out.println(moves[testCaseIndex][moveIndex][0] + " " + moves[testCaseIndex][moveIndex][1]);
            }
        }
    }
}