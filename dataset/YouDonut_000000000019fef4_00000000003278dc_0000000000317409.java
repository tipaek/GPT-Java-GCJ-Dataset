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

            String[] input = raw.split(" ");
            int xCoord = Integer.parseInt(input[0]);
            int yCoord = Integer.parseInt(input[1]);
            String allDirections = input[2];
            int numSteps = allDirections.length();
            // from 4 to input.length-1 are directions

            int finalX = xCoord;
            int finalY = yCoord;
            for (int j = 0; j<numSteps; j++) {
                char direction = allDirections.charAt(j);
                if (direction == 'N') finalY ++;
                else if (direction == 'S') finalY --;
                else if (direction == 'E') finalX ++;
                else finalX --;
                //System.out.println(direction);
            }
            //System.out.println(finalX);
            //System.out.println(finalY);
            int diagDistance = Math.abs(finalX) + Math.abs(finalY);
            if (diagDistance > numSteps) solution = "IMPOSSIBLE";
            // main computation in the else block
            else if (diagDistance == numSteps || diagDistance == numSteps - 1) solution += numSteps;
            else {
                int stepsNeeded = Math.abs(finalX);
                int stepsTaken = stepsNeeded;
                int myY = 0;
                int theirY = yCoord;

                for (int k = 0; k<stepsNeeded; k++) {
                    theirY += determineMoveY(k, allDirections);
                }
                int index = stepsNeeded;
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
                    theirY += determineMoveY(index, allDirections);
                    ySteps++;
                    index++;
                }
                stepsTaken += ySteps;
                solution += stepsTaken;
            }

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    public static int determineMoveY(int index, String input) {
        if (input.charAt(index) == 'N') return 1;
        else return -1;
    }

    public static int determineMoveX(int index, String input) {
        if (input.charAt(index) == 'E') return 1;
        else return -1;
    }
}
