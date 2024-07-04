import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int count = in.nextInt();
        for (int i = 1; i <= count; ++i) {
            String solution = "";
            String raw = in.next();
            raw += in.nextLine();

            char[] input = raw.toCharArray();
            int xCoord = Character.getNumericValue(input[0]);
            int yCoord = Character.getNumericValue(input[2]);
            int numSteps = input.length - 4;
            // from 4 to input.length-1 are directions

            int finalX = xCoord;
            int finalY = yCoord;
            for (int j = 4; j<input.length; j++) {
                char direction = input[j];
                if (direction == 'N') finalY ++;
                else if (direction == 'S') finalY --;
                else if (direction == 'E') finalX ++;
                else finalX --;
            }

            if ((finalX + finalY) > numSteps) solution = "IMPOSSIBLE";
            // main computation in the else block
            else if ((finalX + finalY) == numSteps || (finalX + finalY) == numSteps - 1) solution += numSteps;
            else {
                int stepsNeeded = Math.abs(finalX);
                int stepsTaken = stepsNeeded;
                int myY = 0;
                int theirY = yCoord;

                for (int k = 4; k<4+stepsNeeded; k++) {
                    theirY += determineMoveY(k, input);
                }
                int index = 4 + stepsNeeded;
                int ySteps = 0;
                while (myY != theirY) {
                    if ((theirY - myY)%2 != 0) {
                        // DONT MOVE
                    }
                    else if (theirY > myY) {
                        myY++;
                    }
                    else {
                        myY--;
                    }
                    theirY += determineMoveY(index, input);
                    ySteps++;
                    index++;
                }
                stepsTaken += ySteps;
                solution += stepsTaken;
            }

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    public static int determineMoveY(int index, char[] input) {
        if (input[index] == 'N') return 1;
        else return -1;
    }

    public static int determineMoveX(int index, char[] input) {
        if (input[index] == 'E') return 1;
        else return -1;
    }
}
